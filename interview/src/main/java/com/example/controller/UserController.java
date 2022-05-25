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

import com.example.model.UserModel;
import com.example.service.TicketService;
import com.example.service.UserService;

@Controller
public class UserController {
	
		@Autowired
		UserModel userModel;
		
		@Autowired
		UserService userService;
		
		@Autowired
		TicketService ticketService;
		   
		@PostMapping("/home")
	    public String login(@ModelAttribute UserModel user, Model model) {
	    		    	  	
	    	Map<String,Object> userMap = userService.getUser(user.getName(), user.getPassword());
	    	
	    	if("1".equals(userMap.get("CNT").toString())) {
	    		model.addAttribute("userName", user.getName()); 
	    	}else {    		
	    		model.addAttribute("userName", "登入失敗");     		
	    	}
	    	
	    	List allTicketLst = ticketService.getAllTicket();	    	
	    	model.addAttribute("ticketLst", allTicketLst);     		
	    		    	
	        return "home";
	    }
	    
	    @RequestMapping("/")
	    public String index(Model model) {
	    	
	    	UserModel user = new UserModel();
	    	model.addAttribute("user", user);
	    	
	        return "login";
	    }

}