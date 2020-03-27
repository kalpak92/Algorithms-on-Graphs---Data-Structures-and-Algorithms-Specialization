import java.util.ArrayList;
import java.util.Scanner;
import java.util.*;

public class Reachability {
    private static int reach(ArrayList<Integer>[] adj, int x, int y) {
        //write your code here
        boolean visited[] = new boolean[adj.length];

        explore(x, visited, adj);

        if (visited[y] == true)
            return 1;

        return 0;
    }

    private static void explore(int v,boolean visited[], ArrayList<Integer>[] adj) 
    { 
        // Mark the current node as visited and print it 
        visited[v] = true;
  
        // Recur for all the vertices adjacent to this vertex 
        Iterator<Integer> i = adj[v].listIterator();

        while (i.hasNext()) 
        { 
            int n = i.next(); 
            if (!visited[n]) 
                explore(n, visited, adj); 
        } 
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        ArrayList<Integer>[] adj = (ArrayList<Integer>[])new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < m; i++) {
            int x, y;
            x = scanner.nextInt();
            y = scanner.nextInt();
            adj[x - 1].add(y - 1);
            adj[y - 1].add(x - 1);
        }
        int x = scanner.nextInt() - 1;
        int y = scanner.nextInt() - 1;
        System.out.println(reach(adj, x, y));
    }
}

