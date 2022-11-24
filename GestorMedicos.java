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
public class GestorMedicos {
    private ArrayList<Medico> medicos;
	
	public GestorMedicos() {
		medicos = new ArrayList<Medico>();
	}
	
	/**
	 * Crea y registra un nuevo paciente.
	 * @return True si se pudo registrar con éxito el nuevo paciente.
	 * False si no fue posible registrarlo.
	 */
	public boolean nuevoMedico() {
		String id = JOptionPane.showInputDialog(null, "Introduzca Identificador:", "Nuevo Medico", JOptionPane.QUESTION_MESSAGE);
		String nombre = JOptionPane.showInputDialog(null, "Nombre:", "Nuevo Medico", JOptionPane.QUESTION_MESSAGE);
		String apellidos = JOptionPane.showInputDialog(null, "Apellidos:", "Nuevo Medico", JOptionPane.QUESTION_MESSAGE);
		String especialidad = JOptionPane.showInputDialog(null, "Especialidad:", "Nuevo Medico", JOptionPane.QUESTION_MESSAGE);
		int edad = 0;
		try {
			edad = Integer.parseInt(JOptionPane.showInputDialog(null, "Edad:", "Nuevo Medico", JOptionPane.QUESTION_MESSAGE));
		}
		catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Solo se admite introducir numeros para la edad\nNo se ha registrado el valor introducido",
					"Error", JOptionPane.WARNING_MESSAGE);
		}
		Medico nuevoMedico = new Medico(id, nombre, apellidos, especialidad);
		return medicos.add(nuevoMedico);//Devuelve TRUE si se insertó correctamente, FALSE si no se pudo insertar
	}
	
	/**
	 * Lista por pantalla los datos de todos los pacientes registrados.
	 */
	public void mostrarMedicos() {
		if (medicos.isEmpty())
			JOptionPane.showMessageDialog(null, "No hay Pacientes registrados", "Mostrar Pacientes",
					JOptionPane.WARNING_MESSAGE);
		else {
			for (Medico m: medicos)
				m.mostrar();
		}
	}
	
	/**
	 * Modifica el Paciente que el usuario solicite mediante el ID de Paciente.
	 * @return True al finalizar la modificacion correctamente.
	 * False si no se encontró ningun paciente con el ID indicado.
	 */
	public boolean modificarMedico() {
		String id = JOptionPane.showInputDialog(null, "Introduzca Identificador del medico a modificar:",
				"Modificar Medico", JOptionPane.QUESTION_MESSAGE);
		/*
		 * Ahora buscaremos el paciente en el ArrayList y si lo encontramos lo referenciaremos
		 * a otro objeto de la clase Paciente que incialmente tiene valor null.
		 * Si tras finalizar la búsqueda, este objeto sigue valiendo null significa que no hemos
		 * encontrado el Paciente que nos han pedido e informaremos al usuario.
		 */
		Medico medico = null;
		for (int i = 0; i < medicos.size(); i++){
			if (medicos.get(i).getId().equals(id)) {
				medico = medicos.get(i);//Referenciamos a otro nombre de objeto
				break;//No hace falta seguir buscando, "rompemos" el bucle for
			}
		}
		
		if (medico == null) {
			JOptionPane.showMessageDialog(null, "No se encuentra Medico con el ID:\n" + id, 
					"Medico no encontrado", JOptionPane.WARNING_MESSAGE);
			return false;
		}
		else {
			//Comienza el proceso de modificacion
			medico.setId(JOptionPane.showInputDialog(null, "ID actual: " + medico.getId()
				+ "\nIntroduzca nuevo identificador:", "Modificar Medico", JOptionPane.QUESTION_MESSAGE));
			medico.setNombre(JOptionPane.showInputDialog(null, "Nombre actual: " + medico.getNombre()
				+ "\nIntroduzca nuevo nombre:", "Modificar Medico", JOptionPane.QUESTION_MESSAGE));
			medico.setApellidos(JOptionPane.showInputDialog(null, "Apellidos actuales: " + medico.getApellidos()
				+ "\nIntroduzca nuevos apellidos:", "Modificar Medico", JOptionPane.QUESTION_MESSAGE));
			medico.setEspecialidad(JOptionPane.showInputDialog(null, "Genero actual: " + medico.getEspecialidad()
				+ "\nIntroduzca nueva especialidad:", "Modificar Medico", JOptionPane.QUESTION_MESSAGE));
		
			return true;
		}
	}
	
	/**
	 * Elimina el Paciente indicado por el usuario mediante el ID del Paciente.
	 * @return True si tuvo éxito la eliminacion.
	 * False si no se encontró el Paciente indicado.
	 */
	public boolean borrarPaciente() {
		String id = JOptionPane.showInputDialog(null, "Introduzca Identificador del paciente a borrar:",
				"Borrar Paciente", JOptionPane.QUESTION_MESSAGE);
		
		Medico medico = null;
		for (int i = 0; i < medicos.size(); i++){
			if (medicos.get(i).getId().equals(id))
				medico = medicos.remove(i);//Al eliminar el objeto, el ArrayList nos lo devuelve y lo recogemos en "paciente"
		}
		
		if (medico == null) {
			JOptionPane.showMessageDialog(null, "No se encuentra Medico con el ID:\n" + id, 
					"Medico no encontrado", JOptionPane.WARNING_MESSAGE);
			return false;
		}
		else {
			JOptionPane.showMessageDialog(null, "Se elimino al medico con ID:\n" + id, 
					"Medico Eliminado", JOptionPane.INFORMATION_MESSAGE);
			return true;
		}
        }
	
        	public Medico getMedico(String id) {
		for (Medico medico: medicos)
			if (medico.getId().equals(id))
				return medico; //Doctor encontrado
		//Si el bucle no ha retornado ningún Doctor, es que no existe ese ID
		return null;
	}

}


