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

public class TopupActivity extends AppCompatActivity {

    public static final String TopUp_ID = "topUpId";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topup);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        final int topUpId = (Integer) getIntent().getExtras().get(TopUp_ID);
        String topUpName = TopUp.topups[topUpId].getName();
        TextView textView = (TextView) findViewById(R.id.topUp_text);
        textView.setText(topUpName);
        final int topUpSaldo = TopUp.topups[0].getSaldo();
        TextView textView1 = (TextView)findViewById(R.id.saldo_text);
        textView1.setText("Saldo: "+String.valueOf(topUpSaldo));
        int topUpImage = TopUp.topups[topUpId].getImageResourceId();
        ImageView imageView = (ImageView) findViewById(R.id.topUp_image);
        imageView.setImageDrawable(ContextCompat.getDrawable(this, topUpImage));
        imageView.setContentDescription(topUpName);
        Button mButton = (Button)findViewById(R.id.button1);
        mButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                EditText input = (EditText)findViewById(R.id.saldo);
                int saldo = Integer.parseInt(input.getText().toString());
                if(saldo > 2000000){
                    TextView notif2 = (TextView)findViewById(R.id.saldotest);
                    notif2.setText("Balance cant more than 2.000.000");
                    return;
                }
                int total = topUpSaldo+saldo;
                TopUp.topups[0].setSaldo(total);
                TextView notif1 = (TextView)findViewById(R.id.saldotest);
                notif1.setText("Balance has been update press back to back to menu");
            }
        });
    }
}