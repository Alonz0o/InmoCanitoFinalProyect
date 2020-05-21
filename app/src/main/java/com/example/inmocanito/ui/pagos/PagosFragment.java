package com.example.inmocanito.ui.pagos;

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
import com.example.inmocanito.model.clsPago;
import com.example.inmocanito.model.clsPropiedad;
import com.example.inmocanito.ui.propiedades.PropiedadesViewModel;

public class PagosFragment extends Fragment {

    private PagosViewModel pagosVM;
    private PropiedadesViewModel propiedadVM;
    private Context context;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_propiedades, container, false);

        pagosVM = ViewModelProvider.AndroidViewModelFactory.getInstance(getActivity().getApplication()).create(PagosViewModel.class);
        propiedadVM = ViewModelProvider.AndroidViewModelFactory.getInstance(getActivity().getApplication()).create(PropiedadesViewModel.class);
        context = getActivity();

        final ArrayAdapter<clsPago> cargarPagos = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, pagosVM.obtenerPagos());
        ArrayAdapter<clsPropiedad> listarPropiedades = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, propiedadVM.obtenerPropiedades());

        ArrayAdapter<String> cargarLv = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, propiedadVM.listarPropiedades());

        final ListView lvPropiedades = view.findViewById(R.id.lvPropiedad);
        lvPropiedades.setAdapter(cargarLv);


        lvPropiedades.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                clsPago pago = (clsPago) cargarPagos.getItem(position);
                pago.setNumpago(pago.getNumpago());
                pago.setFecha(pago.getFecha());
                pago.setImporte(pago.getImporte());
                startActivity(PagosDetallesActivity.getCallingIntent(context, pago));
            }
        });


        return view;
    }

}
