package com.videoclub.services;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ListadoPaises {
	
	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	@GetMapping("/listCountries")
	public String hello() {
	    String sql = "select * from country";
	         
	    List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
	    String a = "a";
	    return "ho";
	}
}
