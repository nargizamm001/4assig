import java.util.List;

public class Main {
    public static void main(String[] args) {
        Vertex<String> A = new Vertex<>("A");
        Vertex<String> B = new Vertex<>("B");
        Vertex<String> C = new Vertex<>("C");
        Vertex<String> D = new Vertex<>("D");
        Vertex<String> E = new Vertex<>("E");

        WeightedGraph<String> graph = new WeightedGraph<>();
        graph.addEdge(A, B, 1);
        graph.addEdge(A, C, 4);
        graph.addEdge(B, C, 2);
        graph.addEdge(B, D, 5);
        graph.addEdge(C, D, 1);
        graph.addEdge(D, E, 3);

        System.out.println("=== BFS ===");
        Search<String> bfs = new BreadthFirstSearch<>();
        List<Vertex<String>> bfsPath = bfs.getPath(A, E);
        bfsPath.forEach(v -> System.out.print(v + " "));

        System.out.println("\n=== Dijkstra ===");
        Search<String> dijkstra = new DijkstraSearch<>();
        List<Vertex<String>> dijkstraPath = dijkstra.getPath(A, E);
        dijkstraPath.forEach(v -> System.out.print(v + " "));
    }
}
