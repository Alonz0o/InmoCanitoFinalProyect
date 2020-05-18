package com.example.inmocanito.ui.pagos;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.example.inmocanito.R;
import com.example.inmocanito.model.clsPropiedad;

//TIENE Q SER FRAGMENT
public class PagosDetallesActivity extends AppCompatActivity {

    public PagosDetallesActivity() {
        // Required empty public constructor
    }

    private TextView tvDomicilio;
    private TextView tvTipo;
    private clsPropiedad propiedad;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_pagosdetalles);

        try{
            propiedad = (clsPropiedad) getIntent().getExtras().getSerializable("model");
        }catch (Exception e){
            finish();
        }

        tvDomicilio = (TextView) findViewById(R.id.tvDetallePropiedadDomicilio);
        tvTipo = (TextView) findViewById(R.id.tvDetallePropiedadTipo);

        tvDomicilio.setText(propiedad.getDomicilio());
        tvTipo.setText(propiedad.getTipo());


    }

    public static Intent getCallingIntent(Context context, clsPropiedad classPropiedad){
        Intent intent= new Intent(context, PagosDetallesActivity.class);
        intent.putExtra("model",classPropiedad);
        return intent;
    }

}
