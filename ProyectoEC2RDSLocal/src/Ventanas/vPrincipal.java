package Ventanas;

import java.awt.CardLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import Juego.Jugador;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class vPrincipal extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private boolean datosNuevos=false;// Indicamos que los datos no han sido cambiados
	private final JMenuBar menuBar = new JMenuBar();//Creamos el Menu
	private final JMenu mnVentanas = new JMenu("Ventanas");//Le asignamos un nombre "Ventanas"
	private final JMenuItem mntmPerfil = new JMenuItem("Perfil");//Introdicimos pestaña "Perfil"
	private final JMenuItem mntmJuego = new JMenuItem("Juego");//Introducimos pestaña "Juego"
	//Clase donde almacena Jugador
	private Jugador player1;
	//Damos nombres -- Identificadores
	final static String vGame = "Ventana 1";
	final static String vProfile = "Ventana 2";
	//Clases donde se almacenan ventana Juego y ventana Perfil
	Juego vJuego=new Juego();
	Profile vPerfil=new Profile();
	/**
	 *Inicio y Diseño de la aplicación
	 * 
	 */ 
	public vPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 967, 755);
		setJMenuBar(menuBar);
		
		menuBar.add(mnVentanas);//Menu Ventanas.
		mntmPerfil.addActionListener(new ActionListener() {//Cuando hagamos click en la Pestaña Perfil nos mostrará la Ventana Perfil.
			public void actionPerformed(ActionEvent arg0) {
				CardLayout cl = (CardLayout)(contentPane.getLayout());
			    cl.show(contentPane, vProfile);
			}
		});
		mnVentanas.add(mntmPerfil);

		mntmJuego.addActionListener(new ActionListener() {//Cuando hagamos click en la Pestaña Juego nos mostrará la Ventana Juego.
			public void actionPerformed(ActionEvent e) {
				 CardLayout cl = (CardLayout)(contentPane.getLayout());
				 cl.show(contentPane, vGame);
				 
				datosNuevos= vPerfil.actJugador();//Asignamos datos del Perfil "si" los hemos modificado.
				 if (datosNuevos){
					 player1=vPerfil.getJugador();
				 }
				 vJuego.setJugador(player1);//Cargamos datos nuevos del Perfil.
			}
		});
		mnVentanas.add(mntmJuego);
		
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new CardLayout(0, 0));
		setContentPane(contentPane);
		
		//Añadimos las ventanas al contenedor contentPane
		contentPane.add(vJuego,vGame);//Ventana para JPanel Juego
		contentPane.add(vPerfil,vProfile);//Ventana para JPanel Perfil
		
	}

	public void setJugador(Jugador player1) {
		this.player1=player1;
		vJuego.setJugador(player1);//{Datos precargados de la ventana Login || Datos Modificados de la ventana Perfil} que son trasmitidos a ventana Juego
		vPerfil.setJugador(player1);//Datos cargados de la ventana Login en la ventana Perfil.
		
	}

}
