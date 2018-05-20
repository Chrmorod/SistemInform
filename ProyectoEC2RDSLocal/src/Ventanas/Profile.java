package Ventanas;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;
import Juego.Jugador;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;

public class Profile extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField boxNombre;
	private JTextField boxApellidos;
	private JTextField boxEdad;
	private JTextField boxDificultad;
	private JTextField boxTiempo;
	private JTextField boxId;
	private JLabel lblNombre, lblApellidos, lblEdad, lblDificultad, lblTiempo, lblimagen,lbltxtimagen,lblId;
	private JButton btnActualizar, btnayuda, btnBaja, btnMedia, btnAlta;
	private ImageIcon imagenDefect, imagenEscalada, imagenInfo, imagenSelect;
	private int indicadorimg;
	private JTextArea boxPantalla;
	private boolean actDatos =false;
	
	//Creamos objeto Jugador
	private Jugador player1;
	
	public Profile() {
		
		//Parametro ventana principal
		setLayout(null);
		setForeground(Color.WHITE);
		setBackground(new Color(119, 136, 153));
		setBounds(100, 100, 797, 703);
		/*------CAJAS------*/
		
		/*-----Caja Nombre---*/
		boxNombre = new JTextField();
		boxNombre.setForeground(Color.WHITE);
		boxNombre.setBackground(Color.DARK_GRAY);
		boxNombre.setBounds(116, 67, 370, 39);
		add(boxNombre);
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
		boxApellidos.setBounds(116, 161, 370, 39);
		add(boxApellidos);
		
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
		boxEdad.setBounds(116, 249, 370, 39);
		add(boxEdad);
		boxEdad.setColumns(10);
		
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
		boxDificultad.setBounds(116, 415, 370, 39);
		add(boxDificultad);
		
		/*----Caja Imprime Pantalla----*/
		boxPantalla = new JTextArea();
		boxPantalla.setLineWrap(true);
		boxPantalla.setBackground(Color.DARK_GRAY);
		boxPantalla.setForeground(Color.WHITE);
		boxPantalla.setFont(new Font("Yu Gothic", Font.BOLD, 14));
		boxPantalla.setEnabled(false);
		boxPantalla.setText("BIENVENIDO AL JUEGO MATHDICE!");
		boxPantalla.setBounds(37, 482, 566, 171);
		add(boxPantalla);
		
		/*-----Caja Tiempo----*/
		boxTiempo = new JTextField();
		boxTiempo.setText("00:04:00");
		boxTiempo.setForeground(Color.WHITE);
		boxTiempo.setFont(new Font("Yu Gothic", Font.BOLD, 16));
		boxTiempo.setHorizontalAlignment(SwingConstants.CENTER);
		boxTiempo.setEnabled(false);
		boxTiempo.setColumns(10);
		boxTiempo.setBackground(Color.DARK_GRAY);
		boxTiempo.setBounds(581, 378, 161, 50);
		add(boxTiempo);
		
		/*-------Caja Identificador Jugador (Id)-----*/
		boxId = new JTextField();
		boxId.setHorizontalAlignment(SwingConstants.CENTER);
		boxId.setForeground(Color.WHITE);
		boxId.setFont(new Font("Yu Gothic", Font.BOLD, 16));
		boxId.setEnabled(false);
		boxId.setColumns(10);
		boxId.setBackground(Color.DARK_GRAY);
		boxId.setBounds(581, 277, 161, 50);
		add(boxId);

		/*------BOTONES------*/
		//Boton Actualizar Datos
		
		//Propiedades
		btnActualizar = new JButton("ACTUALIZAR");
		btnActualizar.setForeground(Color.WHITE);
		btnActualizar.setBackground(new Color(0, 128, 128));
		btnActualizar.setFont(new Font("Yu Gothic", Font.BOLD, 14));
		btnActualizar.setBounds(624, 482, 161, 57);
		add(btnActualizar);
		
		//Acciones del boton

				btnActualizar.addActionListener(new ActionListener() {
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
					    	
					    	
						//Informa de que TODAS las cajas han sido completadas
						
							String[] check = {boxNombre.getText(),boxApellidos.getText(),boxEdad.getText(),boxDificultad.getText()};
							
							if((check[0].length()!=0)&&(check[1].length()!=0)&&(check[2].length()!=0)&&(check[3].length()!=0)){
								boxPantalla.setText("Campos actualizados correctamente!\nHola "+player1.getNombre()+" "+player1.getApellidos()+"\n Su Edad: "+player1.getEDAD()+" años\nHas elegido: "+player1.getDificultad()+" con lo que tendras "+player1.getMin()+" minuto/s");
								actDatos=true;
							}else{
								boxPantalla.setText("Saludos!\n"+player1.getNombre()+" "+player1.getApellidos()+player1.getEDAD()+"\nHas elegido: "+player1.getDificultad()+" con lo que tendras "+player1.getMin()+" minuto/s");
							}
							
					}
				});
		
		
		//Boton Ayuda
		
		//Propiedades
				
		btnayuda = new JButton("AYUDA");
		btnayuda.setForeground(Color.WHITE);
		btnayuda.setBackground(new Color(255, 0, 0));
		btnayuda.setFont(new Font("Yu Gothic", Font.BOLD, 14));
		btnayuda.setBounds(624, 596, 161, 57);
		add(btnayuda);
		
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
		btnBaja.setBounds(115, 356, 89, 39);
		add(btnBaja);
		
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
		btnMedia.setBounds(257, 356, 89, 39);
		add(btnMedia);
		
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
		btnAlta.setBounds(397, 356, 89, 39);
		add(btnAlta);
		
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
		
		/*-----ETIQUETAS----*/
		
		//Etiqueta Nombre
		lblNombre = new JLabel("NOMBRE:");
		lblNombre.setForeground(new Color(255, 255, 255));
		lblNombre.setFont(new Font("Yu Gothic", Font.BOLD, 14));
		lblNombre.setBounds(10, 67, 76, 33);
		add(lblNombre);
		
		//Etiqueta Apellidos
		lblApellidos = new JLabel("APELLIDOS:");
		lblApellidos.setForeground(new Color(255, 255, 255));
		lblApellidos.setFont(new Font("Yu Gothic", Font.BOLD, 14));
		lblApellidos.setBounds(8, 163, 96, 33);
		add(lblApellidos);
		
		//Etiqueta Edad
		lblEdad = new JLabel("EDAD:");
		lblEdad.setForeground(new Color(255, 255, 255));
		lblEdad.setFont(new Font("Yu Gothic", Font.BOLD, 14));
		lblEdad.setBounds(12, 251, 92, 33);
		add(lblEdad);
		
		//Etiqueta Dificultad
		lblDificultad = new JLabel("DIFICULTAD:");
		lblDificultad.setForeground(new Color(255, 255, 255));
		lblDificultad.setFont(new Font("Yu Gothic", Font.BOLD, 14));
		lblDificultad.setBounds(9, 359, 96, 14);
		add(lblDificultad);
		
		//Etiqueta Tiempo
		lblTiempo = new JLabel("TIEMPO:");
		lblTiempo.setForeground(Color.WHITE);
		lblTiempo.setFont(new Font("Yu Gothic", Font.BOLD, 14));
		lblTiempo.setBounds(581, 354, 96, 14);
		add(lblTiempo);
		
		//Etiqueta Imagen
		lblimagen = new JLabel("");
		lblimagen.setForeground(Color.WHITE);
		lblimagen.setBackground(Color.DARK_GRAY);
		lblimagen.setHorizontalAlignment(SwingConstants.CENTER);
		imagenDefect = new ImageIcon(getClass().getResource("img/avatar.png"));
		lblimagen.setBounds(581, 36, 161, 177);
		add(lblimagen);
		//Proceso de escalado
		escalaImagen(imagenDefect);
				//Añade Imagen
		lblimagen.addMouseListener(new añadeImagen());
		
		//Etiqueta info para hacer click y añadir Imagen
		lbltxtimagen = new JLabel("Click imagen para a\u00F1adir");
		lbltxtimagen.setForeground(Color.ORANGE);
		lbltxtimagen.setFont(new Font("Yu Gothic", Font.BOLD, 12));
		lbltxtimagen.setBounds(581, 226, 161, 14);
		add(lbltxtimagen);
		
		//Etiqueta Identificador del Jugador(Id)
		lblId = new JLabel("ID JUGADOR:");
		lblId.setForeground(Color.WHITE);
		lblId.setFont(new Font("Yu Gothic", Font.BOLD, 14));
		lblId.setBounds(581, 253, 96, 14);
		add(lblId);
		
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
	//Getters y Setters para Objeto Jugador --- Se cargarán los datos que hayamos introducido al principio y luego podrán ser cambiados con el metodo actJugador
	public Jugador getJugador(){
		return player1;
	}
	
	public void setJugador(Jugador player1) {
		boxNombre.setText(player1.getNombre());
		boxApellidos.setText(player1.getApellidos());
		boxEdad.setText(player1.getEDAD());
		boxDificultad.setText(player1.getDificultad());
		boxTiempo.setText("00:"+"0"+player1.getMin()+":"+"0"+player1.getSeg());
		lblimagen.setIcon(player1.getImagenEscalado());
	}
	
	//Metodo controlador de si los datos del jugador se han modificado
	public boolean actJugador(){
		return actDatos;
	}
}
