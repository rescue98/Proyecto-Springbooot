package com.example.Prueba2;

import java.util.ArrayList;
import java.util.Date;

public class Usuarios {

    private String id;
    private String correo;
    private Date ultimaConexion;
    private ArrayList<Integer> siguiento;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Date getUltimaConexion() {
        return ultimaConexion;
    }

    public void setUltimaConexion(Date ultimaConexion) {
        this.ultimaConexion = ultimaConexion;
    }

    public ArrayList<Integer> getSiguiento() {
        return siguiento;
    }

    public void setSiguiento(ArrayList<Integer> siguiento) {
        this.siguiento = siguiento;
    }

    public Usuarios(String id, String correo, Date ultimaConexion, ArrayList<Integer> siguiento) {
        this.id = id;
        this.correo = correo;
        this.ultimaConexion = ultimaConexion;
        this.siguiento = siguiento;
    }
}
