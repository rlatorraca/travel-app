package ca.com.rlsp.client;


import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.time.temporal.ChronoUnit;

@RegisterRestClient(baseUri = "http://localhost:8181/client")
public interface ClientService {

    @POST
    @Path("newClient")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response newClient(Client client);

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("findById")
    @Timeout(unit = ChronoUnit.SECONDS, value = 3)
    @Fallback(fallbackMethod = "fallback")
    @CircuitBreaker(
            requestVolumeThreshold = 4,
            failureRatio = .5,
            delay = 6000,
            successThreshold = 1
    )
    public Client findById(@QueryParam("id") long id);

}
