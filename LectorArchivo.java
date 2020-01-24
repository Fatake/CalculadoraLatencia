import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/*
 * Clase Lector Archivo
 */
public class LectorArchivo {
    public ArrayList<String> contenidoArchivo = new ArrayList<String>();
    public ArrayList<Float []> contenidoArchivoInt = new ArrayList<Float[]>();
    //
    // Metodos
    //
    // Constructor 1
    public LectorArchivo() {

    };

    public boolean leerArchivo(String fileName){
        File archivo = new File (fileName);
        FileReader fr = null;
        BufferedReader br = null;
        String linea;

        // Lectura del fichero
        try {
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            // hacer una lectura comoda (disponer del metodo readLine()).
            while ((linea = br.readLine()) != null){
                this.contenidoArchivo.add(linea);
                System.out.println(linea);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            try{                    
               if( null != fr ){   
                  fr.close();     
               }                  
            }catch (Exception e2){ 
               e2.printStackTrace();
            }
        }//Fin lectura archivo
        return true;
    }

    //Procesa el archivo a una lista de enteros
    public ArrayList<Float[]> procesaArchivo(){
        System.out.println("<------------------------>\n\nEntra a procesar Archivo");
        int contador = 0;
        String aux = contenidoArchivo.get(contador);
        String aux2[] = aux.split(",");

        //Se Obtienen el numero de nodos y el numero de enlaces
        Float numNodos   = Float.parseFloat(aux2[0]);
        Float numEnlaces = Float.parseFloat(aux2[1]);
        Float auxInt[] = new Float[2];
        auxInt[0] = numNodos;
        auxInt[1] = numEnlaces;
        System.out.println(" Nodo:"+auxInt[0]+" Enlaces:"+auxInt[1]);
        contenidoArchivoInt.add(auxInt);
        auxInt = null;
        aux = null;
        aux2 = null;
        contador++;
        System.out.println("Contador: "+contador+"\n");

        //Nodos y tiempo de cola
        for (int i = contador; i <= numNodos.intValue(); i++) {//Para los n nodos
            aux = contenidoArchivo.get(i);
            aux2 = aux.split(",");
            Float nodo = Float.parseFloat(aux2[0]);
            Float tiem = Float.parseFloat(aux2[1]);

            Float auxInt1[] = new Float[2];
            auxInt1[0] = nodo;
            auxInt1[1] = tiem;
            System.out.println("Nodo: "+auxInt1[0]+" TC: "+auxInt1[1]);
            contenidoArchivoInt.add(auxInt1);
            contador++;
            System.out.println("Contador: "+contador+"");
        }
        System.out.println("\nSale del for");

        //Enlaces nOrigen, nDestino, VelocidadEnlace, Distancia, DC, DU
        for (int i = contador; i < numEnlaces.intValue()+contador; i++) {
            aux = contenidoArchivo.get(i+1);
            aux2 = aux.split(",");
            Float nOrigen = Float.parseFloat(aux2[0]);
            Float nDestino= Float.parseFloat(aux2[1]);
            Float velocidadEnlace=Float.parseFloat(aux2[2]);
            Float distancia= Float.parseFloat(aux2[3]);
            Float DC = Float.parseFloat(aux2[4]);
            Float DU = Float.parseFloat(aux2[5]);

            Float []auxInt1 = {nOrigen,nDestino,velocidadEnlace,distancia,DC,DU};
            System.out.println(""+auxInt1.toString());
            contenidoArchivoInt.add(auxInt1);
            contador++;
        }
        System.out.println("\nSale del for");

        //Tamanio de Paquetes
        aux = contenidoArchivo.get(contador);
        Float []auxInt1 = {Float.parseFloat(aux)};
        System.out.println(""+auxInt1.toString());
        contenidoArchivoInt.add(auxInt1);
        contador++;

        //Nodo A, Nodo B || Destino-Fin
        aux = contenidoArchivo.get(contador);
        aux2 = aux.split(",");
        Float nodoOrigen = Float.parseFloat(aux2[0]);
        Float nodoDestino= Float.parseFloat(aux2[1]);
        Float []auxInt2 = {nodoOrigen,nodoDestino};
        System.out.println(""+auxInt2.toString());
        contenidoArchivoInt.add(auxInt2);

        
        return contenidoArchivoInt;
    }

    private  void clearScreen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }  
}
