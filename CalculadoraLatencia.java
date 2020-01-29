
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

        //Lee el archivo
        if (!leector.leerArchivo(args[0])) {
            System.out.println("Error al leer el archivo");
            System.exit(-1);
        }
        
        if ((aux.contenidoArchivo = leector.procesaArchivo()) == null) {
            System.out.println("Error al tratar el archivo");
            System.exit(-1);
        }

        
    }
}
