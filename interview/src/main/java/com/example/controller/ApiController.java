package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.TicketModel;
import com.example.service.TicketService;

@RestController
public class ApiController {
	
	@Autowired
	TicketModel ticketModel;
	
	@Autowired
	TicketService ticketService;
	
	 @RequestMapping("/get/tickets")
	 public List<TicketModel> memberTest() {
		 
		 List allTicketLst = ticketService.getAllTicket();
		 return allTicketLst;
	 }
	
}