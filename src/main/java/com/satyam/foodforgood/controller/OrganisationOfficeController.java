package com.satyam.foodforgood.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.satyam.foodforgood.model.OrganisationInformation;
import com.satyam.foodforgood.model.OrganisationOffice;
import com.satyam.foodforgood.service.OrganisationInformationService;
import com.satyam.foodforgood.service.OrganisationOfficeService;

@RestController()
@RequestMapping("/api/organisationoffice")
public class OrganisationOfficeController {

	@Autowired
	private OrganisationOfficeService officeService; 
	
	@Autowired
	private OrganisationInformationService informationService;
	
	
	@GetMapping("/all")
	public List<OrganisationOffice> findAll(){
		return officeService.findAll();
	}
	
	@GetMapping("/{id}")
	public OrganisationOffice findById(@PathVariable int id) {
		return officeService.findById(id);
	}
	
	
	@PostMapping("/{org_information_id}")
	public OrganisationOffice saveOrganisationOffice(@RequestBody OrganisationOffice office, @PathVariable int org_information_id) {
		OrganisationInformation data =  informationService.findById(org_information_id);
		
		if(data == null) {
			throw new RuntimeException("Organisation information with the given ID: "+org_information_id+" not found.");
		}
		
		office.setOrganisation(data);
		
		return officeService.save(office);
	}
	
	@PutMapping("/{org_information_id}/{org_office_id}")
	public OrganisationOffice saveOrganisationOffice(@RequestBody OrganisationOffice office, @PathVariable int org_information_id, @PathVariable int org_office_id) {
		OrganisationInformation data =  informationService.findById(org_information_id);
		
		if(data == null) {
			throw new RuntimeException("Organisation information with the given ID: "+org_information_id+" not found.");
		}
		
		Optional<OrganisationOffice> dataOffice = data.getOffices().stream()
				.filter( officeData -> officeData.getOrganisation_office_id() == org_office_id)
				.findFirst();
		
		
		if(!dataOffice.isPresent()) {
			throw new RuntimeException("Organisation office with the given ID: "+org_office_id+" not found in organisation information with ID: " + org_information_id);
		}
		
		office.setOrganisation_office_id(org_office_id);
		
		office.setOrganisation(data);
		
		return officeService.save(office);
	}
	
	
	@DeleteMapping("/{org_office_id}")
	public String deleteOrganisationOffice(@PathVariable int org_office_id) {
		officeService.deleteById(org_office_id);
		return "Deleted Successfully";
	}
	
	
}
