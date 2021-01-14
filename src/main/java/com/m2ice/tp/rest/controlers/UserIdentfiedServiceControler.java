package com.m2ice.tp.rest.controlers;

import com.m2ice.tp.rest.ContextSingletonBean;
import com.m2ice.tp.rest.models.Service;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import java.util.stream.Collectors;

@Path("/users/{identifiant}/services")
@Produces(MediaType.APPLICATION_XML)
public class UserIdentfiedServiceControler {

    @EJB
    private ContextSingletonBean contextSingletonBean;

    @Context
    private UriInfo context;

    @GET
    public String getUserServices(@PathParam("identifiant") String identifiant) {
        return "<user id=\"" + identifiant + "\"><services>" + this.contextSingletonBean.getUser(Integer.parseInt(identifiant))
                .getServices().stream().map(service -> "<service id=\"" + service.getId() + "\"></service>").collect(Collectors.joining("")) + "</services></user>";
    }

    @POST
    public String postUserService(String content, @PathParam("identifiant") String identifiant) {
        Service service = new Service(content);
        int idService = this.contextSingletonBean.addUserService(Integer.parseInt(identifiant), service);
        return "<service xlink:type'simple' xlink:href='" + context.getAbsolutePath() + "/" + idService + "'></service>";
    }
}
