package com.ecommerce.back.models;

import javax.persistence.*;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String image;

    private String brand;

    private Float price;

    private String category;

    private Float stock;

    private String description;

    private Float rating;

    private Float reviews;

    public Product() {
        super();
    }

    public Product(String name, String image, String brand, Float price, String category, Float stock, String description, Float rating, Float reviews) {
        super();
        this.name = name;
        this.image = image;
        this.brand = brand;
        this.price = price;
        this.category = category;
        this.stock = stock;
        this.description = description;
        this.rating = rating;
        this.reviews = reviews;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Float getStock() {
        return stock;
    }

    public void setStock(Float stock) {
        this.stock = stock;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Float getRating() {
        return rating;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }

    public Float getReviews() {
        return reviews;
    }

    public void setReviews(Float reviews) {
        this.reviews = reviews;
    }
}
