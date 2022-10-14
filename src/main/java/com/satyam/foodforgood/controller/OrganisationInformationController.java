package com.satyam.foodforgood.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
import com.satyam.foodforgood.service.OrganisationInformationService;

@RestController
@RequestMapping("/api/organisationinformation")
public class OrganisationInformationController {

	@Autowired
	public BCryptPasswordEncoder passwordEncoder;

	@Autowired
	OrganisationInformationService informationService;
	
	@GetMapping("/all")
	public List<OrganisationInformation> findAll(){
		return informationService.findAll();
	}
	
	@GetMapping("/{id}")
	public OrganisationInformation findById(@PathVariable int id){
		return informationService.findById(id);
	}
	
	@PostMapping("/")	
	public OrganisationInformation save(@RequestBody OrganisationInformation information) {
		information.setPassword(passwordEncoder.encode(information.getPassword()));
		return informationService.save(information);
	}
	
	@PutMapping("/{org_information_id}")	
	public OrganisationInformation update(@PathVariable int org_information_id , @RequestBody OrganisationInformation information) {
		information.setOrganisation_information_id(org_information_id);
		return informationService.update(org_information_id, information);
	}
	
	@DeleteMapping("/{org_information_id}")
	public String delete(@PathVariable int org_information_id ) {
		informationService.deleteById(org_information_id);
		return "Deleted Successfully";
	}
	
}
