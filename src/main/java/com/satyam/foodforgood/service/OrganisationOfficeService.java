package com.satyam.foodforgood.service;

import java.util.List;

import com.satyam.foodforgood.model.OrganisationOffice;

public interface OrganisationOfficeService {
	
	public List<OrganisationOffice> findAll();
	public OrganisationOffice findById(int id);
	public OrganisationOffice save(OrganisationOffice office);
	public OrganisationOffice update(int id, OrganisationOffice office);
	public void deleteById(int id);
}
