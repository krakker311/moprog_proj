package com.example.ezyfoody;

public class Foods {
    private String name;
    private int quantity;
    private int price;
    private int imageResourceId;
    private int totalprice;

    public static final Foods[] foods = {
            new Foods("Fried Rice",123,R.drawable.nasigoreng),
            new Foods("Fried Noodle",124,R.drawable.miegoreng),
            new Foods("Oxtail Soup",125,R.drawable.sopbuntut),
            new Foods("Noodle Soup",125,R.drawable.sotomie),
    };
    public String getName() {
        return name;
    }

    public void reset(){
        quantity = 0;
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

    public int getImageResourceId() {
        return imageResourceId;
    }

    public void setImageResourceId(int imageResourceId) {
        this.imageResourceId = imageResourceId;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Foods(String name, int price,int imageResourceId) {
        this.name = name;
        this.price = price;
        this.imageResourceId = imageResourceId;
    }

    public Foods(String name,  int price,int imageResourceId,int quantity) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.imageResourceId = imageResourceId;
    }
}
