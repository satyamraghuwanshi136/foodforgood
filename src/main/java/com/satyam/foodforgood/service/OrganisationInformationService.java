package com.satyam.foodforgood.service;

import java.util.List;

import com.satyam.foodforgood.model.OrganisationInformation;

public interface OrganisationInformationService {
	
	public OrganisationInformation save(OrganisationInformation information);
	public List<OrganisationInformation> findAll();
	public OrganisationInformation findById(int id);
	public OrganisationInformation update(int id, OrganisationInformation information);
	public void deleteById(int id);
}
