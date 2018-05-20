package Ventanas;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.mysql.jdbc.Connection;

import javax.swing.JTextArea;

import Juego.ConnectDB;
import Juego.GamerDB;
import Juego.Jugador;
public class Login extends JFrame {
	private static final long serialVersionUID = 1L;
	private ImageIcon imagenDefect, imagenEscalada, imagenInfo, imagenSelect;
	private int indicadorimg;
	private JButton btnAlta, btnayuda, btnBaja, btnJugar, btnMedia;
	private JPanel contentPane;
	private JTextArea boxPantalla;
	private JTextField boxNombre, boxApellidos, boxDificultad, boxEdad, boxId, boxTiempo;
	private JLabel lblNombre, lblApellidos, lblDificultad, lblEdad, lblId, lblimagen, lblTiempo, lbltxtimagen;

	/*Referencia al objeto login, es una etiqueta de referencia a un objeto tipo Login*/
	private Login referencia=this;
	/*Permitira el acceso desde la ventana Login a la ventana Juego (game) pasandola como referencia*/
	private vPrincipal game;
	//Creamos objeto Jugador
	private Jugador player1;
	//Creamos objetos que manejaran la DB.
	private ConnectDB connect;
	private GamerDB gamerDB;
	private Connection connected;
	// Var Semaforo DB
	private boolean connecting=false;
	private Integer id_player=0; //Se que se ha insertado si es distinto de 0;
	private String notifyDB;
	/*****************************************************************************
	 *************************EC2*************************************************
	//Datos de la conexión
	private static String host="35.180.69.167:3306";
	private static String nameDB="Jugadores";
	private static String user="christian";
	private static String passwd="Usuario1+";
	******************************************************************************
	******************************************************************************/
	/*****************************************************************************
	 *************************Localhost*******************************************
	//Datos de la conexión
	private static String host="localhost";
	private static String nameDB="jugadores";
	private static String user="root";
	private static String passwd="";
    ********************************************************************************
	****************************RDS*************************************************/
	//Datos de la conexión
	private static String host="mydatabase.cb0hfkoy0cmf.eu-west-3.rds.amazonaws.com:3306";
	private static String nameDB="Gamers";
	private static String user="christian";
	private static String passwd="Usuario1+";
	/**********************************************************************************
	 **********************************************************************************/
	/**
	 *Inicio y Diseño de la aplicación
	 * 
	 */ 
	public Login(vPrincipal g){
		
		/*Titulo del juego*/
		
		setTitle("Mathdice - Login");
		
		//referencia se asocia al objeto creado que es tipo Login.
		referencia=this;
		
		//La etiqueta game se asocia a Login.Será Visible a toda la clase.
		game=g;
				
		/*------ETIQUETAS------*/
		
		//Parametros ventana principal
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 680, 560);
		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setBackground(new Color(119, 136, 153));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		//Etiqueta Nombre
		
		lblNombre = new JLabel("NOMBRE:");
		lblNombre.setForeground(new Color(255, 255, 255));
		lblNombre.setFont(new Font("Yu Gothic", Font.BOLD, 14));
		lblNombre.setBounds(10, 8, 76, 14);
		contentPane.add(lblNombre);
		
		//Etiqueta Apellidos
		
		lblApellidos = new JLabel("APELLIDOS:");
		lblApellidos.setForeground(new Color(255, 255, 255));
		lblApellidos.setFont(new Font("Yu Gothic", Font.BOLD, 14));
		lblApellidos.setBounds(10, 68, 96, 14);
		contentPane.add(lblApellidos);
		
		//Etiqueta Edad
		
		lblEdad = new JLabel("EDAD:");
		lblEdad.setForeground(new Color(255, 255, 255));
		lblEdad.setFont(new Font("Yu Gothic", Font.BOLD, 14));
		lblEdad.setBounds(10, 128, 46, 14);
		contentPane.add(lblEdad);
		
		//Etiqueta Dificultad
		
		lblDificultad = new JLabel("DIFICULTAD:");
		lblDificultad.setForeground(new Color(255, 255, 255));
		lblDificultad.setFont(new Font("Yu Gothic", Font.BOLD, 14));
		lblDificultad.setBounds(10, 188, 96, 14);
		contentPane.add(lblDificultad);
		
		//Etiqueta Tiempo
		
		lblTiempo = new JLabel("TIEMPO:");
		lblTiempo.setForeground(Color.WHITE);
		lblTiempo.setFont(new Font("Yu Gothic", Font.BOLD, 14));
		lblTiempo.setBounds(10, 259, 96, 14);
		contentPane.add(lblTiempo);
		
		//Etiqueta Imagen
		
		lblimagen = new JLabel("");
		lblimagen.setForeground(Color.WHITE);
		lblimagen.setBackground(Color.DARK_GRAY);
		lblimagen.setHorizontalAlignment(SwingConstants.CENTER);
		imagenDefect = new ImageIcon(getClass().getResource("img/avatar.png"));
		lblimagen.setBounds(496, 8, 161, 177);
		contentPane.add(lblimagen);
		//Proceso de escalado
		escalaImagen(imagenDefect);
		//Añade Imagen
		lblimagen.addMouseListener(new añadeImagen());
		
		//Etiqueta info para hacer click y añadir Imagen
		lbltxtimagen = new JLabel("Click imagen para a\u00F1adir");
		lbltxtimagen.setForeground(Color.ORANGE);
		lbltxtimagen.setFont(new Font("Yu Gothic", Font.BOLD, 12));
		lbltxtimagen.setBounds(496, 188, 161, 14);
		contentPane.add(lbltxtimagen);

		
		//Etiqueta Identificador del Jugador(Id)
		
		lblId = new JLabel("ID JUGADOR:");
		lblId.setForeground(Color.WHITE);
		lblId.setFont(new Font("Yu Gothic", Font.BOLD, 14));
		lblId.setBounds(496, 217, 96, 14);
		contentPane.add(lblId);

		/*------CAJAS------*/
		
		/*-----Caja Nombre---*/
		
		boxNombre = new JTextField();
		boxNombre.setFont(new Font("Yu Gothic", Font.BOLD, 12));
		boxNombre.setForeground(Color.WHITE);
		boxNombre.setBackground(Color.DARK_GRAY);
		boxNombre.setBounds(116, 8, 370, 20);
		contentPane.add(boxNombre);
		boxNombre.setColumns(10);


		//Pasamos al siguiente campo con el boton enter (Apellidos) e introducimos identificador.
		boxNombre.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				boxApellidos.requestFocusInWindow();
				if(boxApellidos.requestFocusInWindow()==true){
					boxId.setText(player1.getid());
				}
			}
		});
		
		//Cuando pulsemos en la caja nos aparecerá el identificador para informar al usuario.
		boxNombre.addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e){
				boxId.setText(player1.getid());
			}
		});
		
		/*-------Caja Apellidos	-----*/
		
		boxApellidos = new JTextField();
		boxApellidos.setFont(new Font("Yu Gothic", Font.BOLD, 12));
		boxApellidos.setForeground(Color.WHITE);
		boxApellidos.setBackground(Color.DARK_GRAY);
		boxApellidos.setColumns(10);
		boxApellidos.setBounds(116, 68, 370, 20);
		contentPane.add(boxApellidos);
		
		//Pasamos al siguiente campo con el boton enter (Edad) e introducimos identificador.
		boxApellidos.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				boxEdad.requestFocusInWindow();
				if(boxEdad.requestFocusInWindow()==true){
					boxId.setText(player1.getid());
				}
			}
		});
		
		//Cuando pulsemos en la caja nos aparecerá el identificador para informar al usuario.
		boxApellidos.addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e){
				boxId.setText(player1.getid());
			}
		});
			
		
		/*------Caja Edad-----*/
		
		boxEdad = new JTextField();
		boxEdad.setForeground(Color.WHITE);
		boxEdad.setFont(new Font("Yu Gothic", Font.BOLD, 12));
		boxEdad.setBackground(Color.DARK_GRAY);
		boxEdad.setColumns(10);
		boxEdad.setBounds(116, 128, 370, 20);
		contentPane.add(boxEdad);
		
		//Cuando pulsemos en la caja nos aparecerá el identificador para informar al usuario.
		boxEdad.addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e){
				boxId.setText(player1.getid());
			}
		});
		
		/*------Caja Dificultad----*/
		
		boxDificultad = new JTextField();
		boxDificultad.setEnabled(false);
		boxDificultad.setForeground(Color.WHITE);
		boxDificultad.setFont(new Font("Yu Gothic", Font.BOLD, 12));
		boxDificultad.setBackground(Color.DARK_GRAY);
		boxDificultad.setColumns(10);
		boxDificultad.setBounds(116, 214, 370, 20);
		contentPane.add(boxDificultad);
		boxDificultad.setText("Dificultad Media");
		
		/*----Caja Imprime Pantalla----*/
		
		boxPantalla = new JTextArea();
		boxPantalla.setLineWrap(true);
		boxPantalla.setBackground(Color.DARK_GRAY);
		boxPantalla.setForeground(Color.WHITE);
		boxPantalla.setFont(new Font("Yu Gothic", Font.BOLD, 14));
		boxPantalla.setEnabled(false);
		boxPantalla.setText("BIENVENIDO AL JUEGO MATHDICE!");
		boxPantalla.setBounds(10, 295, 482, 215);
		contentPane.add(boxPantalla);
				
		/*-----Caja Puntos----*/
		
		boxTiempo = new JTextField();
		boxTiempo.setText("00:04:00");
		boxTiempo.setForeground(Color.WHITE);
		boxTiempo.setFont(new Font("Yu Gothic", Font.BOLD, 16));
		boxTiempo.setHorizontalAlignment(SwingConstants.CENTER);
		boxTiempo.setEnabled(false);
		boxTiempo.setColumns(10);
		boxTiempo.setBackground(Color.DARK_GRAY);
		boxTiempo.setBounds(116, 245, 116, 39);
		contentPane.add(boxTiempo);
		
		/*-------Caja Identificador Jugador (Id)-----*/
		
		boxId = new JTextField();
		boxId.setHorizontalAlignment(SwingConstants.CENTER);
		boxId.setForeground(Color.WHITE);
		boxId.setFont(new Font("Yu Gothic", Font.BOLD, 16));
		boxId.setEnabled(false);
		boxId.setColumns(10);
		boxId.setBackground(Color.DARK_GRAY);
		boxId.setBounds(496, 241, 161, 50);
		contentPane.add(boxId);
		
		addPlayer(player1);
		/*------BOTONES------*/
		//Boton Jugar
		
		//Propiedades
		
		btnJugar = new JButton("JUGUEMOS!");
		btnJugar.setForeground(Color.WHITE);
		btnJugar.setBackground(new Color(0, 128, 128));
		btnJugar.setFont(new Font("Yu Gothic", Font.BOLD, 14));
		btnJugar.setBounds(496, 385, 161, 57);
		contentPane.add(btnJugar);
		
		//Acciones del boton

		btnJugar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				/*-----Asigna Nombre----*/
				
				String name = boxNombre.getText();
				player1.setNombre(name);
				
				/*-----Asigna Apellidos----*/
				
				String surname = boxApellidos.getText();
				player1.setApellidos(surname);
				
				/*-----Asigna la edad-----*/
				
				String age = boxEdad.getText();
					player1.setEDAD(age);

				/*-----Asigna la dificultad-----*/
				
				//En funcion de la dificultad saca una puntuación o otra.
				
					player1.setDificultad(boxDificultad.getText());
			    	if(player1.getDificultad()=="Dificultad Baja"){
			    		player1.setMin(Jugador.tbajo[0]);
			    		player1.setSeg(Jugador.tbajo[1]);
			    	}else if(player1.getDificultad()=="Dificultad Media"){
			    		player1.setMin(Jugador.tmedio[0]);
			    		player1.setSeg(Jugador.tmedio[1]);
			    	}else if(player1.getDificultad()=="Dificultad Alta"){
			    		player1.setMin(Jugador.talto[0]);
			    		player1.setSeg(Jugador.talto[1]);
			    	}
			    	
			    //Informa de todo lo que "falte y este completado" (unicamente si falta alguna caja sin completar).	
			    	
				boxPantalla.setText("Saludos!\n"+player1.getNombre()+" "+player1.getApellidos()+"\nCampo Edad: "+player1.getEDAD()+"\nHas elegido: "+player1.getDificultad()+" con lo que tendras "+player1.getMin()+" minutos");
				
				//Cargamos datos del Jugador player1
				game.setJugador(player1);
				
				//Informa de que TODAS las cajas han sido completadas
				
					String[] check = {boxNombre.getText(),boxApellidos.getText(),boxEdad.getText(),boxDificultad.getText()};
					
					if((check[0].length()!=0)&&(check[1].length()!=0)&&(check[2].length()!=0)&&(check[3].length()!=0)){
					//Hacemos invisible la ventana Login y hacemos que aparezca la ventana Juego
					//referencia.setVisible(false);
					
					try{
						notifyDB=addPlayer(player1);
					}catch(Exception e){
						System.out.println("Problemas con la conexión DB...");
					}	
					referencia.dispose();
					game.setVisible(true);
					}	
					
			}
		});
		//Boton Ayuda
		
		//propiedades
		
		btnayuda = new JButton("AYUDA");
		btnayuda.setForeground(Color.WHITE);
		btnayuda.setBackground(new Color(255, 0, 0));
		btnayuda.setFont(new Font("Yu Gothic", Font.BOLD, 14));
		btnayuda.setBounds(496, 453, 161, 57);
		contentPane.add(btnayuda);
		
		//Acciones del boton
		
		btnayuda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boxPantalla.setText("\nDebe introducir un nombre, uno o dos apellidos, edad y elegir\ndificultad. "
						+ " Todo ello en sus casillas correspondientes.\n*En el campo dificultad se le asignara por defecto dificultad media,"
						+ "\npuede cambiarlo con los botones.\n*La imagen puede ser cambiada pulsando sobre ella."
						+ "\n**Si todo esta completado correctamente aparecerá en la ventana\nJuego de lo contrario deberá revisar las indicaciones.");
			}
		});
		
		/*----Boton Dificultad Baja----*/
		
		//propiedades
		
		btnBaja = new JButton("Baja");
		btnBaja.setBackground(Color.DARK_GRAY);
		btnBaja.setForeground(Color.GREEN);
		btnBaja.setBounds(116, 185, 89, 23);
		contentPane.add(btnBaja);
		
		//Acciones del boton
		
		btnBaja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				player1.setDificultad(Jugador.bajo);
				boxDificultad.setText(player1.getDificultad());
				player1.setMin(Jugador.tbajo[0]);//7 Minutos
				player1.setSeg(Jugador.tbajo[1]);//0 Segundos
			    //Informa de la cantidad de puntos en la pantalla para puntos.
				boxTiempo.setText("00:"+"0"+player1.getMin()+":"+"0"+player1.getSeg());
				boxId.setText(player1.getid());
			}
		});

		
		/*------Boton Dificultad Media-----*/
		
		//propiedades
		
		btnMedia = new JButton("Media");
		btnMedia.setBackground(Color.DARK_GRAY);
		btnMedia.setForeground(Color.ORANGE);
		btnMedia.setBounds(258, 185, 89, 23);
		contentPane.add(btnMedia);
		
		//Acciones del boton
		
		btnMedia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				player1.setDificultad(Jugador.medio);
				boxDificultad.setText(player1.getDificultad());
				player1.setMin(Jugador.tmedio[0]);//4 Minutos
				player1.setSeg(Jugador.tmedio[1]);//0 Segundos
			    //Informa de la cantidad de puntos en la pantalla para puntos.
				boxTiempo.setText("00:"+"0"+player1.getMin()+":"+"0"+player1.getSeg());
				boxId.setText(player1.getid());
			}
		});

		/*-----Boton Dificultad Alta----*/
		
		//propiedades
		
		btnAlta = new JButton("Alta");
		btnAlta.setBackground(Color.DARK_GRAY);
		btnAlta.setForeground(Color.RED);
		btnAlta.setBounds(398, 185, 89, 23);
		contentPane.add(btnAlta);
		
		//Acciones del boton
		
		btnAlta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				player1.setDificultad(Jugador.alto);
				boxDificultad.setText(player1.getDificultad());
				player1.setMin(Jugador.talto[0]);//1 Minuto
				player1.setSeg(Jugador.talto[1]);//0 Segundos
			    //Informa de la cantidad de puntos en la pantalla para puntos.
				boxTiempo.setText("00:"+"0"+player1.getMin()+":"+"0"+player1.getSeg());
				boxId.setText(player1.getid());
			}
		});
	
		/*---JUGADOR----*/
		
		player1 = new Jugador();
		player1.setNombre("Christian");
		player1.setApellidos("Molina");
		player1.setEdad(24);
		player1.setDificultad("Dificultad Media");
		player1.setMin(4);
		player1.setSeg(0);
		player1.setid("JPlayer2018");
		player1.setPuntos(0);
		player1.setImagenEscalado(imagenDefect);
		
	}
		/*-----METODOS-----*/
	
	private String addPlayer(Jugador j){
			connect=new ConnectDB(host, nameDB, user, passwd);//Creo un objeto de la Conexión. Conexión con la base de datos.
			/*Establecemos conexion*/
			connecting=connect.connectDB();
			/*Getter en la conexión una vez ha sido esblecida*/
			connected=connect.getConnection();
			/*Pasamos la conexión  a un objeto nuevo "gamersDB" para insertar datos.*/
			gamerDB=new GamerDB(j);//Encargada de pasar lo datos a la DB.
			id_player = gamerDB.addUser(connected);
			if (connecting==true){
				notifyDB="Conexión establecida...";
				if(id_player==0){
				notifyDB="Error en la actualización de la BBDD...";
				}else{
				notifyDB="Conexión Satisfactoria";
				}
			}else{
				notifyDB="Error en la conexión BBDD";
			}
			return notifyDB;
	}
	
	
	/*Metodo para escalar una imagen*/
	private void escalaImagen(ImageIcon img){
		if(img.getIconHeight() > 161 || img.getIconWidth() > 177){ // Si la imagen es mayor de las dimensiones del Jlabel la escalaremos
            imagenEscalada = new ImageIcon(img.getImage().getScaledInstance(161, 177, 100));//escalamos arreglo al Jlabel de la imagen(ancho,largo,pulgadas). 
            lblimagen.setIcon(imagenEscalada); //introducimos la imagen escalada
        }else{
        	lblimagen.setIcon(img);
        }
	}
	
	/*Metodo para introducir una imagen en el Juego*/
	private class añadeImagen implements MouseListener{

		@Override//Palabra reservada que avisamos al compilador que hemos modificado un metodo conforme a mis necesidades
		public void mouseClicked(MouseEvent e) {//Cuando pulsemos click pasará lo siguiente:
					indicadorimg=1;//Valdrá 1 con el proposito de que la imagen que se introduzca quede bloqueada.
				 	JFileChooser fichero = new JFileChooser(); //Damo la opción de elección de un archivo
				 	FileNameExtensionFilter filtro = new FileNameExtensionFilter(".jpg, .gif, .png", "jpg","gif","png"); //imponemos las extensiones validas
			        fichero.setFileFilter(filtro);  //filtramos en los directorios que eliga el usuario la extensión
			        int resultado = fichero.showOpenDialog(lblimagen); //guardamos la imagen seleccionada en una variable para pasar por la condición. Aparece un cuadro de diálogo del selector de archivos "Abrir archivo".
			        if (resultado == JFileChooser.APPROVE_OPTION){//si hacemos click en aceptar entonces: aceptar == ok los mismo 1==1 => devolverá true
			            imagenSelect = new ImageIcon(fichero.getSelectedFile().getPath()); // la introducimos en la variable image de tipo ImageIcon
			            //escalaImagen(imagenSelect);//escalamos imagen si supera el tamaño del Jlabel
			            player1.setImagenEscalado(imagenSelect);
			        }else{
			        	indicadorimg=0;// si cancelamos la acción entonces el indicador será 0 y al cumplir la condición mouseExited se quedará la img por defecto.
			        }
		}
		
		/*------METODOS ASOCIADOS A LA CLASE MOUSELISTENER (deberá tener todos los metodos)-----*/
		
		/*Metodo cuando el mouse este dentro del Jlabel.*/
		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
			imagenInfo = new ImageIcon(getClass().getResource("img/avatarinfo.png"));	
			lblimagen.setIcon(imagenInfo);
			escalaImagen(imagenInfo);
		}
		/*Metodo cuando el mouse este fuera del Jlabel.*/
		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
			if(indicadorimg==0){//Si no hemos seleccionado o click en la imagen el indicador será 0 con lo que mantendremos la imagen por defecto.
				lblimagen.setIcon(imagenDefect);
				escalaImagen(imagenDefect);
			}else{//Si hemos hecho click y seleccionado una imagen se mantedrá la imagen seleccionada.
				lblimagen.setIcon(imagenSelect);
				escalaImagen(imagenSelect);
			}
		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
	}
}
