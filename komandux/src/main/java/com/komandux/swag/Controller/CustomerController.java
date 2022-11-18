package com.komandux.swag.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.komandux.swag.Model.Customer;

import io.swagger.annotations.ApiOperation;

@RestController
public class CustomerController {

	List<Customer> customers = new ArrayList<Customer>();
	{
		customers.add(new Customer(1, "Name1", "Surname1", null, "PhoneNumber1", "Email1", null, "MembershipCard1"));
		customers.add(new Customer(2, "Name2", "Surname2", null, "PhoneNumber2", "Email2", null, "MembershipCard2"));
		customers.add(new Customer(3, "Name3", "Surname3", null, "PhoneNumber3", "Email3", null, "MembershipCard3"));
		customers.add(new Customer(4, "Name4", "Surname4", null, "PhoneNumber4", "Email4", null, "MembershipCard4"));
	}
	
	@ApiOperation(value = "Get list of Customers in the System ", response = Iterable.class, tags = "getCustomers")
//	@ApiResponses(value = { 
//			@ApiResponse(code = 200, message = "Suceess|OK"),
//			@ApiResponse(code = 401, message = "not authorized!"), 
//			@ApiResponse(code = 403, message = "forbidden!!!"),
//			@ApiResponse(code = 404, message = "not found!!!") })

	@RequestMapping(value = "/getCustomers")
	public List<Customer> getCustomers() {
		return customers;
	}
	
	@ApiOperation(value = "Get specific Customer in the System ", response = Customer.class, tags = "getCustomerByName")
	@RequestMapping(value = "/getCustomerByName/{name}")
	public Customer getCustomerByName(@PathVariable(value = "name") String name) {
		return customers.stream().filter(x -> x.getName().equalsIgnoreCase(name)).collect(Collectors.toList()).get(0);
	}
	
	@ApiOperation(value = "Get specific Customer in the System ", response = Customer.class, tags = "getCustomerBySurname")
	@RequestMapping(value = "/getCustomerBySurname/{surname}")
	public Customer getCustomerBySurname(@PathVariable(value = "surname") String surname) {
		return customers.stream().filter(x -> x.getSurname().equalsIgnoreCase(surname)).collect(Collectors.toList()).get(0);
	}
	
	@ApiOperation(value = "Get specific Customer in the System ", response = Customer.class, tags = "getCustomerById")
	@RequestMapping(value = "/getCustomerById/{customerId}")
	public Customer getCustomerById(@PathVariable(value = "customerId") int customerId) {
		return customers.stream().filter(x -> x.getCustomerId() == (customerId)).collect(Collectors.toList()).get(0);
	}
	
}
