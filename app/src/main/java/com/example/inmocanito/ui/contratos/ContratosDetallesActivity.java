package com.example.inmocanito.ui.contratos;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.inmocanito.R;
import com.example.inmocanito.model.clsContrato;

public class ContratosDetallesActivity extends AppCompatActivity {

    public ContratosDetallesActivity() {
        // Required empty public constructor
    }

    private EditText etFechaInicio;
    private EditText etFechaFin;
    private EditText etPrecio;
    private clsContrato contrato;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_contratos_detalles);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        try{
            contrato = (clsContrato) getIntent().getExtras().getSerializable("model");
        }catch (Exception e){
            finish();
        }

        etFechaInicio = (EditText) findViewById(R.id.etContratoFechaInicio);
        etFechaFin = (EditText) findViewById(R.id.etContratoFechaFin);
        etPrecio = (EditText) findViewById(R.id.etContratoPrecio);

        etFechaInicio.setText("Fecha Inicio: " + contrato.getFechainicio());
        etFechaFin.setText("Fecha Finalizacion: " + contrato.getFechafinalizacion());
        etPrecio.setText("Precio: " + contrato.getPrecio());


    }

    public static Intent getCallingIntent(Context context, clsContrato classPropiedad){
        Intent intent= new Intent(context, ContratosDetallesActivity.class);
        intent.putExtra("model",classPropiedad);
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
