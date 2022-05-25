package com.example.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.model.TicketModel;
import com.example.model.UserModel;
import com.example.service.TicketService;

@Controller
public class TicketController {
	
		@Autowired
		TicketModel ticketModel;
		
		@Autowired
		TicketService ticketService;
	    
	    @RequestMapping("/MyFirstPage")
	    public String greeting(@RequestParam(value="title", required=false, defaultValue="xiao") String title, Model model) {
	        model.addAttribute("name", title);
	        return "index";
	    }
	    
	    @RequestMapping("/deleteTicket")
	    public String delete(@RequestParam Map<String,String> allParams, Model model){
	    		    	
	    	ticketService.deleteTicketByNo(allParams.get("no"));
	    	
	    	List allTicketLst = ticketService.getAllTicket();
	    	model.addAttribute("ticketLst", allTicketLst);   
	    	model.addAttribute("userName", allParams.get("userName"));   
	    	
	        return "home";
	    }
	    
	    @RequestMapping("/updatePage")
	    public String updatePage(@RequestParam Map<String,String> allParams, Model model){
	    		    		    	
	    	TicketModel ticket = ticketService.getTicketByNo(allParams.get("no"));
	    	model.addAttribute("ticket", ticket);   
	    	model.addAttribute("userName", allParams.get("userName"));   
	    	
	        return "update";
	    }	
	    
		@PostMapping("/update")
	    public String login(@ModelAttribute TicketModel ticket, @RequestParam String userName, Model model) {
	    		    	  	
			ticketService.updateTicketByNo(ticket);

	    	List allTicketLst = ticketService.getAllTicket();	    	
	    	model.addAttribute("ticketLst", allTicketLst);     		
	    	model.addAttribute("userName", userName);   
	    	
	        return "home";
	    }
		
		@RequestMapping("/insertPage")
	    public String insertPage(@RequestParam String userName, Model model){
	    	
			TicketModel ticket = new TicketModel();
			model.addAttribute("ticket", ticket);
	    	model.addAttribute("userName", userName);   
	    	
	        return "insert";
	    }	
		
		@PostMapping("/insert")
	    public String insert(@ModelAttribute TicketModel ticket, @RequestParam String userName, Model model) {
	    		    	  	
			ticketService.insertTicket(ticket);

	    	List allTicketLst = ticketService.getAllTicket();	    	
	    	model.addAttribute("ticketLst", allTicketLst);     		
	    	model.addAttribute("userName", userName);   
	    	
	        return "home";
	    }

}