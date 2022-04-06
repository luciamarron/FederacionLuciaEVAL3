package Principal;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import entidades.Patrocinador;
import entidades.Responsable;
import utils.Datos;

public class PrincipalExam10<T> {

	public static void main(String[] args) {

		// Ejercicio 8 Examen 10
		List<Patrocinador> patrocinador = new LinkedList<Patrocinador>();

		Responsable r1 = new Responsable(1, "902422202", LocalTime.of(00, 00), LocalTime.of(23, 59),
				Datos.buscarPersonaPorId(1011));
		Patrocinador p1 = new Patrocinador(1, "ALSA", 500.00, "www.alsa.es", r1);
		patrocinador.add(p1);

		Responsable r2 = new Responsable(2, "985181105", LocalTime.of(9, 00), LocalTime.of(18, 00),
				Datos.buscarPersonaPorId(1012));
		Patrocinador p2 = new Patrocinador(2, "Ayto.Gijon", 250.00, "www.gijon.es", r2);
		patrocinador.add(p2);

		Responsable r3 = new Responsable(3, "985103000", LocalTime.of(8, 30), LocalTime.of(20, 00),
				Datos.buscarPersonaPorId(1012));
		Patrocinador p3 = new Patrocinador(3, "Universidad de Oviedo", 350.00, "www.uniovi.es", r3);
		patrocinador.add(p3);

		Responsable r4 = new Responsable(4, "985185503", LocalTime.of(8, 30), LocalTime.of(18, 00),
				Datos.buscarPersonaPorId(1012));
		Patrocinador p4 = new Patrocinador(4, "CIFP la Laboral", 255.99, "www.cifplalaboral.es", r3);
		patrocinador.add(p4);

	}

	// Ejercicio 9 Examen 10
	public boolean insertarSinID(T elemento) {
		return false;
	}

	public boolean insertarConID(T elemento) {
		return false;
	}


//Ejercicio 6 Examen 10
	public static void exportarPatrocinador(Patrocinador[] patrocinadores) {
		String path = "patrocinadores.dat";
		try {
			File fichero = new File(path);
			FileOutputStream fos = new FileOutputStream(path, false);
			ObjectOutputStream escritor = new ObjectOutputStream(fos);
			for (Patrocinador p : patrocinadores) {
				escritor.writeObject(p.data());
				escritor.flush();
			}
			escritor.close();
		} catch (FileNotFoundException e) {
			System.out.println("Se ha producido una FileNotFoundException" + e.getMessage());
		} catch (IOException e) {
			System.out.println("Se ha producido una IOException" + e.getMessage());
		} catch (Exception e) {
			System.out.println("Se ha producido una Exception" + e.getMessage());
		}
	}
}
