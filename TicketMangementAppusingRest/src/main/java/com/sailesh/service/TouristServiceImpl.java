package com.sailesh.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sailesh.dao.TouristRepo;
import com.sailesh.exception.TouristNotFoundException;
import com.sailesh.model.Ticket;

@Service("service")
public class TouristServiceImpl implements TouristService {

	@Autowired
	private TouristRepo repo;
	
	@Override
	public String registerTourist(Ticket ticket) {
		Integer tid = repo.save(ticket).getTid();
		
		return "data inserted successfully on"+" "+tid;
	}

	@Override
	public List<Ticket> findallTourist() {
		List<Ticket> list = repo.findAll();
		list.sort((t1,t2)->t1.getTid().compareTo(t2.getTid()));
		return list;
	}

	@Override
	public Ticket findbyId(Integer id) {
//		Optional<Ticket> optional = repo.findById(id);
//		if(optional.isPresent()) {
//			return optional.get();
//		}
//		else {
//			throw new TouristNotFoundException("Tourist not found with id  "+id);
//		}
//		
		return repo.findById(id).orElseThrow(()->new TouristNotFoundException("Tourist not found with id  "+id));
		
		
	}

	@Override
	public String updateTouristDetails(Ticket ticket) {
		Optional<Ticket> optional = repo.findById(ticket.getTid());
		if(optional.isPresent()) {
			repo.save(ticket);
			return "data Upadated successfully on id  " +ticket.getTid();
		}
		else {
		 throw new TouristNotFoundException("update not done opn id "+ ticket.getTid());
		}

	}

	@Override
	public String updateTouristbyBudget(Integer id, Float hike) {
		Optional<Ticket> optional = repo.findById(id);
		if(optional.isPresent()) {
			Ticket ticket = optional.get();
			ticket.setBudget(ticket.getBudget()+(ticket.getBudget()*(hike/100)));
			repo.save(ticket);
			return "Ticket is updated successfully on id "+ticket.getTid();
		}
		else {
			throw new TouristNotFoundException("Ticket not found for id " + id);
		}
		
	}

	@Override
	public String deleteTouristbyId(Integer id) {
		Optional<Ticket> optional = repo.findById(id);
		if(optional.isPresent()) {
		 repo.delete(optional.get());
		 return "Ticket is deleted successfully on id "+ id;
		}
		else {
			throw new TouristNotFoundException("Ticket is not deleted ");
		}
	
	}

}
