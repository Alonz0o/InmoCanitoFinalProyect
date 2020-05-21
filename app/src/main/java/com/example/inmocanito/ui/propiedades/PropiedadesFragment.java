package com.example.inmocanito.ui.propiedades;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.example.inmocanito.R;
import com.example.inmocanito.model.clsPropiedad;

public class PropiedadesFragment extends Fragment {

    private PropiedadesViewModel propiedadVM;
    private Context context;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_propiedades, container, false);

        propiedadVM = ViewModelProvider.AndroidViewModelFactory.getInstance(getActivity().getApplication()).create(PropiedadesViewModel.class);
        context = getActivity();

        final ArrayAdapter<clsPropiedad> cargarPropiedades = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, propiedadVM.obtenerPropiedades());

        ArrayAdapter<String> datos = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, propiedadVM.listarPropiedades());
        final ListView lvPropiedades = view.findViewById(R.id.lvPropiedad);
        lvPropiedades.setAdapter(datos);


        lvPropiedades.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                clsPropiedad propiedad = (clsPropiedad) cargarPropiedades.getItem(position);
                propiedad.setDomicilio(propiedad.getDomicilio());
                propiedad.setAmbientes(propiedad.getAmbientes());
                propiedad.setTipo(propiedad.getTipo());
                propiedad.setUso(propiedad.getUso());
                propiedad.setPrecio(propiedad.getPrecio());
                propiedad.setDisponible(propiedad.getDisponible());
                startActivity(PropiedadesDetallesActivity.getCallingIntent(context, propiedad));
            }
        });


        return view;
    }

}
