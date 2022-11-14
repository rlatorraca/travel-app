package ca.com.rlsp.client;

import org.eclipse.microprofile.rest.client.inject.RestClient;


import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/client-cli")
public class ClientResource {

    @Inject
    @RestClient
    ClientService clientService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("newClient")
    public Response newClient() {
        Client client = Client.newInstance(0L, "Ronaldo");

        return clientService.newClient(client);
    }

    @GET
    @Path("getClientById")
    @Produces(MediaType.APPLICATION_JSON)
    public Client getClientByIdQueryParam(@QueryParam("id") long id){
        return clientService.getClientByIdQueryParam(id);
    }

    @GET
    @Path("getClientById/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Client getClientByIdPathParam(@PathParam("id") long id){
        return clientService.getClientByIdPathParam(id);
    }
}
