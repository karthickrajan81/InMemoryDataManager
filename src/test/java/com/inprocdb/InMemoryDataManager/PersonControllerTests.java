package com.inprocdb.InMemoryDataManager;

import com.inprocdb.InMemoryDataManager.controller.PersonController;
import com.inprocdb.InMemoryDataManager.model.Person;
import com.inprocdb.InMemoryDataManager.service.PersonService;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.test.web.servlet.MockMvc;

import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

//@RunWith(SpringRunner.class)
@WebMvcTest(PersonController.class)
public class PersonControllerTests {
    @Autowired
    private MockMvc mock;

    @MockBean
    private PersonService personService;

    Person mockPerson = new Person(1, "Test");

    @Test
    void getAllReturns200() throws Exception {

        // mock.perform(MockMvcRequestBuilders.get("/person/all").accept(MediaType.APPLICATION_JSON)).andDo(print())
        // .andExpect(status().isOk());

        // this.mock.perform(get("/person/all").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());

    }

}
