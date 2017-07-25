package com.araujodev.alcoolgasolina;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Environment;

import java.util.ArrayList;

/**
 * Created by joaovaraujo on 05/01/16.
 */

public class DB extends SQLiteOpenHelper {

    static ArrayList<String> List = new ArrayList<>();
    SQLiteDatabase db;

    private static final int DATABASE_VERSION = 8;
    static final String tabela = "ultimosResultados" ;
    static final String id = "_id" ;
    static final String destaque = "destaque";
    static final String descricao = "descricao";

    private static final String TABLE_CREATE =
            "CREATE TABLE "+tabela+" ( "+
                    id+" INTEGER NOT NULL, " +
                    destaque+" TINYTEXT, " +
                    descricao+" TINYTEXT,"+
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

    DB(Context context) {
        super(context, "completacomoque", null, DATABASE_VERSION);
    }

    /*DB(Context context){
      //  super(context, Environment.getExternalStorageDirectory().getAbsolutePath()
        //        + "/Completa-com-oque/DataBase/" + "completacomoque", null, DATABASE_VERSION);
      }*/
}
