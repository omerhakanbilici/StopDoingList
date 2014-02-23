package rest;

import model.StopDoingItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import service.StopDoingService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by omerhakanbilici on 23.02.2014.
 * StopDoingList
 */

@Component("StopDoingListResource")
@Path("/stopdoing")
@Produces(MediaType.APPLICATION_JSON)
public class StopDoingListResource {

    @Autowired
    private StopDoingService stopDoingService;

    @GET
    @Path("/{id}")
    @Consumes({ MediaType.APPLICATION_JSON })
    public Response get(@PathParam("id") String id) {
        return build(Response.ok(stopDoingService.get(id)));
    }


    @GET
    @Consumes({ MediaType.APPLICATION_JSON })
    public Response list() {


        return build(Response.ok(stopDoingService.list()));
    }


    public Response build(Response.ResponseBuilder rb) {
        return rb.header("Access-Control-Allow-Origin", "*").build();
    }


    @POST
    @Consumes({ MediaType.APPLICATION_JSON })
    public Response save(StopDoingItem p) {
        stopDoingService.save(p);
        return build(Response.noContent());

    }



    @DELETE
    @Path("/{id}")
    @Consumes({ MediaType.APPLICATION_JSON })
    public Response delete(@PathParam("id") String id) {
        stopDoingService.remove(id);
        return build(Response.noContent());
    }


}
