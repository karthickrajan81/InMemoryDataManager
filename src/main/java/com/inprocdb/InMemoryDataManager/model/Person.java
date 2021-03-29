package com.inprocdb.InMemoryDataManager.model;

public class Person {
    private final int id;
    private final String name;

    public Person(int i, String name) {
        this.id = i;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}
