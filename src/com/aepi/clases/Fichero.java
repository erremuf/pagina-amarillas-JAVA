package com.aepi.clases;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Writer;
import java.sql.SQLException;
import java.util.StringTokenizer;

public class Fichero {

	private int tel;
	private String nombre;
	File agenda = new File("contactos.txt");
	
	
	public Fichero() {

	}
	public Fichero(int tel, String nombre) {
		super();
		this.tel = tel;
		this.nombre = nombre;
	}

	public int getTel() {
		return tel;
	}

	public void setTel(int tel) {
		this.tel = tel;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

// ---------- MÉTODO PARA ESCRIBIR EN FICHERO

	
	public void insertar() throws IOException {

		try (BufferedWriter añadir = new BufferedWriter(new FileWriter(this.agenda, true))) {

			añadir.write(this.nombre + "@" + this.tel);
			añadir.newLine();

			System.out.println("\nContacto añadido correctamente");
		}
	}

//----------  MÉTODO PARA MOSTRAR CONTACTO

	public void mostrarContacto(String nombre) throws FileNotFoundException, IOException {

		try (BufferedReader mostrarContacto = new BufferedReader(new FileReader(this.agenda))) {
           String linea;

			// Mientras que mostrarContacto.readline() sea sea distinto a null.
			while ((linea = mostrarContacto.readLine()) != null) {			
				StringTokenizer arrobaToken = new StringTokenizer(linea, "@", false);				
			// Y mientras que arroba tenga mas tokens.
				while (arrobaToken.hasMoreTokens()) {
					if (this.nombre.equals(arrobaToken.nextToken())) {
						System.out.println("Nombre: " + this.nombre + " - Telefono: " + arrobaToken.nextToken());
					}
				}
			}			
		}
	}
	

//----------  MÉTODO PARA MOSTRAR AGENDA

	public void mostrarAgenda() throws FileNotFoundException, IOException {

		try (BufferedReader mostrarAgenda = new BufferedReader(new FileReader(this.agenda))) {

			String linea;

			// Mientras que mostrarAgenda.readline() sea distinto a null.
			while ((linea = mostrarAgenda.readLine()) != null) {
				StringTokenizer arrobaToken = new StringTokenizer(linea, "@", false);
				while(arrobaToken.hasMoreTokens()) {
					System.out.println("Nombre: " + arrobaToken.nextToken() + " - Teléfono: " + arrobaToken.nextToken());
				}
			}
		}
	}

}
