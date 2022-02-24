package com.example.aplicacion2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class infoSodimac extends AppCompatActivity {

    Button btnCamaraSodimac, btnVisitarSodimac;
    ImageView imgFotoSodimac;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_sodimac);

        btnCamaraSodimac = findViewById(R.id.btnCamaraSodimac);
        btnVisitarSodimac = findViewById(R.id.btnVisitarSodimac);
        imgFotoSodimac = findViewById(R.id.imgFotoSodimac);


        btnVisitarSodimac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent irSodi = new Intent(infoSodimac.this, productosSodimac.class);
                startActivity(irSodi);
            }
        });


        btnCamaraSodimac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirCamara();

            }
        });
    }

    private void abrirCamara(){
        Intent abrirCam = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(abrirCam, 1);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK) {

            Bundle extras = data.getExtras();
            Bitmap imgBm = (Bitmap) extras.get("data");
            imgFotoSodimac.setImageBitmap(imgBm);
        }
    }
}