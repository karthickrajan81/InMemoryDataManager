package com.inprocdb.InMemoryDataManager.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.inprocdb.InMemoryDataManager.model.Person;

import org.springframework.jdbc.core.RowMapper;

public class PersonRowMapper implements RowMapper<Person> {

	@Override
	public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
		Person person = new Person(rs.getInt("ID"), rs.getString("NAME"));
		return person;
	}

}
