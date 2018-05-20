package Juego;
import java.util.Random;
import javax.swing.ImageIcon;
public class Jugador {
	//Una clase necesita un nombre y un constructor
	
	//Atributos o Variables de la clase Jugador se accede mediante metodos/funciones
	
	private String nombre;
	private String apellidos;
	private int edad;
	private int min;
	private int seg;
	private int puntos;
	private String dificultad;
	private String EDAD;
	private String id;
	private ImageIcon imagen;

	//CONSTANTES
	
	public static final String bajo="Dificultad Baja";
	public static final int[] tbajo={7,0};//Asignamos los min y segundos para una dificultad baja expresanda {min, seg}.
	public static final String medio="Dificultad Media";
	public static final int[] tmedio={4,0};//Asignamos los min y segundos para una dificultad media expresanda {min, seg}.
	public static final String alto="Dificultad Alta";
	public static final int[] talto={1,0};//Asignamos los min y segundos para una dificultad alta expresanda {min, seg}.
	
	//Constructor de la clase
	
	public Jugador() {

	}

	/*---------Getters y setters de la clase Jugador----------*/
	
	//getter y setter Nombre
	
	public String getNombre() {
		return nombre;
	}
	
	//Condicion Nombre
	
	public void setNombre(String nombre) {
		String sumletra="";
		if(nombre.length()==0){
			this.nombre="Se ha olvidado escribir el nombre, por favor escribalo";
		}else{
			//Desglose del nombre y checkeo de que no haya algun caracter especial o numero
			for(int i=0;i<nombre.length();i++){
				char letra = nombre.charAt(i);
				//En función de si tiene o no tiene un caracater especial o numero mostrará un mensaje distinto en pantalla
				if(Character.isLetter(letra)){
					sumletra=sumletra+letra;
					this.nombre=sumletra;
				}else{
					this.nombre="Caracteres invalidos en el nombre";
				}
			}
		}
	}
	//getter y setter Apellidos
	
	public String getApellidos() {
		return apellidos;
	}

	//Condicion Apellidos
	
	public void setApellidos(String apellidos) {
		String sumletra="";
		if(apellidos.length()==0){
			sumletra="\nSe ha olvidado escribir los apellidos, por favor escribalo";
			this.apellidos=sumletra;
		}else{
			//Desglose del apellido y checkeo de que no haya algun caracter especial o numero
			for(int i=0;i<apellidos.length();i++){
			//En función de si tiene o no tiene un caracater especial o numero o espacio inicio o final mostrara un mensaje distinto en pantalla.
				if((i==0&&Character.isWhitespace(apellidos.charAt(i))==true )|(Character.isWhitespace(apellidos.charAt(apellidos.length()-1))==true)){
					sumletra="\n Los apellidos no pueden empezar ni acabar por un espacio ";
					this.apellidos=sumletra;
				}else{
					char letra = apellidos.charAt(i);
						if(Character.isLetter(letra)|Character.isWhitespace(letra)){
							sumletra=sumletra+letra;
							this.apellidos=sumletra;
						}else{
							sumletra="\nCaracteres invalidos en el apellido";
							this.apellidos=sumletra;
						}
				}
			}
		}
	}
	
	//getter y setter edad
	
	public int getEdad() {
		return edad;
	}
	
	//Condicion edad
	
	public void setEdad(int edad) {
		this.edad=edad;
	}
	
	//getter y setter dificultad
	
	public String getDificultad() {
		return dificultad;
	}
	
	//Condicion dificultad
	
	public void setDificultad(String dificultad) {
			switch(dificultad){
			case Jugador.bajo:
				this.dificultad=Jugador.bajo;
				break;
			case Jugador.medio:
				this.dificultad=Jugador.medio;
				break;
			case Jugador.alto:
				this.dificultad= Jugador.alto;
				break;
			default:
				this.dificultad= Jugador.medio;
			}		
	}
	
	//getter y setter tiempo MIN
	
	public int getMin() {
		return min;
	}
	
	//Condicion tiempo MIN

	public void setMin(int minutos){
		if(minutos==Jugador.tbajo[0]){
			this.min=Jugador.tbajo[0];
		}else if(minutos==Jugador.tmedio[0]){
			this.min=Jugador.tmedio[0];
		}else if(minutos==Jugador.talto[0]){
			this.min=Jugador.talto[0];		
		}else{
			this.min=Jugador.tmedio[0];
		}
	}
	//getter y setter tiempo SEG
	
	public int getSeg() {
		return seg;
	}
	
	//Condicion tiempo SEG

	public void setSeg(int segundos){
		if(segundos==Jugador.tbajo[1]){
			this.seg=Jugador.tbajo[1];
		}else if(segundos==Jugador.tmedio[1]){
			this.seg=Jugador.tmedio[1];
		}else if(segundos==Jugador.talto[1]){
			this.seg=Jugador.talto[1];		
		}else{
			this.seg=Jugador.tmedio[1];
		}
	}

	//getter y setter EDAD en String
	
	public String getEDAD() {
		return EDAD;
	}
	public void setEDAD(String EDAD) {
		/*Comprobación de si es un texto o un numero*/
		String text="";
		//Si esto es texto devolvera que no es un numero.
	    if(isNumeric(EDAD)==false){
	    	text="Esto no es un numero, introduzca un numero por favor.";
	    	this.EDAD = text;
	    //Si no es texto y es numero, pasara por las siguientes condiciones.
	    }else{
	    	int edad = Integer.valueOf(EDAD);
	    	if(edad==0){
	    		text="Esta edad es nula, introduzca otra edad por favor.";
	    		this.EDAD = text;
	    	}else if(edad<0){
	    		text="Esta edad es negativa, introduzca otra edad por favor.";
	    		this.EDAD = text;
	    	}else if(edad>99){
	    		text="Esta edad es demasiado elevada, introduzca otra edad por favor";
	    		this.EDAD = text;
	    	}else{
	    		this.EDAD = ""+edad;
	    	}
	    }
	    
	}
	//getter y setter Id(identificador)
	
	public String getid() {
		return id;
	}
	
	public void setid(String id) {
		Random ident =new Random();
		id= "JPlayer"+ident.nextInt(9999);
		this.id=id;

	}
	//getter y setter Puntos
	public int getPuntos() {
		return puntos;
	}

	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}
	
	//getter y setter Imagen Login y Juego.
	public ImageIcon getImagenEscalado() {
		return imagen;
	}

	public void setImagenEscalado(ImageIcon imagen) {
		if(imagen.getIconHeight() > 161 || imagen.getIconWidth() > 177){ // Si la imagen es mayor de las dimensiones del Jlabel la escalaremos
            this.imagen = new ImageIcon(imagen.getImage().getScaledInstance(161, 177, 100));//escalamos arreglo al Jlabel de la imagen(ancho,largo,pulgadas).
		}
	}

	//Metodo isNumeric para saber si es un numero en el campo edad.
	public boolean isNumeric(String text) {
		try{
			Integer.parseInt(text);//convertimos el numero texto en numero entero
			return true;
		}catch (NumberFormatException text2){
			return false;
		}
		
	}
	//Metodo isLetter para saber si es una caracter y NO es un numero o caracter especial.
	public boolean isLetter(char letra) {
		return false;
	}
}
