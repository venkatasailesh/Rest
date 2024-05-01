package com.sailesh.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sailesh.model.Ticket;
import com.sailesh.service.TouristService;

@RestController
@RequestMapping("/api/tourist")
public class Touristcontroller {
	
	@Autowired
	private TouristService service;
	
	@PostMapping("/enroll")
	public ResponseEntity<String> EnrollTourist(@RequestBody Ticket ticket){
		try {
			String resultMsg = service.registerTourist(ticket);
			return new ResponseEntity<String>(resultMsg,HttpStatus.OK);
		}
		catch (Exception e){
			return new ResponseEntity<String>("problem in enroll please try again later",HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
	}

	
@GetMapping("/find")
public ResponseEntity<?> displayTourist(){
	try {
			List<Ticket> list = service.findallTourist();
			return new ResponseEntity<List<Ticket>>(list,HttpStatus.OK);
		}
		catch (Exception e){
			return new ResponseEntity<String>("problem in enroll please try again later",HttpStatus.INTERNAL_SERVER_ERROR);
				
		}
	}

@GetMapping("/find/{id}")
public ResponseEntity<?> displayTouristbyid(@PathVariable("id") Integer id){
	try {
		Ticket list = service.findbyId(id);
		return new ResponseEntity<Ticket>(list,HttpStatus.OK);
	}
	catch(Exception e) {
		return new ResponseEntity<String>("problem in fetching by id ",HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
}
	    
	   
	

}
