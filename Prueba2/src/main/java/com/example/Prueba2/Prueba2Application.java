package com.example.Prueba2;

import com.example.Prueba2.Desafios.Etapa1Desafio2;
import com.example.Prueba2.Desafios.Etapa1Desafio1;
import com.example.Prueba2.Usuario.Usuarios;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class Prueba2Application {
	private static final String CSV_FILE_PATH = "utils/dataset2.csv";
	public static void main(String[] args) {
		SpringApplication.run(Prueba2Application.class, args);
		String csvFilePath = "./src/main/java/com/example/Prueba2/utils/dataset2.csv";
		List<Usuarios> usuariosList = Etapa1Desafio2.getAllUsuarios(csvFilePath);

		List<Usuarios> ultimosUsuarios = Etapa1Desafio2.getUltimosUsuariosConectados(csvFilePath);
		System.out.println("Usuarios con ultima conexion mas reciente");
		for (Usuarios usuario : ultimosUsuarios) {
			System.out.println(usuario);
		}

		List<String> usuariosPopulares = Etapa1Desafio2.getUsuariosMasPopulares(usuariosList);
		// Mostrar los usuarios más populares en la consola
		System.out.println("Usuarios más populares:");
		for (String usuario : usuariosPopulares) {
			System.out.println(usuario);
		}
		String usuarioInactivoMasSeguidores = Etapa1Desafio2.getUsuarioInactivoMasSeguidores(usuariosList);

		System.out.println("Usuario inactivo con más seguidores:");
		System.out.println(usuarioInactivoMasSeguidores);

		List<Usuarios> usuarios = obtenerUsuarios();

		List<Usuarios> usuariosInactivos = Etapa1Desafio1.usuariosInactivos(usuarios);
		System.out.println("Se imprime lista de usuarios inactivos");
		for (Usuarios usuarios1: usuariosInactivos){
			System.out.println(usuarios1.getId());
		}

		List<Usuarios> usuariosSeguidoresInactivos = Etapa1Desafio1.usuariosSeguidoresInactivos(usuarios);
		System.out.println("\nSe imprime lista de usuarios con seguidores inactivos");
		for (Usuarios usuarios1: usuariosSeguidoresInactivos){
			System.out.println(usuarios1.getId());
		}

		List<Usuarios> usuarioMayorCantidadSeguidores = Etapa1Desafio1.usuarioMayorCantidadSeguidores(usuarios);
		System.out.println("\nSe imprime lista de usuarios con mayor cantidad de seguidores");
		for (Usuarios usuarios1: usuarioMayorCantidadSeguidores){
			System.out.println(usuarios1.getId());
		}

	}

	private static List<Usuarios> obtenerUsuarios() {
		List<Usuarios> usuarios = new ArrayList<>();

		try(BufferedReader reader = new BufferedReader(new FileReader(CSV_FILE_PATH))){
			String linea;
			SimpleDateFormat format = new SimpleDateFormat("yyy-MM-dd");

			while((linea = reader.readLine()) != null){
				String[] datos = linea.split(",");
				String id = datos[0];
				String correo = datos[1];
				Date ultimaConexion = format.parse(datos[2]);
				ArrayList<String> siguiendo = new ArrayList<>();

				if (datos.length >3){
					siguiendo.addAll(Arrays.asList(datos[3].split(";")));
				}

				Usuarios usuarios1 = new Usuarios(id, correo, ultimaConexion, siguiendo);
				usuarios.add(usuarios1);
			}
		}catch (IOException | ParseException e){
			e.printStackTrace();
		}

		return usuarios;
	}



}
