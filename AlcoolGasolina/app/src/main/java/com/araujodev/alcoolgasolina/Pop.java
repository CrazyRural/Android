package com.araujodev.alcoolgasolina;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.EditText;
import android.widget.TextView;

import static com.araujodev.alcoolgasolina.TelaPrincipal.*;

/**
 * Created by joaovaraujo on 04/01/16.
 */
public class Pop extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popupwindow);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width*.7),(int)(height*.5));

        final TextView completaCom = (TextView) findViewById(R.id.textViewCombustivel);

        completaCom.setText(completaComIsso);
    }
}
