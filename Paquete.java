import java.util.*;

/**
 * Class Paquete
 */
public class Paquete {

	//
	// Fields
	//
	private int datosControl;
	private int datosUsuario;
  
	//
	// Constructors
	//
	public Paquete (int datosControl, int datosUsuario) {
		this.datosControl = datosControl;
		this.datosUsuario = datosUsuario;
	}
  
	//
	// Methods
	//
	public Integer getTamPaquete(){
		return datosControl + datosUsuario;
	}

	//
	// Accessor methods
	//
	/**
	 * Set the value of datosControl
	 * @param newVar the new value of datosControl
	 */
  	public void datosControl (Integer newVar) {
		datosControl = newVar;
  	}

	/**
	 * Get the value of datosControl
	 * @return the value of datosControl
	 */
  	public Integer datosControl () {
  		return datosControl;
  	}

	/**
	 * Set the value of datosUsuario
	 * @param newVar the new value of datosUsuario
	 */
  	public void datosUsuario (Integer newVar) {
		datosUsuario = newVar;
  	}

	/**
	 * Get the value of datosUsuario
	 * @return the value of datosUsuario
	 */
  	public Integer datosUsuario () {
  		return datosUsuario;
  	}
}
