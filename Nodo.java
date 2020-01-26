import java.util.*;


/**
 * Class Nodo
 */
public class Nodo {

	//
	// Fields
	//

	/**
	 * Numero del Nodo
	 */
  	private Integer numeroNodo;
	/**
	 * Tiempo de cola de los paquetes
	 */
  	private Float tiempoCola;
  
	//
	// Constructors
	//
	public Nodo () { };
  
	//
	// Methods
	//


	//
	// Accessor methods
	//

	/**
	 * Set the value of numeroNodo
	 * Numero del Nodo
	 * @param newVar the new value of numeroNodo
	 */
  	private void setNumeroNodo (Integer newVar) {
  		numeroNodo = newVar;
  	}

	/**
	 * Get the value of numeroNodo
	 * Numero del Nodo
	 * @return the value of numeroNodo
	 */
  	private Integer getNumeroNodo () {
  		return numeroNodo;
  	}

	/**
	 * Set the value of tiempoCola
	 * Tiempo de cola de los paquetes
	 * @param newVar the new value of tiempoCola
	 */
  	private void setTiempoCola (Float newVar) {
  		tiempoCola = newVar;
  	}

	/**
	 * Get the value of tiempoCola
	 * Tiempo de cola de los paquetes
	 * @return the value of tiempoCola
	 */
  	private Float getTiempoCola () {
  		return tiempoCola;
  	}

	//
	// Other methods
	//

}