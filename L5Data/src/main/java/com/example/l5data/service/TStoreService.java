package com.example.l5data.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class TStoreService {

	@Autowired
	private JdbcTemplate jdbc;

	public int maxId() {
		return jdbc.queryForObject("select max(id)" +
									"from t_store" , Integer.class);
	}

}
