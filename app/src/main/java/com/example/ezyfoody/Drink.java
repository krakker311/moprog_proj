package com.example.ezyfoody;

public class Drink {
    private int totalprice;
    private String name;
    private int quantity;
    private int price;
    private int imageResourceId;


    public static final Drink[] drinks = {
            new Drink("Mineral Water",123,R.drawable.mineralwater),
            new Drink("Mango Juice",124,R.drawable.jusmangga),
            new Drink("Apel Juice",125,R.drawable.jusapel),
            new Drink("Avocado Juice",125,R.drawable.jusalpukat),
    };

    public int getTotalprice() {
        return totalprice=price*quantity;
    }

    public void reset(){
        quantity = 0;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public void setImageResourceId(int imageResourceId) {
        this.imageResourceId = imageResourceId;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Drink(String name, int price,int imageResourceId) {
        this.name = name;
        this.price = price;
        this.imageResourceId = imageResourceId;

    }

    public Drink(String name, int price, int imageResourceId,int quantity ) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.imageResourceId = imageResourceId;
    }
}
