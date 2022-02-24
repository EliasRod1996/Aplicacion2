package com.example.aplicacion2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.Toast;

public class productosMetro extends AppCompatActivity {

    Button btnBuscar,btnInsertar, btnActualizar, btnBorrar;
    EditText txtProducto, txtPCosto, txtPxMayor,txtStock;
    TableLayout tlProdMetro;
    ImageView ivGuardar;

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
        ivGuardar = findViewById(R.id.ivGuardar);

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


                        Boolean inserta = helper.insertaDatosMetro(txproducto, txPcosto, txPxMayor, txStock);
                        if (inserta == true) {
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
                            String tproducto = txtProducto.getText().toString();
                            //helper.eliminarProdMetro(tproducto);
                            //Toast.makeText(productosMetro.this, "Se eliminó el producto", Toast.LENGTH_SHORT).show();
                            AlertDialog.Builder alerta = new AlertDialog.Builder(productosMetro.this);
                            alerta.setMessage("¿ Desea eliminar producto ?")
                                    .setPositiveButton("Si", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialogInterface, int i) {

                                            if(tproducto.equals("")){
                                                Toast.makeText(productosMetro.this, "Debe llenar el campo  producto", Toast.LENGTH_SHORT).show();

                                            }else{
                                                helper.eliminarProdMetro(tproducto);
                                                Toast.makeText(productosMetro.this, "Se eliminó el producto", Toast.LENGTH_SHORT).show();

                                            }

                                        }
                                    })
                                    .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialogInterface, int i) {

                                        }
                                    }).show();


                        }
                    });

                    ivGuardar.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            Intent irPdv = new Intent(productosMetro.this, PDeVentas.class);
                            startActivity(irPdv);

                        }
                    });




    }


}





