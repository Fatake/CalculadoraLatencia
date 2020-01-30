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
        AllPaths caminos = new AllPaths();
        Grafo grafo = null;

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
        // Grafo de la red
        //
        grafo = new Grafo(aux.contenidoArchivo);
        grafo.printInfo();//Imprime la informacion
        int matrizAdyacencia[][] = grafo.getMatriz();
        int nodoInisi = grafo.getNodoOrigen()-1;
        int nodoDesti = grafo.getNodoDestino()-1;
        //Busca los caminos
        //Lista de lista una lista que tiene la listas que contienen los caminos
        ArrayList<ArrayList<Integer>> allPaths = caminos.pathsBetween(nodoInisi, nodoDesti, matrizAdyacencia);

        System.out.println("\nCaminos disónibles:");
        //Imprime todos los caminos
        for (ArrayList<Integer> path : allPaths) {
            boolean primero = true;
      
            for (int i : path) {
                if (primero)
                    primero = false;
                else
                    System.out.print(" -> ");
                
                System.out.print(i+1);
            }
            System.out.println();
          }
        
    }

    //
    // Metodos
    //
    private  void clearScreen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }
}
