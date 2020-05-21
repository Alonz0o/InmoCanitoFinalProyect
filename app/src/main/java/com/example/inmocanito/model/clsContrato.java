package com.example.inmocanito.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.example.inmocanito.R;
import java.io.Serializable;
import java.util.ArrayList;

@SuppressWarnings("clsContrato")
public class clsContrato implements Serializable {
    private int contratoId;
    private String fechainicio;
    private String fechafinalizacion;
    private String precio;

    public clsContrato() {
    }

    public clsContrato(int contratoId, String fechainicio, String fechafinalizacion, String precio) {
        this.contratoId = contratoId;
        this.fechainicio = fechainicio;
        this.fechafinalizacion = fechafinalizacion;
        this.precio = precio;
    }

    public int getContratoId() {
        return contratoId;
    }
    public void setContratoId(int contratoId) {
        this.contratoId = contratoId;
    }

    public String getFechainicio() {
        return fechainicio;
    }
    public void setFechainicio(String fechainicio) {
        this.fechainicio = fechainicio;
    }

    public String getFechafinalizacion() {
        return fechafinalizacion;
    }
    public void setFechafinalizacion(String fechafinalizacion) {
        this.fechafinalizacion = fechafinalizacion;
    }

    public String getPrecio() {
        return precio;
    }
    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public class AdaptadorContrato extends BaseAdapter {

        private Context context;
        private ArrayList<clsContrato> arrayList;
        public AdaptadorContrato(Context context, ArrayList<clsContrato> arrayList){
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
                convertView = layoutInflater.inflate(R.layout.fragment_inquilinos_detalles,null);
            }
            return convertView;
        }
    }

}
