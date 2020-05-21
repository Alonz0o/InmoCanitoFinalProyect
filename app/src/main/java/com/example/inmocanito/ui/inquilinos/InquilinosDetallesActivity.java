package com.example.inmocanito.ui.inquilinos;

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
import com.example.inmocanito.model.clsInquilino;

public class InquilinosDetallesActivity extends AppCompatActivity {
    public InquilinosDetallesActivity() {
        // Required empty public constructor
    }

    private EditText etDni;
    private EditText etApellido;
    private EditText etNombre;
    private EditText etTelefono;
    private EditText etDireccion;
    private clsInquilino inquilino;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_inquilinos_detalles);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        try{
            inquilino = (clsInquilino) getIntent().getExtras().getSerializable("InquilinoModel");
        }catch (Exception e){
            finish();
        }

        etDni = (EditText) findViewById(R.id.etDetalleInquilinoDni);
        etApellido = (EditText) findViewById(R.id.etDetalleInquilinoApellido);
        etNombre = (EditText) findViewById(R.id.etDetalleInquilinoNombre);
        etTelefono = (EditText) findViewById(R.id.etDetalleInquilinoTelefono);
        etDireccion = (EditText) findViewById(R.id.etDetalleInquilinoDireccion);

        etDni.setText("Dni: " + inquilino.getDni());
        etApellido.setText("Apellido: " + inquilino.getApellido());
        etNombre.setText("Nombre: " + inquilino.getNombre());
        etTelefono.setText("Telefono: " + inquilino.getTelefono());
        etDireccion.setText("Direccion: " + inquilino.getDireccion());

    }

    public static Intent getCallingIntent(Context context, clsInquilino classInquilino){
        Intent intent= new Intent(context, InquilinosDetallesActivity.class);
        intent.putExtra("InquilinoModel",classInquilino);
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
