package ca.com.rlsp.client;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/client")
public class ClientResource {

    @GET()
    @Produces(MediaType.APPLICATION_JSON)
    public List<Client> getAllClients(){
        return Client.listAll();
    }
}
