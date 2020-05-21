package com.example.inmocanito.ui.cerrarsesion;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.inmocanito.R;


public class CerrarsesionFragment extends Fragment {

    private View v;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_inicio, container, false);
        v=view;
        cerrar();
        return view;
    }

    private void cerrar(){
        new AlertDialog.Builder(getContext())
                .setTitle("Cerrar Aplicacion")
                .setCancelable(false)
                .setMessage("Estas Seguro?")
                .setPositiveButton("Si", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        getActivity().finish();
                    }
                })

                .setNegativeButton("No",new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                        Navigation.findNavController(v).navigate(R.id.inicio, null);
                    }
                })
                .show();
    }

}
