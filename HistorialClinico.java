/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.evidencia_final;

import javax.swing.JOptionPane;

/**
 *
 * @author jorgejarajuarez
 */
public class HistorialClinico {
    private String codigo;
	private String fecha;
	private String idPaciente;
	private String idMedico;
	private String observaciones;
	
	public HistorialClinico(String codigo, String fecha, String idPaciente, 
			String idMedico, String observaciones) {
		this.codigo = codigo;
		this.fecha = fecha;
		this.idPaciente = idPaciente;
		this.idMedico = idMedico;
		this.observaciones = observaciones;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getIdPaciente() {
		return idPaciente;
	}

	public void setIdPaciente(String idPaciente) {
		this.idPaciente = idPaciente;
	}

	public String getIdMedico() {
		return idMedico;
	}

	public void setIdMedico(String idMedico) {
		this.idMedico = idMedico;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	
	/**
	 * Muestra por panel todos los datos del Historial Clinico
	 */
	public void mostrar() {
		String mensaje = "Codigo Historial: " + codigo + "\nFecha: " + fecha
				+ "\nID Paciente: " + idPaciente + "\nID Medico: " + idMedico
				+ "\nObservaciones:\n" + observaciones;
		JOptionPane.showMessageDialog(null, mensaje, "Mostrar Medico", JOptionPane.INFORMATION_MESSAGE);
	}
}

