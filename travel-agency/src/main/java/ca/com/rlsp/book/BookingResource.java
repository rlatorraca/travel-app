package ca.com.rlsp.book;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/booking")
public class BookingResource {

    @GET
    @Path("getAllBooks")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Booking> getAllBookings(){
        return Booking.listAll();
    }

    @Transactional
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response newBooking(Booking booking){
        booking.id = null;

        booking.persist();

        return Response.status(Response.Status.CREATED).entity(booking).build();
    }
}
