package com.example.trab.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "receita")
public class Receita implements Serializable {

    private static final long serialVersionUID = 9125277018717732648L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private long id;

    @Column(name = "description")
    private String description;

    @Column(columnDefinition = "NUMERIC(19,0)")
    private Double value;

//    protected Receita(){}

//    public Receita(String description, Double value){
//        this.description = description;
//        this.value = value;
//    }

    @Override
    public String toString() {
        return String.format("Receita: [id=%d, description='%s']", id,description);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }
}
