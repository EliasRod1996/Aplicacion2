package com.example.aplicacion2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuUsuario extends AppCompatActivity {

    Button btnPuntoDV, btnCerrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_usuario);

        btnPuntoDV = findViewById(R.id.btnPuntoDV);
        btnCerrar = findViewById(R.id.btnCerrar);



        btnPuntoDV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent =new Intent(MenuUsuario.this, PDeVentas.class);

                startActivity(intent);
            }
        });


        btnCerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();


            }
        });



    }
}