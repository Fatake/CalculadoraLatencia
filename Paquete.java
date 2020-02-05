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

	public Paquete () {
		this.datosControl = 0;
		this.datosUsuario = 0;
	}
  
	//
	// Methods
	//
	public Integer getSizePaquete() {
		return datosControl + datosUsuario;
	}

	public void setSizeZero() {
		this.datosControl = 0;
		this.datosUsuario = 0;
	}

	public void reSize(Integer dc, Integer du) {
		this.datosControl = dc;
		this.datosUsuario = du;
	}

	//
	// Accessor methods
	//
	/**
	 * Set the value of datosControl
	 * @param newVar the new value of datosControl
	 */
  	public void setDatosControl (Integer newVar) {
		datosControl = newVar;
  	}

	/**
	 * Get the value of datosControl
	 * @return the value of datosControl
	 */
  	public Integer getDatosControl () {
  		return datosControl;
  	}

	/**
	 * Set the value of datosUsuario
	 * @param newVar the new value of datosUsuario
	 */
  	public void setDatosUsuario (Integer newVar) {
		datosUsuario = newVar;
  	}

	/**
	 * Get the value of datosUsuario
	 * @return the value of datosUsuario
	 */
  	public Integer getDatosUsuario () {
  		return datosUsuario;
  	}
}
