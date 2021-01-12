package com.m2ice.tp.rest.models;

import java.util.List;

public class User {

    private int id;
    private String name;
    private List<Service> services;

    public User(int id, String name, List<Service> services) {
        this.id = id;
        this.name = name;
        this.services = services;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Service> getServices() {
        return services;
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }

    public String toXML() {
        return "<USER id=\"" + id + "\" name=\"" + name + "\" ></USER>";
    }
}
