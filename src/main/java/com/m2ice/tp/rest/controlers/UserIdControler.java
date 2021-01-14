package com.m2ice.tp.rest.controlers;

import com.m2ice.tp.rest.ContextSingletonBean;
import com.m2ice.tp.rest.models.User;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import java.awt.*;

@Path("/users/{identifiant}")
@Produces(MediaType.APPLICATION_XML)
public class UserIdControler {

    @EJB
    private ContextSingletonBean contextSingletonBean;

    @Context
    private UriInfo context;

    @GET
    public String getUser(@PathParam("identifiant") String identifiant) {
        return this.contextSingletonBean.getUser(Integer.parseInt(identifiant)).toXML();
    }

    @PUT
    public String updateUser(@PathParam("identifiant") String identifiant, @QueryParam("name") String name) {
        User user = this.contextSingletonBean.getUser(Integer.parseInt(identifiant));
        user.setName(name);
        return "<user xlink:type'simple' xlink:href='" + context.getAbsolutePath() + "'></user>";
    }
}
