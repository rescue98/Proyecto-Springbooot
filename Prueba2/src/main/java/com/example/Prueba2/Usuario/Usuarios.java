package com.example.Prueba2.Usuario;

import java.util.ArrayList;
import java.util.Date;

public class Usuarios {

    private String id;
    private String correo;
    private Date ultimaConexion;
    private ArrayList<String> siguiendo;

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

    public ArrayList<String> getSiguiendo() {
        return siguiendo;
    }

    public void setSiguiendo(ArrayList<String> siguiendo) {
        this.siguiendo = siguiendo;
    }

    public Usuarios(String id, String correo, Date ultimaConexion, ArrayList<String> siguiendo) {
        this.id = id;
        this.correo = correo;
        this.ultimaConexion = ultimaConexion;
        this.siguiendo = siguiendo;
    }
}
