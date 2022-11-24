/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.evidencia_final;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author jorgejarajuarez
 */
public class GestorCita {

   private ArrayList<Cita> citas;

   //Referencias a las instancias de los gestores de doctores y pacientes
   private GestorMedicos medicos;
   private GestorPacientes pacientes;

   public GestorCita(GestorMedicos gestDoc, GestorPacientes gestPaci) {
      citas = new ArrayList<Cita>();
      medicos = gestDoc;
      pacientes = gestPaci;
   }

   public boolean nuevoCita() {
      String id = JOptionPane.showInputDialog(null, "Introduzca Identificador:", "Nuevo Cita", JOptionPane.QUESTION_MESSAGE);
      String fecha = JOptionPane.showInputDialog(null, "Fecha:", "Nuevo Fecha", JOptionPane.QUESTION_MESSAGE);
      String hora = JOptionPane.showInputDialog(null, "Hora:", "Nuevo Hora", JOptionPane.QUESTION_MESSAGE);
      String motivo = JOptionPane.showInputDialog(null, "Motivo:", "Nuevo Motivo", JOptionPane.QUESTION_MESSAGE);
      String iDMedico = JOptionPane.showInputDialog(null, "ID del Doctor:", "Nuevo Doctor", JOptionPane.QUESTION_MESSAGE);
      String iDpaciente = JOptionPane.showInputDialog(null, "ID del Paciente:", "Nuevo Paciente", JOptionPane.QUESTION_MESSAGE);

      //Pedimos los datos a los gestores que tenemos referenciados
      Medico medico = medicos.getMedico(iDMedico);
      Paciente paciente = pacientes.getPaciente(iDpaciente);
      
      Cita nuevoCita = new Cita(id, fecha, hora, motivo, medico, paciente);
      return citas.add(nuevoCita);
      //Devuelve TRUE si se insertó correctamente, FALSE si no se pudo insertar
   }
   	public void mostrarCitas() {
		if (citas.isEmpty())
			JOptionPane.showMessageDialog(null, "No hay Pacientes registrados", "Mostrar Pacientes",
					JOptionPane.WARNING_MESSAGE);
		else {
			for (Cita c: citas)
				c.mostrar();
		}
	}


}


