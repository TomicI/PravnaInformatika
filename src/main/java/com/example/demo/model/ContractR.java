package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "contractR")
public class ContractR {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "address")
    private String address;

    @ManyToOne
    private User vlasnik;

    @ManyToOne
    private User kupac;

    @ManyToOne
    private Roba roba;

    public ContractR() { }

    public ContractR(String address, User vlasnik, Roba roba) {
        this.address = address;
        this.vlasnik = vlasnik;
        this.roba = roba;
        this.kupac=null;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public User getVlasnik() {
        return vlasnik;
    }

    public void setVlasnik(User vlasnik) {
        this.vlasnik = vlasnik;
    }

    public User getKupac() {
        return kupac;
    }

    public void setKupac(User kupac) {
        this.kupac = kupac;
    }

    public Roba getRoba() {
        return roba;
    }

    public void setRoba(Roba roba) {
        this.roba = roba;
    }
}
