package com.example.inmocanito.ui.propiedades;

import androidx.lifecycle.ViewModel;
import com.example.inmocanito.model.clsPropiedad;

import java.util.ArrayList;

public class PropiedadesViewModel extends ViewModel {



    public void cargarPropiedad(ArrayList<clsPropiedad> propiedades){
        propiedades.add(new clsPropiedad(1,"222sad",2,"Casa","Economico",2000,true));
        propiedades.add(new clsPropiedad(3,"222sad",2,"Casa","Economico",2000,true));
        propiedades.add(new clsPropiedad(3,"222sad",2,"Casa","Economico",2000,true));
        propiedades.add(new clsPropiedad(3,"222sad",2,"Casa","Economico",2000,true));

    }

}