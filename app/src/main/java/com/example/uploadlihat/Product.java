package com.example.uploadlihat;

public class Product {
    private int id ;
    private String image, title, spek;
    private double rating, price;

    public Product(int id, String title, String spek, String image) {
        this.id = id;
        this.image = image;
        this.title = title;
        this.spek = spek;
        this.rating = rating;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }

    public String getspek() {
        return spek;
    }

    public double getRating() {
        return rating;
    }

    public double getPrice() {
        return price;
    }
}
