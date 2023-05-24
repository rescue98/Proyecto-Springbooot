package com.example.Prueba2.Desafios;

import com.example.Prueba2.Usuario.Usuarios;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Etapa1Desafio1 {
    public static List<Usuarios> usuariosInactivos(List<Usuarios> usuarios){
        List<Usuarios> usuariosInactivos1 = new ArrayList<>();
        Date fechaActual = new Date();

        for (Usuarios usuarios1: usuarios){
            if (usuarios1.getUltimaConexion().before(fechaActual)){
                usuariosInactivos1.add(usuarios1);
            }
        }
        return usuariosInactivos1;
    }

    public static List<Usuarios> usuariosSeguidoresInactivos(List<Usuarios> usuarios){
        List<Usuarios> usuarioSeguidorInactivo = new ArrayList<>();

        for (Usuarios usuarios1: usuarios){
            int inactivos = 0;

            for (String seguido: usuarios1.getSiguiendo()){
                for (Usuarios usuarioSeguido : usuarios){
                    if (usuarioSeguido.getId().equals(seguido) && usuarioSeguido.getUltimaConexion().before(usuarios1.getUltimaConexion())){
                        inactivos++;
                    }
                }
            }

            if (inactivos >= usuarios1.getSiguiendo().size() / 2){
                usuarioSeguidorInactivo.add(usuarios1);
            }
        }
        return usuarioSeguidorInactivo;
    }

    public static List<Usuarios> usuarioMayorCantidadSeguidores(List<Usuarios> usuarios){
        List<Usuarios> mayorCantidadSeguidores = new ArrayList<>();
        int maximoSeguidores = 0;

        for(Usuarios usuarios1: usuarios){
            int cantSeguidores = 0;

            for (Usuarios seguido: usuarios){
                if (seguido.getSiguiendo().contains(usuarios1.getId())){
                    cantSeguidores++;
                }
            }

            if (cantSeguidores > maximoSeguidores){
                maximoSeguidores = cantSeguidores;
                mayorCantidadSeguidores.clear();
                mayorCantidadSeguidores.add(usuarios1);
            }else if (cantSeguidores == maximoSeguidores){
                mayorCantidadSeguidores.add(usuarios1);
            }
        }

        return mayorCantidadSeguidores;
    }

}
