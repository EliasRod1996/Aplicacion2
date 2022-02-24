package com.example.aplicacion2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class infoVivanda extends AppCompatActivity {

    Button btnVisitarVivanda, btnCamaraVivanda;
    ImageView imfFotoVivanda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_vivanda);

        btnCamaraVivanda = findViewById(R.id.btnCamaraVivanda);
        btnVisitarVivanda = findViewById(R.id.btnVisitarVivanda);
        imfFotoVivanda = findViewById(R.id.imgFotoVivanda);


        btnCamaraVivanda.setOnClickListener(new View.OnClickListener() {
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
            Bitmap imgBM = (Bitmap) extras.get("data");
            imfFotoVivanda.setImageBitmap(imgBM);
        }
    }
}