package com.m2ice.tp.rest.controlers;

import com.m2ice.tp.rest.ContextSessionBean;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.util.stream.Collectors;

@Path("users")
public class UserControler {

    @EJB
    ContextSessionBean contextSessionBean;

    @GET
    public String getUsers() {
        return "<USERS>" +
                contextSessionBean.getUsers().stream().map(user -> "<userid>" + user.getId() + "</userid>").collect(Collectors.joining()) + "<USERS>";
    }
}
