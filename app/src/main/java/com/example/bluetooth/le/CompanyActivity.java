package com.example.bluetooth.le;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class CompanyActivity extends Activity {

    CardView card1,card2;
    ImageButton ble;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company);

        card1= (CardView) findViewById(R.id.tv_item);
        card2= (CardView) findViewById(R.id.tv_item2);

        card1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(CompanyActivity.this,"点了人家一下啦！！" ,
                        Toast.LENGTH_SHORT).show();
            }
        });
        card2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(CompanyActivity.this,"点了人家一下啦！！" ,
                        Toast.LENGTH_SHORT).show();
            }
        });

        ble= (ImageButton) findViewById(R.id.ble);
        ble.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent();
                intent.setClass(CompanyActivity.this,DeviceScanActivity.class);
                startActivity(intent);

            }
        });

    }


}
