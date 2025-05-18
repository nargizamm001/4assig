import java.util.*;

public class BreadthFirstSearch<V> implements Search<V> {
    private Map<Vertex<V>, Vertex<V>> parentMap = new HashMap<>();

    @Override
    public List<Vertex<V>> getPath(Vertex<V> source, Vertex<V> destination) {
        Queue<Vertex<V>> queue = new LinkedList<>();
        Set<Vertex<V>> visited = new HashSet<>();
        queue.add(source);
        visited.add(source);
        parentMap.put(source, null);

        while (!queue.isEmpty()) {
            Vertex<V> current = queue.poll();
            if (current.equals(destination)) break;

            for (Vertex<V> neighbor : current.getAdjacentVertices().keySet()) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    parentMap.put(neighbor, current);
                    queue.add(neighbor);
                }
            }
        }

        return reconstructPath(destination);
    }

    private List<Vertex<V>> reconstructPath(Vertex<V> dest) {
        List<Vertex<V>> path = new LinkedList<>();
        for (Vertex<V> at = dest; at != null; at = parentMap.get(at)) {
            path.add(0, at);
        }
        return path;
    }
}
