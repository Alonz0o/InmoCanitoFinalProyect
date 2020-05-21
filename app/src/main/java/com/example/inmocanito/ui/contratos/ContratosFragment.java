package com.example.inmocanito.ui.contratos;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.example.inmocanito.R;
import com.example.inmocanito.model.clsContrato;
import com.example.inmocanito.model.clsPropiedad;
import com.example.inmocanito.ui.propiedades.PropiedadesViewModel;


public class ContratosFragment extends Fragment {

    private ContratosViewModel contratosVM;
    private PropiedadesViewModel propiedadVM;
    private Context context;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_propiedades, container, false);

        contratosVM = ViewModelProvider.AndroidViewModelFactory.getInstance(getActivity().getApplication()).create(ContratosViewModel.class);
        propiedadVM = ViewModelProvider.AndroidViewModelFactory.getInstance(getActivity().getApplication()).create(PropiedadesViewModel.class);
        context = getActivity();

        final ArrayAdapter<clsContrato> listarContratos = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, contratosVM.obtenerContratos());
        ArrayAdapter<clsPropiedad> listarPropiedades = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, propiedadVM.obtenerPropiedades());

        ArrayAdapter<String> datos = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, propiedadVM.listarPropiedades());

        final ListView lvPropiedades = view.findViewById(R.id.lvPropiedad);
        lvPropiedades.setAdapter(datos);


        lvPropiedades.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                clsContrato contrato = (clsContrato) listarContratos.getItem(position);
                contrato.setFechainicio(contrato.getFechainicio());
                contrato.setFechafinalizacion(contrato.getFechafinalizacion());
                contrato.setPrecio(contrato.getPrecio());
                startActivity(ContratosDetallesActivity.getCallingIntent(context, contrato));
            }
        });


        return view;
    }

}
