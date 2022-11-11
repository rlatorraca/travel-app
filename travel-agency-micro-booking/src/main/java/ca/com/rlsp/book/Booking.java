package ca.com.rlsp.book;


import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Entity;


@Entity
public class Booking extends PanacheEntity {

    public Long idClient;
}
