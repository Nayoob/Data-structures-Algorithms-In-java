import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class DFS {

    static class Edge{
        private int src ; 
        private int dest;

        public Edge(int src , int dest){
            this.dest = dest ; 
            this.src = src ; 
        }
    }
    
    public static void DepthFirstSearch(ArrayList<Edge>[] graph , int current , boolean[] visitedArr){
        if (visitedArr[current] == false) {
            System.out.print(current + " ");
            visitedArr[current] = true;
            for (int i = 0; i < graph[current].size(); i++) {
                Edge e = graph[current].get(i);
                DepthFirstSearch(graph, e.dest, visitedArr);
            }

        }

    }
    
    public static void createGraph(ArrayList<Edge> graph[]){

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        /* create a graph  */

        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 3));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 4));

        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 4));
        graph[3].add(new Edge(3, 5));
        
        graph[4].add(new Edge(4, 2));
        graph[4].add(new Edge(4, 3));
        graph[4].add(new Edge(4, 5));

        graph[5].add(new Edge(5, 3));
        graph[5].add(new Edge(5, 4));
        graph[5].add(new Edge(5, 6));

        graph[6].add(new Edge(6, 5));


    }    

    public static void main(String[] args) {

        int vertex = 7 ;
        ArrayList<Edge>[] graph = new ArrayList[vertex];
        boolean[] arr = new boolean[vertex];
        Queue<Integer> Queue = new LinkedList<>();
        int current = 0 ;

        
        DFS.createGraph(graph);  
        DFS.DepthFirstSearch(graph , current , arr);  
        
        
        
    }
}
