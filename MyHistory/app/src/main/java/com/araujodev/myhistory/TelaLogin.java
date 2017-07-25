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

public class TelaLogin extends AppCompatActivity {

    private Button cadastroButton;
    private Button logarButton;
    private EditText emailTxt;
    private EditText senhaTxt;
    private String confere = "";
    private MetodosUsuario m;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_login);

        m =  new MetodosUsuario(getApplicationContext());
        cadastroButton = (Button) findViewById(R.id.cadastroButton);
        logarButton = (Button) findViewById(R.id.loginButton);
        emailTxt = (EditText) findViewById(R.id.loginEdit);
        senhaTxt = (EditText) findViewById(R.id.senhaText);

        logarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    logar();
                    aviso(confere);
                }catch (Exception e){
                    aviso(confere);
                }
            }
        });

        cadastroButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cadastro();
            }
        });
    }
    private void logar(){
        confere = m.logar(emailTxt.getText().toString(), senhaTxt.getText().toString());
    }
    private void cadastro(){
        startActivity(new Intent(TelaLogin.this, TelaCadastro.class));
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_tela_login, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void aviso(String aviso){
        Toast.makeText(TelaLogin.this, aviso, Toast.LENGTH_SHORT).show();
    }
}
