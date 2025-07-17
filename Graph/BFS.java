import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {

    private boolean[] vistedArr ;
    private Queue<Integer> BfsQueue ; 

    public BFS(int sizeofArray){

      BfsQueue = new LinkedList<>();
      vistedArr = new boolean[sizeofArray];

    }

    /* lets implemetn Breadth first search Using Queue  */

    static class Edge{
        private int src ; 
        private int dest;

        public Edge(int src , int dest){
            this.dest = dest ; 
            this.src = src ; 
        }
    }

    public void BreadthFirstSearch(ArrayList<Edge>[] Graph){
     
       BfsQueue.offer(1);

       while ( !BfsQueue.isEmpty() ) {
          int current = BfsQueue.poll();

          if (vistedArr[current] == false) {
            
                System.out.print(current + " ");
                vistedArr[current] = true;
                 /* get current getNeighbors pushed to stack */
                for (int i = 0; i < Graph[current].size(); i++) {
                    Edge e = Graph[current].get(i);
                    BfsQueue.offer(e.dest);      
                }
          }

       }   
    }

    public static void getNeighbors(ArrayList<Edge>[] graph){
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].size(); j++) {
                Edge e = graph[i].get(j);
                System.out.println( "vertex:" + i + " " + e.dest);
            }
        }
    }

    public static void createGraph(ArrayList<Edge>[] graph){

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
        
        BFS.createGraph(graph);

        BFS.getNeighbors(graph);


        /* bfs serach  */
        BFS bfs = new BFS(vertex);
        bfs.BreadthFirstSearch(graph);


        
    }
}
