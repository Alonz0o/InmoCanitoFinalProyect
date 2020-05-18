package com.example.inmocanito.ui.pagos;

import androidx.lifecycle.ViewModel;
import com.example.inmocanito.model.clsPropiedad;
import java.util.ArrayList;


public class PagosViewModel extends ViewModel {

    ArrayList<clsPropiedad> arregloPropiedades = new ArrayList<>();


    public ArrayList obtenerPropiedades (){
        arregloPropiedades.add(new clsPropiedad(1,"Casa1",2,"Casa","Economico",2000,true));
        arregloPropiedades.add(new clsPropiedad(2,"Casa2",2,"Casa","Economico",2000,true));
        arregloPropiedades.add(new clsPropiedad(3,"Casa3",2,"Casa","Economico",2000,true));
        arregloPropiedades.add(new clsPropiedad(4,"Casa4",2,"Casa","Economico",2000,true));

        return arregloPropiedades;
    }

}
