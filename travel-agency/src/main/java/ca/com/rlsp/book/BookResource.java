package ca.com.rlsp.book;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/book")
public class BookResource {

    @GET
    @Path("/getAllBooks")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Book> getAllBooks(){
        return Book.listAll();
    }
}
