import java.util.ArrayList;


/* undirectional unweighted graph Code  */
public class GraphFirst {

    static class Edge{
        private int src ; 
        private int dest ; 

        public Edge(int src , int dest){
            this.src = src ;
            this.dest = dest ; 
        }
    }

    public static void printNeighbours(int vertex , ArrayList<Edge>[] graph ){

        for (int i = 0; i < graph[vertex].size() ;  i++) {
            Edge e = graph[2].get(i);
            System.out.print(e.dest + " ");
        }
    }
    
    public static void createGraph(ArrayList<Edge>[] graph){

        for (int i = 0; i < graph.length; i++) {

            graph[i] = new ArrayList<Edge>();

        }

        graph[0].add(new Edge(0 , 2));

        graph[1].add(new Edge(1, 2));
        graph[1].add(new Edge(1, 3));

        graph[2].add(new Edge(2, 1));
        graph[2].add(new Edge(2, 3));
        graph[2].add(new Edge(2, 0));

        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 2));
    }

    public static void main(String[] args) {
     
    /* define the number of vertex  */
    int vertex = 4 ; 

    /* create an List of Lists generally called an Array of Arraylist */

    ArrayList<Edge> graph[] = new ArrayList[vertex];
    GraphFirst.createGraph(graph);

    GraphFirst.printNeighbours(2, graph);

    
    }
}
