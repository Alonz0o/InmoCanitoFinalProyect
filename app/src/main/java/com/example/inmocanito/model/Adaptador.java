package com.example.inmocanito.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.inmocanito.R;

import java.util.ArrayList;

public class Adaptador extends BaseAdapter {

    private Context context;
    private ArrayList<clsPropiedad> arrayList;
    public Adaptador(Context context,ArrayList<clsPropiedad> arrayList){
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
            convertView = layoutInflater.inflate(R.layout.fragment_detalle_pago,null);
        }

        TextView domicilio = (TextView)convertView.findViewById(R.id.tvPropiedadDomicilio);
        TextView tipo = (TextView)convertView.findViewById(R.id.tvPropiedadTipo);


        domicilio.setText(arrayList.get(position).getDomicilio());
        tipo.setText(arrayList.get(position).getTipo());
        return convertView;
    }

}
