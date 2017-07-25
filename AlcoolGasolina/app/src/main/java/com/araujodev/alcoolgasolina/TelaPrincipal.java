package com.araujodev.alcoolgasolina;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Spinner;
import android.widget.Toast;

@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class TelaPrincipal extends Activity {

    static String completaComIsso = "Digite com ponto ao invés de vírgula, Patrão! ";
    ListView listaUltimos;
    Methods listUltimos;
    SimpleCursorAdapter adaptadorList, adaptadorSpinner;
    int contador = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_LEFT_ICON);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_principal);
        setFeatureDrawableResource(Window.FEATURE_LEFT_ICON, R.drawable.icone);

        final Button buttonCalcular = (Button) findViewById(R.id.buttonCalcular);
        final EditText alcool = (EditText) findViewById(R.id.textAlcool);
        final EditText gasolina = (EditText) findViewById(R.id.textGasolina);
        listaUltimos = (ListView) findViewById(R.id.listUltimos);
        final Spinner s = (Spinner) findViewById(R.id.spinner);

        listUltimos = new Methods(getApplicationContext());
        final Adapter a = new Adapter();
        final Cursor cursor = listUltimos.carregaDados();
        final String[] nomeCampos = new String[] {DB.id, DB.destaque, DB.descricao};
        final int[] idViews = new int[] {R.id.textID, R.id.textDestaque,R.id.textDescricao};

        adaptadorList = new SimpleCursorAdapter(getApplicationContext(), R.layout.listlayout,cursor,nomeCampos,idViews, 0);
        adaptadorSpinner = new SimpleCursorAdapter(getApplicationContext(), R.layout.spinnerlist,cursor,nomeCampos,idViews, 0);
        listaUltimos.setAdapter(adaptadorList);
        s.setAdapter(adaptadorSpinner);

        buttonCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    completaComIsso = listUltimos.calculaPreciso(Float.valueOf(alcool.getText().toString()),
                            Float.valueOf(gasolina.getText().toString()));
                    startActivity(new Intent(TelaPrincipal.this, Pop.class));
                    listaUltimos.clearChoices();
                    s.setAdapter(null);
                    adaptadorList.changeCursor(listUltimos.carregaDados());
                    adaptadorSpinner.changeCursor(listUltimos.carregaDados());
                    s.setAdapter(adaptadorSpinner);
                } catch (NumberFormatException e) {
                    startActivity(new Intent(TelaPrincipal.this, Pop.class));
                }
            }
        });


        final Button btndelete = (Button) findViewById(R.id.buttonDelete);


        btndelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                long j= s.getSelectedItemId();
                listUltimos.deletaDB((int) j);
                s.setAdapter(null);
                listaUltimos.clearChoices();
                adaptadorList.changeCursor(listUltimos.carregaDados());
                adaptadorSpinner.changeCursor(listUltimos.carregaDados());
                s.setAdapter(adaptadorSpinner);
                aviso("Apagado com sucesso, Patrão! ");
                contador++;

            }
        });
        /*listaUltimos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Cursor c = (Cursor) s.getItemAtPosition(position);
                deletaBD(listaUltimos.getSelectedItemPosition);
                listaUltimos.clearChoices();
                adaptador.changeCursor(listUltimos.carregaDados());
                aviso("Resultado Apagado! ");
            }
        });*/
    }
    public int retorna(View v){
        int i = listaUltimos.getPositionForView((View) v.getParent());
        return i;
    }
    public void deletaBD(int id){
        listUltimos.deletaDB(id);
    }
    public void aviso(String aviso){
        Toast.makeText(TelaPrincipal.this , aviso, Toast.LENGTH_SHORT).show();
    }
}