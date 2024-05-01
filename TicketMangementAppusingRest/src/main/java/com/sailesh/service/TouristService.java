package com.sailesh.service;

import java.util.List;

import com.sailesh.model.Ticket;

public interface TouristService {

	public String registerTourist (Ticket ticket) ;
	public List<Ticket> findallTourist();
	public Ticket findbyId(Integer id);
}
