package com.m2ice.tp.rest.controlers;

import com.m2ice.tp.rest.ContextSingletonBean;
import com.m2ice.tp.rest.models.Done;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import java.util.stream.Collectors;

@Path("/users/{identifiant}/services/{idService}/dones")
@Produces(MediaType.APPLICATION_XML)
public class UserIdenfiedServicesIdentifiedDonesControler {

    @EJB
    private ContextSingletonBean contextSingletonBean;

    @Context
    private UriInfo context;

    @GET
    public String getUserServicesDones(@PathParam("identifiant") String identifiant, @PathParam("idService") String idService) {
        return "<dones>" + this.contextSingletonBean.getUserService(Integer.parseInt(identifiant), Integer.parseInt(idService))
                .getDones().stream().map(done -> "<done>" + done.getId() + "</done>").collect(Collectors.joining("")) + "</dones>";
    }

    @POST
    public String addUserServiceDone(String content, @PathParam("identifiant") String identifiant, @PathParam("idService") String idService) {
        Done done = new Done(content);
        int id = this.contextSingletonBean.addUserServiceDone(Integer.parseInt(identifiant), Integer.parseInt(idService), done);
        return "<done xlink:type'simple' xlink:href='" + context.getAbsolutePath() + "/" + id + "'></done>";
    }
}
