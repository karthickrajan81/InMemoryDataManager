package com.inprocdb.InMemoryDataManager.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

    @RequestMapping("/")
    public String Index() {
        return "Welcome to In memory data management application";
    }

}
