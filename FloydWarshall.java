import java.util.*; 
import java.lang.*; 
import java.io.*; 

/*
 * Clase FloydWarshall
 * El algoritmo encuentra el 
 * camino entre todos los pares 
 * de vértices en una única ejecución
 * 
 */
class FloydWarshall { 
    private final static Integer INF = 99999;
    private Integer vertices;

    //
    // Constructor
    //
    public FloydWarshall(Integer numeroVertices){
        this.vertices = numeroVertices;
    }
    //
    // Metodos
    //
    public void floydWarshall(Integer graph[][]) { 
        Integer dist[][] = new Integer[vertices][vertices]; 
        Integer i, j, k; 
  
        /* 
           Inicialice la matriz de solución igual que
           la matriz del grafo de entrada.
           O podemos decir que los valores iniciales de 
           distancias más cortas se basan en caminos más 
           cortos sin considerar ningún vértice intermedio.
        */
        for (i = 0; i < vertices; i++) 
            for (j = 0; j < vertices; j++) 
                dist[i][j] = graph[i][j]; 
  
        /* 
            Agregue todos los vértices uno por uno
            al conjunto de vértices intermedios.

            ---> Antes de comenzar una iteración, 
            tenemos distancias más cortas entre todos 
            los pares de vértices, de modo que las 
            distancias más cortas consideren solo los 
            vértices del conjunto {0, 1, 2, .. k-1} como vértices intermedios.

            ----> Después del final de una iteración, 
            el vértice no. k se agrega al conjunto de 
            vértices intermedios y el conjunto se 
            convierte en {0, 1, 2, .. k}
        */
        for (k = 0; k < vertices; k++) { 
            // Elige todos los vértices como fuente uno por uno 
            for (i = 0; i < vertices; i++) { 
                // Elija todos los vértices como destino 
                // para la fuente elegida anteriormente
                for (j = 0; j < vertices; j++) { 
                    // Si el vértice k está en la ruta más 
                    // corta de i a j, actualice el valor de dist [i] [j]
                    if (dist[i][k] + dist[k][j] < dist[i][j]) 
                        dist[i][j] = dist[i][k] + dist[k][j]; 
                } 
            } 
        } 
  
        //Solucion
        printSolution(dist); 
    } 
  
    public void printSolution(Integer dist[][]) { 
        System.out.println("La siguiente matriz muestra las distancias "
        + "más cortas entre cada par de vértices. ");
        for (Integer i=0; i<vertices; ++i) { 
            for (Integer j=0; j<vertices; ++j) { 
                if (dist[i][j]==INF) 
                    System.out.print("00 "); 
                else
                    System.out.print(dist[i][j]+"   "); 
            } 
            System.out.println(); 
        } 
    } 
  
    //
    // Main
    //
    public static void main (String[] args) { 
        Integer graph[][] = { {0, 1, INF, 1}, 
                            {1, 0, 1, INF}, 
                            {INF, 1, 0, 1}, 
                            {1, INF, 1, 0} 
                        }; 
        
        FloydWarshall a = new FloydWarshall(4); 
        a.floydWarshall(graph); 
    } 
} 
