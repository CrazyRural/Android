package com.araujodev.myhistory;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class TelaOrdemInsercao extends AppCompatActivity {

    private SimpleCursorAdapter adaptadorList;
    private ListView listaUltimos;
    private MetodosUsuario metodo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_ordem_insercao);

        listaUltimos = (ListView) findViewById(R.id.listOrdemInsercaoView);

        preencheLista();
    }

    void preencheLista(){
        metodo = new MetodosUsuario(getApplicationContext());
        final AdapterInsercao a = new AdapterInsercao();
        final Cursor cursor = metodo.carregaDados();
        final String[] nomeCampos = new String[] {DBUsuarios.id, DBUsuarios.nome, DBUsuarios.email};
        final int[] idViews = new int[] {R.id.textID, R.id.textDestaque,R.id.textDescricao};

        adaptadorList = new SimpleCursorAdapter(getApplicationContext(), R.layout.listlayoutinsercao,
                cursor,nomeCampos,idViews, 0);
        listaUltimos.setAdapter(adaptadorList);
    }

    public int retorna(View v){
        int i = listaUltimos.getPositionForView((View) v.getParent());
        return i;
    }

}
