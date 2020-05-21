package com.example.inmocanito.ui.pagos;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.inmocanito.R;
import com.example.inmocanito.model.clsPago;

public class PagosDetallesActivity extends AppCompatActivity {

    public PagosDetallesActivity() {
        // Required empty public constructor
    }

    private EditText etPagoNumPgo;
    private EditText etPagoFecha;
    private EditText etPagoImporte;

    private clsPago pago;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_pagos_detalles);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        try{
            pago = (clsPago) getIntent().getExtras().getSerializable("modelPago");
        }catch (Exception e){
            finish();
        }


        etPagoNumPgo = (EditText) findViewById(R.id.etDetallePagoNumPago);
        etPagoFecha = (EditText) findViewById(R.id.etDetallePagoFecha);
        etPagoImporte = (EditText) findViewById(R.id.etDetallePagoImporte);

        etPagoNumPgo.setText("Numero de actividad: " + pago.getNumpago());
        etPagoFecha.setText("Fecha: " +  pago.getFecha());
        etPagoImporte.setText("Importe: " + pago.getImporte());

    }




    public static Intent getCallingIntent(Context context, clsPago cPago){
        Intent intent= new Intent(context, PagosDetallesActivity.class);
        intent.putExtra("modelPago",cPago);
        return intent;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(item.getItemId() == android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
