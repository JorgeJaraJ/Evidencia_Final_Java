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
public class GestorHistorialesClinicos {
    private ArrayList<HistorialClinico> historialesclinicos;
	
	public GestorHistorialesClinicos() {
		historialesclinicos = new ArrayList<HistorialClinico>();
	}
	
	/**
	 * Crea y registra un nuevo paciente.
	 * @return True si se pudo registrar con éxito el nuevo paciente.
	 * False si no fue posible registrarlo.
	 */
	public boolean nuevoHistorialClinico() {
		String codigo = JOptionPane.showInputDialog(null, "Introduzca Identificador:", "Nuevo Historial Medico", JOptionPane.QUESTION_MESSAGE);
		String fecha = JOptionPane.showInputDialog(null, "Fecha:", "Nueva Fecha", JOptionPane.QUESTION_MESSAGE);
		String idPaciente = JOptionPane.showInputDialog(null, "ID Paciente:", "Nuevo ID Paciente", JOptionPane.QUESTION_MESSAGE);
                String observaciones = JOptionPane.showInputDialog(null, "Observaciones:", "Nuevas Observaciones", JOptionPane.QUESTION_MESSAGE);
		String idMedico = JOptionPane.showInputDialog(null, "ID Médico:", "Nuevo ID Medico", JOptionPane.QUESTION_MESSAGE);
		int edad = 0;

		HistorialClinico nuevoHistorialClinico = new HistorialClinico(codigo, fecha, idPaciente, observaciones, idMedico);
		return historialesclinicos.add(nuevoHistorialClinico);//Devuelve TRUE si se insertó correctamente, FALSE si no se pudo insertar
	}
	
	/**
	 * Lista por pantalla los datos de todos los historiales registrados.
	 */
	public void mostrarHistorialesClinicos() {
		if (historialesclinicos.isEmpty())
			JOptionPane.showMessageDialog(null, "No hay historiales registrados", "Mostrar historiales",
					JOptionPane.WARNING_MESSAGE);
		else {
			for (HistorialClinico m: historialesclinicos)
				m.mostrar();
		}
	}
	
	/**
	 * Modifica el Paciente que el usuario solicite mediante el ID de Paciente.
	 * @return True al finalizar la modificacion correctamente.
	 * False si no se encontró ningun paciente con el ID indicado.
	 */
	public boolean modificarHistorialClinico() {
		String codigo = JOptionPane.showInputDialog(null, "Introduzca código del historial a modificar:",
				"Modificar historial", JOptionPane.QUESTION_MESSAGE);
		/*
		 * Ahora buscaremos el hisotrial en el ArrayList y si lo encontramos lo referenciaremos
		 * a otro objeto de la clase HistorialClinico que incialmente tiene valor null.
		 * Si tras finalizar la búsqueda, este objeto sigue valiendo null significa que no hemos
		 * encontrado el HistorialClinico que nos han pedido e informaremos al usuario.
		 */
		HistorialClinico historialclinico = null;
		for (int i = 0; i < historialesclinicos.size(); i++){
			if (historialesclinicos.get(i).getCodigo().equals(codigo)) {
				historialclinico = historialesclinicos.get(i);//Referenciamos a otro nombre de objeto
				break;//No hace falta seguir buscando, "rompemos" el bucle for
			}
		}
		
		if (historialclinico == null) {
			JOptionPane.showMessageDialog(null, "No se encuentra Hisotrial con el Codigo:\n" + codigo, 
					"Historial no encontrado", JOptionPane.WARNING_MESSAGE);
			return false;
		}
		else {
			//Comienza el proceso de modificacion
			historialclinico.setCodigo(JOptionPane.showInputDialog(null, "Código Actual: " + historialclinico.getCodigo()
				+ "\nIntroduzca nuevo identificador:", "Modificar Historial", JOptionPane.QUESTION_MESSAGE));
			historialclinico.setFecha(JOptionPane.showInputDialog(null, "Fecha actual: " + historialclinico.getFecha()
				+ "\nIntroduzca nueva fecha:", "Modificar Historial", JOptionPane.QUESTION_MESSAGE));
			historialclinico.setIdPaciente(JOptionPane.showInputDialog(null, "Id Paciente: " + historialclinico.getIdPaciente()
				+ "\nIntroduzca nuevo ID Paciente:", "Modificar Historial", JOptionPane.QUESTION_MESSAGE));
                        historialclinico.setIdMedico(JOptionPane.showInputDialog(null, "Id Medico: " + historialclinico.getIdMedico()
				+ "\nIntroduzca nuevo ID Medico:", "Modificar Historial", JOptionPane.QUESTION_MESSAGE));
			historialclinico.setObservaciones(JOptionPane.showInputDialog(null, "Observaciones: " + historialclinico.getObservaciones()
				+ "\nIntroduzca nueva observación:", "Modificar Historial", JOptionPane.QUESTION_MESSAGE));
		
			return true;
		}
	}
	
	/**
	 * Elimina el Historial indicado por el usuario mediante el CODIGO del historial.
	 * @return True si tuvo éxito la eliminacion.
	 * False si no se encontró el Paciente indicado.
	 */
	public boolean borrarHistorialClinico() {
		String codigo = JOptionPane.showInputDialog(null, "Introduzca Identificador del historial a borrar:",
				"Borrar Historial", JOptionPane.QUESTION_MESSAGE);
		
		HistorialClinico historialclinico = null;
		for (int i = 0; i < historialesclinicos.size(); i++){
			if (historialesclinicos.get(i).getCodigo().equals(codigo))
				historialclinico = historialesclinicos.remove(i);//Al eliminar el objeto, el ArrayList nos lo devuelve y lo recogemos en "paciente"
		}
		
		if (historialclinico == null) {
			JOptionPane.showMessageDialog(null, "No se encuentra hisotrial con el código:\n" + codigo, 
					"Historial no encontrado", JOptionPane.WARNING_MESSAGE);
			return false;
		}
		else {
			JOptionPane.showMessageDialog(null, "Se elimino al historial con código:\n" + codigo, 
					"Historial Eliminado", JOptionPane.INFORMATION_MESSAGE);
			return true;
		}
	}

}

