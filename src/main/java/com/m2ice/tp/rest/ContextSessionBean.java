package com.m2ice.tp.rest;

import com.m2ice.tp.rest.models.User;

import javax.ejb.Stateful;
import java.util.ArrayList;
import java.util.List;

@Stateful
public class ContextSessionBean {

    private final List<User> users;

    public ContextSessionBean() {
        this.users = new ArrayList<>();
    }

    public List<User> getUsers() {
        return users;
    }
}
