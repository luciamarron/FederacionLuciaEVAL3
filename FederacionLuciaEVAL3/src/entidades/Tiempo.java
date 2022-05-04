package entidades;

import java.time.temporal.ChronoUnit;

public class Tiempo implements Comparable <Tiempo>{
	private int horas;
	private int minutos;
	private int segundos;
	private int centesimas;
	private Prueba prueba;
	private Participante participante;

	public Tiempo() {

	}

	public Tiempo(int horas, int minutos, int segundos, int centesimas, Prueba prueba, Participante participante) {
		super();
		this.horas = horas;
		this.minutos = minutos;
		this.segundos = segundos;
		this.centesimas = centesimas;
		this.prueba = prueba;
		this.participante = participante;
	}

	public int getHoras() {
		return horas;
	}

	public void setHoras(int horas) {
		this.horas = horas;
	}

	public int getMinutos() {
		return minutos;
	}

	public void setMinutos(int minutos) {
		this.minutos = minutos;
	}

	public int getSegundos() {
		return segundos;
	}

	public void setSegundos(int segundos) {
		this.segundos = segundos;
	}

	public int getCentesimas() {
		return centesimas;
	}

	public void setCentesimas(int centesimas) {
		this.centesimas = centesimas;
	}

	public Prueba getPrueba() {
		return prueba;
	}

	public void setPrueba(Prueba prueba) {
		this.prueba = prueba;
	}

	public Participante getParticipante() {
		return participante;
	}

	public void setParticipante(Participante participante) {
		this.participante = participante;
	}

	@Override
	public String toString() {
		return "Tiempo:" + horas + ":" + minutos + ":" + segundos + "," + centesimas;

	}

	@Override
	public int compareTo(Tiempo o) {
		// TODO Auto-generated method stub
		return 0;
	}





}