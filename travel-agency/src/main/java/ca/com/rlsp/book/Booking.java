package ca.com.rlsp.book;

import ca.com.rlsp.client.Client;
import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@Entity
public class Booking extends PanacheEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    Client client;

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
