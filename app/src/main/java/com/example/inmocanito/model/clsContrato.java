package com.example.inmocanito.model;

import java.util.Date;

public class clsContrato {
    private int contratoId;
    private Date fechainicio;
    private Date fechafinalizacion;
    private int precio;

    public clsContrato() {
    }

    public clsContrato(int contratoId, Date fechainicio, Date fechafinalizacion, int precio) {
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

    public Date getFechainicio() {
        return fechainicio;
    }
    public void setFechainicio(Date fechainicio) {
        this.fechainicio = fechainicio;
    }

    public Date getFechafinalizacion() {
        return fechafinalizacion;
    }
    public void setFechafinalizacion(Date fechafinalizacion) {
        this.fechafinalizacion = fechafinalizacion;
    }

    public int getPrecio() {
        return precio;
    }
    public void setPrecio(int precio) {
        this.precio = precio;
    }


}
