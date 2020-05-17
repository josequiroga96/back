package com.ecommerce.back.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name can not be blank")
    @Column(name = "name")
    private String name;

    @NotBlank(message = "Image can not be blank")
    @Column(name = "image")
    private String image;

    @NotBlank(message = "Brand can not be blank")
    @Column(name = "brand")
    private String brand;

    @NotNull(message = "Price can not be null")
    @Column(name = "price")
    private Float price;

    @NotBlank(message = "Category can not be blank")
    @Column(name = "category")
    private String category;

    @NotNull(message = "Stock can not be null")
    @Column(name = "stock")
    private Float stock;

    @Column(name = "description")
    private String description;

    @Column(name = "rating")
    private Float rating;

    @Column(name = "reviews")
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
