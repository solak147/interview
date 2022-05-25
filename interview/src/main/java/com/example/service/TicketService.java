package com.example.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.TicketModel;
import com.example.model.UserModel;
import com.example.repository.TicketRepository;

@Service
public class TicketService {
	
	@Autowired
	TicketRepository ticketRepository;
	
	public void insertTicket(TicketModel ticketModel){
		ticketRepository.insertTicket(ticketModel);
	}
	
	public void deleteTicketByNo(String no){
		ticketRepository.deleteTicketByNo(no);
	}
	
	public void updateTicketByNo(TicketModel ticket){
		ticketRepository.updateTicketByNo(ticket);
	}
	
	public TicketModel getTicketByNo(String no){
		Map<String,Object> m = ticketRepository.getTicketByNo(no);
		
		TicketModel ticket = new TicketModel();
		ticket.setNo(Integer.parseInt(m.get("NO").toString()));
		ticket.setType(m.get("TYPE").toString());
		ticket.setSerious(m.get("SERIOUS").toString());
		ticket.setPriority(m.get("PRIORITY").toString());	
		ticket.setSolved("1".equals(m.get("SOLVED").toString()) ? "已解決" : "未解決");
		
		return ticket;
		
	}
	
	public List<TicketModel> getAllTicket(){
		List<Map<String,Object>> allTicketLst = ticketRepository.getAllTicket();
		List<TicketModel> lst = new ArrayList<TicketModel>();
		
		for(Map m : allTicketLst) {
			TicketModel ticket = new TicketModel();
			ticket.setNo(Integer.parseInt(m.get("NO").toString()));
			ticket.setType(m.get("TYPE").toString());
			ticket.setSerious(m.get("SERIOUS").toString());
			ticket.setPriority(m.get("PRIORITY").toString());	
			ticket.setSolved("1".equals(m.get("SOLVED").toString()) ? "已解決" : "未解決");
			lst.add(ticket);
		}
		
		return lst;
	
	}
	
}