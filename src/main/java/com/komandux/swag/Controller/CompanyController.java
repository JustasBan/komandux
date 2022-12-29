package com.komandux.swag.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.komandux.swag.Model.Company;
import com.komandux.swag.Model.Customer;
import com.komandux.swag.Model.RelationshipType;
import com.komandux.swag.Model.ServiceType;

import io.swagger.annotations.ApiOperation;

@RestController
public class CompanyController {

	List<Company> companies = new ArrayList<Company>();
	{
		companies.add(new Company(1, "CompanyName1", ServiceType.Consulting, "Address1", "ContactInformation1", RelationshipType.Customer));
		companies.add(new Company(2, "CompanyName2", ServiceType.Consulting, "Address2", "ContactInformation2", RelationshipType.Customer));
		companies.add(new Company(3, "CompanyName3", ServiceType.Consulting, "Address3", "ContactInformation3", RelationshipType.Customer));
		companies.add(new Company(4, "CompanyName4", ServiceType.Consulting, "Address4", "ContactInformation4", RelationshipType.Customer));
	}
	
	//gauti visas kompanijas
	@ApiOperation(value = "Get list of Companies in the System ", response = Iterable.class, tags = "Company")
	@GetMapping(value = "/getCompanies")
	public List<Company> getCompanies() {
		return companies;
	}
	
	//gauti kompanijas pagal supplierId
	@ApiOperation(value = "Get Companies in the System ", response = Company.class, tags = "Company")
	@GetMapping(value = "/getCompaniesBySupplierId/{supplierId}")
	public List<Company> getCompaniesBySupplierId(@PathVariable(value = "supplierId") int supplierId) {
		return companies.stream().filter(x -> x.getSupplierId() == (supplierId)).collect(Collectors.toList());
	}
	
	//gauti kompanija pagal jos varda
	@ApiOperation(value = "Get specific Company in the System ", response = Company.class, tags = "Company")
	@GetMapping(value = "/getCompanyByName/{companyName}")
	public Company getCompanyByName(@PathVariable(value = "companyName") String companyName) {
		return companies.stream().filter(x -> x.getCompanyName().equalsIgnoreCase(companyName)).collect(Collectors.toList()).get(0);
	}
	
	//gauti kompanijas pagal ServiceType
	@ApiOperation(value = "Get list of Companies in the System ", response = Company.class, tags = "Company")
	@GetMapping(value = "/getCompaniesByServiceType/{serviceType}")
	public List<Company> getCompaniesByServiceType(@PathVariable(value = "serviceType") ServiceType serviceType) {
		return companies.stream().filter(x -> x.getServiceType() == (serviceType)).collect(Collectors.toList());
	}
	
	//gauti kompanijas pagal RelationshipType
	@ApiOperation(value = "Get list of Companies in the System ", response = Company.class, tags = "Company")
	@GetMapping(value = "/getCompaniesByRelationshipType/{relationshipType}")
	public List<Company> getCompaniesByRelationshipType(@PathVariable(value = "relationshipType") RelationshipType relationshipType) {
		return companies.stream().filter(x -> x.getRelationshipType() == (relationshipType)).collect(Collectors.toList());
	}
	
	//ištrina company pagal name
	@ApiOperation(value = "Delete The Customer in the System ", response = Customer.class, tags = "Company")
	@DeleteMapping(value = "/deleteACompanyByCompanyName/{companyName}")
	public ResponseEntity<?> deleteACompany(String companyName) {
		for(int i=0; i<companies.size(); i++)
		{
			if(companies.get(i).getCompanyName().equals(companyName))
				companies.remove(i);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}
