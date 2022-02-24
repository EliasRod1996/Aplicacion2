package com.example.aplicacion2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DBNAME = "login.db";

    public DBHelper(@Nullable Context context ) {
        super(context, "login.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table usuarios(usuario TEXT primary key, password TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop table if exists usuarios");
    }

    public Boolean insertarDatos(String usuario, String contra){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("usuario", usuario);
        values.put("password", contra);

        long result = db.insert("usuarios", null, values);
        if(result == -1)
            return false;
         else
            return true;

    }

    public Boolean revisarUsuario(String usuario){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from usuarios where usuario=?", new String[] {usuario});
        if(cursor.getCount() > 0)
            return true;
        else
            return false;

    }

    public Boolean revisarUsuarioContra(String usuario, String contra){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from usuarios where usuario = ? and password = ? ", new String[] {usuario, contra});
        if(cursor.getCount()>0)
            return true;
        else
            return false;

    }

}
