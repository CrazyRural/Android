package com.araujodev.myhistory;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.SimpleCursorAdapter;

import java.util.ArrayList;

/**
 * Created by joaovaraujo on 24/11/16.
 */
public class AdapterData extends BaseAdapter implements ListAdapter {


    private ArrayList<String> list = new ArrayList<String>();
    private Context context;
    SimpleCursorAdapter adaptador;

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int pos) {
        return list.get(pos);
    }

    @Override
    public long getItemId(int pos) {
        return 0;
        //just return 0 if your list items do not have an Id variable.
    }


    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final TelaOrdemData tela = new TelaOrdemData();

        View view = convertView;
        final int posicao = tela.retorna(view);

        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.listlayoutdata, null);
        }



        return view;
    }
}
