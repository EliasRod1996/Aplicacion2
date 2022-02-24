package com.example.aplicacion2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class infoMetro extends AppCompatActivity {

    Button btnVisitarMetro, btnCamaraMetro;
    ImageView imgFotoMetro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_metro);

        btnVisitarMetro = findViewById(R.id.btnVisitarMetro);
        btnCamaraMetro = findViewById(R.id.btnCamaraMetro);
        imgFotoMetro = findViewById(R.id.imgFotoMetro);


        //BOTONES DE CAMARAS
        btnCamaraMetro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirCamara();
            }
        });

        btnVisitarMetro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent irProdMetro = new Intent(infoMetro.this, productosMetro.class);
                startActivity(irProdMetro);
            }
        });
    }
    private void abrirCamara(){
        Intent abrirCam = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        //startActivity(abrirCam);
        startActivityForResult(abrirCam, 1);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //llamando al metodo construcor
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK) {

            Bundle extras = data.getExtras();
            Bitmap imgBm = (Bitmap) extras.get("data");
            imgFotoMetro.setImageBitmap(imgBm);
        }
    }
}