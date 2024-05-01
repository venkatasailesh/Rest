package com.sailesh.service;

import java.util.List;

import com.sailesh.model.Ticket;

public interface TouristService {

	public String registerTourist (Ticket ticket) ;
	public List<Ticket> findallTourist();
	public Ticket findbyId(Integer id);
	public String updateTouristDetails(Ticket ticket);
	public String updateTouristbyBudget(Integer id, Float hike);
	public String deleteTouristbyId(Integer id);
}
