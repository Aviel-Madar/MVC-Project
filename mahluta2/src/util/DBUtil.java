package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	
	private static Connection connection ;
	public static final String URL = "jdbc:postgresql://stampy.db.elephantsql.com:5432/ehojrwqz";
    public	static final String USERNAME = "ehojrwqz";
	public	static final String PASSWORD = "RZ8RYHu_ntU6h5456E-7GnhSlKBkv4dc";
	 
	public static Connection getConnection() {
		if (connection !=null)
			return connection;
		
	 
	
	try {
		Class.forName ("org.postgresql.Driver");
		connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
		
	}
	catch (ClassNotFoundException|SQLException e){
		System.out.println(e.getMessage());
	}
	return connection;
	}
	
	
}