package com.m2ice.tp.rest.controlers;

import com.m2ice.tp.rest.ContextSingletonBean;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import java.util.stream.Collectors;

@Path("/services")
@Produces(MediaType.APPLICATION_XML)
public class ServicesControler {

    @EJB
    ContextSingletonBean contextSingletonBean;

    @Context
    private UriInfo context;

    @GET
    public String getUsers() {
        return "<services>" + this.contextSingletonBean.getUsers().stream()
                .flatMap(user -> user.getServices().stream())
                .map(service -> "<service id=\"" + service.getId() + "\"></service>")
                .collect(Collectors.joining("")) +
                "</services>";
    }
}
