package com.satyam.foodforgood.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.satyam.foodforgood.model.OrganisationInformation;
import com.satyam.foodforgood.repository.OrganisationInformationRepository;

@Service
public class OrganisationInformationServiceImplementation implements OrganisationInformationService{

	@Autowired
	private OrganisationInformationRepository informationRepository;
	
	@Override
	public OrganisationInformation save(OrganisationInformation information) {
		return informationRepository.save(information);
	}

	@Override
	public List<OrganisationInformation> findAll() {
		List<OrganisationInformation> data = informationRepository.findAll();
		return data;
	}

	@Override
	public OrganisationInformation findById(int id) {
		Optional<OrganisationInformation> data = informationRepository.findById(id);
		
		if(!data.isPresent()) {
			throw new RuntimeException("Organisation information with the given ID: "+id+" not found.");
		}
		
		return data.get();
	}

	@Override
	public OrganisationInformation update(int id, OrganisationInformation information) {
		return informationRepository.save(information);
	}

	@Override
	public void deleteById(int id) {
		Optional<OrganisationInformation> data = informationRepository.findById(id);
		
		if(!data.isPresent()) {
			throw new RuntimeException("Organisation information with the given ID: "+id+" not found.");
		}
		
		informationRepository.deleteById(id);
	}

}
