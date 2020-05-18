package com.example.inmocanito.model;

public class clsPropietario {
    private int propietarioId;
    private String dni;
    private String apellido;
    private String nombre;
    private String telefono;
    private String email;
    private String clave;

    public clsPropietario() {
    }

    public clsPropietario(int propietarioId, String dni, String apellido, String nombre, String telefono, String email,  String clave) {
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

    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
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
}
