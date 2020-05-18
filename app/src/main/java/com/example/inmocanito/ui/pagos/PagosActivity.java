package com.example.inmocanito.ui.pagos;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import com.example.inmocanito.R;
import com.example.inmocanito.model.Adaptador;
import com.example.inmocanito.model.clsPropiedad;

public class PagosActivity extends AppCompatActivity {

    private PagosViewModel pagosVM;
    private ListView listaPropiedades;
    private Adaptador adaptador;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagos);

        pagosVM = ViewModelProviders.of(this).get(PagosViewModel.class);
        context = this;

        adaptador = new Adaptador(this, pagosVM.obtenerPropiedades());
        listaPropiedades = (ListView)findViewById(R.id.lvPropiedad);
        listaPropiedades.setAdapter(adaptador);


        listaPropiedades.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                clsPropiedad propiedad = (clsPropiedad) adaptador.getItem(position);
                startActivity(PagosDetallesActivity.getCallingIntent(context, propiedad));
            }
        });

    }
}
