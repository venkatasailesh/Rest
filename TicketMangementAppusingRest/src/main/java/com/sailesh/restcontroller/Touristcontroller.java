package com.sailesh.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sailesh.model.Ticket;
import com.sailesh.service.TouristService;
import org.springframework.web.bind.annotation.PutMapping;


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
		return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
}


@PutMapping("/update")
public ResponseEntity<String> modifyTourist(@RequestBody Ticket ticket){
	try {
		String msg = service.updateTouristDetails(ticket);
		return new ResponseEntity<String>(msg, HttpStatus.OK);
	}
	catch(Exception e) {
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
	}
	
  
}

@PatchMapping("/modify/{id}/{hike}")
public ResponseEntity<String> modifyTouristbyBudget(@PathVariable("id") Integer id , @PathVariable("hike") Float hikeamt){
	try {
		String msg = service.updateTouristbyBudget(id, hikeamt);
		return new ResponseEntity<String>(msg, HttpStatus.OK);
		
	}
	catch(Exception e) {
		return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
	}
	
	
}

@DeleteMapping("/delete/{id}")
public ResponseEntity<String> deleteTouristbyId(@PathVariable("id") Integer id){
	try {
		String msg = service.deleteTouristbyId(id);
		return new ResponseEntity<String>(msg, HttpStatus.OK);
		
	}
	catch(Exception e) {
		return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
	}
	
	
}


	    
	   
	

}
