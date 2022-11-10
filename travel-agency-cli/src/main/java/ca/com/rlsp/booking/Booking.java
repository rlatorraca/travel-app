package ca.com.rlsp.booking;

import ca.com.rlsp.client.Client;

public class Booking {

    private Long id;
    private Long idClient;


    public Booking() {}

    public Booking(Long id, Long idClient) {
        this.id = id;
        this.idClient = idClient;
    }

    public static Booking newInstance(Long id, Long idClient){
        return new Booking(id, idClient);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdClient() {
        return idClient;
    }

    public void setIdClient(Long idClient) {
        this.idClient = idClient;
    }
}
