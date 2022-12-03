package com.example.reto1_session;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.reto1_session.Adapters.ProductAdapter;
import com.example.reto1_session.Entities.Product;

import java.util.ArrayList;

public class Catalog extends AppCompatActivity {

    private ListView listViewProducts;
    private ProductAdapter productAdapter;
    private ArrayList<Product> arrayProducts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalog);

        arrayProducts = new ArrayList<>();

        //Listado / Creacion de productos
        Product producto1 = new  Product(R.drawable.rym, "Saco 1", "Descripcion1", 100 );
        Product producto2 = new  Product(R.drawable.stranger, "Saco 2", "Descripcion2", 120 );
        Product producto3 = new  Product(R.drawable.witcher, "Saco 3", "Descripcion3", 110 );

        arrayProducts.add(producto1);
        arrayProducts.add(producto2);
        arrayProducts.add(producto3);

        listViewProducts = (ListView) findViewById(R.id.listViewProducts);
        productAdapter = new ProductAdapter(this, arrayProducts);
        listViewProducts.setAdapter(productAdapter);
    }
}