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
    public Integer[][] getMatrizCamino(){
        Integer matriz[][] = {{0, 1, INF, 1}, 
                         {1, 0, 1, INF}, 
                         {INF, 1, 0, 1}, 
                         {1, INF, 1, 0}};

        FloydWarshall a = new FloydWarshall(4); 
        a.floydWarshall(matriz); 
        return matriz;
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
