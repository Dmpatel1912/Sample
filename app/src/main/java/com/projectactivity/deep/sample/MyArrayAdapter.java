package com.projectactivity.deep.sample;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class MyArrayAdapter extends BaseAdapter {

    Activity activity;
    String[] mtypes;


    public MyArrayAdapter(@NonNull Activity context, @NonNull String[] types) {
        this.activity = context;
        this.mtypes = types;
    }


    @Override
    public int getCount() {
        return mtypes.length;
    }

    @Override
    public String getItem(int i) {
        return mtypes[i];
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        View v = view;
        LayoutInflater inflater = activity.getLayoutInflater();
        v = inflater.inflate(R.layout.custom_spinner_item, null);
        TextView tv = v.findViewById(R.id.spinner_type);

        String value = mtypes[position];
        tv.setText(value);

        return v;

    }
}
