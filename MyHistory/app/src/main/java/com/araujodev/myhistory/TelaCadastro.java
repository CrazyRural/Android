package com.araujodev.myhistory;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.SQLException;

public class TelaCadastro extends AppCompatActivity {

    private Button limparBtn;
    private Button cadastrarBtn;
    private EditText emailTxt;
    private EditText senhaTxt;
    private EditText nomeTxt;
    private MetodosUsuario m;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cadastro);

        m = new MetodosUsuario(getApplicationContext());
        limparBtn = (Button) findViewById(R.id.limparButton);
        cadastrarBtn = (Button) findViewById(R.id.cadastrarButton);
        emailTxt = (EditText) findViewById(R.id.emailEdit);
        senhaTxt = (EditText) findViewById(R.id.senhaEdit);
        nomeTxt = (EditText) findViewById(R.id.nomeEdit);

        cadastrarBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    insere();
                    aviso("Cadastrado com sucesso!");
                }catch (Exception e){
                    aviso("Algum erro ocrreu...");
                }finally {
                    moveOn();
                }
            }});
        
        limparBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                limpar();
            }
        });

    }
    private void moveOn(){
        startActivity(new Intent(TelaCadastro.this, TelaLogin.class));
    }
    private void limpar(){
        nomeTxt.setText("");
        emailTxt.setText("");
        senhaTxt.setText("");
    }
    private void insere(){
        m.inserirUsuarioDB(nomeTxt.getText().toString(), emailTxt.getText().toString(), senhaTxt.getText().toString());
    }

    private void aviso(String aviso){
        Toast.makeText(TelaCadastro.this, aviso, Toast.LENGTH_SHORT).show();
    }
}
