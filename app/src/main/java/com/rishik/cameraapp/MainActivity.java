package com.rishik.cameraapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private Button capture;
    private ImageView ImgCapture;
    private static final int code = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        capture = findViewById(R.id.capture);
        ImgCapture = findViewById(R.id.imgview);
        capture.setOnClickListener(new View.OnClickListener() {
            @SuppressWarnings("deprecation")
            @Override
            public void onClick(View view) {
                Intent Cint = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(Cint,code);
            }
        });


    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data ) {

        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == code){
            if(resultCode == RESULT_OK){
                Bitmap bp =(Bitmap) data.getExtras().get("data");
                ImgCapture.setImageBitmap(bp);


            }
            else if (resultCode == RESULT_CANCELED){
                Toast.makeText(this,"Cancelled",Toast.LENGTH_SHORT).show();
            }
        }
    }
}