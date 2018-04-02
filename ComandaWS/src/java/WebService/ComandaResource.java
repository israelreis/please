/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebService;

import com.google.gson.Gson;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Reis
 */
@Path("Comanda")
public class ComandaResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ComandaResource
     */
    public ComandaResource() {
    }

    /**
     * Retrieves representation of an instance of WebService.ComandaResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        Gson g = new Gson();
        return g.toJson("Olá meu caro");
    }

    /**
     * PUT method for updating or creating an instance of ComandaResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
