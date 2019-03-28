package com.projectactivity.deep.sample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FeedbackActivity extends AppCompatActivity {

    String enrollmentNo;
    EditText feed_detail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        setTitle("FeedbackBox");

        final APIInterface apiService =
                ApiClient.getClient().create(APIInterface.class);

        enrollmentNo = getIntent().getStringExtra("enrollmentNo");
        if(enrollmentNo == null){
            Toast.makeText(this, "Id card scan is required, please try again", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this, StartActivity.class));
            finish();
        }else{
            Toast.makeText(this, "Enrollment no is "+enrollmentNo, Toast.LENGTH_SHORT).show();
        }

        feed_detail = (EditText) findViewById(R.id.feedback_txt);

        /** submit button query **/
        Button f_submit = findViewById(R.id.Fsub_btn);

        f_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String feedback = feed_detail.getText().toString();

                if(TextUtils.isEmpty(feedback)){
                    feed_detail.setError("Feedback is required");
                    return;
                }

                ModelFeedback p = new ModelFeedback(enrollmentNo,feedback);


                Call<ModelFeedback> call = apiService.sendModel(p);

                call.enqueue(new Callback<ModelFeedback>() {
                    @Override
                    public void onResponse(Call<ModelFeedback> call, Response<ModelFeedback> response) {
                        Toast.makeText(FeedbackActivity.this, "done", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(FeedbackActivity.this, EndActivity.class));
                        finish();
                    }

                    @Override
                    public void onFailure(Call<ModelFeedback> call, Throwable t) {
                        Toast.makeText(FeedbackActivity.this, "Failed", Toast.LENGTH_SHORT).show();
                    }
                });

                /*startActivity(new Intent(FeedbackActivity.this,EndActivity.class));
                Toast.makeText(FeedbackActivity.this,"Enrollment no : "+enrollmentNo+" your Feedback : "+feedback,Toast.LENGTH_SHORT).show();
                finish();*/
            }
        });

        /** Reset feedback button query **/
        Button f_reset =findViewById(R.id.Freset_btn);

        f_reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                feed_detail.setText("");
            }
        });

        /** cancel button query **/
        Button fcancel = findViewById(R.id.Fcancel_btn);

        fcancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FeedbackActivity.this,StartActivity.class));
                Toast.makeText(FeedbackActivity.this,"Activity is successfully cancelled.",Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}
