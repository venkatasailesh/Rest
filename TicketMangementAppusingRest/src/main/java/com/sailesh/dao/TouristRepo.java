package com.sailesh.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sailesh.model.Ticket;

public interface TouristRepo extends JpaRepository<Ticket, Integer> {

}
