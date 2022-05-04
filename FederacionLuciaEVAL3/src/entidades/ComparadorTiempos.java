package entidades;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.temporal.ChronoUnit;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;

import entidades.Metal;
import entidades.Patrocinador;
import entidades.Tiempo;
import utils.Datos;

public class ComparadorTiempos implements Comparator <Tiempo> {

	public int compare(Tiempo t1, Tiempo t2) {
		int ret = Integer.compare(t1.getHoras(),t2.getHoras());
		if(ret!=0) 
			return ret;
		else {
			ret = Integer.compare(t1.getMinutos(),t2.getMinutos());
			if(ret!=0)
				return ret;
			else {
				ret = Integer.compare(t1.getSegundos(),t2.getSegundos());
				if(ret!=0)
					return ret;
				else {
					ret = Integer.compare(t1.getCentesimas(),t2.getCentesimas());
				}
			}
			
		}
		
		return ret; 
	}

	
	public void recorrerTiempo() {
		
		System.out.println("Guardando en tiempos.dat");
		File f;
		FileOutputStream fis = null;
		ObjectOutputStream ois = null;

		try {

			f = new File("tiempos.dat");
			fis = new FileOutputStream(f);
			ois = new ObjectOutputStream(fis);
			
			for (int i = 0; i < 6; i++) {
				Tiempo t = (Tiempo) ois.readObject();
				System.out.println(t.toString());
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				if (ois != null)
					ois.close();
				if (fis != null)
					fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		LinkedList <Tiempo> ret = new LinkedList<Tiempo>();
		
		Collections.sort(ret, new ComparadorTiempos());
		System.out.println("La lista ordenada de todos los tiempos es:");
		Iterator<Tiempo> it = ret.iterator();
		int i = 1; // Marcador de posicion del tiempo (orden)
		while (it.hasNext()) {
			System.out.println(i + ": " + ((Tiempo)it.next()).toString() + " ");
			i++;
		}
	}

}