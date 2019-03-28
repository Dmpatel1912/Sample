package com.projectactivity.deep.sample;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ComplainActivity extends AppCompatActivity {

    Spinner spinner;
    String enrollmentNo=null;
//    Button Add;

    EditText com_detail;
//    Spinner spinner_type;
//    EditText com_detail2;

    String spinertype,complain;
//    String spinertype,complain,spinnertype,d;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complain);
        setTitle("ComplainBox");

        final APIInterface apiService =
                ApiClient.getClient().create(APIInterface.class);

       enrollmentNo = getIntent().getStringExtra("enrollmentNo");
        if (enrollmentNo == null) {
            Toast.makeText(this, "Id card scan is required, please try again", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this, StartActivity.class));
            finish();
        } else {
            Toast.makeText(this, "Enrollment no is " + enrollmentNo, Toast.LENGTH_SHORT).show();
        }

        final Button c_submit = findViewById(R.id.submit_btn);

        spinner = findViewById(R.id.spinner_type);

        String[] types = getResources().getStringArray(R.array.types);
        final MyArrayAdapter adapter = new MyArrayAdapter(ComplainActivity.this, types);
        spinner.setAdapter(adapter);

        c_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                 spinertype = spinner.getSelectedItem().toString();
                 com_detail= findViewById(R.id.discription_txt);
                 complain = com_detail.getText().toString();

               /* if(spinner_type == null){
                    spinnertype = "null";
                }else{
                    spinnertype = spinner_type.getSelectedItem().toString();
                }

                if(com_detail2 == null){
                    d = "null";
                }else{
                    d = com_detail2.getText().toString();
                }*/

                if(TextUtils.isEmpty(complain)){
                    com_detail.setError("complain detail is required");
                    return;
                }
               /* if (TextUtils.isEmpty(d)){
                    com_detail2.setError("complain detail is required");
                    return;
                }*/
                else{

//                printer(spinertype, complain, spinnertype, d);
                   // printer(spinertype, complain);

                    ModelComplain p = new ModelComplain(enrollmentNo,spinertype,complain);


                    Call<ModelComplain> call = apiService.sendModel(p);

                    call.enqueue(new Callback<ModelComplain>() {
                        @Override
                        public void onResponse(Call<ModelComplain> call, Response<ModelComplain> response) {
                            Toast.makeText(ComplainActivity.this, "done", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(ComplainActivity.this, EndActivity.class));
                            finish();
                        }

                        @Override
                        public void onFailure(Call<ModelComplain> call, Throwable t) {
                            Toast.makeText(ComplainActivity.this, "Failed", Toast.LENGTH_SHORT).show();
                        }
                    });


               /*     startActivity(new Intent(ComplainActivity.this, EndActivity.class));
                    finish();*/
                }
            }
        });

        com_detail = (EditText) findViewById(R.id.discription_txt);

        /*com_detail2=findViewById(R.id.discription_txt2);*/

        Button c_reset = findViewById(R.id.reset_btn);

        c_reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                com_detail.setText("");

                /*com_detail2.setText("");*/


            }
        });

        Button c_cancel = findViewById(R.id.cancel_btn);

        c_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ComplainActivity.this, StartActivity.class));
                Toast.makeText(ComplainActivity.this, "Activity is sucessfully cancelled.", Toast.LENGTH_SHORT).show();
                finish();
            }
        });

        final Button feed = findViewById(R.id.feedback_btn);

        feed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                enrollmentNo = getIntent().getStringExtra("enrollmentNo");
                Intent i = new Intent(ComplainActivity.this,FeedbackActivity.class);
                i.putExtra("action","feed");
                i.putExtra("enrollmentNo",enrollmentNo);
                startActivity(i);

            }
        });

       /* Add = findViewById(R.id.add_btn);

        Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LinearLayout parentLayout = (LinearLayout) findViewById(R.id.Type_Discrip_layout);
                LayoutInflater layoutInflater = getLayoutInflater();
                View view2;

                view2 = layoutInflater.inflate(R.layout.activity_dynamic_view, parentLayout, false);

                parentLayout.addView(view2);

                spinner_type = view2.findViewById(R.id.spinner_type2);
                com_detail2 = view2.findViewById(R.id.discription_txt2);
                String[] types = getResources().getStringArray(R.array.types);
                MyArrayAdapter adapter = new MyArrayAdapter(ComplainActivity.this, types);
                spinner_type.setAdapter(adapter);

                Add.setEnabled(false);
                Add.setTextColor(Color.GRAY);
            }
        });*/
    }

    /*public void printer(String sp1, String desc1, String spn2, String desc2) {
        Toast.makeText(this,"enrollment no : "+enrollmentNo+" sp1 : " +sp1+ " desc1 : " +desc1 +" sp2 : " +spn2+ " desc2 : " +desc2 , Toast.LENGTH_SHORT).show();
    }*/
    public void printer(String spinner, String description) {
        Toast.makeText(this, "enrollment no : " + enrollmentNo + " sp1 : " + spinner + " desc1 : " + description, Toast.LENGTH_SHORT).show();
    }
}
