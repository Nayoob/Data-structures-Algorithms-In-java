
import java.util.ArrayList;
/* code implementation of the undirectional weighted graph  */
public class GraphSecond {

    static class Edge{

        private int src ; 
        private int dest;
        private int weight; 

        public Edge(int src , int dest , int weight){
            this.dest = dest; 
            this.src = src;
            this.weight = weight;
         }
        }

        public static void printNeigbor(int vertex , ArrayList<Edge>[] graph){

            for (int i = 0; i < graph[vertex].size(); i++) {
                Edge e = graph[vertex].get(i);
                System.out.println(e.dest + " " + e.weight);
            }

        }

        public static void createGraph(ArrayList<Edge>[] graph){

          for (int i = 0; i < graph.length; i++) {

             graph[i] = new ArrayList<Edge>();
             
          }
          
          graph[0].add(new Edge(0, 2, 2));
          graph[1].add(new Edge(1, 2, 10));
          graph[1].add(new Edge(1, 3, 0));
          graph[2].add(new Edge(2, 1, 10));
          graph[2].add(new Edge(2, 3, -1));
          graph[2].add(new Edge(2, 0, 2));
          graph[3].add(new Edge(3, 2, -1));
          graph[3].add(new Edge(3, 1, 0));


 
    }
    public static void main(String[] args) {

        int vertex = 4 ;
        ArrayList<Edge> graph[] = new ArrayList[vertex];
        GraphSecond.createGraph(graph);
        GraphSecond.printNeigbor(2, graph);


        
    }
}
