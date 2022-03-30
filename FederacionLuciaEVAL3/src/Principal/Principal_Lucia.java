package Principal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import entidades.DatosPersona;
import entidades.Lugar;
import utils.ConexBD;
import utils.Datos;

public class Principal_Lucia {

	public static void main(String[] args) {
		System.out.println("INICIO");
		Connection conex = null;
		Statement consulta = null;
		ResultSet resultado = null;
		try {

			conex = ConexBD.establecerConexion();
			String consultaStr = "SELECT * FROM personas";
			if (conex == null)
				conex = ConexBD.getCon();
			consulta = conex.createStatement();
			resultado = consulta.executeQuery(consultaStr);
			while (resultado.next()) {
				int id = resultado.getInt(1);
				String nombre = resultado.getString(2);
				String telefono = resultado.getString(3);
				String nifnie = resultado.getString(4);
			}
		} catch (SQLException e) {
			System.out.println("Se ha producido una Excepcion:" + e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				System.out.println("Cerrando recursos...");
				if (resultado != null)
					resultado.close();
				if (consulta != null)
					consulta.close();
				if (conex != null)
					conex.close();
			} catch (SQLException e) {
				System.out.println("Se ha producido una Excepcion:" + e.getMessage());
				e.printStackTrace();
			}
		}
		System.out.println("FIN");
	}

}
