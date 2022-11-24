/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.evidencia_final;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author jorgejarajuarez
 */
public class Evidencia_Final {


	
   private static ArrayList<Administrador> administradores = new ArrayList<Administrador>();
   private static GestorMedicos medicos = new GestorMedicos();
   private static GestorPacientes pacientes = new GestorPacientes();
   private static GestorCita citas = new GestorCita(medicos, pacientes);//Pasamos referencias
   private static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {
		
      crearAdmins();

      if (validarAcceso()) {
         System.out.println("\nUsuario autorizado\n");
         if (validarAcceso()) {
            System.out.println("\nUsuario autorizado\n");
            medicos.nuevoMedico();
            medicos.modificarMedico();
            medicos.mostrarMedicos();
            pacientes.nuevoPaciente();
            pacientes.mostrarPacientes();
            pacientes.modificarPaciente();
            pacientes.borrarPaciente();
            citas.nuevoCita();
            citas.mostrarCitas();
         }
         else
            System.out.println("\nUsuario no autorizado.");

         System.out.println("\n\t\tFIN DE PROGRAMA");

      }

   }//Cierre de main

   private static void crearAdmins() {
      administradores.add(new Administrador("Jorge", "1234"));
      administradores.add(new Administrador("Jara", "4321"));
      administradores.add(new Administrador("Juarez", "0000"));
   }

   private static boolean validarAcceso( ) {

      System.out.println("ACCESO AL SISTEMA");
      System.out.println("------ -- -------\n");
      System.out.print("Nombre: ");
      String nombre = teclado.nextLine();
      System.out.print("Password: ");
      String password = teclado.nextLine();

      Administrador admin = new Administrador(nombre, password);

      return administradores.contains(admin);
   }
}