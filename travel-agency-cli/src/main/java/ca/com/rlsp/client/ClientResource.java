package ca.com.rlsp.client;

import org.eclipse.microprofile.rest.client.inject.RestClient;


import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/client-cli")
public class ClientResource {

    @Inject
    @RestClient
    ClientService clientService;

    @GET
    @Path("newClient")
    public Response newClient() {
        Client client = Client.newInstance(0L, "Ronaldo");

        return clientService.newClient(client);
    }
}
