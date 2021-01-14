package com.m2ice.tp.rest.controlers;

import com.m2ice.tp.rest.ContextSingletonBean;
import com.m2ice.tp.rest.models.User;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import java.util.stream.Collectors;

@Path("/users")
@Produces(MediaType.APPLICATION_XML)
public class UserControler {

    @EJB
    ContextSingletonBean contextSingletonBean;

    @Context
    private UriInfo context;

    @GET
    public String getUsers() {
        return "<users>" +
                contextSingletonBean.getUsers().stream().map(user -> "<userid>" + user.getId() + "</userid>").collect(Collectors.joining()) + "</users>";
    }

    @POST
    public String postUser(String content) throws ServerErrorException {
        User user = new User(content);
        int id = this.contextSingletonBean.addUser(user);
        return "<user xlink:type'simple' xlink:href='" + context.getAbsolutePath() + "/" + id + "'></user>";
    }
}
