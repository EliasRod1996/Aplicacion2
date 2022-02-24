package com.example.aplicacion2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class productosVivanda extends AppCompatActivity {

    Button btnBuscar,btnInsertar, btnActualizar, btnBorrar;
    EditText txtProducto, txtPCosto, txtPxMayor,txtStock;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productos_vivanda);

        txtProducto = findViewById(R.id.txtProducto);
        txtPCosto = findViewById(R.id.txtPCosto);
        txtPxMayor = findViewById(R.id.txtPxMayor);
        txtStock = findViewById(R.id.txtStock);

        btnInsertar = findViewById(R.id.btnInsertar);
        btnBuscar = findViewById(R.id.btnBuscar);
        btnActualizar = findViewById(R.id.btnActualizar);
        btnBorrar = findViewById(R.id.btnBorrar);

        DBHelperProductos helper = new DBHelperProductos(this);

        btnInsertar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String txproducto = txtProducto.getText().toString();
                String txPcosto = txtPCosto.getText().toString();
                String txPxMayor = txtPxMayor.getText().toString();
                String txStock = txtStock.getText().toString();

                if (TextUtils.isEmpty(txproducto) || TextUtils.isEmpty(txPcosto) || TextUtils.isEmpty(txPxMayor) || TextUtils.isEmpty(txStock))
                    Toast.makeText(productosVivanda.this, "Debe llenar todos los campos", Toast.LENGTH_LONG).show();
                else {


                    Boolean inserta = helper.insertaDatosVivanda(txproducto, txPcosto, txPxMayor, txStock);
                    if (inserta == true) {
                        Toast.makeText(productosVivanda.this, "Datos insertados correctamente", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(productosVivanda.this, "Fallo al registrar producto", Toast.LENGTH_LONG).show();
                    }}
            }
        });
    }
}