package com.projectactivity.deep.sample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ForgotPasswordActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);


        Button btn_forgot = findViewById(R.id.btn_forgot);
        btn_forgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText et_email = findViewById(R.id.et_email);
                String email = et_email.getText().toString();
               
                Toast.makeText(ForgotPasswordActivity.this, "Email is "+email, Toast.LENGTH_SHORT).show();

                TextView tv_output = findViewById(R.id.tv_output);
                tv_output.setText("Email is "+email);
            }
        });
    }
}
