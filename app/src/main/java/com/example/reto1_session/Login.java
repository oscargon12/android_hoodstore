package com.example.reto1_session;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.reto1_session.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {

    private Button btnLogin, btnLoginRegister;
    private EditText editMailLogin, editPassLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnLoginRegister = (Button) findViewById(R.id.btnLoginRegister);
        editMailLogin = (EditText) findViewById(R.id.editMailLogin);
        editPassLogin = (EditText) findViewById(R.id.editPassLogin);

        //Login btn
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mail = editMailLogin.getText().toString();
                String pass = editPassLogin.getText().toString();

                FirebaseAuth mAuth;
                // ...
                // Initialize Firebase Auth
                mAuth = FirebaseAuth.getInstance();

                mAuth.signInWithEmailAndPassword(mail, pass)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if(task.isSuccessful()){
                                    Intent intent = new Intent(getApplicationContext(), Catalog.class);
                                    startActivity(intent);
                                }
                            }
                        });


            }
        });

        //Register btn
        btnLoginRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Register.class);
                startActivity(intent);
            }
        });
    }
}