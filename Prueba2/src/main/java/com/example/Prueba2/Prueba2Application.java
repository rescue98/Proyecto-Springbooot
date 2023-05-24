package com.example.Prueba2;

import com.example.Prueba2.Desafios.Etapa1Desafio2;
import com.example.Prueba2.Usuario.Usuarios;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class Prueba2Application {

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
	}



}
