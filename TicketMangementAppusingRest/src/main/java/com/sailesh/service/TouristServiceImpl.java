package com.sailesh.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sailesh.dao.TouristRepo;
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
		Optional<Ticket> optional = repo.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}
		else {
			return null;
		}
		
		
	}

}
