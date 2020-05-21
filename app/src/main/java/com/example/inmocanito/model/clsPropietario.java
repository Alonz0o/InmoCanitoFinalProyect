package com.example.inmocanito.model;

import android.content.Intent;

import com.example.inmocanito.MainActivity;

import java.util.ArrayList;

import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;

public class clsPropietario {
    private int propietarioId;
    private int dni;
    private String apellido;
    private String nombre;
    private int telefono;
    private String email;
    private String clave;

    public clsPropietario() {
    }

    public clsPropietario(int propietarioId, int dni, String apellido, String nombre, int telefono, String email,  String clave) {
        this.propietarioId = propietarioId;
        this.nombre = nombre;
        this.dni = dni;
        this.apellido = apellido;
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
        this.clave = clave;
    }

    public int getPropietarioId() {
        return propietarioId;
    }
    public void setPropietarioId(int propietarioId) {
        this.propietarioId = propietarioId;
    }
    
    public int getDni() {
        return dni;
    }
    public void setDni(int dni) {
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

    public int getTelefono() {
        return telefono;
    }
    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getClave() {
        return clave;
    }
    public void setClave(String email) {
        this.clave = clave;
    }

    public boolean logueo(String cuenta, String contraseña) {

        ArrayList<clsPropietario> arregloPropietarios = new ArrayList<>();
        arregloPropietarios.add(new clsPropietario(1,37599310,"Francescoli","Enzo", 14665768, "ariel@gmail.com","123456"));

        if(cuenta.equals("ariel@gmail.com") && contraseña.equals("123456")) {
            return true;
        } else return false;
    }

}
