package com.example.aplicacion2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.Toast;

public class productosMetro extends AppCompatActivity {

    Button btnBuscar,btnInsertar, btnActualizar, btnBorrar;
    EditText txtProducto, txtPCosto, txtPxMayor,txtStock;
    TableLayout tlProdMetro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productos_metro);

        txtProducto = findViewById(R.id.txtProducto);
        txtPCosto = findViewById(R.id.txtPCosto);
        txtPxMayor = findViewById(R.id.txtPxMayor);
        txtStock = findViewById(R.id.txtStock);

        btnInsertar = findViewById(R.id.btnInsertar);
        btnBuscar = findViewById(R.id.btnBuscar);
        btnActualizar = findViewById(R.id.btnActualizar);
        btnBorrar = findViewById(R.id.btnBorrar);

        tlProdMetro = findViewById(R.id.tlProdMetro);

        DBHelperProductos helper = new DBHelperProductos(this);

        //Acciones
        btnInsertar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String txproducto = txtProducto.getText().toString();
                String txPcosto = txtPCosto.getText().toString();
                String txPxMayor = txtPxMayor.getText().toString();
                String txStock = txtStock.getText().toString();

                if (TextUtils.isEmpty(txproducto) || TextUtils.isEmpty(txPcosto) || TextUtils.isEmpty(txPxMayor) || TextUtils.isEmpty(txStock))
                    Toast.makeText(productosMetro.this, "Debe llenar todos los campos", Toast.LENGTH_LONG).show();
                else {


                        Boolean insertar = helper.insertarDatos(txproducto, txPcosto, txPxMayor, txStock);
                        if (insertar == true) {
                            Toast.makeText(productosMetro.this, "Datos insertados correctamente", Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(productosMetro.this, "Fallo al registrar producto", Toast.LENGTH_LONG).show();
                        }}


                }
            });



                    btnBuscar.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                        }
                    });


                    btnActualizar.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                        }
                    });

                    btnBorrar.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {


                        }
                    });




    }
}





