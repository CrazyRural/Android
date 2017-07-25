package com.araujodev.myhistory;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

public class TelaReceituario extends AppCompatActivity {
    private CheckBox vacina, remedio, exame, consulta;
    private EditText vacinaEdit, remedioEdit, exameEdit, consultaEdit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_receituario);

        vacina = (CheckBox) findViewById(R.id.vacinacheckBox);
        remedio = (CheckBox) findViewById(R.id.medicamentocheckBox);
        exame = (CheckBox) findViewById(R.id.examecheckBox);
        consulta = (CheckBox) findViewById(R.id.consultacheckBox);

        remedioEdit = (EditText) findViewById(R.id.medicadoEdit);
        consultaEdit = (EditText) findViewById(R.id.novaConsultaEdit);
        vacinaEdit = (EditText) findViewById(R.id.vacinadoEdit);
        exameEdit = (EditText) findViewById(R.id.exameEdit);


        vacinaEdit.setClickable(false);
        remedioEdit.setClickable(false);
        exameEdit.setClickable(false);
        consultaEdit.setClickable(false);

        verifica();
    }


    void allOf(){

    }
    void verifica(){
            if(vacina.isChecked()){
                vacinaEdit.setClickable(true);
            }
            if(remedio.isChecked()){
                remedioEdit.setClickable(true);
            }
            if(exame.isChecked()){
                exameEdit.setClickable(true);
            }
            if(consulta.isChecked()){
                consultaEdit.setClickable(true);
            }
    }

}
