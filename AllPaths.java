import java.util.ArrayList;
/*
 * Clase AllPaths
 * Genera de forma backtracking todos los caminos
 * de un nodo A a un nodo B
 */
public class AllPaths {

  public AllPaths(){ };
  
  private void pathsBetweenRec(int curr, int dest, int[][] m, ArrayList<Integer> currentPath, boolean[] visited, ArrayList<ArrayList<Integer>> results) {
    int n = m.length;

    if ((0 <= curr && curr < n) && (0 <= dest && dest < n)) {
      if (curr == dest) {
        // Copia el camino actual
        ArrayList<Integer> correctPath = new ArrayList<>(currentPath);
        correctPath.add(dest);

        // Agrega al resultado
        results.add(correctPath);

        // Termina de buscar
        return;
      }

      // Agrega el vértice actual
      currentPath.add(curr);
      visited[curr] = true;//Se ve los vertices ya visitados 
      
      for (int i = 0; i < n; i++)
        // Si el siguiente nodo es accesible y no visitado
        if (m[curr][i] > 0 && !visited[i]) //Recursivo
          pathsBetweenRec(i, dest, m, currentPath, visited, results);

      // Pop al vértice actual para backtrack
      currentPath.remove(currentPath.size() - 1);
      visited[curr] = false;
    } else {
      throw new IllegalArgumentException();
    }
  }

  public ArrayList<ArrayList<Integer>> pathsBetween(int src, int dest, int[][] m) {
    ArrayList<ArrayList<Integer>> results = new ArrayList<>();

    //si el nodo es el mismo entonces no hay camino
    if (src == dest)
      return results;

    //Crea arreglo de visitados del tamaño de la matriz e inicia proceso de recurrencia
    ArrayList<Integer> currentPath = new ArrayList<>();
    boolean[] visited = new boolean[m.length];

    pathsBetweenRec(src, dest, m, currentPath, visited, results);

    return results;
  }

}
