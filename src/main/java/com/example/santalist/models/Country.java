package com.example.santalist.models;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
public class Country {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

//    @JoinColumn(name="capitalId", referencedColumnName = "id")
    @JoinColumn
    @OneToOne(cascade = CascadeType.ALL)
    private Capital capital;

    @OneToMany(mappedBy="country")
    @JsonBackReference
    private List<Child> children;

    public Country() {}

    public Country(String name) {
        this.name = name;
    }

    public Country(String name, Capital capital) {
        this.name = name;
        this.capital = capital;
    }

    public Country(Long id, String name, Capital capital) {
        this.id = id;
        this.name = name;
        this.capital = capital;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Capital getCapital() {
        return capital;
    }
    public void setCapital(Capital capital) {
        this.capital = capital;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public List<Child> getChildren() {
        return children;
    }
    public void setChildren(List<Child> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "Country{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", capital=" + capital +
                '}';
    }
}
