package com.komandux.swag.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.komandux.swag.Model.Company;
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
	
	@ApiOperation(value = "Get list of Companies in the System ", response = Iterable.class, tags = "getCompanies")
	@RequestMapping(value = "/getCompanies")
	public List<Company> getCompanies() {
		return companies;
	}
	
	@ApiOperation(value = "Get specific Company in the System ", response = Company.class, tags = "getCompanyBySupplierId")
	@RequestMapping(value = "/getCompanyBySupplierId/{supplierId}")
	public Company getCompanyBySupplierId(@PathVariable(value = "supplierId") int supplierId) {
		return companies.stream().filter(x -> x.getSupplierId() == (supplierId)).collect(Collectors.toList()).get(0);
	}
	
	@ApiOperation(value = "Get specific Company in the System ", response = Company.class, tags = "getCompanyByName")
	@RequestMapping(value = "/getCompanyByName/{companyName}")
	public Company getCompanyByName(@PathVariable(value = "companyName") String companyName) {
		return companies.stream().filter(x -> x.getCompanyName().equalsIgnoreCase(companyName)).collect(Collectors.toList()).get(0);
	}
	
	@ApiOperation(value = "Get list of Companies in the System ", response = Company.class, tags = "getCompaniesByServiceType")
	@RequestMapping(value = "/getCompaniesByServiceType/{serviceType}")
	public List<Company> getCompaniesByServiceType(@PathVariable(value = "serviceType") ServiceType serviceType) {
		return companies.stream().filter(x -> x.getServiceType() == (serviceType)).collect(Collectors.toList());
	}
	
	@ApiOperation(value = "Get list of Companies in the System ", response = Company.class, tags = "getCompaniesByRelationshipType")
	@RequestMapping(value = "/getCompaniesByRelationshipType/{relationshipType}")
	public List<Company> getCompaniesByRelationshipType(@PathVariable(value = "relationshipType") RelationshipType relationshipType) {
		return companies.stream().filter(x -> x.getRelationshipType() == (relationshipType)).collect(Collectors.toList());
	}
}
