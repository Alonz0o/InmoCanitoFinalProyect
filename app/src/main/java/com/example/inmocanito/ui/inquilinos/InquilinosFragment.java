package com.example.inmocanito.ui.inquilinos;

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
import com.example.inmocanito.model.clsInquilino;

public class InquilinosFragment extends Fragment {

    private InquilinosViewModel inquilinoVM;
    private Context context;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_inquilinos, container, false);

        inquilinoVM = ViewModelProvider.AndroidViewModelFactory.getInstance(getActivity().getApplication()).create(InquilinosViewModel.class);
        context = getActivity();

        final ArrayAdapter<clsInquilino> cargarInquilinos = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, inquilinoVM.obtenerInquilinos());

        ArrayAdapter<String> cargarLvInquilinos = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, inquilinoVM.listarInquilinos());

        final ListView lvInquilinos = view.findViewById(R.id.lvInquilino);
        lvInquilinos.setAdapter(cargarLvInquilinos);


        lvInquilinos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                clsInquilino inquilino = (clsInquilino) cargarInquilinos.getItem(position);
                inquilino.setInquilinoId(inquilino.getInquilinoId());
                inquilino.setDni(inquilino.getDni());
                inquilino.setApellido(inquilino.getApellido());
                inquilino.setNombre(inquilino.getNombre());
                inquilino.setDireccion(inquilino.getDireccion());
                inquilino.setTelefono(inquilino.getTelefono());
                startActivity(InquilinosDetallesActivity.getCallingIntent(context, inquilino));
            }
        });


        return view;
    }

}
