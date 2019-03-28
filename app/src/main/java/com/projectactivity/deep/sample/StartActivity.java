package com.projectactivity.deep.sample;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        Button wel_btn = findViewById(R.id.welcome_btn);
        wel_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(StartActivity.this,ComplainActivity.class));
            }
        });

        Button to_btn = findViewById(R.id.to_btn);
        to_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(StartActivity.this,FeedbackActivity.class));
            }
        });


        Button com1 = findViewById(R.id.com_btn);

        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.CAMERA},12);
        }

        com1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getApplicationContext(),ScanCodeActivity.class);
                i.putExtra("action","complaint");
                startActivity(i);

               // startActivityForResult(new Intent(MediaStore.ACTION_IMAGE_CAPTURE),654);
            }
        });

        Button feed1=(Button) findViewById(R.id.feed_btn);

        feed1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(getApplicationContext(),ScanCodeActivity.class);
                i.putExtra("action","feedback");
                startActivity(i);
                finish();
            }
        });

        Button contact_us =(Button) findViewById(R.id.contact_us_btn);

        contact_us.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto","dmp121197@gmail.com",null));
                emailIntent.putExtra(Intent.EXTRA_SUBJECT,"");
                emailIntent.putExtra(Intent.EXTRA_TEXT,"");
                startActivity(Intent.createChooser(emailIntent,"Send email"));
            }
        });

       /* Button FAQ = findViewById(R.id.FAQ_btn);
        FAQ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(StartActivity.this,FAQActivity.class));
            }
        });*/

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(ActivityCompat.checkSelfPermission(this,"android.permission.CAMERA") != PackageManager.PERMISSION_GRANTED){
            Toast.makeText(this, "You need to provide camera permission", Toast.LENGTH_SHORT).show();
        }
    }
     /** @Override
        protected void onActivityResult(int requestCode, int resultCode, Intent data) {
            if(requestCode == 654){
                startActivity(new Intent(StartActivity.this,ComplainActivity.class));
                Toast.makeText(StartActivity.this,"Now you can put your complain here.",Toast.LENGTH_SHORT).show();
            } else{
                startActivity(new Intent(StartActivity.this,FeedbackActivity.class));
                Toast.makeText(StartActivity.this, "Now you can put your feedback here.", Toast.LENGTH_SHORT).show();
            }
        }
      **/
}
