package com.example.aplicacion2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class productosSodimac extends AppCompatActivity {

    Button btnBuscar,btnInsertar, btnActualizar, btnBorrar;
    EditText txtProducto, txtPCosto, txtPxMayor,txtStock;
    ImageView ivGuardar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productos_sodimac);

        txtProducto = findViewById(R.id.txtProducto);
        txtPCosto = findViewById(R.id.txtPCosto);
        txtPxMayor = findViewById(R.id.txtPxMayor);
        txtStock = findViewById(R.id.txtStock);

        btnInsertar = findViewById(R.id.btnInsertar);
        btnBuscar = findViewById(R.id.btnBuscar);
        btnActualizar = findViewById(R.id.btnActualizar);
        btnBorrar = findViewById(R.id.btnBorrar);

        ivGuardar = findViewById(R.id.ivGuardar);

        DBHelperProductos helper = new DBHelperProductos(this);


        btnInsertar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String txproducto = txtProducto.getText().toString();
                String txPcosto = txtPCosto.getText().toString();
                String txPxMayor = txtPxMayor.getText().toString();
                String txStock = txtStock.getText().toString();

                if (TextUtils.isEmpty(txproducto) || TextUtils.isEmpty(txPcosto) || TextUtils.isEmpty(txPxMayor) || TextUtils.isEmpty(txStock))
                    Toast.makeText(productosSodimac.this, "Debe llenar todos los campos", Toast.LENGTH_LONG).show();
                else {


                    Boolean inserta = helper.insertaDatosSodimac(txproducto, txPcosto, txPxMayor, txStock);
                    if (inserta == true) {
                        Toast.makeText(productosSodimac.this, "Datos insertados correctamente", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(productosSodimac.this, "Fallo al registrar producto", Toast.LENGTH_LONG).show();
                    }}

            }
        });

        btnBorrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tproducto = txtProducto.getText().toString();
                //helper.eliminarProdMetro(tproducto);
                //Toast.makeText(productosMetro.this, "Se eliminó el producto", Toast.LENGTH_SHORT).show();
                AlertDialog.Builder alerta = new AlertDialog.Builder(productosSodimac.this);
                alerta.setMessage("¿ Desea eliminar producto ?")
                        .setPositiveButton("Si", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                                if(tproducto.equals("")){
                                    Toast.makeText(productosSodimac.this, "Debe llenar el campo  producto", Toast.LENGTH_SHORT).show();

                                }else{
                                    helper.eliminarProdSodimac(tproducto);
                                    Toast.makeText(productosSodimac.this, "Se eliminó el producto", Toast.LENGTH_SHORT).show();

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

                Intent irPdv = new Intent(productosSodimac.this, PDeVentas.class);
                startActivity(irPdv);

            }
        });
    }
}