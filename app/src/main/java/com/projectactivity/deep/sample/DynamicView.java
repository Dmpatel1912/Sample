package com.projectactivity.deep.sample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Spinner;

public class DynamicView extends AppCompatActivity {

    Spinner spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic_view);

        spinner = findViewById(R.id.spinner_type2);

        String[] types = getResources().getStringArray(R.array.types);
        MyArrayAdapter adapter = new MyArrayAdapter(DynamicView.this,types);
        spinner.setAdapter(adapter);
    }
}
