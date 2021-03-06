package com.inprocdb.InMemoryDataManager;

import static org.assertj.core.api.Assertions.assertThat;

import com.inprocdb.InMemoryDataManager.controller.PersonController;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SmokeTest {

    @Autowired
    private PersonController controller;

    @Test
    public void contextLoads() throws Exception {
        assertThat(controller).isNotNull();
    }
}