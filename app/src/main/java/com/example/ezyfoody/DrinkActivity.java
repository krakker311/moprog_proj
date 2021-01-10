package com.example.ezyfoody;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;



public class DrinkActivity extends AppCompatActivity {
    public static final String Drink_ID = "drinkId";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        final int drinkId = (Integer)getIntent().getExtras().get(Drink_ID);
        String drinkName = Drink.drinks[drinkId].getName();
        TextView textView = (TextView)findViewById(R.id.drink_text);
        textView.setText(drinkName);
        int drinkPrice = Drink.drinks[drinkId].getPrice();
        TextView textView1 = (TextView)findViewById(R.id.price_text);
        textView1.setText("Price: "+String.valueOf(drinkPrice));
        int drinkImage = Drink.drinks[drinkId].getImageResourceId();
        ImageView imageView = (ImageView)findViewById(R.id.drink_image);
        imageView.setImageDrawable(ContextCompat.getDrawable(this, drinkImage));
        imageView.setContentDescription(drinkName);
        Button mButton = (Button)findViewById(R.id.button1);
        mButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                EditText input = (EditText)findViewById(R.id.quantity);
                int quantity = Integer.parseInt(input.getText().toString());
                if(Drink.drinks[drinkId].getQuantity()==0){
                    Drink.drinks[drinkId].setQuantity(quantity);
                    TextView notif = (TextView)findViewById(R.id.qtytest);
                    notif.setText("Quantity has been input press back to back to menu");
                }else{
                    int total = quantity+Drink.drinks[drinkId].getQuantity();
                    Drink.drinks[drinkId].setQuantity(quantity);
                    TextView notif1 = (TextView)findViewById(R.id.qtytest);
                    notif1.setText("Quantity has been update press back to back to menu");
                }


            }
        });

    }
}