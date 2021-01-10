package com.example.ezyfoody;

public class Snacks {
    private String name;
    private int quantity;
    private int price;
    private int imageResourceId;
    private int totalprice;

    public static final Snacks[] snacks = {
            new Snacks("French Fries",123,R.drawable.kentanggoreng),
            new Snacks("Potato Chip",124,R.drawable.keripikkentang),
            new Snacks("Fried Tofu",125,R.drawable.tahugoreng),
            new Snacks("Batagor",126,R.drawable.batagor),
    };

    public int getTotalprice() {
        return totalprice;
    }
    public void reset(){
        quantity = 0;
    }
    public void setTotalprice(int totalprice) {
        this.totalprice = totalprice;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public void setImageResourceId(int imageResourceId) {
        this.imageResourceId = imageResourceId;
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

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Snacks(String name, int price,int imageResourceId) {
        this.name = name;
        this.price = price;
        this.imageResourceId = imageResourceId;
    }

    public Snacks(String name,  int price,int imageResourceId,int totalprice,int quantity) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.imageResourceId = imageResourceId;
        this.totalprice = totalprice;
    }
}
