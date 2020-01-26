
import java.util.*;


/**
 * Class Enlace
 */
public class Enlace {

	//
	// Fields
	//
	/**
	 * Nodo de Origen	
	 */
	private Nodo nodoOrigen;

	/**
	 * Nodos Destino
	 */
	private Nodo NodoDestino;

	/**
	 * Mbps mega byts por segundo
	 */

	private Float velocidadEnlace = 0.0;

	/**
	 * Distancia en Metros del nodo Origen a Nodo Destino
	 */
	private Float distancia;

	/**
	 * Datos de Control DC
	 */
	private Integer datosControl;

	/**
	 * Datos de Usuario bytes DU
	 */
 	private Integer datosUsuario;
  
	//
	// Constructors
	//
	public Enlace () { };
  
	//
	// Methods
	//


	//
	// Accessor methods
	//

	/**
	 * Set the value of nodoOrigen
	 * Nodo de Origen
	 * 
	 * @param newVar the new value of nodoOrigen
	 */
  private void setNodoOrigen (Nodo newVar) {
  	nodoOrigen = newVar;
  }

	/**
	 * Get the value of nodoOrigen
	 * Nodo de Origen
	 * 
	 * @return the value of nodoOrigen
	 */
  private Nodo getNodoOrigen () {
  	return nodoOrigen;
  }

	/**
	 * Set the value of NodoDestino
	 * Nodos Destino
	 * 
	 * @param newVar the new value of NodoDestino
	 */
  private void setNodoDestino (Nodo newVar) {
  	NodoDestino = newVar;
  }

	/**
	 * Get the value of NodoDestino
	 * Nodos Destino
	 * 
	 * @return the value of NodoDestino
	 */
  private Nodo getNodoDestino () {
  	return NodoDestino;
  }

	/**
	 * Set the value of velocidadEnlace
	 * Mbps mega byts por segundo
	 * 
	 * @param newVar the new value of velocidadEnlace
	 */
  private void setVelocidadEnlace (Float newVar) {
  	velocidadEnlace = newVar;
  }

	/**
	 * Get the value of velocidadEnlace
	 * Mbps mega byts por segundo
	 * 
	 * @return the value of velocidadEnlace
	 */
  private Float getVelocidadEnlace () {
  	return velocidadEnlace;
  }

	/**
	 * Set the value of distancia
	 * Distancia en Metros del nodo Origen a Nodo Destino
	 * 
	 * @param newVar the new value of distancia
	 */
  private void setDistancia (Float newVar) {
  	distancia = newVar;
  }

	/**
	 * Get the value of distancia
	 * Distancia en Metros del nodo Origen a Nodo Destino
	 * 
	 * @return the value of distancia
	 */
  private Float getDistancia () {
  	return distancia;
  }

	/**
	 * Set the value of datosControl
	 * Datos de Control DC
	 * @param newVar the new value of datosControl
	 */
  private void setDatosControl (Integer newVar) {
  	datosControl = newVar;
  }

	/**
	 * Get the value of datosControl
	 * Datos de Control DC
	 * @return the value of datosControl
	 */
  private Integer getDatosControl () {
  	return datosControl;
  }

	/**
	 * Set the value of datosUsuario
	 * Datos de Usuario bytes DU
	 * @param newVar the new value of datosUsuario
	 */
  private void setDatosUsuario (Integer newVar) {
  	datosUsuario = newVar;
  }

	/**
	 * Get the value of datosUsuario
	 * Datos de Usuario bytes DU
	 * @return the value of datosUsuario
	 */
  private Integer getDatosUsuario () {
  	return datosUsuario;
  }

	//
	// Other methods
	//

}
