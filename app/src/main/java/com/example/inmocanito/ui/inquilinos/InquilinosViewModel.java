package com.example.inmocanito.ui.inquilinos;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.inmocanito.model.clsInquilino;

import java.util.ArrayList;

public class InquilinosViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public InquilinosViewModel() {
        //mText = new MutableLiveData<>();
        //mText.setValue("This is inquilinos fragment");
    }

    ArrayList<clsInquilino> arregloInquilinos = new ArrayList<>();
    ArrayList<String> datosInqui = new ArrayList<>();


    public ArrayList obtenerInquilinos (){
        arregloInquilinos.add(new clsInquilino(1,"31599310","Ariel","Suarez","Sanluis","200552022"));
        arregloInquilinos.add(new clsInquilino(2,"32599311","Juan","Gimenez","Mendoza","200553022"));
        arregloInquilinos.add(new clsInquilino(3,"33599312","Paola","Fernandez","Chile","20001512"));
        arregloInquilinos.add(new clsInquilino(4,"34599313","Jernan","Chumbo","SanLuan","20015120"));

        return arregloInquilinos;
    }
    public ArrayList listarinkiss (){

        int contador=-1;
        for(clsInquilino inquilino: arregloInquilinos){
            contador++;
            datosInqui.add(arregloInquilinos.get(contador).getDni()+" "+arregloInquilinos.get(contador).getNombre());
        }
        return datosInqui;
    }

}