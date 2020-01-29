
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

    //
    // Constructor
    //
    public CalculadoraLatencia(){ };
    //
    // Funcion main
    //
    public static void main(final String[] args) {
        CalculadoraLatencia aux = new CalculadoraLatencia();
        LectorArchivo leector = new LectorArchivo();

        //
        // Lectura del Archivo
        //
        if (!leector.leerArchivo(args[0])) {
            //Si no se pudo leer correctamente
            System.out.println("Error al leer el archivo");
            System.exit(-1);
        }
        
        if ((aux.contenidoArchivo = leector.procesaArchivo()) == null) {
            //Si no se puso procesar
            System.out.println("Error al tratar el archivo");
            System.exit(-1);
        }

        //
        //
        //
    }

    //
    // Metodos
    //
    private  void clearScreen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }
}
