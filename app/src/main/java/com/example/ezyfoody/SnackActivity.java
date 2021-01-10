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

public class SnackActivity extends AppCompatActivity {
    public static final String Snack_ID = "snackId";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snack);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        final int snackId = (Integer)getIntent().getExtras().get(Snack_ID);
        String snackName = Snacks.snacks[snackId].getName();
        TextView textView = (TextView)findViewById(R.id.snack_text);
        textView.setText(snackName);
        int snackPrice = Snacks.snacks[snackId].getPrice();
        TextView textView1 = (TextView)findViewById(R.id.price_text);
        textView1.setText("Price: "+String.valueOf(snackPrice));
        int snackImage = Snacks.snacks[snackId].getImageResourceId();
        ImageView imageView = (ImageView)findViewById(R.id.snack_image);
        imageView.setImageDrawable(ContextCompat.getDrawable(this, snackImage));
        imageView.setContentDescription(snackName);
        Button mButton = (Button)findViewById(R.id.button1);
        mButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                EditText input = (EditText)findViewById(R.id.quantity);
                int quantity = Integer.parseInt(input.getText().toString());
                if(Snacks.snacks[snackId].getQuantity()==0){
                    Snacks.snacks[snackId].setQuantity(quantity);
                    TextView notif = (TextView)findViewById(R.id.qtytest);
                    notif.setText("Quantity has been input press back to back to menu");
                }else{
                    int total = Snacks.snacks[snackId].getQuantity();
                    Snacks.snacks[snackId].setQuantity(quantity);
                    TextView notif1 = (TextView)findViewById(R.id.qtytest);
                    notif1.setText("Quantity has been update press back to back to menu");
                }
            }
        });
}
}