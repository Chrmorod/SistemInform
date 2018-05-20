package Principal;
import Ventanas.Login;
import Ventanas.vPrincipal;


public class Principal {

	public static void main(String[] args) {
		/*------Ventanas a utilizar----*/
		//Ventana del juego
		//Juego game=new Juego();
		vPrincipal game = new vPrincipal();
		//Generamos la ventana de Login
		Login login=new Login(game);
		login.setVisible(true);
	}

}
