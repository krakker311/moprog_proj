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

public class FoodActivity extends AppCompatActivity {
    public static final String Food_ID = "foodId";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        final int foodId = (Integer)getIntent().getExtras().get(Food_ID);
        String foodName = Foods.foods[foodId].getName();
        TextView textView = (TextView)findViewById(R.id.food_text);
        textView.setText(foodName);
        int foodPrice = Foods.foods[foodId].getPrice();
        TextView textView1 = (TextView)findViewById(R.id.price_text);
        textView1.setText("Price: "+String.valueOf(foodPrice));
        int foodImage = Foods.foods[foodId].getImageResourceId();
        ImageView imageView = (ImageView)findViewById(R.id.food_image);
        imageView.setImageDrawable(ContextCompat.getDrawable(this, foodImage));
        imageView.setContentDescription(foodName);
        Button mButton = (Button)findViewById(R.id.button1);
        mButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                EditText input = (EditText)findViewById(R.id.quantity);
                int quantity = Integer.parseInt(input.getText().toString());
                if(Foods.foods[foodId].getQuantity()==0){
                    Foods.foods[foodId].setQuantity(quantity);
                    TextView notif = (TextView)findViewById(R.id.qtytest);
                    notif.setText("Quantity has been input press back to back to menu");
                }else{
                    int total = quantity+Foods.foods[foodId].getQuantity();
                    Foods.foods[foodId].setQuantity(quantity);
                    TextView notif1 = (TextView)findViewById(R.id.qtytest);
                    notif1.setText("Quantity has been update press back to back to menu");
                }


            }
        });

    }
}