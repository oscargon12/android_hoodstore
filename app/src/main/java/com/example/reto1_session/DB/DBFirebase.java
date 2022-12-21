package com.example.reto1_session.DB;

import android.util.Log;

import androidx.annotation.NonNull;

import com.example.reto1_session.Adapters.ProductAdapter;
import com.example.reto1_session.Entities.Product;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DBFirebase {
    private FirebaseFirestore db;

    public DBFirebase() {
        db = FirebaseFirestore.getInstance();
    }

    //** Metodo POST **
    public void insertData(Product product) {

        // Create a new user with a first and last name
        Map<String, Object> prod = new HashMap<>();
        prod.put("id", product.getId());
        prod.put("name", product.getName());
        prod.put("description", product.getDescription());
        prod.put("price", product.getPrice());
        prod.put("image", product.getImage());
        prod.put("latitud", product.getLatitud());
        prod.put("longitud", product.getLongitud());

        // Add a new document with a generated ID
        db.collection("products").add(prod);
    }

    //** metodo GET **
    public void getData(ProductAdapter productAdapter) {
        db.collection("products")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {

                            ArrayList<Product> list = new ArrayList<>();
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Product product = new Product(
                                        document.getData().get("id").toString(),
                                        document.getData().get("name").toString(),
                                        document.getData().get("description").toString(),
                                        Integer.parseInt(document.getData().get("price").toString()),
                                        document.getData().get("image").toString(),
                                        document.getData().get("latitud").toString(),
                                        document.getData().get("longitud").toString()
                                );

                                //Agregando producto
                                list.add(product);
                                productAdapter.setArrayProducts(list);
                                productAdapter.notifyDataSetChanged(); // actualiza la pantalla
                            }
                        }
                    }
                });
    }

    //** metodo PUT **
    public void editData(Product product){
        db.collection("products").whereEqualTo("id", product.getId())
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {

                            ArrayList<Product> list = new ArrayList<>();
                            for(QueryDocumentSnapshot document : task.getResult()){
                                document.getReference().update(
                                        "name", product.getName(),
                                        "description", product.getDescription(),
                                        "price", product.getPrice(),
                                        "image", product.getImage(),
                                        "latitud", product.getLatitud(),
                                        "longitud", product.getLongitud()
                                );
                            }
                        }
                    }
                });
    }


    //** metodo DELETE **
    public void deleteData(String id){
        db.collection("products").whereEqualTo("id", id)
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {

                            ArrayList<Product> list = new ArrayList<>();
                            for(QueryDocumentSnapshot document : task.getResult()){
                                document.getReference().delete();
                            }
                        }
                    }
                });
    }

}