package com.example.inmocanito.ui.propiedades;

import androidx.lifecycle.ViewModel;
import com.example.inmocanito.model.clsPropiedad;
import java.util.ArrayList;

public class PropiedadesViewModel extends ViewModel {


    ArrayList<clsPropiedad> arregloPropiedades = new ArrayList<>();
    ArrayList<String> datosPropiedad = new ArrayList<>();


    public ArrayList obtenerPropiedades(){
        arregloPropiedades.add(new clsPropiedad(1,"Sanlui",2,"Casa","Economico",2000,true));
        arregloPropiedades.add(new clsPropiedad(2,"Lujan",2,"Casa","Economico",2000,true));
        arregloPropiedades.add(new clsPropiedad(3,"Nocheoquea",2,"Casa","Economico",2000,true));
        arregloPropiedades.add(new clsPropiedad(4,"Llamaja",2,"Casa","Economico",2000,true));

        return arregloPropiedades;
    }

    public ArrayList listarPropiedades(){

        int contador=-1;
        for(clsPropiedad propiedad: arregloPropiedades){
            contador++;
            datosPropiedad.add(arregloPropiedades.get(contador).getDomicilio()+" "+ arregloPropiedades.get(contador).getAmbientes());
        }
        return datosPropiedad;
    }

}