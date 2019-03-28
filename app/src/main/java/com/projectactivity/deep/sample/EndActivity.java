package com.projectactivity.deep.sample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class EndActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end);

        Button home = findViewById(R.id.FeedTOHome);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(EndActivity.this,StartActivity.class));
                Toast.makeText(EndActivity.this,"Thank You",Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}
