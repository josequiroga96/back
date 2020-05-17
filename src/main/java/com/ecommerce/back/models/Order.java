package com.ecommerce.back.models;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "payment_method")
    private String payment_method;

    @Column(name = "items_price")
    private Float items_price;

    @Column(name = "tax_price")
    private Float tax_price;

    @Column(name = "shipping_price")
    private Float shipping_price;

    @Column(name = "total_price")
    private Float total_price;

    @Column(name = "is_paid")
    private Boolean is_paid;

    @Column(name = "paid_at")
    private Date paid_at;

    @Column(name = "is_delivered")
    private Boolean is_delivered;

    @Column(name = "delivered_at")
    private Date delivered_at;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;

    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<OrderItem> order_items;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public Order() {
        super();
    }

    public Order(Long id, String payment_method, Float items_price, Float tax_price, Float shipping_price,
                 Float total_price, Boolean is_paid, Date paid_at, Boolean is_delivered, Date delivered_at,
                 Address address, Set<OrderItem> order_items, User user) {
        super();
        this.id = id;
        this.payment_method = payment_method;
        this.items_price = items_price;
        this.tax_price = tax_price;
        this.shipping_price = shipping_price;
        this.total_price = total_price;
        this.is_paid = is_paid;
        this.paid_at = paid_at;
        this.is_delivered = is_delivered;
        this.delivered_at = delivered_at;
        this.address = address;
        this.user = user;
        this.order_items = order_items;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPayment_method() {
        return payment_method;
    }

    public void setPayment_method(String payment_method) {
        this.payment_method = payment_method;
    }

    public Float getItems_price() {
        return items_price;
    }

    public void setItems_price(Float items_price) {
        this.items_price = items_price;
    }

    public Float getTax_price() {
        return tax_price;
    }

    public void setTax_price(Float tax_price) {
        this.tax_price = tax_price;
    }

    public Float getShipping_price() {
        return shipping_price;
    }

    public void setShipping_price(Float shipping_price) {
        this.shipping_price = shipping_price;
    }

    public Float getTotal_price() {
        return total_price;
    }

    public void setTotal_price(Float total_price) {
        this.total_price = total_price;
    }

    public Boolean getIs_paid() {
        return is_paid;
    }

    public void setIs_paid(Boolean is_paid) {
        this.is_paid = is_paid;
    }

    public Date getPaid_at() {
        return paid_at;
    }

    public void setPaid_at(Date paid_at) {
        this.paid_at = paid_at;
    }

    public Boolean getIs_delivered() {
        return is_delivered;
    }

    public void setIs_delivered(Boolean is_delivered) {
        this.is_delivered = is_delivered;
    }

    public Date getDelivered_at() {
        return delivered_at;
    }

    public void setDelivered_at(Date delivered_at) {
        this.delivered_at = delivered_at;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Set<OrderItem> getOrder_items() {
        return order_items;
    }

    public void setOrder_items(Set<OrderItem> order_items) {
        this.order_items = order_items;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
