package com.example.santalist.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Present {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    public Present(){}

    public Present(String name){
        this.name = name;
    }

    public Present(Long id, String name) {
        this.id = id;
        this.name = name;
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

    @Override
    public String toString() {
        return "Present{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
