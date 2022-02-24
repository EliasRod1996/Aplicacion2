package com.example.aplicacion2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PDeVentas extends AppCompatActivity {

    Button btnUbiMetro, btnUbiVea, btnUbiSodi, btnUbiWong, btnVisMetro, btnVisPvea,btnVisSodi, btnVisWong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pde_ventas);


        btnUbiMetro = findViewById(R.id.btnUbiMetro);
        btnUbiVea = findViewById(R.id.btnUbiPvea);
        btnUbiSodi =  findViewById(R.id.btnUbiSodi);
        btnUbiWong = findViewById(R.id.btnUbiWong);
        btnVisMetro = findViewById(R.id.btnVisMetro);
        btnVisPvea = findViewById(R.id.btnVisPvea);
        btnVisSodi = findViewById(R.id.btnVisSodi);
        btnVisWong = findViewById(R.id.btnVisWong);

        btnUbiMetro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent ametro = new Intent(getApplicationContext(), Metro.class);
                startActivity(ametro);
            }
        });
        
        
        btnUbiVea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                
                Intent aPvea = new Intent(getApplicationContext(), plazavea.class);
                startActivity(aPvea);
            }
        });

        btnUbiSodi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent aSodimac = new Intent(getApplicationContext(), sodimac.class);
                startActivity(aSodimac);
            }
        });

        btnUbiWong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent aVivanda = new Intent(getApplicationContext(), wong.class);
                startActivity(aVivanda);
            }
        });

        //BOTONES DE VISITA

        btnVisMetro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alerta=new AlertDialog.Builder(PDeVentas.this);
                alerta.setMessage("¿ Atendera Metro ?")
                        .setCancelable(false)
                        .setPositiveButton("Si", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                                    Intent infoMetro = new Intent(PDeVentas.this, infoMetro.class);
                                    startActivity(infoMetro);
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.cancel();
                            }
                        });
                AlertDialog titulo = alerta.create();
                titulo.setTitle("Avanzar");
                titulo.show();

            }
        });
        btnVisPvea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alerta=new AlertDialog.Builder(PDeVentas.this);
                alerta.setMessage("¿ Atendera PlazaVea?")
                        .setCancelable(false)
                        .setPositiveButton("Si", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                                Intent infoPvea = new Intent(PDeVentas.this, infoPlazaVea.class);
                                startActivity(infoPvea);
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.cancel();
                            }
                        });
                AlertDialog titulo = alerta.create();
                titulo.setTitle("Avanzar");
                titulo.show();

            }
        });
        btnVisSodi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alerta=new AlertDialog.Builder(PDeVentas.this);
                alerta.setMessage("¿ Atendera Sodimac ?")
                        .setCancelable(false)
                        .setPositiveButton("Si", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                                Intent infoSodi = new Intent(PDeVentas.this, infoSodimac.class);
                                startActivity(infoSodi);
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.cancel();
                            }
                        });
                AlertDialog titulo = alerta.create();
                titulo.setTitle("Avanzar");
                titulo.show();

            }
        });
        btnVisWong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alerta=new AlertDialog.Builder(PDeVentas.this);
                alerta.setMessage("¿ Atendera Vivanda ?")
                        .setCancelable(false)
                        .setPositiveButton("Si", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                                Intent infoViva = new Intent(PDeVentas.this, infoVivanda.class);
                                startActivity(infoViva);
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.cancel();
                            }
                        });
                AlertDialog titulo = alerta.create();
                titulo.setTitle("Avanzar");
                titulo.show();

            }
        });
    }
}