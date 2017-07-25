package com.araujodev.myhistory;

import java.util.Locale;

import android.app.TabActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.FragmentPagerAdapter;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TabHost;
import android.widget.TextView;

public class TelaGerenciar extends TabActivity {

    private TabHost TabHostWindow;
    private final String um = "Próximas Visitas", dois = "Todas as Visitas";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_gerenciar);

        TabHostWindow = (TabHost)findViewById(android.R.id.tabhost);

        TabHost.TabSpec TabMenu1 = TabHostWindow.newTabSpec(um);
        TabHost.TabSpec TabMenu2 = TabHostWindow.newTabSpec(dois);

        TabMenu1.setIndicator(um);
        TabMenu1.setContent(new Intent(this, TelaOrdemData.class));

        TabMenu2.setIndicator(dois);
        TabMenu2.setContent(new Intent(this, TelaOrdemInsercao.class));


        TabHostWindow.addTab(TabMenu1);
        TabHostWindow.addTab(TabMenu2);

    }
}
