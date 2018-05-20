package Ventanas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import Juego.Jugador;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;

public class Juego extends JPanel{
	private static final long serialVersionUID = 1L;
	private ImageIcon dadoGris, img, restar, sumar;
	private ImageIcon[] dado1 = new ImageIcon[4], dado2 = new ImageIcon[7], dado3 = new ImageIcon[13];
	private int numAlmacenDado3, puntos;
	private int[] numAlmacenDado1 = new int[4], numAlmacenDado2 = new int[7];
	private JButton  btnRepetir, btnMathdice;
	private JLabel BienvenidaNombre, lblAvisofinJuego, lblComprobacion, lblDado11, lblDado12, lblDado13, lblDado21, lblDado22, lblDado3, lblimagen, lblPuntos, lbltxtPuntos, lblResta, lblResultado, lblSuma;
	private JTextField boxOperaciones;
	private Random dado = new Random();
	private Jugador player1;
	
	//variables semaforos
	private boolean controlNumOpera=true;
	private boolean sumandos=true;
	private int contenido=0;
	private int numIntro=0;
	
	/**
	 * Inicio ventana Juego y Diseño Juego
	 */

	//Juego: constructor de la clase
	public Juego() {
		setBounds(100, 100, 797, 703);
		setBackground(new Color(119, 136, 153));
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(null);
		
		/*-----CAJAS-----*/
		
		/*-----Caja Operaciones----*/
		
		boxOperaciones = new JTextField();
		boxOperaciones.setHorizontalAlignment(SwingConstants.CENTER);
		boxOperaciones.setEnabled(false);
		boxOperaciones.setForeground(Color.MAGENTA);
		boxOperaciones.setFont(new Font("Yu Gothic", Font.BOLD, 26));
		boxOperaciones.setBackground(Color.DARK_GRAY);
		boxOperaciones.setBounds(487, 104, 279, 106);
		add(boxOperaciones);
		boxOperaciones.setColumns(10);
		
		/*-----Caja texto Puntos----*/
		
		lbltxtPuntos = new JLabel("PUNTOS:");
		lbltxtPuntos.setHorizontalAlignment(SwingConstants.RIGHT);
		lbltxtPuntos.setBackground(Color.DARK_GRAY);
		lbltxtPuntos.setForeground(Color.WHITE);
		lbltxtPuntos.setOpaque(true);
		lbltxtPuntos.setFont(new Font("Yu Gothic", Font.BOLD, 18));
		lbltxtPuntos.setBounds(72, 36, 519, 30);
		add(lbltxtPuntos);
		
		/*-----Caja Puntos----*/
		
		lblPuntos = new JLabel("Cantidad de Puntos");
		lblPuntos.setHorizontalAlignment(SwingConstants.CENTER);
		lblPuntos.setForeground(Color.ORANGE);
		lblPuntos.setBackground(Color.DARK_GRAY);
		lblPuntos.setOpaque(true);
		lblPuntos.setFont(new Font("Yu Gothic", Font.BOLD, 18));
		lblPuntos.setBounds(590, 36, 191, 30);
		add(lblPuntos);
		
		/*-----ETIQUETAS-----*/
		
		/*-----Etiqueta Bienvenida----*/
		BienvenidaNombre = new JLabel("Nombre y Apellidos");
		BienvenidaNombre.setForeground(Color.WHITE);
		BienvenidaNombre.setFont(new Font("Yu Gothic", Font.BOLD, 18));
		BienvenidaNombre.setHorizontalAlignment(SwingConstants.LEFT);
		BienvenidaNombre.setBackground(Color.DARK_GRAY);
		BienvenidaNombre.setOpaque(true);
		BienvenidaNombre.setBounds(72, 0, 709, 36);
		add(BienvenidaNombre);
		
		/*----Etiqueta Imagen----*/
		lblimagen = new JLabel("");
		lblimagen.setHorizontalAlignment(SwingConstants.CENTER);
		lblimagen.setBounds(0, 0, 71, 65);
		add(lblimagen);
		
		/*------ETIQUETAS DADOS----*/
		
		/*------ETIQUETA DADO 1 GRUPO 1----*/
		
		lblDado11 = new JLabel("11");
		lblDado11.setBackground(Color.DARK_GRAY);
		lblDado11.setHorizontalAlignment(SwingConstants.CENTER);
		lblDado11.setBounds(0, 104, 140, 140);
		add(lblDado11);

		
		/*------ETIQUETA DADO 2 GRUPO 1----*/
		
		lblDado12 = new JLabel("12");
		lblDado12.setHorizontalAlignment(SwingConstants.CENTER);
		lblDado12.setBackground(Color.DARK_GRAY);
		lblDado12.setBounds(160, 104, 140, 140);
		add(lblDado12);

		
		/*------ETIQUETA DADO 3 GRUPO 1----*/
		
		lblDado13 = new JLabel("13");
		lblDado13.setHorizontalAlignment(SwingConstants.CENTER);
		lblDado13.setBackground(Color.DARK_GRAY);
		lblDado13.setBounds(320, 104, 140, 140);
		add(lblDado13);

		
		/*------ETIQUETA DADO 1 GRUPO 2----*/
		
		lblDado21 = new JLabel("21");
		lblDado21.setHorizontalAlignment(SwingConstants.CENTER);
		lblDado21.setBackground(Color.DARK_GRAY);
		lblDado21.setBounds(0, 310, 140, 140);
		add(lblDado21);

		
		/*------ETIQUETA DADO 2 GRUPO 2----*/
		
		lblDado22 = new JLabel("22");
		lblDado22.setHorizontalAlignment(SwingConstants.CENTER);
		lblDado22.setBackground(Color.DARK_GRAY);
		lblDado22.setBounds(160, 310, 140, 140);
		add(lblDado22);
		
		/*------ETIQUETA DADO 1 GRUPO 3----*/
		
		lblDado3 = new JLabel("");
		lblDado3.setFont(new Font("Yu Gothic", Font.BOLD, 14));
		lblDado3.setHorizontalAlignment(SwingConstants.CENTER);
		lblDado3.setBackground(Color.DARK_GRAY);
		lblDado3.setBounds(310, 294, 170, 170);
		add(lblDado3);
		
		/*------ETIQUETA PUNTUACION----*/
		
		lblResultado = new JLabel("Puntuacion");
		lblResultado.setForeground(Color.ORANGE);
		lblResultado.setFont(new Font("Yu Gothic", Font.BOLD, 22));
		lblResultado.setHorizontalAlignment(SwingConstants.CENTER);
		lblResultado.setBounds(10, 579, 638, 23);
		add(lblResultado);
		
		/*------ETIQUETA COMPROBACIÓN----*/
		
		lblComprobacion = new JLabel("Correcto o Incorrecto");
		lblComprobacion.setHorizontalAlignment(SwingConstants.CENTER);
		lblComprobacion.setForeground(new Color(102, 0, 204));
		lblComprobacion.setFont(new Font("Yu Gothic", Font.BOLD, 26));
		lblComprobacion.setBounds(0, 613, 648, 51);
		add(lblComprobacion);
		
		/*------ETIQUETA SUMA----*/
		
		lblSuma = new JLabel("Suma");
		lblSuma.setHorizontalAlignment(SwingConstants.CENTER);
		lblSuma.setBounds(487, 231, 140, 140);
		add(lblSuma);
		sumar=new ImageIcon(getClass().getResource("img/suma.png"));
		lblSuma.setIcon(sumar);
		lblSuma.addMouseListener(new selectSuma());

		/*------ETIQUETA RESTA----*/
		
		lblResta = new JLabel("Resta");
		lblResta.setHorizontalAlignment(SwingConstants.CENTER);
		lblResta.setBounds(641, 231, 140, 140);
		add(lblResta);
		restar=new ImageIcon(getClass().getResource("img/resta.png"));
		lblResta.setIcon(restar);
		lblResta.addMouseListener(new selectResta());
		
		/*------ETIQUETA AVISO FIN DEL JUEGO----*/
		lblAvisofinJuego = new JLabel("Tiempo!!!");
		lblAvisofinJuego.setForeground(Color.RED);
		lblAvisofinJuego.setHorizontalAlignment(SwingConstants.CENTER);
		lblAvisofinJuego.setFont(new Font("Yu Gothic", Font.BOLD, 50));
		lblAvisofinJuego.setBounds(10, 223, 470, 106);
		
		
		
		/*------Boton Mathdice-----*/
		
		btnMathdice = new JButton("MATHDICE");
		btnMathdice.setForeground(Color.GREEN);
		btnMathdice.setBackground(Color.DARK_GRAY);
		btnMathdice.setFont(new Font("Yu Gothic", Font.BOLD, 17));
		btnMathdice.setBounds(487, 392, 130, 119);
		add(btnMathdice);
		btnMathdice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(numIntro>1){
					lblResultado.setText("El resultado es: "+String.valueOf(contenido));
					btnRepetir.setEnabled(true);
					if((numAlmacenDado3)==contenido){
						lblComprobacion.setText("Correcto!!! Ganas 5 puntos");
						btnMathdice.setEnabled(false);
						puntos=puntos+5;//Suma 5 puntos por acierto.
						lblPuntos.setText(String.valueOf(puntos));//Imprime en lblPuntos
					}else{
						lblComprobacion.setText("Fallaste!!! Intentalo de Nuevo");
						btnMathdice.setEnabled(false);
					}
				}
			}
		});
		
		/*------Boton Repetir-----*/
		
		btnRepetir = new JButton("REPETIR");
		btnRepetir.setBackground(Color.DARK_GRAY);
		btnRepetir.setForeground(Color.ORANGE);
		btnRepetir.setFont(new Font("Yu Gothic", Font.BOLD, 17));
		btnRepetir.setBounds(641, 392, 130, 119);
		add(btnRepetir);
		btnRepetir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				iniciaDados();
				btnMathdice.setEnabled(true);
				btnRepetir.setEnabled(false);
				boxOperaciones.setText("");
			}
		});
		
		/*Iniciamos dados aleatoriamente*/
		
		iniciaDados();
		
		}
		
	/*---Recogemos datos introducidos en la ventana Login---*/
	public void setJugador(Jugador player1){
		BienvenidaNombre.setText("Bienvenido "+player1.getNombre()+" "+player1.getApellidos());
		puntos=player1.getPuntos();
		lblPuntos.setText(String.valueOf(puntos));
		img = new ImageIcon(player1.getImagenEscalado().getImage().getScaledInstance(71, 65, 100));
		lblimagen.setIcon(img);
	}
	
	//Metodo para una tirada aleatoria.
	private void iniciaDados(){
		//Cargamos imagenes diferenciados por los arrays dado1, dado2 , dado3; transformamos el primer valor de la imagen en un integer más la coletilla que diferencia cada imagen
		//Ejemplo dado1_3.png el numero 1 será el que transformemos en integer e ira seguido _3.png con lo que pertenecera a la primera posicion del bucle primero que se corresponde con dado1
		for(int i=1;i<dado1.length;i++){
			dado1[i] = new ImageIcon(getClass().getResource("img/dado"+String.valueOf(i)+"_3.png"));//Cargar imagenes de dados de la fila 1 (Las imagenes estaran dentro de un array con valores de 1 a 3 en la caras)
		}
		for(int i=1;i<dado2.length;i++){
			dado2[i] = new ImageIcon(getClass().getResource("img/dado"+String.valueOf(i)+"_6.png"));//Cargar imagenes de dados de la fila 2 (Las imagenes estaran dentro de un array con valores de 1 a 6 en la caras)
		}
		for(int i=1;i<dado3.length;i++){
			dado3[i] = new ImageIcon(getClass().getResource("img/dadodoce_"+String.valueOf(i)+".png"));//Cargar imagenes de dados de la fila 3 (Las imagenes estaran dentro de un array con valores de 1 a 12 en la caras)
		}
		dadoGris =new ImageIcon(getClass().getResource("img/dadogris.png"));//Imagen util a la hora de seleccionar un dado para que aparezca esta imagen.

	/* Posicionamos los dados3 FILA 1*/

		for(int i=1; i<numAlmacenDado1.length;i++){
			numAlmacenDado1[i] = dado.nextInt(4);//Almacena los 3 numeros ultimos de los dados de la fila_1 con una aleatoriedad de 1 a 3
			
			if (numAlmacenDado1[i]==0){//impide que en nuestro array numAlmacenDado el minimo sea 0 de esta forma recogerá como minimo la imagen 1_3
				numAlmacenDado1[i]=numAlmacenDado1[i]+1;
			}
		}
			lblDado11.setIcon(dado1[numAlmacenDado1[1]]);
			lblDado11.setName("1");
			lblDado12.setIcon(dado1[numAlmacenDado1[2]]);
			lblDado12.setName("2");
			lblDado13.setIcon(dado1[numAlmacenDado1[3]]);
			lblDado13.setName("3");
			
			//Introducimos el valor del setName de cada variable lblDado.. en selectDados
			lblDado11.addMouseListener(new selectDados());
			lblDado12.addMouseListener(new selectDados());
			lblDado13.addMouseListener(new selectDados());
		
		
	/* Posicionamos los dados6 FILA 2*/
		
		for(int i=1; i<numAlmacenDado2.length;i++){
			numAlmacenDado2[i] = dado.nextInt(7);//Almacena 6 utlimos numeros de los dados de la fila 2 con una aleatoriedad de 1 a 6
			
			if (numAlmacenDado2[i]==0){//impide que en nuestro array numAlmacenDado el minimo sea 0 de esta forma recogerá como minimo la imagen 1_6
				numAlmacenDado2[i]=numAlmacenDado2[i]+1;
			}
		}
			lblDado21.setIcon(dado2[numAlmacenDado2[4]]);
			lblDado21.setName("4");
			lblDado22.setIcon(dado2[numAlmacenDado2[5]]);
			lblDado22.setName("5");
			
			//Introducimos el valor del setName de cada variable lblDado.. en selectDados
			lblDado21.addMouseListener(new selectDados());
			lblDado22.addMouseListener(new selectDados());
		
		
	/* Posicionamos los dados12 FILA 3*/
		
			numAlmacenDado3 = dado.nextInt(13);//Almacena 12 numeros aleatorio de la fila 3 con una aleatoriedad de 12
			
			if (numAlmacenDado3==0){//impide que en nuestro array numAlmacenDado el minimo sea 0 de esta forma recogerá como minimo la imagen doce_1
				numAlmacenDado3=numAlmacenDado3+1;
			}
			
			lblDado3.setIcon(dado3[numAlmacenDado3]);
			lblResultado.setText("A\u00F1ade la Operacion y mostraremos tu resultado aqui");
			lblComprobacion.setText("Te diremos si es correcto(+5 puntos) o Incorrecto");
			
	/*Reseteamos las variables semaforos y valores*/
			controlNumOpera=true;
			contenido=0;
			numIntro=0;
			sumandos=true;
	}
	
	//metodo setOperacion para la resta y la suma de los valores uniendo el contenido que contenga en la caja de las Operaciones.
	private void setOperacion(int num){
		numIntro++;//Numero introducido
		if(numIntro>1){//Si es mayor que 1 suma sino resta.
			if(sumandos){
				contenido=contenido+num;
			}else{
				contenido=contenido-num;
			}
		}else{
			contenido=num;
		}
	}
	
	//Creamos la clase inner llamada selectDados. Implementara la clase mouselisener recogiendo todos sus metodos.
	private class selectDados implements MouseListener{

		@Override//Palabra reservada que avisamos al compilador que hemos modificado un metodo conforme a mis necesidades
		public void mouseClicked(MouseEvent e) {
			JLabel dado = (JLabel) e.getSource();//Identifica el Jlabel sobre el cual he hecho click y lo guardas en dado. (Será los numeros: 1,2,3,4 y 5).Valor recuperado del setName declarado en los bucles for 
			int numDado = Integer.valueOf(dado.getName());//Transformar a numero entero para obtener el valor.
			if(controlNumOpera){//Control de saber si toca un numero o una operacion de esta manera no se pueden duplicar signos ni numeros.
				
				/*Comprobación del array y del valor que se selecciona al pulsar los dados de la fila1*/
				//System.out.println(numAlmacenDado1[1]+" "+numAlmacenDado1[2]+" "+numAlmacenDado1[3]);
				//System.out.println(String.valueOf(numAlmacenDado1[numDado]));
				
				/*Comprobación del array y del valor que se selecciona al pulsar los dados de la fila2*/				
				//System.out.println(numAlmacenDado2[4]+" "+numAlmacenDado2[5]);
				//System.out.println(String.valueOf(numAlmacenDado2[numDado]));

				if(numDado<4){//Corresponde a las variables lblDado11, lblDado12, lblDado13.
					boxOperaciones.setText(boxOperaciones.getText()+String.valueOf(numAlmacenDado1[numDado]));//Ejemplo: lblDado11 numDado-1=0 escogera el numero en posicion 0 del array y lo incrementara 1 lo transformara en valor y lo añadera al getText Contenido
				}else{//Corresponde a las variables lblDado21, lblDado22
					boxOperaciones.setText(boxOperaciones.getText()+String.valueOf(numAlmacenDado2[numDado]));
				}
				dado.removeMouseListener(this);//Borra MouseListener del Jlabel
				dado.setIcon(dadoGris);//Añade imagen del dado gris
				controlNumOpera=false;//Variable semaforo en false (para impedir seleccionar dos dados a la vez o dos signos a la vez).
				
				//Condición para añadir la operacion junto al contenido que haya en la caja "boxOperaciones"
				if(numDado<4){
						setOperacion(numAlmacenDado1[numDado]);
				}else{
						setOperacion(numAlmacenDado2[numDado]);
				}
			}
		}
		//Metodos asociados a la clase MouseListener (deberá tener todos los metodos):

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
	}
	
	private class selectSuma implements MouseListener{

			@Override//Palabra reservada que avisamos al compilador que hemos modificado un metodo conforme a mis necesidades
			public void mouseClicked(MouseEvent e) {
					if(!controlNumOpera){
						boxOperaciones.setText(boxOperaciones.getText()+"+");
						controlNumOpera=true;
						sumandos=true;
					}
				}
			//Metodos asociados a la clase MouseListener (deberá tener todos los metodos):
			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
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
	
	private class selectResta implements MouseListener{

		@Override//Palabra reservada que avisamos al compilador que hemos modificado un metodo conforme a mis necesidades
		public void mouseClicked(MouseEvent e) {
			if(!controlNumOpera){
				boxOperaciones.setText(boxOperaciones.getText()+"-");
				controlNumOpera=true;
				sumandos=false;
			}
		}
		//Metodos asociados a la clase MouseListener (deberá tener todos los metodos):
		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
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
