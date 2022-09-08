
package com.marketingapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marketingapp.Repositories.LeadRepository;
import com.marketingapp.entities.Lead;


@Service
public class LeadServiceImpl implements LeadService {

	@Autowired 
	private LeadRepository LeadRepo;
	
	
	
	@Override
	public void saveLead(Lead lead) {
		
		LeadRepo.save(lead);
		
	}
	
	
	
	@Override
	public List <Lead> listAll() {
		List <Lead> leads = LeadRepo.findAll();
		return leads;
	}



	@Override
	public void deleteLeadById(long id) {
		LeadRepo.deleteById(id);
		
	}



	@Override
	public Lead findOneLeadById(long id) {
		Optional<Lead> findById = LeadRepo.findById(id);
		
		if(findById.isPresent()) {
		Lead lead = findById.get();
		
		return lead;
	}else {
		return null;
	}



	

	}


}