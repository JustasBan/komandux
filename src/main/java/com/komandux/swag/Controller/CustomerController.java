package com.komandux.swag.Controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.komandux.swag.Model.Customer;
import com.komandux.swag.Model.LoyaltyType;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class CustomerController {

	List<Customer> customers = new ArrayList<Customer>();
	{
		customers.add(new Customer(1, "Name1", "Surname1", null, "PhoneNumber1", "Email1", null, "MembershipCard1",
				LoyaltyType.BronzeCustomers));
		customers.add(new Customer(2, "Name2", "Surname2", null, "PhoneNumber2", "Email2", null, "MembershipCard2",
				LoyaltyType.BronzeCustomers));
		customers.add(new Customer(3, "Name3", "Surname3", null, "PhoneNumber3", "Email3", null, "MembershipCard3",
				LoyaltyType.BronzeCustomers));
		customers.add(new Customer(4, "Name4", "Surname4", null, "PhoneNumber4", "Email4", null, "MembershipCard4",
				LoyaltyType.BronzeCustomers));
	}

	@ApiOperation(value = "Get list of Customers in the System ", response = Iterable.class, tags = "Customer")
	// @ApiResponses(value = {
	// @ApiResponse(code = 200, message = "Suceess|OK"),
	// @ApiResponse(code = 401, message = "not authorized!"),
	// @ApiResponse(code = 403, message = "forbidden!!!"),
	// @ApiResponse(code = 404, message = "not found!!!") })

	// gaunamas visas customer sarasas
	@GetMapping(value = "/getCustomers")
	public List<Customer> getCustomers() {
		return customers;
	}

	// gali grazinti daugiau nei viena, nes ne visu name yra unikalūs
	@ApiOperation(value = "Get specific Customer in the System ", response = Customer.class, tags = "Customer")
	@GetMapping(value = "/getCustomerByName/{name}")
	public List<Customer> getCustomerByName(@PathVariable(value = "name") String name) {
		return customers.stream().filter(x -> x.getName().equalsIgnoreCase(name)).collect(Collectors.toList());
	}

	// gali grazinti daugiau nei viena, nes ne visu surname yra unikalūs
	@ApiOperation(value = "Get specific Customer in the System ", response = Customer.class, tags = "Customer")
	@GetMapping(value = "/getCustomerBySurname/{surname}")
	public List<Customer> getCustomerBySurname(@PathVariable(value = "surname") String surname) {
		return customers.stream().filter(x -> x.getSurname().equalsIgnoreCase(surname)).collect(Collectors.toList());
	}

	// grazina customer pagal username ir password. LOGIN funkcija
	@ApiOperation(value = "Get specific Customer in the System ", response = Customer.class, tags = "Customer")
	@GetMapping(value = "/getCustomerByUsernameAndPassword/{username, password}")
	public Customer getCustomerByUsernameAndPassword(@PathVariable(value = "username") String username,
			@PathVariable(value = "password") String password) {
		return customers.stream().filter(x -> x.getUsername().equals(username))
				.filter(x -> x.getPassword().equals(password)).collect(Collectors.toList()).get(0);
	}

	// grazina vieninteli customer pagal jo id
	@ApiOperation(value = "Get specific Customer in the System ", response = Customer.class, tags = "Customer")
	@GetMapping(value = "/getCustomerById/{customerId}")
	public Customer getCustomerById(@PathVariable(value = "customerId") int customerId) {
		return customers.stream().filter(x -> x.getCustomerId() == (customerId)).collect(Collectors.toList()).get(0);
	}

	// grazina vieninteli customer pagal jo membershipCard
	@ApiOperation(value = "Get specific Customer in the System ", response = Customer.class, tags = "Customer")
	@GetMapping(value = "/getCustomerByMembershipCard/{membershipCard}")
	public Customer getCustomerByMembershipCard(@PathVariable(value = "membershipCard") String membershipCard) {
		return customers.stream().filter(x -> x.getMembershipCard().equals(membershipCard)).collect(Collectors.toList())
				.get(0);
	}

	// sukuriamas customer by Employee. Is story map, kad vietoje klientas uzpildo
	// forma ir darbuotojas uzregistruoja sistemoje
	@ApiOperation(value = "Create The Customer in the System by Employee", response = Customer.class, tags = "Customer")
	@PostMapping(value = "/createACustomerByEmployee/{name, surname, dataOfBirth, phoneNumber, emailAddress, membershipCard}")
	public Customer createACustomer(String name, String surname, Date dataOfBirth, String phoneNumber,
			String emailAddress,
			String membershipCard, LoyaltyType loyaltyType) {
		customers.add(new Customer(customers.get(customers.size() - 1).getCustomerId() + 1, name, surname, dataOfBirth,
				phoneNumber, emailAddress, new Date(), membershipCard, loyaltyType));
		return customers.get(customers.size() - 1);
	}

	// sukuriamas customer pacio vartotojo sistemoje. Is user story create account,
	// login...
	@ApiOperation(value = "Create The Customer in the System", response = Customer.class, tags = "Customer")
	@PostMapping(value = "/createACustomerByCustomerHimself/{name, surname, dataOfBirth, phoneNumber, emailAddress, membershipCard, username, password}")
	public Customer createACustomer(String name, String surname, Date dataOfBirth, String phoneNumber,
			String emailAddress,
			String membershipCard, String username, String password) {
		customers.add(new Customer(customers.get(customers.size() - 1).getCustomerId() + 1, name, surname, dataOfBirth,
				phoneNumber, emailAddress, new Date(), membershipCard, LoyaltyType.BronzeCustomers, username,
				password));
		return customers.get(customers.size() - 1);
	}

	// ištrina customer pagal jo id
	@ApiOperation(value = "Delete The Customer in the System ", response = Customer.class, tags = "Customer")
	@DeleteMapping(value = "/deleteCustomerById/{customerId}")
	public ResponseEntity<?> deleteACustomer(@PathVariable(value = "customerId") int customerId) {
		for (int i = 0; i < customers.size(); i++) {
			if (customers.get(i).getCustomerId() == (customerId)) {
				customers.remove(i);
				return new ResponseEntity<>(HttpStatus.OK);
			}
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	// Darbuotojas gali pakeisti loyaltyType
	@ApiOperation(value = "Change Customer LoyaltyType in the System ", response = Customer.class, tags = "Customer")
	@PatchMapping(value = "/changeCustomerLoyaltyTypeByHisMembershipCard{membershipCard, loyaltyType}")
	public ResponseEntity<?> changeCustomerLoyaltyType(@PathVariable(value = "membershipCard") String membershipCard, 
			@PathVariable(value = "loyaltyType") LoyaltyType loyaltyType) {
		for (int i = 0; i < customers.size(); i++) {
			if (customers.get(i).getMembershipCard().equals(membershipCard)) {
				Customer customer = customers.get(i);
				customer.setLoyaltyType(loyaltyType);
				customers.set(i, customer);
				return new ResponseEntity<>(HttpStatus.OK);
			}
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	// pats vartotojass gali redaguoti savo profili. Negalima keisti membershipCard,
	// username, id
	@ApiOperation(value = "Change Customer information in the System ", response = Customer.class, tags = "Customer")
	@PutMapping(value = "/changeCustomerInformationByHisUsername{username, name, surname, dataOfBirth, phoneNumber, emailAddress, password}}")
	public ResponseEntity<?> changeCustomerInformation(String username, String name, String surname, Date dataOfBirth,
			String phoneNumber, String emailAddress, String password) {
		for (int i = 0; i < customers.size(); i++) {
			Customer customer = customers.get(i);
			if (customer.getUsername() != null && customer.getUsername().equals(username)) {
				customers.set(i,
						new Customer(customer.getCustomerId(), name, surname, dataOfBirth, phoneNumber, emailAddress,
								customer.getJoinDate(), customer.getMembershipCard(),
								customer.getLoyaltyType(), customer.getUsername(), password));
				return new ResponseEntity<>(HttpStatus.OK);
			}
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

}
