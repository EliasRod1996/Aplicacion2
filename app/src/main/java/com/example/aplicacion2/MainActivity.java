package com.example.aplicacion2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText txtusuario, txtcontra, txtrecontra;
    Button btnregistrar, btningresar;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtusuario = findViewById(R.id.txtusuario);
        txtcontra = findViewById(R.id.txtcontra);
        txtrecontra = findViewById(R.id.txtrecontra);

        btnregistrar = findViewById(R.id.btnregistrar);
        btningresar = findViewById(R.id.btniniciar);
        DB = new DBHelper(this);

        btnregistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String txusuario = txtusuario.getText().toString();
                String txcontra = txtcontra.getText().toString();
                String txrecontra = txtrecontra.getText().toString();

                if(TextUtils.isEmpty(txusuario) || TextUtils.isEmpty(txcontra) || TextUtils.isEmpty(txrecontra))
                    Toast.makeText(MainActivity.this, "Debe llenar todos los campos", Toast.LENGTH_LONG).show();
                else{
                    if(txcontra.equals(txrecontra)){
                        Boolean revUsuario = DB.revisarUsuario(txusuario);
                        if(revUsuario == false){
                            Boolean insertar = DB.insertarDatos(txusuario, txcontra);
                            if(insertar == true){
                                Toast.makeText(MainActivity.this, "Datos insertados correctamente" , Toast.LENGTH_LONG).show();
                                Intent inten = new Intent(getApplicationContext(), Login.class);
                                //Intent inten = new Intent(MainActivity.this, Login.class);
                                startActivity(inten);
                            }else{
                                Toast.makeText(MainActivity.this, "Fallo al registrar usuario", Toast.LENGTH_LONG).show();
                            }
                        }else{
                            Toast.makeText(MainActivity.this, "El usuario ya existe", Toast.LENGTH_LONG).show();
                        }
                    }else{
                        Toast.makeText( MainActivity.this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        btningresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inten1 = new Intent(MainActivity.this, Login.class);
                startActivity(inten1);

            }
        });
    }






}