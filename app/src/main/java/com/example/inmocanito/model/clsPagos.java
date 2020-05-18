package com.example.inmocanito.model;

import android.icu.util.LocaleData;

import java.util.Date;

public class clsPagos {
    private int pagoId;
    private int numpago;
    private LocaleData fecha;
    private int importe;

    public clsPagos() {
    }

    public clsPagos(int pagoId, int numpago, LocaleData fecha, int importe) {
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

    public LocaleData getFecha() {
        return fecha;
    }
    public void setFecha(LocaleData fecha) {
        this.fecha = fecha;
    }

    public int getImporte() {
        return importe;
    }
    public void setImporte(int importe) {
        this.importe = importe;
    }


}
