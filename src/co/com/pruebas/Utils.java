package co.com.pruebas;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class Utils {
	
	public static Properties readPropertiesFile(String fileName) throws FileNotFoundException, IOException {
		
		Properties p = new Properties();
		p.load(new FileReader(fileName));
		
		return p;
		
	}

	public static String editQuery(String query, String oldData, String newData ) {

		return query.replace(oldData, newData);
		
	}
	
	public static Connection getConnection(String driver, String url, String user, String pass) throws SQLException, ClassNotFoundException {
		
		Connection conexion = null;
		
		try {
			
			Class.forName(driver);
			conexion = DriverManager.getConnection(url, user, pass);
			System.out.println("Conexion exitosa!!");
		
		}catch(Exception e) {
			System.out.println(e);
		}
		return conexion;
	}
	
	public static String makeQuery(Connection conexion, String query) throws SQLException {
		
		PreparedStatement ps = null;
		ResultSet res = null;
		String resFinal = null;
		
		try {
			
			ps = conexion.prepareStatement(query);
			res = ps.executeQuery();
			
			while(res.next()) {
					
				if(res.getString(2).equalsIgnoreCase("Nicolas")) {
					resFinal = res.getString(4);
				}
			}
			
		}catch(Exception e) {
			System.out.println(e);
		}
		return resFinal;
		
		
	}
}