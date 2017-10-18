package com.pickdata.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.java.Log;

@Controller
@RequestMapping("/pickdata")
@Log
public class PickdataContoller {
	
	@GetMapping("/credits")
	public String credits() {
		
		log.info("/pickdata/credits");
		
		
		
		
		return "jsp/pickdata/credits";
	}
	

}
