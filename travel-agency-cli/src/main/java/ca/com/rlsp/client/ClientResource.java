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
    @Path("findById")
    @Produces(MediaType.APPLICATION_JSON)
    public Client findById(@QueryParam("id") long id){
        return clientService.findById(id);
    }
}
