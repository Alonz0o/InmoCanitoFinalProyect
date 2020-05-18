package com.example.inmocanito.ui.inquilinos;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.inmocanito.R;
import com.example.inmocanito.model.clsInquilino;

public class InquilinosDetallesActivity extends AppCompatActivity {
    public InquilinosDetallesActivity() {
        // Required empty public constructor
    }

    private TextView tvDni;
    private TextView tvApellido;
    private TextView tvNombre;
    private TextView tvTelefono;
    private TextView tvDireccion;
    private clsInquilino inquilino;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_inquilinos_detalles);

        try{
            inquilino = (clsInquilino) getIntent().getExtras().getSerializable("InquilinoModel");
        }catch (Exception e){
            finish();
        }

        tvDni = (TextView) findViewById(R.id.tvDetalleInquilinoDni);
        tvApellido = (TextView) findViewById(R.id.tvDetalleInquilinoApellido);
        tvNombre = (TextView) findViewById(R.id.tvDetalleInquilinoNombre);
        tvTelefono = (TextView) findViewById(R.id.tvDetalleInquilinoTelefono);
        tvDireccion = (TextView) findViewById(R.id.tvDetalleInquilinoDireccion);

        tvDni.setText(inquilino.getDni());
        tvApellido.setText(inquilino.getApellido());
        tvNombre.setText(inquilino.getNombre());
        tvTelefono.setText(inquilino.getTelefono());
        tvDireccion.setText(inquilino.getDireccion());

    }

    public static Intent getCallingIntent(Context context, clsInquilino classInquilino){
        Intent intent= new Intent(context, InquilinosDetallesActivity.class);
        intent.putExtra("InquilinoModel",classInquilino);
        return intent;
    }
}
