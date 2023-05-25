package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import entities.DTO.AuctionDTO;
import entities.DTO.BoatDTO;
import facades.AuctionFacade;
import utils.EMF_Creator;

import javax.annotation.security.RolesAllowed;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

@Path("auction")
public class AuctionResource {

    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();
    private static final AuctionFacade auctionFacade = AuctionFacade.getAuctionFacade(EMF);

    @Context
    private UriInfo context;

    @Context
    SecurityContext securityContext;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getInfoForAll() {
        return "{\"msg\":\"Auction ressource\"}";
    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("allauctions")
    public Response allAuctions() throws WebApplicationException{

        return Response.ok(GSON.toJson(auctionFacade.getAllAuctions()) ,"application/json").build();
    }




/*    @POST
    @Path("createauction")
    @Produces("application/json")
    @Consumes("application/json")
    public String createAuction(String jsonString){

        String name;
        String date;
        String time;
        String location;

        JsonObject json = JsonParser.parseString(jsonString).getAsJsonObject();

        name = json.get("name").getAsString();
        date = json.get("date").getAsString();
        time = json.get("time").getAsString();
        location = json.get("location").getAsString();

        AuctionDTO auctionDTO = new AuctionDTO(name,date,time,location);
        AuctionDTO response = auctionFacade.createAuction(auctionDTO);
        return GSON.toJson(response);
    }*/

    @POST
    @Path("create")
    @RolesAllowed("admin")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(String auction){
        AuctionDTO auctionDTO = GSON.fromJson(auction,AuctionDTO.class);
        return Response.ok(GSON.toJson(auctionFacade.createAuction(auctionDTO)),"application/json").build();
    }

    @DELETE
    @Path("delete/{id}")
    @RolesAllowed("admin")
    public Response deleteAuction(@PathParam("id") Long id){

        AuctionDTO auctionDTO = auctionFacade.deleteByID(id);

        return Response.ok(GSON.toJson(auctionDTO) ,"application/json").build();
    }


}
