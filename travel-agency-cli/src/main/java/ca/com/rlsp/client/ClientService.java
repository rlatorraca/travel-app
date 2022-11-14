package ca.com.rlsp.client;


import org.eclipse.microprofile.faulttolerance.CircuitBreaker;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.Timeout;
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
    @Path("/getClientById")
    @Timeout(unit = ChronoUnit.SECONDS, value = 3) // Timout setado em 3 segundos
    @Fallback(fallbackMethod = "fallbackClientQueryParam") // meotodo rsponde em caso de problema na nesse metodo
    @CircuitBreaker(
            requestVolumeThreshold = 4, // num inttervalo de 4 requisicoes sera feita a verificacao de circuitbreaker
            failureRatio = .5, // a porcentagem de falha em relacao ao mumero de transacoes (no caso 50%)
            delay = 6000, // depois de 6 segundos fechara o circuito novamente, se houve
            successThreshold = 1 // para fechar o cirucuito novamente, testa se exuste 1 a conexao com sucesso
    )
    public Client getClientByIdQueryParam(@QueryParam("id") long id);

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getClientById/{id}")
    @Timeout(unit = ChronoUnit.SECONDS, value = 3) // Timout setado em 3 segundos
    @Fallback(fallbackMethod = "fallbackClientPathParam") // meotodo rsponde em caso de problema na nesse metodo
    @CircuitBreaker(
            requestVolumeThreshold = 4, // num inttervalo de 4 requisicoes sera feita a verificacao de circuitbreaker
            failureRatio = .5, // a porcentagem de falha em relacao ao mumero de transacoes (no caso 50%)
            delay = 6000, // depois de 6 segundos fechara o circuito novamente, se houve
            successThreshold = 1 // para fechar o cirucuito novamente, testa se exuste 1 a conexao com sucesso
    )
    public Client getClientByIdPathParam(@PathParam("id") long id);

    private Client fallbackClientPathParam(long id){
        return Client.newInstance(0l, "PathParam");
    }

    private Client fallbackClientQueryParam(long id){
        return Client.newInstance(0L, "QueryParam");
    }

}
