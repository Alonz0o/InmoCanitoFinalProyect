package com.example.inmocanito.ui.propiedades;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.example.inmocanito.R;
import com.example.inmocanito.model.clsPropiedad;

public class PropiedadesDetallesActivity extends AppCompatActivity {

    public PropiedadesDetallesActivity() {
        // Required empty public constructor
    }

    private EditText etPropiedadDomicilio;
    private EditText etPropiedadAmbientes;
    private EditText etPropiedadTipo;
    private EditText etPropiedadUso;
    private EditText etPropiedadPrecio;
    private EditText etPropiedadDisponible;

    private clsPropiedad propiedad;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_propiedades_detalles);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        try{
            propiedad = (clsPropiedad) getIntent().getExtras().getSerializable("Propiedadmodel");
        }catch (Exception e){
            finish();
        }

        etPropiedadDomicilio = (EditText)findViewById(R.id.etPropiedadDomicilio);
        etPropiedadAmbientes = (EditText)findViewById(R.id.etPropiedadAmbientes);
        etPropiedadTipo = (EditText)findViewById(R.id.etPropiedadTipo);
        etPropiedadUso = (EditText)findViewById(R.id.etPropiedadUso);
        etPropiedadPrecio = (EditText)findViewById(R.id.etPropiedadPrecio);
        etPropiedadDisponible = (EditText)findViewById(R.id.etPropiedadDisponible);



        etPropiedadDomicilio.setText("Direccion: " + propiedad.getDomicilio());
        etPropiedadAmbientes.setText("Ambientes: " + propiedad.getAmbientes());
        etPropiedadTipo.setText("Tipo: " +propiedad.getTipo());
        etPropiedadUso.setText("Uso: " +propiedad.getUso());
        etPropiedadPrecio.setText("Precio: " +propiedad.getPrecio());
        if (propiedad.getDisponible()==true)
        { etPropiedadDisponible.setText("Disponibilidad: Disponible");
        }else{etPropiedadDisponible.setText("Disponibilidad: No Disponible");}


    }

    public static Intent getCallingIntent(Context context, clsPropiedad cPropiedad){
        Intent intent= new Intent(context, PropiedadesDetallesActivity.class);
        intent.putExtra("Propiedadmodel",cPropiedad);
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
