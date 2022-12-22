package com.example.reto1_session;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class Register extends AppCompatActivity {

    private Button btnRegister;
    private EditText editMailReg, editPassReg, editPassConfirmReg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        btnRegister = (Button) findViewById(R.id.btnRegister);
        editMailReg = (EditText) findViewById(R.id.editMailReg);
        editPassReg = (EditText) findViewById(R.id.editPassReg);
        editPassConfirmReg = (EditText) findViewById(R.id.editPassConfirmReg);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mail = editMailReg.getText().toString();
                String pass = editPassReg.getText().toString();
                String confirm = editPassConfirmReg.getText().toString();

                if(pass.compareTo(confirm) == 0){
                    FirebaseAuth mAuth;
                    // ...
                    // Initialize Firebase Auth
                    mAuth = FirebaseAuth.getInstance();
                    mAuth.createUserWithEmailAndPassword(mail, pass);
                    Intent intent = new Intent(getApplicationContext(), Login.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(), "Contraseña no coincide", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}