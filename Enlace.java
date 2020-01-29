import java.util.*;

/**
 * Class Enlace
 */
public class Enlace {
	//
	// Constantes
	//
	private static final Integer velocidadLuz = 300000000;
	//
	// Fields
	//
	private Nodo nodoOrigen;
	private Nodo nodoDestino;

	private Float velocidadEnlace;
	private Float distancia;
  
	//
	// Constructors
	//
	public Enlace (Nodo nodoOrigen, Nodo nodoDestino,Float velocidadEnlace,Float distancia) {
		this.nodoOrigen = nodoOrigen;
		this.nodoDestino = nodoDestino;

		this.velocidadEnlace = velocidadEnlace;
		this.distancia = distancia;
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
		Float timeTransmicion = nodoDestino.tamPaquete.getSizePaquete() / this.velocidadEnlace;
		Float latencia = timePropagacion + timeTransmicion + this.nodoDestino.getTiempoCola();
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
		Float timeTransmicion = nodoDestino.tamPaquete.getSizePaquete() / this.velocidadEnlace;
		Float latencia = timePropagacion + timeTransmicion + this.nodoDestino.getTiempoCola();
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
		Float timeTransmicion = pack.getSizePaquete() / this.velocidadEnlace;
		Float latencia = timePropagacion + timeTransmicion + this.nodoDestino.getTiempoCola();
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
  		return nodoDestino;
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
