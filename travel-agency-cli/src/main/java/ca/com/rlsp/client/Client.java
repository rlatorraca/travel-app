package ca.com.rlsp.client;

import java.io.Serializable;

public class Client {

    private Long id;
    private String name;

    public Client(){

    }


    private Client(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public static Client newInstance(Long id, String name){
        return new Client(id, name);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
