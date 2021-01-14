package com.m2ice.tp.rest.models;

import com.m2ice.tp.rest.utils.XMLFinder;

import java.util.ArrayList;
import java.util.List;

public class User {

    private int id;
    private String name;
    private List<Service> services;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
        this.services = new ArrayList<>();
    }

    public User(String xml) {
        this.id = -1;
        this.name = XMLFinder.findAttribute(xml, "name");
        this.services = new ArrayList<>();
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
        return "<user id=\"" + id + "\" name=\"" + name + "\" ></user>";
    }



}
