package ca.com.rlsp.client;

import javax.enterprise.context.RequestScoped;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.lang.annotation.Repeatable;
import java.util.List;


@Path("/client")
public class ClientResource {

    @GET()
    @Produces(MediaType.APPLICATION_JSON)
    public List<Client> getAllClients(){
        return Client.listAll();
    }

    @GET()
    @Path("getClientById/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Client getClientByIdPathParam(@PathParam("id") long id){
        return Client.findById(id);
    }

    @GET()
    @Path("getClientById")
    @Produces(MediaType.APPLICATION_JSON)
    public Client getClientByIdQueryParam(@QueryParam("id") long id){
        return Client.findById(id);
    }

    @DELETE()
    @Path("removeClientById/{id}")
    @Transactional
    public void removeClientByIdPathParam(@PathParam("id") long id){
        Client.deleteById(id);
    }

    @DELETE()
    @Path("removeClientById")
    @Transactional
    public void removeClientByIdQueryParam(@QueryParam("id") long id){
        Client.deleteById(id);
    }

    @POST
    @Path("newClient")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response newClient(Client client){
        client.id=null; //Garante que nao sera um update
        client.persist();

        return Response.status(Response.Status.CREATED).entity(client).build();
    }
}
