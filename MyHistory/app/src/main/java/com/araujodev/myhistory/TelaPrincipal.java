package com.araujodev.myhistory;

import android.annotation.TargetApi;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Build;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

public class TelaPrincipal extends AppCompatActivity {


    private static boolean alreadyOpen = false;

    private Button logarButton;
    private Button infoButton;
    private Button adicionarButton;
    private Button gerenciarButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_principal);

        logarButton = (Button) findViewById(R.id.loginButton);
        infoButton = (Button) findViewById(R.id.infoButton);
        adicionarButton = (Button) findViewById(R.id.adicionarButton);
        gerenciarButton = (Button) findViewById(R.id.gerenciarbutton);



        logarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logar();
            }
        });
        gerenciarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gerenciar();
            }
        });
        adicionarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adicionar();
            }
        });
        infoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info();
            }
        });

    }

    private void gerenciar() {
        startActivity(new Intent(TelaPrincipal.this, TelaGerenciar.class));
    }

    private void adicionar() {
        startActivity(new Intent(TelaPrincipal.this, TelaAdicionar.class));
    }

    private void info() {
        startActivity(new Intent(TelaPrincipal.this, TelaInfo.class));
    }

    private void logar() {
        startActivity(new Intent(TelaPrincipal.this, TelaLogin.class));
    }
}

