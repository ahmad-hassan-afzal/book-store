package com.example.bookstore;

public class BookOrderItem {
    private String title;
    private double price;
    private int quantity;

    public BookOrderItem(String title, double price, int quantity){
        this.title = title;
        this.price = price;
        this.quantity = quantity;
    }

    public int getQuantity() { return quantity; }
    public double getPrice() { return price; }
    public String getTitle() { return title; }
}
