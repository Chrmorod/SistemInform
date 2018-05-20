package Juego;

import java.sql.DriverManager;
import java.sql.SQLException;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class ConnectDB {
	
	/*---DATOS DE LA CONEXION---*/
	
	/*Creamos una constante donde almacenamos todos los drivers que estan en mi jdbc
	 *(es la API Java Database conectivity) donde estan todos lo metodos de Java para conectarme.
	 */
	private static final String DRIVER_MYSQL="com.mysql.jdbc.Driver";
	
	/*---DATOS DE LA BBDD---*/
	
	/*Donde creamos las variables que almacenen nuestro host/locahost, nombre de la bbdd, usuario,
	 * contraseña y url (explicado en la variable).
	 */
	/*********************************************
	 *****************LocalHost_EC2_RDS***********/ 
	 private String host;
	 private String n_bbdd;
	 private String user;
	 private String passwd;
	 /*******************************************
	*********************************************/
	
	/*Proporcionará el metodo de lo conectores de la base de datos el string necesario
	para saber a que host se tiene que conectar de forma adecuada (si nos fijamos son todo String)*/ 
	private String url;
	
	/*----CONEXION A LA BBDD---*/
	private Connection connection = null; //Maneja la conexión de la BBDD, es necesario importar de la libreria
	
	/*--CONSTRUCTOR DONDE INTRODUCIMOS DATOS NECESARIOS PARA CONECTAR CON LA BBDD--*/
	
	public ConnectDB(String host, String n_bbdd, String user, String passwd){
		this.host=host; this.n_bbdd=n_bbdd; this.user=user; this.passwd=passwd;
		this.url="jdbc:mysql://"+this.host+"/"+this.n_bbdd;
	}
	
	/*--METODO PARA CONECTARSE A LA BASE DE DATOS--*/
	/*
	 * 1- Cargamos el controlador.
	 * 2- Conectamos con la BBDD.
	 * 3- Exceptions sino encuentra tanto la DB como los drivers.
	 * 4- Devolver la instancia de la conexión.
	 */
	public boolean connectDB(){
		try{
			//Cargamos el controlador MySQL el cual automáticamente se registra.
			Class.forName(DRIVER_MYSQL);
			//Conectamos a la DB.
			connection = (Connection) DriverManager.getConnection(this.url, this.user, this.passwd);
		}catch(SQLException exceptionSQL){ //No encuentra la DB.
			exceptionSQL.printStackTrace();
			return false;
		}catch(ClassNotFoundException noFoundClass){ //No encuentra el driver para conectar.
			noFoundClass.printStackTrace();
			return false;
		}
		return true;		
	}
	
	//Nos devuelve la instancia mediante un Getter para manejar esta conexión.
	public Connection getConnection(){
		return this.connection;
	}
}
