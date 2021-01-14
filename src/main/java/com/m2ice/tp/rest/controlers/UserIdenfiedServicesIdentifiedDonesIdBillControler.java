package com.m2ice.tp.rest.controlers;

import com.m2ice.tp.rest.ContextSingletonBean;
import com.m2ice.tp.rest.models.Done;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

@Path("/users/{identifiant}/services/{idService}/dones/{done}/bill")
@Produces(MediaType.APPLICATION_XML)
public class UserIdenfiedServicesIdentifiedDonesIdBillControler {

    @EJB
    private ContextSingletonBean contextSingletonBean;

    @Context
    private UriInfo context;

    @GET
    public String getUserServicesDone(@PathParam("identifiant") String identifiant,
                                      @PathParam("idService") String idService,
                                      @PathParam("done") String idDone) {
        Done done = this.contextSingletonBean.getUserServiceDone(Integer.parseInt(identifiant), Integer.parseInt(idService), Integer.parseInt(idDone));
        return "<bill><qt>" + done.getQt() + "</qt><date>" + done.getDate() + "</date></bill>";
    }
}
