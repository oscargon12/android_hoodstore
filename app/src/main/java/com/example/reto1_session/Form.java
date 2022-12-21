package com.example.reto1_session;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.reto1_session.DB.DBFirebase;
import com.example.reto1_session.Entities.Product;

public class Form extends AppCompatActivity {

    //Llamo la base de datos
    private DBFirebase dbFirebase;

    //llamo los elementos del form
    private Button btnForm;
    private EditText editNameForm, editDescriptionForm, editPriceForm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        //Inicializo los elementos del form
        btnForm = (Button) findViewById(R.id.btnForm);
        editNameForm = (EditText) findViewById(R.id.editNameForm);
        editDescriptionForm = (EditText) findViewById(R.id.editDescriptionForm);
        editPriceForm = (EditText) findViewById(R.id.editPriceForm);

        //Inicializo la DB
        dbFirebase = new DBFirebase();

        //Funciones:
        btnForm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Product product = new Product(
                  editNameForm.getText().toString(),
                        editDescriptionForm.getText().toString(),
                        Integer.parseInt(editPriceForm.getText().toString()),
                        "",
                        "",
                        ""
                );

                dbFirebase.insertData(product);
                Intent intent = new Intent(getApplicationContext(), Catalog.class);
                startActivity(intent);
            }
        });
    }
}