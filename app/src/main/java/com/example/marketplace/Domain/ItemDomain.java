package com.example.marketplace.Domain;

import java.util.ArrayList;

public class ItemDomain {
    private String  title;
    private String description;
    private ArrayList<String> picUrl;
    private double price;
    private double oldPrice;
    private int review;
    private double rating;
    private int numberInCart;

    public ItemDomain() {
    }

    public ItemDomain(double rating, int review, double oldPrice, double price, ArrayList<String> picUrl, String description, String title) {
        this.rating = rating;
        this.review = review;
        this.oldPrice = oldPrice;
        this.price = price;
        this.picUrl = picUrl;
        this.description = description;
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<String> getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(ArrayList<String> picUrl) {
        this.picUrl = picUrl;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getOldPrice() {
        return oldPrice;
    }

    public void setOldPrice(double oldPrice) {
        this.oldPrice = oldPrice;
    }

    public int getReview() {
        return review;
    }

    public void setReview(int review) {
        this.review = review;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getNumberInCart() {
        return numberInCart;
    }

    public void setNumberInCart(int numberInCart) {
        this.numberInCart = numberInCart;
    }
}
