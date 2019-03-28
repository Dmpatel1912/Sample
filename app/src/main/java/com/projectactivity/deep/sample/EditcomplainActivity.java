package com.projectactivity.deep.sample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class EditcomplainActivity extends AppCompatActivity {

    String enrollmentNo=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editcomplain);
        setTitle("EDIT or NEW");

        enrollmentNo =getIntent().getStringExtra("enrollmentno");

        final Button edit_complain = findViewById(R.id.editcomplain_btn);

        edit_complain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(EditcomplainActivity.this, "Edit your previous complain", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(EditcomplainActivity.this, ComplainActivity.class));
                finish();

            }
        });

        final Button new_complain = findViewById(R.id.newcomplain_btn);

        edit_complain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(EditcomplainActivity.this, "Put your complain here", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(EditcomplainActivity.this, ComplainActivity.class));
                finish();

            }
        });
    }
}
