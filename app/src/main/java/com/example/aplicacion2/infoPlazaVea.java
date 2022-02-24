package com.example.aplicacion2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class infoPlazaVea extends AppCompatActivity {

    Button btnCamaraPlazavea,btnVisitarPvea;
    ImageView imgFotoPlazaVea;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_plaza_vea);

        btnCamaraPlazavea = findViewById(R.id.btnCamaraPlazavea);
        btnVisitarPvea = findViewById(R.id.btnVisitarPvea);
        imgFotoPlazaVea = findViewById(R.id.imgFotoPlazaVea);


        btnCamaraPlazavea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirCamara();


            }
        });
    }

    private void abrirCamara(){

        Intent abrirCam = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult (abrirCam, 1);
    }

    protected  void onActivityResult(int requestCode, int resulCode, Intent data) {

        super.onActivityResult(requestCode, resulCode, data);
        if (requestCode == 1 && resulCode == RESULT_OK) {

            Bundle extras = data.getExtras();
            Bitmap imgBm = (Bitmap) extras.get("data");
            imgFotoPlazaVea.setImageBitmap(imgBm);
        }

    }


}