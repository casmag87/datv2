package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entities.DTO.BoatDTO;
import facades.AuctionFacade;
import facades.OwnerFacade;
import utils.EMF_Creator;

import javax.annotation.security.RolesAllowed;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

@Path("boat")
public class BoatResource {

    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();
    private static final OwnerFacade ownerFacade = OwnerFacade.getOwnerFacade(EMF);

    @Context
    private UriInfo context;

    @Context
    SecurityContext securityContext;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getInfoForAll() {
        return "{\"msg\":\"Boat ressource\"}";
    }

    @GET
    @Path("ownerboats")
    @RolesAllowed("user")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getOwnerBoats(){
        String thisuser = securityContext.getUserPrincipal().getName();

        return Response.ok(GSON.toJson(ownerFacade.getOwnerBoats(thisuser)),"application/json").build();
    }

    @DELETE
    @Path("delete/{id}")
    @RolesAllowed("admin")
    public Response deleteAuction(@PathParam("id") Long id){

        BoatDTO boatDTO = ownerFacade.deleteById(id);

        return Response.ok(GSON.toJson(boatDTO) ,"application/json").build();
    }


}
