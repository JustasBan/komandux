package com.komandux.swag.Controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.komandux.swag.Model.Product;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(name="Products ops")
public class ProductController {
	List<Product> products = new ArrayList<Product>();
	
	{
		products.add(new Product(0, "barcode", "product1", new BigDecimal("0.1")));
		products.add(new Product(1, "barcode", "product2", new BigDecimal("0.1")));
		products.add(new Product(2, "barcode", "product3", new BigDecimal("0.1")));
		products.add(new Product(3, "barcode", "product4", new BigDecimal("0.1")));
	}
	
	@ApiOperation(value = "Create new product/service", tags="Product")
	@RequestMapping(value = "/product", method = RequestMethod.POST)
	public Product createProduct(@RequestBody Product product) {
		
		List<Integer> listIds = products.stream().map(u -> u.getProductId()).collect(Collectors.toList());
		int newId= listIds.stream().max(Integer::compareTo).get() + 1;
		
		products.add(new Product(newId, "barcode", product.getName(), product.getPrice()));
		return products.get(products.size()-1);
	}
	
	@ApiOperation(value = "delete product/service by ID", tags="Product")
	@RequestMapping(value = "/productsDeleteById/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteProductById(@PathVariable("id") int id) {
		
		int index=-1;
		
		for(int i=0; i<products.size(); i++) {
			if(products.get(i).getProductId()==id) {
				index=i;
			}
		}
		
		if(index>-1) {
			products.remove(index);
			return new ResponseEntity<>(HttpStatus.OK); 
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
		}
	}
	
	@ApiOperation(value = "delete product/service by name", tags="Product")
	@RequestMapping(value = "/productsDeleteById/{name}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteProductByName(@PathVariable("name") String name) {
		
		int deleteCount=0;
		
		for(int i=0; i<products.size(); i++) {
			if(products.get(i).getName()==name) {
				products.remove(i);
				deleteCount++;
			}
		}
		
		if(deleteCount>0) {
			return new ResponseEntity<>(HttpStatus.OK); 
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
		}
	}
	
	@ApiOperation(value = "View all products/services", tags="Product")
	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public List<Product> viewProducts() {
		return products;
	}
	
	@ApiOperation(value = "View one product/service", tags="Product")
	@RequestMapping(value = "/product/{id}", method = RequestMethod.GET)

	public ResponseEntity<?> viewProduct(@PathVariable("id") int id) {
		for(int i=0; i<products.size(); i++) {
			if(products.get(i).getProductId() == (id)) {
				products.remove(i);
				return new ResponseEntity<>(HttpStatus.OK);
			}
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@ApiOperation(value = "update produt by ID", tags="Product")
	@RequestMapping(value = "/ProductUpdateById/{id}", method = RequestMethod.PUT)
	public Product updateProductById(@PathVariable("id") int id, @RequestBody Product product) {
		
		int index=0;
		
		for(int i=0; i<products.size(); i++) {
			if(products.get(i).getProductId()==id) {
				index=i;
				products.set(i, new Product(id, product.getBarcode(), product.getName(), product.getPrice()));
			}
		}
		
		return products.get(index);
	}

}
