package com.example.repository;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.model.TicketModel;

@Repository
public class TicketRepository {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void insertTicket(TicketModel ticket){
		String sql = "INSERT INTO TICKET (TYPE, SERIOUS, PRIORITY, SOLVED) VALUES (?,?,?,?)";
		jdbcTemplate.update(sql, ticket.getType(), ticket.getSerious(),
				ticket.getPriority(), "已解決".equals(ticket.getSolved()) ? "1" : "0");
	}
	
	public Map<String,Object> getTicketByNo(String no){
        String sql="SELECT * FROM TICKET WHERE NO = ?";
        Map<String,Object> map=jdbcTemplate.queryForMap(sql, no);
        
        return map;
    }
	
    public List<Map<String,Object>> getAllTicket(){
        String sql="SELECT * FROM TICKET";
        List<Map<String,Object>> list=jdbcTemplate.queryForList(sql);
        
        return list;
    }
    
    public void deleteTicketByNo(String no){
        String sql="DELETE FROM TICKET WHERE NO = ?";
        jdbcTemplate.update(sql, no);     
    }
    
    public void updateTicketByNo(TicketModel ticket){
        String sql="UPDATE TICKET SET TYPE=?, SERIOUS=?, PRIORITY=?, SOLVED=? WHERE NO = ?";
        jdbcTemplate.update(sql, ticket.getType(), ticket.getSerious(), ticket.getPriority(), "已解決".equals(ticket.getSolved()) ? "1" : "0", ticket.getNo());     
    }


}