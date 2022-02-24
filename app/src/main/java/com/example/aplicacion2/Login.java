package com.example.aplicacion2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    EditText txtusuariolog, txtcontralog;
    Button btnLogIngresar;
    DBHelper sb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        txtusuariolog = findViewById(R.id.txtusuariolog);
        txtcontralog = findViewById(R.id.txtcontralog);

        btnLogIngresar = findViewById(R.id.btnLogIngresar);

        sb = new DBHelper(this);

        btnLogIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String tusuario = txtusuariolog.getText().toString();
                String tcontra = txtcontralog.getText().toString();

                if(TextUtils.isEmpty(tusuario) || TextUtils.isEmpty(tcontra)){
                    Toast.makeText(Login.this, "Todos los campos son requeridos", Toast.LENGTH_LONG).show();
                }else{
                    Boolean revContra = sb.revisarUsuarioContra(tusuario, tcontra);
                    if(revContra == true){
                        Toast.makeText(Login.this, "Bienvenido", Toast.LENGTH_SHORT).show();
                        Intent intents = new Intent(Login.this, MenuUsuario.class);
                        startActivity(intents);
                    }else{
                        Toast.makeText(Login.this, "Ingreso fallido", Toast.LENGTH_LONG).show();
                    }



                }

            }
        });
    }
}