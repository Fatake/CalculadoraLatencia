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
    public LectorArchivo() { };

    /*
     * LeerArchivo Guarda en forma de String todas las lineas
     * leidas del archivo en el atributo contenidoArchivo
     * recibe:
     * * String fileName
     * 
     */
    public boolean leerArchivo(String fileName){
        boolean bandera = false;
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
        bandera = true;
        return bandera;
    }

    /*
     * procesaArchivo procesa el atributo contenidoArchivo quitanto comas y
     * convietiendo los campos a floats
     * Retorna:
     * ArrayList<Float[]>
     */
    public ArrayList<Float[]> procesaArchivo(){
        if (contenidoArchivo.isEmpty()) {//Si no tiene campos
            return null;
        }
        
        int contador = 0;
        String aux = contenidoArchivo.get(contador);
        String aux2[] = aux.split(",");

        //Se Obtienen el numero de nodos y el numero de enlaces
        Float numNodos   = Float.parseFloat(aux2[0]);
        Float numEnlaces = Float.parseFloat(aux2[1]);
        Float auxFloat[] = {numNodos,numEnlaces};
        //System.out.println("Nodos:"+auxFloat[0]+" Enlaces:"+auxFloat[1]);
        contenidoArchivoInt.add(auxFloat);

        contador++;

        //
        // Nodos y tiempo de cola
        //
        for (int i = contador; i <= numNodos.intValue(); i++) {//Para los n nodos
            aux = contenidoArchivo.get(i);//Optiene todo el string
            aux2 = aux.split(",");//Separa en n string sin ","
            Float nodo = Float.parseFloat(aux2[0]);
            Float tiem = Float.parseFloat(aux2[1]);

            Float auxFloat1[] = {nodo,tiem};
            //System.out.println("Nodo: "+auxFloat1[0]+" TC: "+auxFloat1[1]);
            contenidoArchivoInt.add(auxFloat1);//Agrega a la lista ligada
            contador++;
            
        }
         
        //
        //Enlaces nOrigen, nDestino, VelocidadEnlace, Distancia, DC, DU
        //
        int paro = numEnlaces.intValue()+contador;  
        for (int i = contador; i < paro; i++) {
            aux = contenidoArchivo.get(i);
            aux2 = aux.split(",");
            Float nOrigen         = Float.parseFloat(aux2[0]);
            Float nDestino        = Float.parseFloat(aux2[1]);
            Float velocidadEnlace = Float.parseFloat(aux2[2]);
            Float distancia       = Float.parseFloat(aux2[3]);
            Float DC              = Float.parseFloat(aux2[4]);
            Float DU              = Float.parseFloat(aux2[5]);

            Float auxFloat1[] = {nOrigen,nDestino,velocidadEnlace,distancia,DC,DU};
            /*
            System.out.println("NO: "+auxFloat1[0]+
                               " ND: "+auxFloat1[1]+
                               " VE: "+auxFloat1[2]+
                               " Di: "+auxFloat1[3]+
                               " DC: "+auxFloat1[4]+
                               " DU: "+auxFloat1[5]);
                               */
            
            //Agrega al arreglo de float
            contenidoArchivoInt.add(auxFloat1);
            contador++;
        }

        //
        // Tamanio de Paquetes
        //
        aux = contenidoArchivo.get(contador);
        Float auxInt1[] = {Float.parseFloat(aux)};
        //System.out.println("TP: "+auxInt1[0]);

        contenidoArchivoInt.add(auxInt1);
        contador++;

        //
        // Nodo A, Nodo B || Destino-Fin
        //
        aux = contenidoArchivo.get(contador);
        aux2 = aux.split(",");
        Float nodoOrigen = Float.parseFloat(aux2[0]);
        Float nodoDestino= Float.parseFloat(aux2[1]);
        Float auxInt2[] = {nodoOrigen,nodoDestino};

        //System.out.println("NOrigen: "+auxInt2[0]+" NDestino: "+auxInt2[1]);
        contenidoArchivoInt.add(auxInt2);

        
        return contenidoArchivoInt;
    }
}
