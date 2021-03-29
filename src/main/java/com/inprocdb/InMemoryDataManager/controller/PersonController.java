package com.inprocdb.InMemoryDataManager.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.inprocdb.InMemoryDataManager.exception.InvalidInputException;
import com.inprocdb.InMemoryDataManager.exception.PersonNotfoundException;
import com.inprocdb.InMemoryDataManager.exception.ServerErrorException;
import com.inprocdb.InMemoryDataManager.model.Person;
import com.inprocdb.InMemoryDataManager.service.PersonService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    private static final Logger logger = LoggerFactory.getLogger(PersonController.class);

    @RequestMapping("/")
    public String person() {
        return "Welcome to Person Controller!";
    }

    @GetMapping("/{id}")
    public Person getPersonbyId(@PathVariable int id) {
        try {
            return personService.findByPersonId(id);
        } catch (EmptyResultDataAccessException ex) {
            logger.error(ex.getMessage());
            throw new PersonNotfoundException();
        } catch (Exception ex) {
            logger.error(ex.getMessage());
            throw new ServerErrorException();
        }
    }

    @GetMapping("/all")
    public List<Person> getAllPerson() {
        try {
            return personService.findAllPersons();
        } catch (Exception ex) {
            logger.error(ex.getMessage());
            throw new ServerErrorException();
        }
    }

    @PostMapping("/add")
    public void AddPerson(@RequestBody Person person) {
        try {
            personService.addPerson(person);
        } catch (DataIntegrityViolationException ex) {
            logger.error(ex.getMessage());
            throw new InvalidInputException();
        } catch (Exception ex) {
            logger.error(ex.getMessage());
            throw new ServerErrorException();
        }
    }

    @PutMapping("/update")
    public void updatePerson(@RequestBody Person person) {
        try {
            personService.updatePerson(person);
        } catch (DataIntegrityViolationException ex) {
            logger.error(ex.getMessage());
            throw new InvalidInputException();
        } catch (Exception ex) {
            logger.error(ex.getMessage());
            throw new ServerErrorException();
        }
    }

    @DeleteMapping("/{id}")
    public void deletePerson(@PathVariable int id) {
        try {
            personService.deletePerson(id);
        } catch (EmptyResultDataAccessException ex) {
            logger.error(ex.getMessage());
            throw new PersonNotfoundException();
        } catch (Exception ex) {
            logger.error(ex.getMessage());
            throw new ServerErrorException();
        }
    }
}
