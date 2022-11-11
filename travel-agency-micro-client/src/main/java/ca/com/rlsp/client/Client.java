package ca.com.rlsp.client;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Entity;

//Trata Client como entidade
@Entity
public class Client extends PanacheEntity {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
