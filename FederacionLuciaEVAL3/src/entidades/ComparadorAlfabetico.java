package entidades;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;

import utils.Datos;

public class ComparadorAlfabetico implements Comparator<DatosPersona> {

	@Override
	public int compare(DatosPersona dp1, DatosPersona dp2) {

		return dp1.getNombre().compareToIgnoreCase(dp2.getNombre());
	}

	public void nombresOrdenados() {
		LinkedList<DatosPersona> ret = new LinkedList<DatosPersona>();
		
		for(DatosPersona dp: Datos.PERSONAS) {
			ret.add(dp);
		}
		Collections.sort(ret, new ComparadorAlfabetico());
		System.out.println("La lista ordenada alfabéticamente de todas los nombres es:");
		Iterator<DatosPersona> it = ret.iterator();
		

	}
}