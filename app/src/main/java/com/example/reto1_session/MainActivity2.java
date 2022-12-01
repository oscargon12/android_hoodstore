package com.example.reto1_session;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.reto1_session.Adapters.ProductAdapter;
import com.example.reto1_session.Entidades.Product;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {

    ListView productListView;
    ProductAdapter productAdapter;
    ArrayList<Product> arrayProducts;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        productListView = (ListView) findViewById(R.id.productListView);
        arrayProducts = new ArrayList<>();
        productAdapter = new ProductAdapter(this, arrayProducts);

        productListView.setAdapter(productAdapter);
    }
}