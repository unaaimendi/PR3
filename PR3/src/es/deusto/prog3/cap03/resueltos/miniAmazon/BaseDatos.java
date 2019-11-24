package es.deusto.prog3.cap03.resueltos.miniAmazon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseDatos {
	
	private static Connection conexion;
	
	public static void abrirConexion( String nombreBD ) {
		try {
			System.out.println("Conexion Abierta");
			Class.forName("org.sqlite.JDBC");
			conexion = DriverManager.getConnection("jdbc:sqlite:" + nombreBD);
		} catch (ClassNotFoundException |SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	
		}
	}
	public static void cerrarConexion() {
	try {
		if(conexion !=null) conexion.close();
		System.out.println("Cierre de base de datos");
		
	}catch(SQLException e) {
		System.out.println("Error en cierre de base de datos");
	
		e.printStackTrace();
	}
	}
}
