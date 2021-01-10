package com.example.ezyfoody;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class OrderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        final ArrayList<Order> orderList = new ArrayList<>();

        for(int i =0;i<Drink.drinks.length;i++){
            if(Drink.drinks[i].getQuantity()!=0)
            orderList.add(new Order(Drink.drinks[i].getName(),Drink.drinks[i].getQuantity(),Drink.drinks[i].getPrice()));
        }for(int i =0;i<Foods.foods.length;i++){
            if(Foods.foods[i].getQuantity()!=0)
            orderList.add(new Order(Foods.foods[i].getName(),Foods.foods[i].getQuantity(),Foods.foods[i].getPrice()));
        }for(int i =0;i<Snacks.snacks.length;i++){
            if(Snacks.snacks[i].getQuantity()!=0)
            orderList.add(new Order(Snacks.snacks[i].getName(),Snacks.snacks[i].getQuantity(),Snacks.snacks[i].getPrice()));
        }
        int totalprice = 0;
        for(int i =0 ;i<orderList.size();i++){
            totalprice = totalprice+ orderList.get(i).getTotalprice();
        }
        TextView balance= (TextView)findViewById(R.id.balance);
        balance.setText("Balance:"+TopUp.topups[0].getSaldo());
        TextView total= (TextView)findViewById(R.id.Totprice);
        total.setText("Total Price :"+totalprice);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);


        CardOrderAdapter adapter = new CardOrderAdapter(orderList);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(OrderActivity.this);

        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setAdapter((RecyclerView.Adapter) adapter);
        Button mButton = (Button)findViewById(R.id.button1);
        Button mButton2 = (Button)findViewById(R.id.button2);
        Button mButton3 = (Button)findViewById(R.id.button3);
        final int finalTotalprice = totalprice;
        mButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(TopUp.topups[0].getSaldo()< finalTotalprice){
                    TextView nobalance= (TextView)findViewById(R.id.nobalance);
                    nobalance.setText("Balance not enough");
                }
                int money = TopUp.topups[0].getSaldo()-finalTotalprice;
                TopUp.topups[0].setSaldo(money);
                String name = "",price="",qty ="";
                for (int i = 0;i<orderList.size();i++){
                    name += name+orderList.get(i).getName()+",";
                    price += price+String.valueOf(orderList.get(i).getPrice())+",";
                    qty += qty + String.valueOf(orderList.get(i).getQuantity())+",";
                }
                Date currentTime = Calendar.getInstance().getTime();
                ArrayList<History>historyArrayList = new ArrayList<>();
                historyArrayList.add(new History(name,price,qty,currentTime));
                History history = new History(name,price,qty,currentTime);
                history.setHistoryList1(historyArrayList);
                orderList.clear();
                for(int i =0;i<Drink.drinks.length;i++){
                    Drink.drinks[i].reset();
                }for(int i =0;i<Foods.foods.length;i++){
                    Foods.foods[i].reset();
                }for(int i =0;i<Drink.drinks.length;i++){
                    Snacks.snacks[i].reset();
                }
                for(int i =0;i<Drink.drinks.length;i++){
                    orderList.add(new Order(Drink.drinks[i].getName(),Drink.drinks[i].getQuantity(),Drink.drinks[i].getPrice()));
                }for(int i =0;i<Foods.foods.length;i++){
                    orderList.add(new Order(Foods.foods[i].getName(),Foods.foods[i].getQuantity(),Foods.foods[i].getPrice()));
                }for(int i =0;i<Snacks.snacks.length;i++){
                    orderList.add(new Order(Snacks.snacks[i].getName(),Snacks.snacks[i].getQuantity(),Snacks.snacks[i].getPrice()));
                }
                TextView suces= (TextView)findViewById(R.id.done);
                suces.setText("Payment Done.Thank you.(If you want to order again press back)");
            }
        });
        mButton2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(OrderActivity.this, MapsActivity.class);
                startActivity(intent);
            }
        });
        mButton3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(OrderActivity.this, HistoryActivity.class);
                startActivity(intent);
            }
        });

    }


}