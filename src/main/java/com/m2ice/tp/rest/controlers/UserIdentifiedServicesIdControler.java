package com.m2ice.tp.rest.controlers;

import com.m2ice.tp.rest.ContextSingletonBean;
import com.m2ice.tp.rest.models.Service;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

@Path("/users/{identifiant}/services/{idService}")
@Produces(MediaType.APPLICATION_XML)
public class UserIdentifiedServicesIdControler {

    @EJB
    private ContextSingletonBean contextSingletonBean;

    @Context
    private UriInfo context;

    @GET
    public String getUserServices(@PathParam("identifiant") String identifiant, @PathParam("idService") String idService) {
        return this.contextSingletonBean.getUserService(Integer.parseInt(identifiant), Integer.parseInt(idService)).toXML();
    }

    @PUT
    public String updateUserService(@PathParam("identifiant") String identifiant,
                                    @PathParam("idService") String idService,
                                    @QueryParam("title") String title,
                                    @QueryParam("price") String price) {
        Service service = this.contextSingletonBean.getUserService(Integer.parseInt(identifiant), Integer.parseInt(idService));

        if (title != null && !title.equals("")) {
            service.setTitle(title);
        }
        if (price != null && !price.equals("")) {
            service.setPrice(Integer.parseInt(price));
        }
        return "<service xlink:type'simple' xlink:href='" + context.getAbsolutePath() + "'></service>";
    }
}
