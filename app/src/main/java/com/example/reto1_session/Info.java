package com.example.reto1_session;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Info extends AppCompatActivity {
    TextView textNameInfoProduct, textDescriptionInfoProduct, textPriceInfoProduct;
    ImageView imgInfoProduct;
    Button btnInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        //Recibiendo datos desde el adaptador
        textNameInfoProduct = (TextView) findViewById(R.id.textNameInfoProduct);
        textDescriptionInfoProduct = (TextView) findViewById(R.id.textDescriptionInfoProduct);
        textPriceInfoProduct = (TextView) findViewById(R.id.textPriceInfoProduct);
        imgInfoProduct = (ImageView) findViewById(R.id.imgInfoProduct);
        btnInfo = (Button) findViewById(R.id.btnInfo);

        Intent intentIN = getIntent();
        textNameInfoProduct.setText(intentIN.getStringExtra("name"));
        textDescriptionInfoProduct.setText(intentIN.getStringExtra("description"));
        textPriceInfoProduct.setText(String.valueOf(intentIN.getIntExtra("price", 0 )));
        imgInfoProduct.setImageResource(intentIN.getIntExtra("image", 0));

        btnInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Catalog.class);
                startActivity(intent);
            }
        });

    }
}