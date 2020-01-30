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
        //grafo.printInfo();//Imprime la informacion
        int matrizAdyacencia[][] = grafo.getMatriz();
        int nodoInisi = grafo.getNodoOrigen()-1;
        int nodoDesti = grafo.getNodoDestino()-1;
        //Busca los caminos por backtraking
        //Lista de lista una lista que tiene la listas que contienen los caminos
        ArrayList<ArrayList<Integer>> allPaths = caminos.pathsBetween(nodoInisi, nodoDesti, matrizAdyacencia);
        //Imprime todos los caminos
        //caminos.printPaths(allPaths);
        //
        // Calculo de Latencias
        //
        ArrayList<Enlace> enlaces = grafo.getEnlaces();
        float latencia[] = new float[allPaths.size()];
        int j = 0;
        for (ArrayList<Integer> path : allPaths) {
            boolean primero = true;
            latencia[j] = 0;
            for (int i = 0; i < path.size(); i++) {
                if (primero)
                    primero = false;
                else
                    System.out.print(" -> ");
                System.out.print(path.get(i)+1);
                Enlace auxEnlaceActual = null;
                for (Enlace enlace : enlaces) {
                    int auxNO = enlace.getNodoOrigen().getNumeroNodo();
                    int auxND = enlace.getNodoDestino().getNumeroNodo();
                    //Si encuentra el enlace
                    if (auxNO == (path.get(i)+1) && auxND == (path.get(i+1)+1)) {
                        auxEnlaceActual = enlace;
                        break;
                    }
                }
                if (auxEnlaceActual != null) {
                    latencia[j]= latencia[j] + auxEnlaceActual.latencia();
                }
            }
            System.out.println(" Latencia: "+latencia[j]);
            j++;
        }
        
        //
        // Tiempo de tranferencia del archivo
        //
        float minimo = 99999;
        for (int i = 0; i < latencia.length; i++) {
            if (latencia[i] < minimo) {
                minimo = latencia[i];
            }
        }
        float time = minimo *grafo.getSizeArchivo();
        System.out.println("\nLatencia mas pequeña: "+minimo);
        System.out.println("El archivo tardará: "+time+" milisegundos");
        System.out.println(""+(time/1000)+" segundos");
        System.out.println(""+(time/1000*60)+" minutos");
        System.out.println(""+(time/1000*60*60)+" Horas");
    }

    //
    // Metodos
    //
    private  void clearScreen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }
}
