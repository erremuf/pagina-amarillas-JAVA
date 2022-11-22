package com.aepi;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import com.aepi.clases.Fichero;

public class PaginasAmarillas {

	public static void main(String[] args) {
		
		System.out.println("\r\nBIENVENIDO A LAS PÁGINAS AMARILLAS");
		
		Scanner sc = new Scanner(System.in);
		Fichero fichero = new Fichero();
		boolean salir = false;

		
		do {
			
			System.out.println("\r\n¿Qué quieres hacer?");
			System.out.println("\n1.Añadir contacto"
					+ "\n2.Buscar contacto por nombre"
					+ "\n3.Listar todos los contactos"
					+ "\n4.Salir");

			int opcion = sc.nextInt();
			switch (opcion) {
			
			case 1: 
				System.out.println("\nPor favor introduce un nombre: ");
				fichero.setNombre(sc.next());
				System.out.println("Por favor, introduce un numero de teléfono: ");
				fichero.setTel(sc.nextInt());
				try {
					fichero.insertar();
				} catch (IOException e) {
					System.out.println("\nNo se ha podido guardar el contacto");
				}
				break;
				
			case 2: 
				System.out.println("\nPor favor, intruzca el nombre del usuario deseado: ");
				fichero.setNombre(sc.next());
				try {
					fichero.mostrarContacto(fichero.getNombre());
				}catch (FileNotFoundException e) {
					System.out.println("\nNo se ha encontrado el fichero");
				}catch (IOException e) {
					System.out.println("\nERROR");
				}
				break;
				
			case 3:
				System.out.println("\nMostrando agenda telefónica: ");
				try {
					fichero.mostrarAgenda();
				} catch (FileNotFoundException e) {
					System.out.println("\nNo se ha encontrado el fichero");
				} catch (IOException e) {
					System.out.println("\nERROR");
				}
			break;
			
			case 4:
				salir = true;
	
			}
		} while (!salir);

	}

}
