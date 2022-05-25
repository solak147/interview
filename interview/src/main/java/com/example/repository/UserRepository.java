package com.example.repository;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.model.UserModel;

@Repository
public class UserRepository {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
    public Map<String,Object> getUser(String name, String password){
        String sql="SELECT COUNT(*) CNT FROM USER WHERE NAME = ? AND PASSWORD = ?";
        Map<String,Object> maps=jdbcTemplate.queryForMap(sql, name, password);

        return maps;
    }

}