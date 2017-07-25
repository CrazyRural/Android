package com.araujodev.myhistory;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class TelaOrdemData extends AppCompatActivity {

    private SimpleCursorAdapter adaptadorList;
    private ListView listaUltimos;
    private MetodosUsuario metodo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_ordem_data);

        listaUltimos = (ListView) findViewById(R.id.listOrdemDataView);

        preencheLista();
    }

    void preencheLista(){
        metodo = new MetodosUsuario(getApplicationContext());
        final AdapterData a = new AdapterData();
        final Cursor cursor = metodo.carregaDadosUltimos();
        final String[] nomeCampos = new String[] {DBUsuarios.id, DBUsuarios.nome, DBUsuarios.email};
        final int[] idViews = new int[] {R.id.textID, R.id.textDestaque,R.id.textDescricao};

        adaptadorList = new SimpleCursorAdapter(getApplicationContext(), R.layout.listlayoutdata,
                cursor,nomeCampos,idViews, 0);
        listaUltimos.setAdapter(adaptadorList);

    }

    public int retorna(View v){
        int i = listaUltimos.getPositionForView((View) v.getParent());
        return i;
    }

}
