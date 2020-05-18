package com.example.inmocanito.ui.pagos;

import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.example.inmocanito.R;
import com.example.inmocanito.model.clsPropiedad;
import com.example.inmocanito.ui.propiedades.PropiedadesViewModel;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;


public class PagosFragment extends Fragment {

    private ArrayList<clsPropiedad> propiedades = new ArrayList<>();
    private ArrayList<clsPropiedad> propiedadesmuteable = new ArrayList<>();
    private PropiedadesViewModel propiedadesViewModel;

    private PropiedadesViewModel PVM;
    private TabLayout tbPropiedades;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        propiedadesViewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(getActivity().getApplication()).create(PropiedadesViewModel.class);

        View view = inflater.inflate(R.layout.fragment_pagos, container, false);
        final ListView lvProdiedad = view.findViewById(R.id.lvPropiedad);

        propiedadesViewModel.cargarPropiedad(propiedades);
        ArrayAdapter<clsPropiedad> adaptador = new ArrayAdapter(getContext(), android.R.layout.simple_list_item_1, propiedades);
        lvProdiedad.setAdapter(adaptador);

        //propiedadesmuteable = new ArrayList<>();



        //final Observer<List<clsPropiedad>> listaObserver = new Observer<List<clsPropiedad>>() {
        //  @Override
        // public void onChanged(List<clsPropiedad> propiedades) {
        //   lvProdiedad.setAdapter(new Adapter(propiedades));
        //}
        //};


        //propiedadesViewModel.getPropiedades().observe(getViewLifecycleOwner(), listaObserver);


        return view;
    }

    public interface OnFragmentInteractionListener {
        void OnFragmentInteraction(Uri uri);
    }

}
