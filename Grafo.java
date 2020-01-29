import java.util.*;

/**
 * Class Nodo
 */
public class Grafo {

	//
	// Fields
    //
    private final static Integer INF = 99999;
  	private ArrayList<Enlace> enlaces;
  
	//
	// Constructors
	//
	public Grafo (ArrayList<Float []> informacion) {

    }
  
	//
	// Methods
	//
    public int[][] getMatriz(){
        int matriz[][] = {{0, 1, INF, 1}, 
                         {1, 0, 1, INF}, 
                         {INF, 1, 0, 1}, 
                         {1, INF, 1, 0}}; 
        return matriz;
    }
}
