package entidades;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;

public class Responsable {
	private long idResponsable;
	private String telefonoProf;
	private LocalTime horarioIni;
	private LocalTime horarioFin;
	
	private DatosPersona persona;
	
	public Responsable(long idResponsable, String telefonoProf, LocalTime horarioIni, LocalTime horarioFin, DatosPersona dp) {
		super();
		this.idResponsable = idResponsable;
		this.telefonoProf = telefonoProf;
		this.horarioIni = horarioIni;
		this.horarioFin = horarioFin;
		this.persona = dp;
	}

	public long getIdResponsable() {
		return idResponsable;
	}



	public void setIdResponsable(long idResponsable) {
		this.idResponsable = idResponsable;
	}



	public String getTelefonoProf() {
		return telefonoProf;
	}



	public void setTelefonoProf(String telefonoProf) {
		this.telefonoProf = telefonoProf;
	}



	public LocalTime getHorarioIni() {
		return horarioIni;
	}



	public void setHorarioIni(LocalTime horarioIni) {
		this.horarioIni = horarioIni;
	}



	public LocalTime getHorarioFin() {
		return horarioFin;
	}



	public void setHorarioFin(LocalTime horarioFin) {
		this.horarioFin = horarioFin;
	}



	//Ejercicio 4 Examen 10
	public String data() {
		return "" + this.getIdResponsable() + "|" + persona.getId() + "|" + this.getTelefonoProf() + "|"
				+ this.getHorarioIni().format(DateTimeFormatter.ofPattern("HH:mm")) + "|"+ this.getHorarioFin().format(DateTimeFormatter.ofPattern("HH:mm"));
	}
	
	//Ejercicio 7 Examen 10
	//solo está la estructura del fichero de texto porque no me dio tiempo a seguir con el
	//resto del ejercicio
	public static void importarResponsables() {
		System.out.println("Cargando de responsables.txt...");
		File f = new File("responsables.txt");
		FileReader fr = null;
		BufferedReader br = null;

		try {
			fr = new FileReader(f);
			br = new BufferedReader(fr);
			String s;

			for (int i = 0; i < 6; i++) {
				s = (String) br.readLine();
				System.out.println(s);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
				if (fr != null)
					fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
}
