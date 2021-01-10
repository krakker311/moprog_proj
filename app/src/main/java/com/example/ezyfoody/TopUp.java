package com.example.ezyfoody;

public class TopUp {
    private int saldo;
    private String name;
    private int quantity;
    private int imageResourceId;
    public static final TopUp[] topups = {
            new TopUp("Bank",R.drawable.bank),
            new TopUp("Gopay",R.drawable.gopay),
            new TopUp("Ovo",R.drawable.ovo),
            new TopUp("Pulsa",R.drawable.pulsa),
    };

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

    public  int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public TopUp(String name ,int imageResourceId) {
        this.name = name;
        this.imageResourceId = imageResourceId;
    }

    public TopUp(String name,  int saldo,int imageResourceId,int quantity) {
        this.name = name;
        this.quantity = quantity;
        this.saldo = saldo;
        this.imageResourceId = imageResourceId;
    }
}
