package com.example.inmocanito.ui.contratos;

import androidx.lifecycle.ViewModel;

import com.example.inmocanito.model.clsContrato;
import com.example.inmocanito.model.clsPropiedad;

import java.util.ArrayList;


public class ContratosViewModel extends ViewModel {

    ArrayList<clsContrato> arregloContratos = new ArrayList<>();


    public ArrayList obtenerContratos(){
        arregloContratos.add(new clsContrato(1,"10/2/2020","10/3/2020","1000"));
        arregloContratos.add(new clsContrato(2,"23/3/2020","23/3/2020","3000"));
        arregloContratos.add(new clsContrato(3,"1/4/2020","1/4/2020","50000"));
        arregloContratos.add(new clsContrato(4,"15/5/2020","15/6/2020","20000"));

        return arregloContratos;
    }
}
