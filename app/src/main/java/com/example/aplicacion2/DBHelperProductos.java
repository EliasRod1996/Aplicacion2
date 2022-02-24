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

        //tabla productosPVea
        db.execSQL("create table productosPlazaVea(producto TEXT primary key, PCosto TEXT, PxMayor TEXT,Stock TEXT )");

        //tabla productosSodimac
        db.execSQL("create table productosSodimac(producto TEXT primary key, PCosto TEXT, PxMayor TEXT,Stock TEXT )");

        //tabla productosVivanda
        db.execSQL("create table productosVivanda(producto TEXT primary key, PCosto TEXT, PxMayor TEXT,Stock TEXT )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop table if exists productosMetro");

        db.execSQL("drop table if exists productosPlazaVea");

        db.execSQL("drop table if exists productosSodimac");

        db.execSQL("drop table if exists productosVivanda");
    }



    public Boolean insertaDatosMetro(String producto, String PCosto, String PxMayor, String Stock  ){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("producto", producto);
        values.put("Pcosto", PCosto);
        values.put("PxMayor", PxMayor);
        values.put("Stock", Stock);

        long result = db.insert("productosMetro", null, values);
        if(result == -1)
            return false;
        else
            return true;

    }
    public Boolean insertaDatosPlazavea(String producto, String PCosto, String PxMayor, String Stock  ){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("producto", producto);
        values.put("Pcosto", PCosto);
        values.put("PxMayor", PxMayor);
        values.put("Stock", Stock);

        long result = db.insert("productosPlazaVea", null, values);
        if(result == -1)
            return false;
        else
            return true;

    }
    public Boolean insertaDatosSodimac(String producto, String PCosto, String PxMayor, String Stock  ){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("producto", producto);
        values.put("Pcosto", PCosto);
        values.put("PxMayor", PxMayor);
        values.put("Stock", Stock);

        long result = db.insert("productosSodimac", null, values);
        //corrobora si la pk se repite
        if(result == -1)
            return false;
        else
            return true;

    }
    public Boolean insertaDatosVivanda(String producto, String PCosto, String PxMayor, String Stock  ){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("producto", producto);
        values.put("Pcosto", PCosto);
        values.put("PxMayor", PxMayor);
        values.put("Stock", Stock);

        long result = db.insert("productosVivanda", null, values);
        if(result == -1)
            return false;
        else
            return true;

    }




    //ELIMINAR
    public boolean eliminarProdMetro(String producto){

        boolean ok ;
        SQLiteDatabase db = this.getWritableDatabase();

        try {
            db.execSQL("DELETE FROM productosMetro WHERE producto ='" + producto +"' ");
            ok = true;
        }catch (Exception e){
            e.toString();
            ok =false;
        }finally {
            db.close();
        }
        return ok;
    }
    public boolean eliminarProdPvea(String producto){

        boolean ok ;
        SQLiteDatabase db = this.getWritableDatabase();

        try {
            db.execSQL("DELETE FROM productosPlazaVea WHERE producto ='" + producto +"' ");
            ok = true;
        }catch (Exception e){
            e.toString();
            ok =false;
        }finally {
            db.close();
        }
        return ok;
    }
    public boolean eliminarProdSodimac(String producto){

        boolean ok ;
        SQLiteDatabase db = this.getWritableDatabase();

        try {
            db.execSQL("DELETE FROM productosSodimac WHERE producto ='" + producto +"' ");
            ok = true;
        }catch (Exception e){
            e.toString();
            ok =false;
        }finally {
            db.close();
        }
        return ok;
    }
    public boolean eliminarProdVivanda(String producto){

        boolean ok ;
        SQLiteDatabase db = this.getWritableDatabase();

        try {
            db.execSQL("DELETE FROM productosVivanda WHERE producto ='" + producto +"' ");
            ok = true;
        }catch (Exception e){
            e.toString();
            ok =false;
        }finally {
            db.close();
        }
        return ok;
    }


}
