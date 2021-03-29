package com.inprocdb.InMemoryDataManager.service;

import java.util.List;

import com.inprocdb.InMemoryDataManager.dao.PersonDao;
import com.inprocdb.InMemoryDataManager.model.Person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    @Autowired
    private PersonDao personDao;

    public Person findByPersonId(long personId) {
        return personDao.findByPersonId(personId);
    }

    public List<Person> findAllPersons() {
        return personDao.findAllPersons();
    }

    public void addPerson(Person person) {
        personDao.addPerson(person);
    }

    public void updatePerson(Person person) {
        personDao.updatePerson(person);
    }

    public void deletePerson(long personId) {
        personDao.deletePerson(personId);
    }

}