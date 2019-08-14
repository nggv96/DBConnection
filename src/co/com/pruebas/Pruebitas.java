package co.com.pruebas;

import static co.com.pruebas.Utils.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;


public class Pruebitas {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
		
		Properties p = readPropertiesFile("querys.properties");
		
		String res = makeQuery(getConnection(p.getProperty("DRIVER"), p.getProperty("URL"), p.getProperty("USERNAME"), p.getProperty("PASSWORD")), 
				editQuery(p.getProperty("QUERYUNO"), "%%", "Usuarios"));
		
		System.out.println(res);
	}
}

