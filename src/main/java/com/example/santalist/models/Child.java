package com.example.santalist.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
public class Child {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

//    @JoinColumn(name="countryId", referencedColumnName = "id")
    @JoinColumn
    @ManyToOne(cascade = CascadeType.ALL) // fetch=FetchType.LAZY
    @JsonManagedReference
    private Country country;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name="wishes", joinColumns = {@JoinColumn(referencedColumnName = "id")}
            ,inverseJoinColumns = {@JoinColumn(referencedColumnName = "id")})
    private List<Present> wishes;

    public Child() { }

    public Child(String name) {
        this.name = name;
    }

    public Child(String name, Country country) {
        this.name = name;
        this.country = country;
    }

    public Child(String name, Country country, List<Present> wishes) {
        this.name = name;
        this.country = country;
        this.wishes = wishes;
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
    public Country getCountry() {
        return country;
    }
    public void setCountry(Country country) {
        this.country = country;
    }
    public List<Present> getWishes() {
        return wishes;
    }
    public void setWishes(List<Present> presents) {
        this.wishes = presents;
    }
    @Override
    public String toString() {
        return "Child{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", country=" + country +
                '}';
    }
}
