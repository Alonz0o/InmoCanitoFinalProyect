package com.example.inmocanito.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.example.inmocanito.R;
import java.io.Serializable;
import java.util.ArrayList;

@SuppressWarnings("clsPropiedad")
public class clsPropiedad implements Serializable {
    private int propiedadId;
    private String domicilio;
    private int ambientes;
    private String tipo;
    private String uso;
    private int precio;
    private boolean disponible;

    public clsPropiedad() {
    }

    public clsPropiedad(int propiedadId, String domicilio, int ambientes, String tipo, String uso, int precio, boolean disponible) {
        this.propiedadId = propiedadId;
        this.tipo = tipo;
        this.domicilio = domicilio;
        this.ambientes = ambientes;
        this.tipo = tipo;
        this.uso = uso;
        this.precio = precio;
        this.disponible = disponible;
    }

    public int getPropiedadId() {
        return propiedadId;
    }
    public void setPropiedadId(int propiedadId) {
        this.propiedadId = propiedadId;
    }
    
    public String getDomicilio() {
        return domicilio;
    }
    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public int getAmbientes() {
        return ambientes;
    }
    public void setAmbientes(int ambientes) {
        this.ambientes = ambientes;
    }

    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getUso() {
        return uso;
    }
    public void setUso(String uso) {
        this.uso = uso;
    }

    public int getPrecio() {
        return precio;
    }
    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public boolean getDisponible() {
        return disponible;
    }
    public void setDisponible(boolean email) {
        this.disponible = disponible;
    }

    public class AdaptadorPropiedades extends BaseAdapter {

        private Context context;
        private ArrayList<clsPropiedad> arrayList;
        public AdaptadorPropiedades(Context context, ArrayList<clsPropiedad> arrayList){
            this.context=context;
            this.arrayList=arrayList;
        }


        @Override
        public int getCount() {
            return arrayList.size();
        }

        @Override
        public Object getItem(int position) {
            return arrayList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if(convertView==null){
                LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
                convertView = layoutInflater.inflate(R.layout.fragment_pagos_detalles,null);
            }
            return convertView;
        }
    }

}
