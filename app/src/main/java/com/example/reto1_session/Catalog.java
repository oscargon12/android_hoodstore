package com.example.reto1_session;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.example.reto1_session.Adapters.ProductAdapter;
import com.example.reto1_session.DB.DBFirebase;
import com.example.reto1_session.Entities.Product;

import java.util.ArrayList;

public class Catalog extends AppCompatActivity {

    //Llamo la DB
    private DBFirebase dbFirebase;

    private ListView listViewProducts;
    private ArrayList<Product> arrayProducts;
    private ProductAdapter productAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalog);

        listViewProducts = (ListView) findViewById(R.id.listViewProducts);
        arrayProducts = new ArrayList<>();


        //Inicializar la DB
        dbFirebase = new DBFirebase();

        //*** Produts ***
        //Listado / Creacion de productos
        /*
        Product producto1 = new Product("Rick and Morty Pair", "Pullover Unisex Pullover Hoodie", 100, "", "", "");
        Product producto2 = new Product("Netflix Stranger Things", "SuperHeroes Inc. Hoodie", 120, "", "", "" );
        Product producto3 = new Product("Netflix Witcher", "SuperHeroes Inc. Contrast Pullover Hooded Sweatshirt", 110, "", "","" );
        Product producto4 = new Product("Harry Potter Hogwarts", "College Crest Pullover Hoodie", 130, "", "", "" );

        arrayProducts.add(producto1);
        arrayProducts.add(producto2);
        arrayProducts.add(producto3);
        arrayProducts.add(producto4);
        */
        //*** Produts End ***

        productAdapter = new ProductAdapter(this, arrayProducts);
        listViewProducts.setAdapter(productAdapter);

        dbFirebase.getData(productAdapter); //Consulta los datos y los lleva al adaptador
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent intent;
        switch (item.getItemId()){
            case R.id.itemAdd:
                intent = new Intent(getApplicationContext(), Form.class); //Si presiono add, ir al form
                startActivity(intent);
                return true;
            case R.id.itemMap:

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
}