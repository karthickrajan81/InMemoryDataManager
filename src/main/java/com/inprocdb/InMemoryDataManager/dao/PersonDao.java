package com.inprocdb.InMemoryDataManager.dao;

import java.util.List;

import com.inprocdb.InMemoryDataManager.model.Person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class PersonDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static final String SQL_NEW_Person = "INSERT INTO Person(NAME) VALUES(?)";
    private static final String SQL_UPDATE_Person = "UPDATE Person SET NAME = ? WHERE ID = ?";
    private static final String SQL_DELETE_Person = "DELETE FROM Person WHERE ID = ?";
    private static final String SQL_FIND_ALL_PersonS = "SELECT * FROM Person";
    private static final String SQL_FIND_BY_Person_ID = "SELECT * FROM Person WHERE ID = ?";

    public Person findByPersonId(long PersonId) {
        Person Person = jdbcTemplate.queryForObject(SQL_FIND_BY_Person_ID, new PersonRowMapper(),
                new Object[] { PersonId });
        return Person;
    }

    public List<Person> findAllPersons() {
        List<Person> Persons = jdbcTemplate.query(SQL_FIND_ALL_PersonS, new PersonRowMapper());
        return Persons;
    }

    public void addPerson(Person Person) {
        jdbcTemplate.update(SQL_NEW_Person, new Object[] { Person.getName() });
    }

    public void updatePerson(Person Person) {
        jdbcTemplate.update(SQL_UPDATE_Person, new Object[] { Person.getName(), Person.getId() });
    }

    public void deletePerson(long PersonId) {
        jdbcTemplate.update(SQL_DELETE_Person, new Object[] { PersonId });
    }

}
