package com.ecommerce.back.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "addresses")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Address can not be blank")
    @Column(name = "address")
    private String address;

    @NotBlank(message = "City can not be blank")
    @Column(name = "city")
    private String city;

    @NotBlank(message = "Postal code can not be blank")
    @Column(name = "postal_code")
    private String postal_code;

    @NotBlank(message = "Country can not be blank")
    @Column(name = "country")
    private String country;

    @OneToOne(mappedBy = "address")
    private Order order;

    public Address() {
        super();
    }

    public Address(Long id, String address, String city, String postal_code, String country, Order order) {
        super();
        this.id = id;
        this.address = address;
        this.city = city;
        this.postal_code = postal_code;
        this.country = country;
        this.order = order;
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostal_code() {
        return postal_code;
    }

    public void setPostal_code(String postal_code) {
        this.postal_code = postal_code;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
