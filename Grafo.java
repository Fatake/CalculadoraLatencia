import java.util.*;

/**
 * Class Nodo
 */
public class Grafo {
	//
	// Fields
    //
    private final static Integer INF = 99999;
    private Integer numeroNodos;
    private Integer numeroEnlaces;
    private ArrayList<Nodo> nodos = new ArrayList<Nodo>();
    private ArrayList<Enlace> enlaces = new ArrayList<Enlace>();
    private Integer tamArchivo;
    private Integer nodoOrigen;
    private Integer nodoDestino;
    private Integer matrizCamino[][];
  
	//
	// Constructors
	//
	public Grafo (ArrayList<Float []> informacion) {
        int contador = 0;
        this.numeroNodos   = informacion.get(contador)[0].intValue();
        this.numeroEnlaces = informacion.get(contador)[1].intValue();
        contador++;

        //Obtiene Paquetes
        int paro = numeroNodos+contador;
        for (int i = contador; i < paro; i++) {
            Float    aux[]  = informacion.get(i);
            Integer numNodo = aux[0].intValue();
            Float  timeCola = aux[1];

            this.nodos.add(new Nodo(numNodo, timeCola));
            contador++;
        }

        //Obtiene los enlaces
        paro = numeroEnlaces+contador; 
        for (int i = contador ; i < paro; i++) {
            Float   aux[] = informacion.get(i);
            Enlace  auxEn = null;
            Nodo    aux1N = null;
            Nodo    aux2N = null;

            //Separar la informacion 
            Integer nodoOrigen  = aux[0].intValue();
            Integer nodoDestino = aux[1].intValue();
            Float velocidadEnla = aux[2];
            Float distancia     = aux[3];
            Integer dc          = aux[4].intValue();
            Integer du          = aux[5].intValue();

            // Busca El nodo Origen
            for (int j = 0; j < this.numeroNodos ; j++) {
                if ((j+1) == nodoOrigen) {
                    aux1N = this.nodos.get(j);
                    break;
                }
            }

            //Busca el Nodo Destino
            for (int j = 0; j < this.numeroNodos ; j++) {
                if ((j+1) == nodoDestino) {
                    aux2N = this.nodos.get(j);
                    break;
                }
            }

            //Establece los Dc y DU del nodo destino
            aux2N.tamPaquete.reSize(dc, du);

            auxEn = new Enlace(aux1N, aux2N, velocidadEnla, distancia);

            this.enlaces.add(auxEn);
            contador++;
        }

        //Obtiene El tamaño del arrchivo y lo convierte a Bytes
        Float aux = informacion.get(contador)[0];//Auxiliar que tiene los Gb
        aux = aux*(1024*1024);//Convierte de Gbytes a Bytes
        this.tamArchivo = aux.intValue();
        contador++;

        //Cambia el nodo destino y origen de DC y DU a 0
        aux = informacion.get(contador)[0];//Nodo Origen 
        this.nodoOrigen  = aux.intValue();
        aux = informacion.get(contador)[1];//Nodo Destino
        this.nodoDestino = aux.intValue();

        for (int i = 0; i < this.enlaces.size(); i++) {
            if (this.enlaces.get(i).getNodoOrigen().getNumeroNodo() == nodoOrigen) {
                this.enlaces.get(i).getNodoOrigen().tamPaquete.setSizeZero();
                break;
            }
        }

        for (int i = 0; i < this.enlaces.size(); i++) {
            if (this.enlaces.get(i).getNodoDestino().getNumeroNodo() == nodoDestino) {
                this.enlaces.get(i).getNodoDestino().tamPaquete.setSizeZero();
                break;
            }
        }
    }
  
	//
	// Methods
    //
    
    /*
     * Retorna la matriz de caminos
     */
    public Integer[][] getMatriz(){
        matrizCamino = new Integer[numeroNodos][numeroNodos];
        
        //Poner la matriz en infinito y en 0s la diagonal
        for (int i = 0; i < matrizCamino.length; i++) {
            for (int j = i; j < matrizCamino.length; j++) {
                if (i == j) {
                    matrizCamino[i][j] = 0;
                } else {//Si existe relacion o no relacion
                    for (int k = 0; k < enlaces.size(); k++) { //Para cada enlace
                        if (enlaces.get(k).getNodoOrigen().getNumeroNodo()-1 == i &&
                            enlaces.get(k).getNodoDestino().getNumeroNodo()-1 == j) {
                                //Si existe una relacion
                                matrizCamino[i][j] = 1;
                                matrizCamino[j][i] = 1;
                                break;
                        }else{
                            matrizCamino[i][j] = INF;
                            matrizCamino[j][i] = INF;
                        }
                    }
                }
            }
        }
        return matrizCamino;
    }
    
    public void setMatriz(Integer newMat[][]){
        this.matrizCamino = newMat;
    }

    public Integer getNumeroNodos(){
        return this.numeroNodos;
    }

    public void printMatriz(){
        for (Integer i=0; i<matrizCamino.length; ++i) { 
            for (Integer j=0; j<matrizCamino.length; ++j) { 
                if (matrizCamino[i][j]==INF) 
                    System.out.print("I "); 
                else
                    System.out.print(matrizCamino[i][j]+"   "); 
            } 
            System.out.println(); 
        } 
    }
    
    public void printInfo(){
        System.out.println("#Nodos: "+numeroNodos);
        System.out.println("#Enlaces: "+numeroEnlaces);

        System.out.println("\n<<------------------------------>>");
        for (Nodo node : nodos) {
            System.out.println("#Nodo: "+node.getNumeroNodo()+" TC: "+node.getTiempoCola());
        }

        System.out.println("\n<<------------------------------>>");
        for (Enlace lace : enlaces) {
            System.out.println("NO: "+lace.getNodoOrigen().getNumeroNodo()
                              +" ND: "+lace.getNodoDestino().getNumeroNodo()
                              +" Vel: "+lace.getVelocidadEnlace()
                              +" Dis: "+lace.getDistancia()
                              +" DC dest: "+lace.getNodoDestino().tamPaquete.getDatosControl()
                              +" Du dest: "+lace.getNodoDestino().tamPaquete.getDatosUsuario()
                                );
        }

        System.out.println("\n<<------------------------------>>");
        Float aux = tamArchivo.floatValue()/(1024*1024);
        System.out.println("Tamañio Archivo: "+aux+"Gb = "+tamArchivo+" Bytes");
        System.out.println("Nodo Inico: "+nodoOrigen+" Nodo Fin: "+nodoDestino);
    }
}
