package com.example.firebaseproject.entities;

public class Product {

    private String description;
    private String brand;
    private double price;

    public Product(){
    }

    public Product(String description, String brand, double price) {
        this.description = description;
        this.brand = brand;
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}