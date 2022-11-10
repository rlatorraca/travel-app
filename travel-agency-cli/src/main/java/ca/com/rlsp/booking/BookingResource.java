package ca.com.rlsp.booking;


import ca.com.rlsp.client.Client;
import ca.com.rlsp.client.ClientService;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/booking-cli")
public class BookingResource {

    @Inject
    @RestClient
    BookingService bookingService;

    @Inject
    @RestClient
    ClientService clientService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("newBooking")
    public String newBooking(){
        //Client client = clientService.findById(3);
        Booking booking = Booking.newInstance(0L, 3L);

        return bookingService.newBooking(booking);
    }
}
