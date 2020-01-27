import java.util.*;

/**
 * Class Enlace
 */
public class Enlace {
	//
	// Constantes
	//
	static final float velocidadLuz = 3*Math.pow(10, 8);
	//
	// Fields
	//
	private Nodo nodoOrigen;
	private Nodo NodoDestino;

	private Float velocidadEnlace;
	private Float distancia;
	public Paquete tamPaquete;
  
	//
	// Constructors
	//
	public Enlace (Nodo nodoOrigen, Nodo nodoDestino,Float velocidadEnlace,Float distancia,Integer datosControl,Integer datosUsuario) {
		this.nodoOrigen = nodoOrigen;
		this.NodoDestino = nodoDestino;

		this.velocidadEnlace = velocidadEnlace;
		this.distancia = distancia;
		this.tamPaquete = new Paquete(datosControl, datosUsuario);
	}
  
	//
	// Methods
	//
	/*
	 * Funcion que retorna la latencia de 1 paquete
	 * Retorna:
	 * 	float latencia
	 */
	public Float latencia(){
		Float timePropagacion = this.distancia/velocidadLuz;
		Float timeTransmicion = tamPaquete.getTamPaquete() / this.velocidadEnlace;
		Float latencia = timePropagacion + timeTransmicion + this.NodoDestino.getTiempoCola();
		return latencia;
	}

	/*
	 * Funcion que retorna la latencia de n paquetes
	 * Recibe:
	 * 	int numero de paquetes
	 * Retorna:
	 * 	float latencia
	 */
	public Float latencia(int numPaquetes){
		Float timePropagacion = this.distancia/velocidadLuz;
		Float timeTransmicion = tamPaquete.getTamPaquete() / this.velocidadEnlace;
		Float latencia = timePropagacion + timeTransmicion + this.NodoDestino.getTiempoCola();
		return numPaquetes*latencia;
	}

	/*
	 * Funcion que retorna la latencia de n paquetes
	 * y de un tamaño de paquete diferente al del enlaceh
	 * Recibe:
	 * 	int numero de paquetes
	 * Retorna:
	 * 	float latencia
	 */
	public Float latencia(int numPaquetes,Paquete pack){
		Float timePropagacion = this.distancia/velocidadLuz;
		Float timeTransmicion = pack.getTamPaquete() / this.velocidadEnlace;
		Float latencia = timePropagacion + timeTransmicion + this.NodoDestino.getTiempoCola();
		return numPaquetes*latencia;
	}

	//
	// Accessor methods
	//
	/**
	 * Get the value of nodoOrigen
	 * Nodo de Origen
	 * 
	 * @return the value of nodoOrigen
	 */
  	public Nodo getNodoOrigen () {
  		return nodoOrigen;
  	}

	/**
	 * Get the value of NodoDestino
	 * Nodos Destino
	 * 
	 * @return the value of NodoDestino
	 */
  	public Nodo getNodoDestino () {
  		return NodoDestino;
  	}

	/**
	 * Get the value of velocidadEnlace
	 * Mbps mega byts por segundo
	 * 
	 * @return the value of velocidadEnlace
	 */
  	public Float getVelocidadEnlace () {
  		return velocidadEnlace;
  	}

	/**
	 * Get the value of distancia
	 * Distancia en Metros del nodo Origen a Nodo Destino
	 * 
	 * @return the value of distancia
	 */
  	public Float getDistancia () {
  		return distancia;
  	}

	//
	// Other methods
	//
}
