package com.araujodev.myhistory;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.TabActivity;
import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TabHost;
import android.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

public class TelaAdicionar extends TabActivity {

    private TabHost TabHostWindow;
    private final String um = "Dados", dois = "Visita", tres = "Receita";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_adicionar);

        TabHostWindow = (TabHost)findViewById(android.R.id.tabhost);

        TabHost.TabSpec TabMenu1 = TabHostWindow.newTabSpec(um);
        TabHost.TabSpec TabMenu2 = TabHostWindow.newTabSpec(dois);
        TabHost.TabSpec TabMenu3 = TabHostWindow.newTabSpec(tres);

        TabMenu1.setIndicator(um);
        TabMenu1.setContent(new Intent(this, TelaBasico.class));

        TabMenu2.setIndicator(dois);
        TabMenu2.setContent(new Intent(this, TelaDetalhes.class));


        TabMenu3.setIndicator(tres);
        TabMenu3.setContent(new Intent(this, TelaReceituario.class));

        TabHostWindow.addTab(TabMenu1);
        TabHostWindow.addTab(TabMenu2);
        TabHostWindow.addTab(TabMenu3);

    }
}
