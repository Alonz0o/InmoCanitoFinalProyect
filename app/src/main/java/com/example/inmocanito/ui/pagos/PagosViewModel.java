package com.example.inmocanito.ui.pagos;

import androidx.lifecycle.ViewModel;

import com.example.inmocanito.model.clsPago;

import java.util.ArrayList;


public class PagosViewModel extends ViewModel {

    ArrayList<clsPago> arregloPagos = new ArrayList<>();


    public ArrayList obtenerPagos(){
        arregloPagos.add(new clsPago(1,1,"2/10/2020",5000));
        arregloPagos.add(new clsPago(2,2,"3/9/2020",10000));
        arregloPagos.add(new clsPago(3,3,"4/8/2020",6000));
        arregloPagos.add(new clsPago(4,4,"5/7/2020",7000));
        return arregloPagos;
    }

}
