import java.util.*;

/*
 * Clase Dijkstra
 */
public class Dijkstra {
    private char[]  nodos;  // Letras de identificación de nodo
    private int[][] dijkstra;  // Matriz de distancias entre nodos
    private String  rutaMasCorta;                           // distancia más corta
    private int     longitudMasCorta = Integer.MAX_VALUE;   // ruta más corta
    private List<NodoDijkstra>  listos = null;                        // NodoDijkstras revisados dijkstra

    //
    // Consctructor
    //
    /*
     * construye el dijkstra con la serie de 
     * identificadores de nodo en una cadena
     */
    public Dijkstra(String serieNodos) {
        nodos = serieNodos.toCharArray();
        dijkstra = new int[nodos.length][nodos.length];
    }

    //
    // Metodos
    //

    /*
     * Funcion que recibe el numero de nodos
     * y los enlaces, y retorna una lista con los caminos mas cortos de
     * un punto a a un punto b
     */
    public List<String> iniciaDijkstra(int numeroNodos, ArrayList<Enlace> nodosEnlazados) {   
        if (nodosEnlazados.isEmpty()) {//Si no recibo enlaces
            return null;
        }

        System.out.println("    ~~~ DIJKSTRA ~~~");   
        List<String> resp;
        Scanner sc = new Scanner(System.in);
        String vertices = "";
        int nV = numeroNodos; //Numero de Vertices
        int nA = nodosEnlazados.size();//Nunero Aristas
        Dijkstra g = null;
        
        
        for (int i = 0; i < nV; i++){            
            vertices = vertices + (i+1);
        }
        
        g = new Dijkstra(vertices);
        
        
        for (int a = 0; a < nA; a++){
            // Nodo inicial
            char inicio = Integer.toString(nodosEnlazados.get(a).getNodoOrigen().getNumeroNodo());
            
            //  Nodo final
            char fin = Integer.toString(nodosEnlazados.get(a).getNodoDestino().getNumeroNodo());
            
            // Peso
            int peso = 1;
            g.agregarRuta(inicio, fin, peso);
        }
        
        char[] dd = vertices.toCharArray();
        
        for (int k=0; k< nV -1; k++) {
            String respuesta = g.encontrarRutaMinimadijkstra(dd[k], dd[k+1]);
            System.out.println(respuesta);
            resp.add(respuesta);
        }
        return resp;        
    }
 
    // asigna el tamaño de la arista entre dos nodos
    public void agregarRuta(char origen, char destino, int distancia) {
        int n1 = posicionNodo(origen);
        int n2 = posicionNodo(destino);        
        dijkstra[n1][n2]=distancia;
        dijkstra[n2][n1]=distancia;
    }
 
    // retorna la posición en el arreglo de un nodo específico
    private int posicionNodo(char nodo) {
        for(int i=0; i<nodos.length; i++) {
            if(nodos[i]==nodo) return i;
        }
        return -1;
    }
     
    // encuentra la ruta más corta desde un nodo origen a un nodo destino
    public String encontrarRutaMinimadijkstra(char inicio, char fin) {
        // calcula la ruta más corta del inicio a los demás
        encontrarRutaMinimadijkstra(inicio);
        // recupera el nodo final de la lista de terminados
        NodoDijkstra tmp = new NodoDijkstra(fin);
        if(!listos.contains(tmp)) {
            System.out.println("Error, nodo no alcanzable");
            return "Bye";
        }
        tmp = listos.get(listos.indexOf(tmp));
        int distancia = tmp.distancia;  
        // crea una pila para almacenar la ruta desde el nodo final al origen
        Stack<NodoDijkstra> pila = new Stack<NodoDijkstra>();
        while(tmp != null) {
            pila.add(tmp);
            tmp = tmp.procedencia;
        }
        String ruta = "";
        // recorre la pila para armar la ruta en el orden correcto
        while(!pila.isEmpty()) ruta+=(pila.pop().id + " ");
        return distancia + ": " + ruta;
    }
 
    // encuentra la ruta más corta desde el nodo inicial a todos los demás
    public void encontrarRutaMinimadijkstra(char inicio) {
        Queue<NodoDijkstra>   cola = new PriorityQueue<NodoDijkstra>(); // cola de prioridad
        NodoDijkstra            ni = new NodoDijkstra(inicio);          // nodo inicial
         
        listos = new LinkedList<NodoDijkstra>();// lista de nodos ya revisados
        cola.add(ni);                   // Agregar nodo inicial a la cola de prioridad
        while(!cola.isEmpty()) {        // mientras que la cola no esta vacia
            NodoDijkstra tmp = cola.poll();     // saca el primer elemento
            listos.add(tmp);            // lo manda a la lista de terminados
            int p = posicionNodo(tmp.id);   
            for(int j=0; j<dijkstra[p].length; j++) {  // revisa los nodos hijos del nodo tmp
                if(dijkstra[p][j]==0) continue;        // si no hay conexión no lo evalua
                if(estaTerminado(j)) continue;      // si ya fue agregado a la lista de terminados
                NodoDijkstra nod = new NodoDijkstra(nodos[j],tmp.distancia+dijkstra[p][j],tmp);
                // si no está en la cola de prioridad, lo agrega
                if(!cola.contains(nod)) {
                    cola.add(nod);
                    continue;
                }
                // si ya está en la cola de prioridad actualiza la distancia menor
                for(Nodo x: cola) {
                    // si la distancia en la cola es mayor que la distancia calculada
                    if(x.id==nod.id && x.distancia > nod.distancia) {
                        cola.remove(x); // remueve el nodo de la cola
                        cola.add(nod);  // agrega el nodo con la nueva distancia
                        break;          // no sigue revisando
                    }
                }
            }
        }
    }
 
    // verifica si un nodo ya está en lista de terminados
    public boolean estaTerminado(int j) {
        NodoDijkstra tmp = new NodoDijkstra(nodos[j]);
        return listos.contains(tmp);
    }
 
    // encontrar la ruta mínima por fuerza bruta
    public void encontrarRutaMinimaFuerzaBruta(char inicio, char fin) {
        int p1 = posicionNodo(inicio);
        int p2 = posicionNodo(fin);
        // cola para almacenar cada ruta que está siendo evaluada
        Stack<Integer> resultado = new Stack<Integer>();
        resultado.push(p1);
        recorrerRutas(p1, p2, resultado);
    }
 
    // recorre recursivamente las rutas entre un nodo inicial y un nodo final
    // almacenando en una cola cada nodo visitado
    private void recorrerRutas(int nodoI, int nodoF, Stack<Integer> resultado) {
        // si el nodo inicial es igual al final se evalúa la ruta en revisión
        if(nodoI == nodoF) {
            int respuesta = evaluar(resultado);
            if(respuesta < longitudMasCorta) {
                longitudMasCorta = respuesta;
                rutaMasCorta     = "";
                for(int x: resultado) rutaMasCorta+=(nodos[x]+" ");
            }
            return;
        }
        // Si el nodoInicial no es igual al final se crea una lista con todos los nodos
        // adyacentes al nodo inicial que no estén en la ruta en evaluación
        List<Integer> lista = new Vector<Integer>();
        for(int i=0; i<dijkstra.length;i++) {
            if(dijkstra[nodoI][i]!=0 && !resultado.contains(i))lista.add(i);
        }
        // se recorren todas las rutas formadas con los nodos adyacentes al inicial
        for(int nodo: lista) {
            resultado.push(nodo);
            recorrerRutas(nodo, nodoF, resultado);
            resultado.pop();
        }
    }
 
    // evaluar la longitud de una ruta
    public int evaluar(Stack<Integer> resultado) {
        int  resp = 0;
        int[]   r = new int[resultado.size()];
        int     i = 0;
        for(int x: resultado) r[i++]=x;
        for(i=1; i<r.length; i++) resp+=dijkstra[r[i]][r[i-1]];
        return resp;
    }
}