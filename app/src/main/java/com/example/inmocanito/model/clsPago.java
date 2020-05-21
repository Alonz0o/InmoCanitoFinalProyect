package com.example.inmocanito.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.inmocanito.R;

import java.io.Serializable;
import java.util.ArrayList;

@SuppressWarnings("clsPago")
public class clsPago implements Serializable {
    private int pagoId;
    private int numpago;
    private String fecha;
    private int importe;

    public clsPago() {
    }

    public clsPago(int pagoId, int numpago, String fecha, int importe) {
        this.pagoId = pagoId;
        this.numpago = numpago;
        this.fecha = fecha;
        this.importe = importe;
    }

    public int getPagoId() {
        return pagoId;
    }
    public void setPagoId(int pagoId) {
        this.pagoId = pagoId;
    }

    public int getNumpago() {
        return numpago;
    }
    public void setNumpago(int numpago) {
        this.numpago = numpago;
    }

    public String getFecha() {
        return fecha;
    }
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getImporte() {
        return importe;
    }
    public void setImporte(int importe) {
        this.importe = importe;
    }

    public class AdaptadorPagos extends BaseAdapter {

        private Context context;
        private ArrayList<clsPago> arrayList;
        public AdaptadorPagos(Context context, ArrayList<clsPago> arrayList){
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
