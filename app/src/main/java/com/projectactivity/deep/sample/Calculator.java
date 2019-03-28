package com.projectactivity.deep.sample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Calculator extends AppCompatActivity {

    String st_a1,st_a2,st_a3;
    int a1,a2,a3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        Button btn_add = findViewById(R.id.btn_add);
        btn_add.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                EditText et_a1=findViewById(R.id.et_a1);
                EditText et_a2=findViewById((R.id.et_a2));

                st_a1=et_a1.getText().toString();
                st_a2=et_a2.getText().toString();

                a1= Integer.parseInt(st_a1);
                a2= Integer.parseInt(st_a2);

                a3=a1+a2;

                st_a3= String.valueOf(a3);

                TextView tv_ans=findViewById(R.id.ans);
                tv_ans.setText(st_a3);
            }
        });
        Button btn_sub = findViewById(R.id.btn_sub);
        btn_sub.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                EditText et_a1=findViewById(R.id.et_a1);
                EditText et_a2=findViewById((R.id.et_a2));

                st_a1=et_a1.getText().toString();
                st_a2=et_a2.getText().toString();

                a1= Integer.parseInt(st_a1);
                a2= Integer.parseInt(st_a2);

                a3=a1-a2;

                st_a3= String.valueOf(a3);

                TextView tv_ans=findViewById(R.id.ans);
                tv_ans.setText(st_a3);
            }
        });

        Button btn_div = findViewById(R.id.btn_div);
        btn_div.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                EditText et_a1=findViewById(R.id.et_a1);
                EditText et_a2=findViewById((R.id.et_a2));

                st_a1=et_a1.getText().toString();
                st_a2=et_a2.getText().toString();

                a1= Integer.parseInt(st_a1);
                a2= Integer.parseInt(st_a2);

                a3=a1/a2;

                st_a3= String.valueOf(a3);

                TextView tv_ans=findViewById(R.id.ans);
                tv_ans.setText(st_a3);
            }
        });

        Button btn_mal = findViewById(R.id.btn_mal);
        btn_mal.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                EditText et_a1=findViewById(R.id.et_a1);
                EditText et_a2=findViewById((R.id.et_a2));

                st_a1=et_a1.getText().toString();
                st_a2=et_a2.getText().toString();

                a1= Integer.parseInt(st_a1);
                a2= Integer.parseInt(st_a2);

                a3=a1*a2;

                st_a3= String.valueOf(a3);

                TextView tv_ans=findViewById(R.id.ans);
                tv_ans.setText(st_a3);
            }
        });
    }
}
