package com.komandux.swag.Controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.komandux.swag.Model.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(name="Discount")

public class TaxAndDiscountController {

    public List<Discount> discounts = new ArrayList<>();

    {
        discounts.add(new Discount(0, DiscountType.PercentageDiscount,new BigDecimal("0.1"),new Date(),new Date()));
        discounts.add(new Discount(1, DiscountType.PercentageDiscount,new BigDecimal("0.1"),new Date(),new Date()));
        discounts.add(new Discount(2, DiscountType.FlatDiscount,new BigDecimal("0.1"),new Date(),new Date()));
        discounts.add(new Discount(3, DiscountType.FlatDiscount,new BigDecimal("0.1"),new Date(),new Date()));
    }

    List<Tax> taxes = new ArrayList<>();

    {
        taxes.add(new Tax(0,new BigDecimal("0.1"),TaxType.FlatTax,TaxReason.ExcisesTax));
        taxes.add(new Tax(1,new BigDecimal("0.1"),TaxType.FlatTax,TaxReason.SalesTax));
        taxes.add(new Tax(2,new BigDecimal("0.1"),TaxType.Percentage,TaxReason.LicenseFees));
        taxes.add(new Tax(3,new BigDecimal("0.1"),TaxType.Percentage,TaxReason.Poll));
    }

    @ApiOperation(value = "Create new discount", tags="Discount")
    @RequestMapping(value = "/discount", method = RequestMethod.POST)
    public Discount createDiscount(@RequestBody Discount discount) {

        List<Integer> listProducts = discounts.stream().map(Discount::getProduct).toList();
        int newProduct= listProducts.stream().max(Integer::compareTo).get() + 1;

        discounts.add(new Discount(newProduct,discount.getDiscountType(),discount.getAmmount(),new Date(),new Date()));

        return discounts.get(discounts.size()-1);
    }

    @ApiOperation(value = "delete discount by PRODUCT", tags="Discount")
    @RequestMapping(value = "/DiscountDeleteByProduct/{product}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteDiscountByProduct(@PathVariable("product") int product) {

        int index=-1;

        for(int i=0; i<discounts.size(); i++) {
            if(discounts.get(i).getProduct()==product) {
                index=i;
            }
        }

        if(index>-1) {
            discounts.remove(index);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @ApiOperation(value = "update discount by PRODUCT", tags="Discount")
    @RequestMapping(value = "/DiscountUpdateByProduct/{product}", method = RequestMethod.PUT)
    public Discount updateDiscountByProduct(@PathVariable("product") int product, @RequestBody Discount discount) {

        int index=0;

        for(int i=0; i<discounts.size(); i++) {
            if(discounts.get(i).getProduct()==product) {
                index=i;
                discounts.set(i, new Discount(product,discount.getDiscountType(),discount.getAmmount(),discount.getDiscountStart(),discount.getDiscountEnd()));
            }
        }

        return discounts.get(index);
    }

    @ApiOperation(value = "View all discounts", tags="Discount")
    @RequestMapping(value = "/discounts", method = RequestMethod.GET)
    public List<Discount> viewDiscounts() {
        return discounts;
    }

    @ApiOperation(value = "View one discount", tags="Discount")
    @RequestMapping(value = "/discount/{product}", method = RequestMethod.GET)
    public ResponseEntity<?> viewDiscount(@PathVariable("product") int product) {
        for(int i=0; i<discounts.size(); i++) {
            if(discounts.get(i).getProduct() == (product)) {
                discounts.remove(i);
                return new ResponseEntity<>(HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @ApiOperation(value = "Create new tax", tags="Tax")
    @RequestMapping(value = "/tax", method = RequestMethod.POST)
    public Tax createTax(@RequestBody Tax tax) {

        List<Integer> listOrders = taxes.stream().map(Tax::getOrder).toList();
        int newOrder= listOrders.stream().max(Integer::compareTo).get() + 1;

        taxes.add(new Tax(newOrder,tax.getTax(),tax.getTaxType(),tax.getTaxReason()));

        return taxes.get(taxes.size()-1);
    }

    @ApiOperation(value = "delete tax by ORDER", tags="Tax")
    @RequestMapping(value = "/TaxDeleteByOrder/{order}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteTaxByOrder(@PathVariable("order") int order) {

        int index=-1;

        for(int i=0; i<taxes.size(); i++) {
            if(taxes.get(i).getOrder()==order) {
                index=i;
            }
        }

        if(index>-1) {
            taxes.remove(index);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @ApiOperation(value = "update tax by ORDER", tags="Tax")
    @RequestMapping(value = "/TaxUpdateByOrder/{order}", method = RequestMethod.PUT)
    public Tax updateTaxByOrder(@PathVariable("order") int order, @RequestBody Tax tax) {

        int index=0;

        for(int i=0; i<taxes.size(); i++) {
            if(taxes.get(i).getOrder()==order) {
                index=i;
                taxes.set(i, new Tax(order,tax.getTax(),tax.getTaxType(),tax.getTaxReason()));
            }
        }

        return taxes.get(index);
    }

    @ApiOperation(value = "View all taxes", tags="Tax")
    @RequestMapping(value = "/taxes", method = RequestMethod.GET)
    public List<Tax> viewTaxes() {
        return taxes;
    }

    @ApiOperation(value = "View one tax", tags="Tax")
    @RequestMapping(value = "/tax/{order}", method = RequestMethod.GET)
    public ResponseEntity<?> viewTax(@PathVariable("order") int order) {
        for(int i=0; i<taxes.size(); i++) {
            if(taxes.get(i).getOrder() == (order)) {
                taxes.remove(i);
                return new ResponseEntity<>(HttpStatus.OK);
            }
        }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
