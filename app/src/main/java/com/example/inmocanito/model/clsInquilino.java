package com.example.inmocanito.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.inmocanito.R;

import java.io.Serializable;
import java.util.ArrayList;

@SuppressWarnings("clsInquilino")
public class clsInquilino implements Serializable {
    private int inquilinoId;
    private String dni;
    private String apellido;
    private String nombre;
    private String direccion;
    private String telefono;

    public clsInquilino() {
    }

    public clsInquilino(int inquilinoId, String dni, String apellido, String nombre, String direccion, String telefono) {
        this.inquilinoId = inquilinoId;
        this.nombre = nombre;
        this.dni = dni;
        this.apellido = apellido;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public int getInquilinoId() {
        return inquilinoId;
    }
    public void setInquilinoId(int inquilinoId) {
        this.inquilinoId = inquilinoId;
    }
    
    public String getDni() {
        return dni;
    }
    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public class AdaptadorInquilino extends BaseAdapter {

        private Context context;
        private ArrayList<clsInquilino> arrayList;
        public AdaptadorInquilino(Context context, ArrayList<clsInquilino> arrayList){
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
            TextView tvDniInqui = (TextView)convertView.findViewById(R.id.tvDetalleInquilinoDni);
            TextView tvApellidoInqui = (TextView)convertView.findViewById(R.id.tvDetalleInquilinoApellido);
            TextView tvNombreInqui = (TextView)convertView.findViewById(R.id.tvDetalleInquilinoNombre);

            tvDniInqui.setText(arrayList.get(position).getDni());
            tvApellidoInqui.setText(arrayList.get(position).getApellido());
            tvNombreInqui.setText(arrayList.get(position).getNombre());
            return convertView;
        }
    }
}

