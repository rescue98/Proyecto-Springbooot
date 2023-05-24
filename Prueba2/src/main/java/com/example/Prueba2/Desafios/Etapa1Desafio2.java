package com.example.Prueba2.Desafios;

import com.example.Prueba2.Usuario.Usuarios;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

public class Etapa1Desafio2 {
    public Etapa1Desafio2() {
    }

    public static List<Usuarios> readCsvFile(String filePath) {
        List<Usuarios> usuariosList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            // Leer la primera línea que contiene los encabezados y descartarla
            br.readLine();

            String line;
            while ((line = br.readLine()) != null) {
                String[] rowData = line.split(";");
                if (rowData.length == 4) {
                    String id = rowData[0];
                    String correo = rowData[1];
                    Date ultimaConexion = parseDate(rowData[2]);
                    ArrayList<String> siguiendo = parseSiguiendo(rowData[3]);

                    Usuarios usuario = new Usuarios(id, correo, ultimaConexion, siguiendo);
                    usuariosList.add(usuario);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return usuariosList;
    }

    private static Date parseDate(String dateString) {
        SimpleDateFormat[] dateFormats = {
                new SimpleDateFormat("dd/MM/yyyy"),
                new SimpleDateFormat("dd-MM-yyyy"),
                // Agrega más formatos aquí si es necesario
        };

        for (SimpleDateFormat dateFormat : dateFormats) {
            try {
                return dateFormat.parse(dateString);
            } catch (ParseException e) {
                // Ignorar el error y probar el siguiente formato
            }
        }

        // Si no se puede analizar la fecha con ninguno de los formatos, devuelve null
        return null;
    }

    private static ArrayList<String> parseSiguiendo(String siguiendoString) {
        String[] siguiendoArray = siguiendoString.split(",");
        ArrayList<String> siguiendo = new ArrayList<>();
        for (String sig : siguiendoArray) {
            siguiendo.add(sig.trim());
        }
        return siguiendo;
    }
    public static List<Usuarios> getAllUsuarios(String filePath) {
        return readCsvFile(filePath);
    }
    public static List<Usuarios> getUltimosUsuariosConectados(String filePath) {
        List<Usuarios> usuariosList = readCsvFile(filePath);

        usuariosList.sort(Comparator.comparing(Usuarios::getUltimaConexion).reversed());

        // Obtener los últimos 10 usuarios
        List<Usuarios> ultimosUsuarios = usuariosList.stream()
                .limit(10)
                .collect(Collectors.toList());

        return ultimosUsuarios;
    }
    public static List<String> getUsuariosMasPopulares(List<Usuarios> usuariosList) {
        Map<String, Integer> popularidadMap = new HashMap<>();

        // Calcular la popularidad de cada usuario
        for (Usuarios usuario : usuariosList) {
            List<String> siguiendo = usuario.getSiguiendo();
            for (String seguido : siguiendo) {
                popularidadMap.put(seguido, popularidadMap.getOrDefault(seguido, 0) + 1);
            }
        }

        // Encontrar la máxima popularidad
        int maxPopularidad = 0;
        for (int popularidad : popularidadMap.values()) {
            if (popularidad > maxPopularidad) {
                maxPopularidad = popularidad;
            }
        }

        // Obtener los usuarios más populares
        List<String> usuariosPopulares = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : popularidadMap.entrySet()) {
            if (entry.getValue() == maxPopularidad) {
                Usuarios usuario = getUsuarioById(usuariosList, entry.getKey());
                if (usuario != null) {
                    String infoUsuario = "ID: " + usuario.getId() + ", Correo: " + usuario.getCorreo() +
                            ", Seguidores: " + entry.getValue();
                    usuariosPopulares.add(infoUsuario);
                }
            }
        }

        return usuariosPopulares;
    }

    private static Usuarios getUsuarioById(List<Usuarios> usuariosList, String id) {
        for (Usuarios usuario : usuariosList) {
            if (usuario.getId().equals(id)) {
                return usuario;
            }
        }
        return null;
    }

    public static String getUsuarioInactivoMasSeguidores(List<Usuarios> usuariosList) {
        Map<String, Integer> seguidoresMap = new HashMap<>();

        // Contar el número de seguidores para cada usuario
        for (Usuarios usuario : usuariosList) {
            for (String seguidor : usuario.getSiguiendo()) {
                seguidoresMap.put(seguidor, seguidoresMap.getOrDefault(seguidor, 0) + 1);
            }
        }

        String usuarioInactivoMasSeguidores = null;
        int maxSeguidores = 0;

        // Encontrar el usuario inactivo con más seguidores
        for (Usuarios usuario : usuariosList) {
            if (!usuario.esInactivo() && seguidoresMap.containsKey(usuario.getId())) {
                int numSeguidores = seguidoresMap.get(usuario.getId());
                if (numSeguidores > maxSeguidores) {
                    maxSeguidores = numSeguidores;
                    String fechaUltimaConexion = formatDate(usuario.getUltimaConexion());
                    usuarioInactivoMasSeguidores = usuario.getId() + ", " + usuario.getCorreo() + ", Seguidores: " + maxSeguidores + ", Última conexión: " + fechaUltimaConexion;
                }
            }
        }

        return usuarioInactivoMasSeguidores;
    }

    private static String formatDate(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return dateFormat.format(date);
    }
    }



