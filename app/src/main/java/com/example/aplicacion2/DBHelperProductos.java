package com.example.aplicacion2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelperProductos extends SQLiteOpenHelper {

    public static final String DBNAME = "productos.db";

    public DBHelperProductos(@Nullable Context context) {
        super(context,"productos.db" , null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table productosMetro(producto TEXT primary key, PCosto TEXT, PxMayor TEXT,Stock TEXT )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop table if exists productosMetro");
    }



    public Boolean insertarDatos(String producto, String PCosto, String PxMayor, String Stock  ){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("produscto", producto);
        values.put("Pcosto", PCosto);
        values.put("PxMayor", PxMayor);
        values.put("Stock", Stock);

        long result = db.insert("productos", null, values);
        if(result == 0)
            return false;
        else
            return true;

    }


}
