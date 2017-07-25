package com.araujodev.myhistory;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import com.araujodev.myhistory.DB;

/**
 * Created by joaovaraujo on 19/10/16.
 */
public class MetodosUsuario {

    //private DB criaDB;
    private DBUsuarios usuariosDB;
    private SQLiteDatabase db;
    private String nomeRetorno = "Insira dados";

    MetodosUsuario(Context context) {

        usuariosDB = new DBUsuarios(context);
    }

    private void insereDB(String nome, String email, String senha){

        ContentValues content = new ContentValues();
        long resultado;

        db = usuariosDB.getWritableDatabase();


        content.put(usuariosDB.nome, nome);
        content.put(usuariosDB.email, email);
        content.put(usuariosDB.senha, senha);

        resultado = db.insert(usuariosDB.tabela, null, content);
        db.close();

    }

    private void deletaDB(int id){
        String where = usuariosDB.id + "=" + id;
        db = usuariosDB.getReadableDatabase();
        db.delete(usuariosDB.tabela,where,null);
        db.close();
    }

    private String VarreDB(String email){
            Cursor cursor= db.query("usuarios", null, " EMAIL= ", new String[]{email}, null, null, null);
            if(cursor.getCount()<1) {
                cursor.close();
                nomeRetorno = "Usuario não encontrado, cadastre-se abaixo";
                return "Não existe";
            }
            cursor.moveToFirst();
            nomeRetorno = "Bem vindo,"+cursor.getString(cursor.getColumnIndex("NOME"));
            String password= cursor.getString(cursor.getColumnIndex("SENHA"));
            cursor.close();
            return password;
    }
    public Cursor carregaDados(){
        Cursor cursor;
        String[] campos = {usuariosDB.id, usuariosDB.nome, usuariosDB.email};
        db = usuariosDB.getReadableDatabase();
        cursor = db.query(usuariosDB.tabela, campos, null, null, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }

    public Cursor carregaDadosUltimos(){
        Cursor cursor;
        String[] campos = {usuariosDB.id, usuariosDB.nome, usuariosDB.email};
        db = usuariosDB.getReadableDatabase();
        cursor = db.query(usuariosDB.tabela, campos, null, null, null, null, null, null);
        if (cursor != null) {
            cursor.moveToPrevious();
        }
        db.close();
        return cursor;
    }

    public void inserirUsuarioDB(String nome, String email, String senha){
        insereDB(nome, email, senha);
    }
    public String logar(String email, String senha){
        if(senha.equals(VarreDB(email))){
            return "Bem vindo"+ nomeRetorno;
        }
        return nomeRetorno;
    }
}
