package com.example.ezyfoody;

import java.io.OptionalDataException;
import java.util.ArrayList;
import java.util.Date;

public class History {

    private static ArrayList<History> historyList;
    private String food,qty,totalprice;
    private Date date;

    public History(String food, String qty, String totalprice, Date date) {
        this.food = food;
        this.qty = qty;
        this.totalprice = totalprice;
        this.date = date;
    }

    public static void setHistoryList(ArrayList<History> historyList) {
        History.historyList = historyList;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public History(String food, String qty, String totalprice) {
        this.food = food;
        this.qty = qty;
        this.totalprice = totalprice;
    }

    public String getFood() {
        return food;
    }
    public void setHistoryList(String food, String qty, String totalprice){
        historyList.add(new History(food,qty,totalprice));
    }

    public static ArrayList<History> getHistoryList() {
        return historyList;
    }

    public void setHistoryList1(ArrayList<History> historyList) {
        this.historyList = historyList;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    public String getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(String totalprice) {
        this.totalprice = totalprice;
    }
}
