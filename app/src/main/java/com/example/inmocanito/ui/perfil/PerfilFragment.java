package com.example.inmocanito.ui.perfil;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.example.inmocanito.R;

public class PerfilFragment extends Fragment {

    private PerfilViewModel perfilVM;



    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_perfil, container, false);


        final TextView tvPEditar = root.findViewById(R.id.tvPEditar);
        final EditText etPDn = root.findViewById(R.id.etPDni);
        final EditText etPApe = root.findViewById(R.id.etPApellido);
        final EditText etPNom = root.findViewById(R.id.etPNnombre);
        final EditText etPTel = root.findViewById(R.id.etPTelefono);
        final EditText etPCorreo = root.findViewById(R.id.etPEmail);
        final EditText etPContra = root.findViewById(R.id.etPContraseña);
        final ImageView imgPDniOk = root.findViewById(R.id.imgCorrecto1);
        final Button btnPEdit = root.findViewById(R.id.btnPEditar);

        perfilVM = ViewModelProvider.AndroidViewModelFactory.getInstance(getActivity().getApplication()).create(PerfilViewModel.class);
        perfilVM.cargarPropietarios(etPDn, etPApe, etPNom, etPTel, etPCorreo, etPContra);

        btnPEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                perfilVM.botonHabilitado(etPDn, etPApe, etPNom, etPTel, etPCorreo, etPContra);
                perfilVM.editar(etPDn.getText().toString(), etPNom.getText().toString(), etPApe.getText().toString());
            }
        });



        perfilVM.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                tvPEditar.setText(s);
            }
        });

        TextWatcher afterTextChangedListener = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // ignorar
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // ignorar
            }

            @Override
            public void afterTextChanged(Editable s) {
                perfilVM.datosCambian(etPDn, etPApe, etPNom, etPTel, etPCorreo, etPContra, imgPDniOk, btnPEdit);
            }
        };
        etPDn.addTextChangedListener(afterTextChangedListener);
        etPApe.addTextChangedListener(afterTextChangedListener);
        etPNom.addTextChangedListener(afterTextChangedListener);
        etPTel.addTextChangedListener(afterTextChangedListener);
        etPCorreo.addTextChangedListener(afterTextChangedListener);
        etPContra.addTextChangedListener(afterTextChangedListener);
        btnPEdit.addTextChangedListener(afterTextChangedListener);
        return root;
    }
}

