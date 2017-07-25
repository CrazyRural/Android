package com.araujodev.myhistory;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by joaovaraujo on 19/10/16.
 */
public class DBHistorico extends SQLiteOpenHelper {

    SQLiteDatabase db;

    private static final int DATABASE_VERSION = 0;

    static final String tabela = "historico" ;
    static final String id = "_id" ;
    static final String exames = "exames";
    static final String consultas = "consultas" ;
    static final String vacinas = "vacinas" ;


    private static final String TABLE_CREATE =
            "CREATE TABLE "+tabela+" ( "+
                    id+" INTEGER NOT NULL, " +
                    exames+" TINYTEXT"+
                    consultas+" TINYTEXT, " +
                    vacinas+" TINYTEXT,"+
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

    DBHistorico(Context context) {
        super(context, "mymedicalhistory", null, DATABASE_VERSION);
    }

    /*com.araujodev.myhistory.DB(Context context){
      //  super(context, Environment.getExternalStorageDirectory().getAbsolutePath()
        //        + "/Completa-com-oque/DataBase/" + "completacomoque", null, DATABASE_VERSION);
      }*/
}


