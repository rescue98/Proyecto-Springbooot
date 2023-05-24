package com.example.Prueba2.Usuario;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
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
    public boolean esInactivo() {
        // Define aquí la lógica para determinar si el usuario es inactivo
        // Puedes utilizar la fecha actual y la fecha de última conexión para calcular la inactividad

        // Por ejemplo, si consideramos que un usuario es inactivo si su última conexión es anterior a 4 años de la fecha actual
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.YEAR, -4);
        Date fechaInactividad = calendar.getTime();

        return ultimaConexion.before(fechaInactividad);
    }
    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String ultimaConexionFormatted = dateFormat.format(ultimaConexion);
        return "Usuarios{" +
                "id='" + id + '\'' +
                ", correo='" + correo + '\'' +
                ", ultimaConexion=" + ultimaConexionFormatted +
                ", siguiendo=" + siguiendo +
                '}';
    }
}
