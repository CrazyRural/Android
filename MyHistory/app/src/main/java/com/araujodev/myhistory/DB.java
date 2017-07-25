package com.araujodev.myhistory;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by joaovaraujo on 18/10/16.
 */
public class DB extends SQLiteOpenHelper {

    SQLiteDatabase db;

    private static final int DATABASE_VERSION = 0;

    static final String tabela0 = "usuarios" ;
    static final String tabela1 = "historico" ;
    static final String id = "_id" ;
    static final String email = "emails" ;
    static final String senha = "senhas" ;
    static final String exame = "exames";
    static final String consulta = "consultas";
    static final String vacina = "vacinas";
    static final String data = "datas";


    private static final String TABLE_CREATE0 =
            "CREATE TABLE "+tabela0+" ( "+
                    id+" INTEGER NOT NULL, " +
                    email+" TINYTEXT, " +
                    senha+" TINYTEXT,"+
                    "PRIMARY KEY("+id+"));";

    private static final String TABLE_CREATE1 =
            "CREATE TABLE "+tabela1+" ( "+
                    id+" INTEGER NOT NULL, " +
                    data+" TINYTEXT, " +
                    exame+" TINYTEXT, " +
                    consulta+" TINYTEXT,"+
                    vacina+" TINYTEXT,"+
                    "PRIMARY KEY("+id+"));";
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE0);
        db.execSQL(TABLE_CREATE1);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if(oldVersion < DATABASE_VERSION){
            db.execSQL("DROP TABLE IF EXISTS "+tabela0);
            db.execSQL("DROP TABLE IF EXISTS "+tabela1);
            onCreate(db);
        }
    }

    DB(Context context) {
        super(context, "mymedicalhistory", null, DATABASE_VERSION);
    }

    /*com.araujodev.myhistory.DB(Context context){
      //  super(context, Environment.getExternalStorageDirectory().getAbsolutePath()
        //        + "/Completa-com-oque/DataBase/" + "completacomoque", null, DATABASE_VERSION);
      }*/
}

