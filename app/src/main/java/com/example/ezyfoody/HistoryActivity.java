package com.example.ezyfoody;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Date;

public class HistoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        final ArrayList<History> historyList = new ArrayList<>();
        String name,qty,price;
        Date date;
        if(History.getHistoryList().isEmpty() ){
            TextView total= (TextView)findViewById(R.id.kosong);
            total.setText("no history");
        }else{
            for(int i =0;i<History.getHistoryList().size();i++){

                name = History.getHistoryList().get(i).getFood();
                qty = History.getHistoryList().get(i).getQty();
                price= History.getHistoryList().get(i).getTotalprice();
                date = History.getHistoryList().get(i).getDate();
                historyList.add(new History(name,qty,price,date));
            }
        }



        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        CardHistoryAdapter adapter = new CardHistoryAdapter(historyList);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(HistoryActivity.this);

        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setAdapter((RecyclerView.Adapter) adapter);
    }
}