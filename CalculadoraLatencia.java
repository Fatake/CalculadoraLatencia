
import java.io.IOException;
import java.util.ArrayList;
/*
 * Clase Main
 */
public class CalculadoraLatencia {
    //
    // Atributos
    //
    public ArrayList<Float []> contenidoArchivo;
    private ArrayList<Enlace> nodosEnlazados; 
    //
    // Metodos
    //

    // Constructor
    public CalculadoraLatencia(){

    };
    //
    // Funcion main
    //
    public static void main(final String[] args) {
        CalculadoraLatencia aux = new CalculadoraLatencia();
        LectorArchivo leector = new LectorArchivo();
        leector.leerArchivo(args[0]);//Lee el archivo
        aux.contenidoArchivo = leector.procesaArchivo();//Optiene el contendido sin comas
        for (Float[] pasos : aux.contenidoArchivo) {
            System.out.println(""+pasos.toString());
        }
    }
}
