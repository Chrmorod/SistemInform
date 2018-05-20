package Juego;

import java.sql.SQLException;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class GamerDB {

private Jugador player1;
	
/*--Conexion a la base de datos--*/
private static Connection connectionDB;

/*--Statement sirve para ejecutar una orden en la base de datos--*/
private Statement order = null;

private int id=0;/*Se utiliza en la ventana Login para saber si ha habido algun error, en caso de que sea 0 nos adevertirá de un
error en la BBDD*/

/*--Constructor--*/
public GamerDB (Jugador j){
	this.player1=j;
}

/*--Metodo para incorporar un Jugador/Usuario en la DB--*/

public int addUser(Connection c){
	try{
		order = (Statement) c.createStatement();//Será un objeto clase Statement la cual mandare un sentencia a la DB.
		//SENTENCIA SQL ---JUGADOR (TABLA DE MI BD JUGADORES--- NOMBRE, APELLIDOS, EDAD SON MIS CAMPOS.
		/*******************************************************************************************
		 * *********************************EC2 y localhost(jugador) minusculas*********************
		 * String sqlStat = "INSERT INTO `Jugador` (`NOMBRE`, `APELLIDOS`, `EDAD`) " + 
		   "VALUES('"+player1.getNombre()+"','"+player1.getApellidos()+"',"+player1.getEdad()+")";
		 * *****************************************************************************************
		 * ***********Para RDS*********************`Gamer`******************************************/
		String sqlStat = "INSERT INTO `Gamer` (`NOMBRE`, `APELLIDOS`, `EDAD`) " + 
		"VALUES('"+player1.getNombre()+"','"+player1.getApellidos()+"',"+player1.getEdad()+")";
		
		order.executeUpdate(sqlStat);//Ejecuta una orden SQL en una BBDD siempre que sea un INSERT, UPDATE O DELETE.
	}catch(SQLException e){
		e.printStackTrace();
		
	}catch(Exception e){
		e.printStackTrace();
	}finally{//Cerrar la conexión a la DB. Para evitar poner en peligro la integridad y la seguridad de la base de datos.
		try{
			if(order!=null){
				order.close();//Cerramos la orden.
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		try{
			if(connectionDB!=null){
				connectionDB.close();
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	return id;
}

}
