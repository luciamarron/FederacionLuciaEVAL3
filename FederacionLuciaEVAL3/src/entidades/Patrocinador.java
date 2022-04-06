package entidades;

import java.time.LocalTime;
import java.util.ArrayList;

public class Patrocinador implements Comparable<Patrocinador> {
	private long idPatrocinador;
	private String nombre;
	private String web;
	private double dotacion;

	private Responsable responsable;

	public Patrocinador(long idPatrocinador, String nombre, double dotacion, String web, Responsable r) {
		super();
		this.idPatrocinador = idPatrocinador;
		this.nombre = nombre;
		this.web = web;
		this.dotacion = dotacion;
		this.responsable = r;
	}



	public Patrocinador(long idPatrocinador, String nombre, double dotacion, String web) {
		super();
		this.idPatrocinador = idPatrocinador;
		this.nombre = nombre;
		this.web = web;
		this.dotacion = dotacion;
	}



	public long getIdPatrocinador() {
		return idPatrocinador;
	}

	public void setIdPatrocinador(long idPatrocinador) {
		this.idPatrocinador = idPatrocinador;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getWeb() {
		return web;
	}

	public void setWeb(String web) {
		this.web = web;
	}

	public double getDotacion() {
		return dotacion;
	}

	public void setDotacion(double dotacion) {
		this.dotacion = dotacion;
	}
	

	public Responsable getResponsable() {
		return responsable;
	}

	public void setResponsable(Responsable responsable) {
		this.responsable = responsable;
	}

	// Ejercicio 5 Examen 10
	@Override
	public int compareTo(Patrocinador p) {
		int compararDotacion = (int) (this.getDotacion() - (p.getDotacion()));
		int franja1 = this.getResponsable().getHorarioIni().compareTo(this.getResponsable().getHorarioFin());
		int franja2 = p.getResponsable().getHorarioIni().compareTo(p.getResponsable().getHorarioFin());
		int compararFranjas = franja1 - franja2;
		int compararId = (int) (this.getIdPatrocinador() - p.getIdPatrocinador());
		if (compararDotacion == 0) {

			return compararFranjas;
		} else {
			if (compararFranjas == 0) {
				return compararId;
			}
			return compararDotacion;
		}

	}

	// Ejercicio 8 Examen 10
	public String data() {
		return "" + this.getIdPatrocinador() + "|" + responsable.getIdResponsable() + "|" + this.getNombre() + "|"
				+ this.getDotacion() + "|" + this.getWeb();
	}

}
