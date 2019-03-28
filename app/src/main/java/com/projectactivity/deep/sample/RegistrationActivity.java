package com.projectactivity.deep.sample;

import android.content.Context;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import org.w3c.dom.Text;

public class RegistrationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        Button btn = findViewById(R.id.btn_submit);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(RegistrationActivity.this,"Sucessfully registered",Toast.LENGTH_SHORT).show();
            }
        });

        Button btn_add=(Button) findViewById(R.id.btn_add1);
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegistrationActivity.this,Calculator.class));
                Toast.makeText(RegistrationActivity.this, "calculator open sucessfully", Toast.LENGTH_SHORT).show();
            }
        });

        Button btn_forgot = findViewById(R.id.btn_forgot);

        btn_forgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegistrationActivity.this,ForgotPasswordActivity.class);
                startActivity(intent);
          }
        });

        Button c_btn = findViewById(R.id.c_btn);

        c_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegistrationActivity.this, StartActivity.class);
                startActivity(intent);
            }
        });
    }
}
