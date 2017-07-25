package com.araujodev.alcoolgasolina;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

/**
 * Created by joaovaraujo on 04/01/16.
 */
public class Methods {

    private DB criaDB;
    private SQLiteDatabase db;

    Methods(Context context) {
        criaDB = new DB(context);
    }

    private void insereDB(String destaque, String descricao){

        ContentValues content = new ContentValues();
        long resultado;

        db = criaDB.getWritableDatabase();

        content.put(criaDB.descricao, descricao);
        content.put(criaDB.destaque, destaque);

        resultado = db.insert(criaDB.tabela, null, content);
        db.close();

    }

    public void deletaDB(int id){
        String where = DB.id + "=" + id;
        db = criaDB.getReadableDatabase();
        db.delete(DB.tabela,where,null);
        db.close();
    }

    public Cursor carregaDados(){
        //try {
            Cursor cursor;
            String[] campos = {criaDB.id, criaDB.destaque, criaDB.descricao};
            db = criaDB.getReadableDatabase();
            cursor = db.query(criaDB.tabela, campos, null, null, null, null, null, null);
            if (cursor != null) {
                cursor.moveToFirst();
            }
            db.close();
            return cursor;
       //}catch(RuntimeException e){
         //   criaDB.onCreate(db);
           // return carregaDados();
         //}
    }

    public Cursor carregaDadoId(int id){
        Cursor cursor;
        String[] campos = {criaDB.id,criaDB.destaque,criaDB.descricao};
        String where = DB.id +"="+id;
        db = criaDB.getReadableDatabase();
        cursor = db.query(DB.tabela,campos,where, null, null, null, null, null);
        if(cursor!=null){
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }

    //private static void retornaArray(ArrayList<String> list, String destaque, String descricao){
        //list.add(destaque);
        //list.add(descricao);
    //}

    public String calculaPreciso(Float a, Float g){
        String fraseDestaque = "";
        String fraseDescricao = "";

        float resultado = Float.valueOf(a) / Float.valueOf(g);
        if(resultado > 0.7){
            fraseDestaque = "Completa com Gasolina, Chefia! ";
            fraseDescricao = "Etanol R$ " + String.valueOf(a) + " x " + "Gasolina R$ " + String.valueOf(g);
            insereDB(fraseDestaque, fraseDescricao);
            //retornaArray(DB.List, "Gasolina", fraseDescricao);
        }else if(resultado <= 0.7){
            fraseDestaque = "Completa com Etanol, Chefia! ";
            fraseDescricao = "Etanol R$ " + String.valueOf(a) + " x " + "Gasolina R$ " + String.valueOf(g);
            insereDB(fraseDestaque, fraseDescricao);
            //retornaArray(DB.List, "Etanol", fraseDescricao);
        }
        return fraseDestaque;
    }

}
