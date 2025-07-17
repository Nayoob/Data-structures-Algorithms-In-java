public class GraphMatrix {
    public static void main(String[] args) {
        int vertices = 5; // number of nodes (0 to 4)
        int[][] adjMatrix = new int[vertices][vertices];

        // Add undirected edges
        addEdge(adjMatrix, 0, 1);
        addEdge(adjMatrix, 0, 4);
        addEdge(adjMatrix, 1, 2);
        addEdge(adjMatrix, 1, 3);
        addEdge(adjMatrix, 1, 4);
        addEdge(adjMatrix, 2, 3);
        addEdge(adjMatrix, 3, 4);

        printMatrix(adjMatrix);
    }

    // Add edge for undirected graph (both ways)
    public static void addEdge(int[][] matrix, int u, int v) {
        matrix[u][v] = 1;
        matrix[v][u] = 1; // undirected
    }

    // Print adjacency matrix
    public static void printMatrix(int[][] matrix) {
        System.out.println("Adjacency Matrix:");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
