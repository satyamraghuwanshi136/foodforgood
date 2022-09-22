package com.satyam.foodforgood.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.satyam.foodforgood.model.OrganisationOffice;
import com.satyam.foodforgood.repository.OrganisationOfficeRepository;

@Service
public class OrganisationOfficeServiceImplementation implements OrganisationOfficeService{

	@Autowired
	private OrganisationOfficeRepository officeRepository;

	@Override
	public OrganisationOffice findById(int id) {
		
		Optional<OrganisationOffice> office = officeRepository.findById(id);
		
		if(!office.isPresent()) {
			throw new RuntimeException("Organisation Office with the given Id: " + id + " not found");
		}
		
		return office.get();
	}

	@Override
	public OrganisationOffice save(OrganisationOffice office) {
		return officeRepository.save(office);
	}

	@Override
	public OrganisationOffice update(int id, OrganisationOffice office) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		
	}
	
	
}
