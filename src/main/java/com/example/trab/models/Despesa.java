package com.example.trab.models;

import javax.persistence.*;

@Entity
@Table(name = "despesa")
public class Despesa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private long id;

    @Column(name = "description")
    private String description;

    @Column(columnDefinition = "NUMERIC(19,0)")
    private Double value;

    public Despesa(){}

    public Despesa(String description, Double value) {
        this.description = description;
        this.value = value;
    }

    public String toStringDespesa() {
        return String.format("Despesa: [id=%d, description='%s']", id,description);
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
