package com.komandux.swag.Controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.komandux.swag.Model.DeliveryMethod;
import com.komandux.swag.Model.Order;
import com.komandux.swag.Model.OrderItem;
import com.komandux.swag.Model.PaymentMethod;
import com.komandux.swag.Model.Product;
import com.komandux.swag.Model.RefundTicket;
import com.komandux.swag.Model.RefundType;
import com.komandux.swag.Model.State;

import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping(name="Order ops")
public class OrderAndRefundController {

	public List<Product> products = new ArrayList<Product>();
	
	{
		products.add(new Product(0, "barcode", "product1", new BigDecimal("0.1")));
		products.add(new Product(1, "barcode", "product2", new BigDecimal("0.1")));
		products.add(new Product(2, "barcode", "product3", new BigDecimal("0.1")));
		products.add(new Product(3, "barcode", "product4", new BigDecimal("0.1")));
	}
	
	List<Order> orders = new ArrayList<Order>();
	
	{
		orders.add(new Order(0, new Date(), State.Approved, DeliveryMethod.DeliveryToHome, new Date(), PaymentMethod.BankTransfer, "details", "comment"));
		orders.add(new Order(1, new Date(), State.Shipping, DeliveryMethod.DeliveryToPostMachine, new Date(), PaymentMethod.BankTransfer, "details", "comment"));
		orders.add(new Order(2, new Date(), State.Pending, DeliveryMethod.InPersonPickup, new Date(), PaymentMethod.BankTransfer, "details", "comment"));
		orders.add(new Order(3, new Date(), State.Delivered, DeliveryMethod.DeliveryToHome, new Date(), PaymentMethod.BankTransfer, "details", "comment"));
	}
	
	List<OrderItem> orderItemList = new ArrayList<OrderItem>();
	{
		orderItemList.add(new OrderItem(1, 1));
		orderItemList.add(new OrderItem(1, 2));
		orderItemList.add(new OrderItem(2, 1));
		orderItemList.add(new OrderItem(2, 1));
	}
	
	List<RefundTicket> refunds = new ArrayList<RefundTicket>();
	{
		refunds.add(new RefundTicket(0, 0, new Date(), false, "reason", null));
		refunds.add(new RefundTicket(1, 1, new Date(), false, "reason", null));
		refunds.add(new RefundTicket(2, 2, new Date(), false, "reason", null));
		refunds.add(new RefundTicket(3, 3, new Date(), false, "reason", null));
		refunds.add(new RefundTicket(4, 4, new Date(), false, "reason", null));
	}
	
	@ApiOperation(value = "Create new order", tags="Order")
	@RequestMapping(value = "/order", method = RequestMethod.POST)
	public Order createOrder(@RequestBody Order order) {
		
		List<Integer> listIds = orders.stream().map(u -> u.getOrderId()).collect(Collectors.toList());
		int newId= listIds.stream().max(Integer::compareTo).get() + 1;
		
		orders.add(new Order(newId, new Date(), order.getState(), order.getDeliveryMethod(), order.getPurchaseDate(), order.getPaymentMethod(), order.getTransactionDetails(), order.getAdditionalComments()));
		
		return orders.get(orders.size()-1);		
	}
	
	@ApiOperation(value = "delete order by ID", tags="Order")
	@RequestMapping(value = "/OrderDeleteById/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteProductById(@PathVariable("id") int id) {
		
		int index=-1;
		
		for(int i=0; i<orders.size(); i++) {
			if(orders.get(i).getOrderId()==id) {
				index=i;
			}
		}
		
		if(index>-1) {
			orders.remove(index);
			return new ResponseEntity<>(HttpStatus.OK); 
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
		}
	}
	
	@ApiOperation(value = "update order by ID", tags="Order")
	@RequestMapping(value = "/OrderUpdateById/{id}", method = RequestMethod.PUT)
	public Order updateOrderById(@PathVariable("id") int id, @RequestBody Order order) {
		
		int index=0;
		
		for(int i=0; i<orders.size(); i++) {
			if(orders.get(i).getOrderId()==id) {
				index=i;
				orders.set(i, new Order(id, order.getPurchaseDate(), order.getState(), order.getDeliveryMethod(), order.getDeliveryDate(), order.getPaymentMethod(), order.getTransactionDetails(), order.getAdditionalComments()));
			}
		}
		
		return orders.get(index);
	}
	
	@ApiOperation(value = "View all orders", tags="Order")
	@RequestMapping(value = "/orders", method = RequestMethod.GET)
	public List<Order> viewOrders() {
		return orders;
	}
	
	@ApiOperation(value = "add product to order", tags="Order")
	@RequestMapping(value = "/orderItem", method = RequestMethod.POST)
	public ResponseEntity<?> addProduct(@RequestBody OrderItem orderItem) {
		
		for(int i=0; i<orders.size(); i++) {
			if(orders.get(i).getOrderId()==orderItem.getOrderId()) {
				for(int i2=0; i2<products.size(); i2++) {
					if(products.get(i2).getProductId()==orderItem.getProductId()) {
						orderItemList.add(orderItem);
						return new ResponseEntity<>(HttpStatus.OK);
					}
				}
			}
		}
		
		return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
	}
	
	@ApiOperation(value = "create ticket", tags="Refunds")
	@RequestMapping(value = "/refund/{id}", method = RequestMethod.POST)
	public RefundTicket createRefundTicket(@RequestBody() RefundTicket ticket) {
		
		RefundTicket refund = null;
		
		for(int i=0; i<orders.size(); i++) {
			if(orders.get(i).getOrderId()==ticket.getRelatedOrder()) {
				
				List<Integer> listIds = refunds.stream().map(u -> u.getRefundTicketId()).collect(Collectors.toList());
				int newId= listIds.stream().max(Integer::compareTo).get() + 1;
				refund = new RefundTicket(newId, ticket.getRelatedOrder(), new Date(), false, ticket.getReason(), null);
			}
		}
		return refund;		
	}
	
	@ApiOperation(value = "approve ticket", tags="Refunds")
	@RequestMapping(value = "/refund/{id}/{type}", method = RequestMethod.POST)
	public RefundTicket approveTicket(@PathVariable("id") int refundId, @PathVariable("type") RefundType refundType) {
		RefundTicket old = refunds.get(refundId);
		old.setGranted();
		old.setRefundType(refundType);
		refunds.set(refundId, old);
		
		return refunds.get(refundId);
	}
}
