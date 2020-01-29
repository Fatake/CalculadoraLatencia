/**
 * Class Nodo
 */
public class Nodo {

	//
	// Fields
	//
  	private Integer numeroNodo;
	private Float tiempoCola;
	public Paquete tamPaquete;
  
	//
	// Constructors
	//
	public Nodo (Integer numeroNodo, Float tiempoCola) {
		this.numeroNodo = numeroNodo;
		this.tiempoCola = tiempoCola;
		this.tamPaquete = new Paquete();
	}

	public Nodo (Integer numeroNodo, Float tiempoCola, Paquete tamPaquete) {
		this.numeroNodo = numeroNodo;
		this.tiempoCola = tiempoCola;
		this.tamPaquete = tamPaquete;
	}

	public Nodo (Integer numeroNodo, Float tiempoCola, Integer datControl, Integer datUser){
		this.numeroNodo = numeroNodo;
		this.tiempoCola = tiempoCola;
		this.tamPaquete = new Paquete(datControl,datUser);
	}
  
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
  	public void setNumeroNodo (Integer newVar) {
  		numeroNodo = newVar;
  	}

	/**
	 * Get the value of numeroNodo
	 * Numero del Nodo
	 * @return the value of numeroNodo
	 */
  	public Integer getNumeroNodo () {
  		return numeroNodo;
  	}

	/**
	 * Set the value of tiempoCola
	 * Tiempo de cola de los paquetes
	 * @param newVar the new value of tiempoCola
	 */
  	public void setTiempoCola (Float newVar) {
  		tiempoCola = newVar;
  	}

	/**
	 * Get the value of tiempoCola
	 * Tiempo de cola de los paquetes
	 * @return the value of tiempoCola
	 */
  	public Float getTiempoCola () {
  		return tiempoCola;
  	}

	//
	// Other methods
	//

}
