package com.araujodev.myhistory;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by joaovaraujo on 19/10/16.
 */
public class DBUsuarios extends SQLiteOpenHelper {

    SQLiteDatabase db;

    private static final int DATABASE_VERSION = 10;

    static final String tabela = "usuarios" ;
    static final String id = "_id" ;
    static final String nome = "NOME";
    static final String email = "EMAIL" ;
    static final String senha = "SENHA" ;


    private static final String TABLE_CREATE =
            "CREATE TABLE "+tabela+" ( "+
                    id+" INTEGER NOT NULL, " +
                    nome+" TINYTEXT,"+
                    email+" TINYTEXT, " +
                    senha+" TINYTEXT,"+
                    "PRIMARY KEY("+id+"));";


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if(oldVersion < DATABASE_VERSION){
            db.execSQL("DROP TABLE IF EXISTS "+tabela);
            onCreate(db);
        }
    }

    DBUsuarios(Context context) {
            super(context, "mymedicalhistory", null, DATABASE_VERSION);
    }

    /*com.araujodev.myhistory.DB(Context context){
      //  super(context, Environment.getExternalStorageDirectory().getAbsolutePath()
        //        + "/Completa-com-oque/DataBase/" + "completacomoque", null, DATABASE_VERSION);
      }*/
}


