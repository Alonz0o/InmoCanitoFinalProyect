package com.example.inmocanito.ui.inquilinos;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import com.example.inmocanito.R;
import com.example.inmocanito.model.clsInquilino;

public class InquilinosActivity extends AppCompatActivity {

    private InquilinosViewModel inquilinoVM;
    private ListView lvInquilinos;
    private Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_inquilinos);

        inquilinoVM = ViewModelProviders.of(this).get(InquilinosViewModel.class);
        context = this;


        final ArrayAdapter<clsInquilino> adaptadorInquilino = new ArrayAdapter(this, android.R.layout.simple_list_item_1, inquilinoVM.obtenerInquilinos());

        ArrayAdapter<String> datos = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, inquilinoVM.listarinkiss());
        lvInquilinos = (ListView)findViewById(R.id.lvInquilino);
        lvInquilinos.setAdapter(datos);

        lvInquilinos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                clsInquilino inquilino = (clsInquilino) adaptadorInquilino.getItem(position);

                clsInquilino inqui=new clsInquilino();
                inqui.setInquilinoId(inquilino.getInquilinoId());
                inqui.setDni(inquilino.getDni());
                inqui.setApellido(inquilino.getApellido());
                inqui.setNombre(inquilino.getNombre());
                inqui.setDireccion(inquilino.getDireccion());
                inqui.setTelefono(inquilino.getApellido());
                startActivity(InquilinosDetallesActivity.getCallingIntent(context, inquilino));
            }
        });

    }
}

