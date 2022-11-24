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
public class Cita {
	
	private String id;
	private String fecha;
	private String hora;
	private String motivo;
	private Medico medico;
	private Paciente paciente;
	
	public Cita(String id, String fecha, String hora, String motivo,
			Medico medico, Paciente paciente) {
		this.id = id;
		this.fecha = fecha;
		this.hora = hora;
		this.motivo = motivo;
		this.medico = medico;
		this.paciente = paciente;
	}
	
	public Cita(String id, String fecha, String hora, String motivo) {
		this.id = id;
		this.fecha = fecha;
		this.hora = hora;
		this.motivo = motivo;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
        public void mostrar() {
		String mensaje = "ID Cita: " + id + "\nFecha: " + fecha
				+ "\nHora: " + hora + "\nMotivo: " + motivo
                        + "\nMedico: " + medico + "\nPaciente: " + paciente;
		JOptionPane.showMessageDialog(null, mensaje, "Mostrar Cita", JOptionPane.INFORMATION_MESSAGE);
	}
	
}
