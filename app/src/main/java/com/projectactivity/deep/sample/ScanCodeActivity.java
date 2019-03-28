package com.projectactivity.deep.sample;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;

import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ScanCodeActivity extends AppCompatActivity implements ZXingScannerView.ResultHandler {

    ZXingScannerView ScannerView;
    AlertDialog dialog;
    String enrollementNo;
    String action;
    Intent i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan_code);
        ScannerView = new ZXingScannerView(this);
        setContentView(ScannerView);
        enrollementNo = "";
        action = getIntent().getStringExtra("action");
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle("Please Wait");
        alertDialogBuilder.setMessage("Checking your details with system");
        alertDialogBuilder.setCancelable(false);
        dialog = alertDialogBuilder.create();
    }
    public void handleResult(Result result) {


        enrollementNo = result.getText();


        if(TextUtils.isEmpty(enrollementNo)){
            Toast.makeText(this, "Could not get Your details", Toast.LENGTH_SHORT).show();
            return;
        }

        dialog.show();
        APIInterface apiInterface = ApiClient.getClient().create(APIInterface.class);
        Call<ModelStudent> call = apiInterface.getModelPost(enrollementNo);

        call.enqueue(new Callback<ModelStudent>() {
            @Override
            public void onResponse(Call<ModelStudent> call, Response<ModelStudent> response) {
                Toast.makeText(ScanCodeActivity.this, "Success", Toast.LENGTH_SHORT).show();
                ModelStudent student = response.body();


                Toast.makeText(ScanCodeActivity.this, "Email : "+student.getEmail(), Toast.LENGTH_SHORT).show();
                dialog.hide();

                if(action.equals("complaint")){
                    i = new Intent(ScanCodeActivity.this,ComplainActivity.class);
                }else{
                    i = new Intent(ScanCodeActivity.this,FeedbackActivity.class);
                }

                i.putExtra("enrollmentNo",enrollementNo);
                startActivity(i);
                finish();
            }

            @Override
            public void onFailure(Call<ModelStudent> call, Throwable t) {
                Toast.makeText(ScanCodeActivity.this, "Some error occured : "+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });


    }

    @Override
    protected void onPause() {
        super.onPause();

        ScannerView.stopCamera();
    }

    @Override
    protected void onResume() {
        super.onResume();

        ScannerView.setResultHandler(this);
        ScannerView.startCamera();
    }
}
