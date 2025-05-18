import java.util.*;

public class DijkstraSearch<V> implements Search<V> {
    private Map<Vertex<V>, Double> distances = new HashMap<>();
    private Map<Vertex<V>, Vertex<V>> parentMap = new HashMap<>();

    @Override
    public List<Vertex<V>> getPath(Vertex<V> source, Vertex<V> destination) {
        PriorityQueue<Vertex<V>> pq = new PriorityQueue<>(Comparator.comparingDouble(distances::get));
        Set<Vertex<V>> visited = new HashSet<>();

        for (Vertex<V> vertex : source.getAdjacentVertices().keySet()) {
            distances.put(vertex, Double.MAX_VALUE);
        }
        distances.put(source, 0.0);
        pq.add(source);
        parentMap.put(source, null);

        while (!pq.isEmpty()) {
            Vertex<V> current = pq.poll();

            if (visited.contains(current)) continue;
            visited.add(current);

            for (Map.Entry<Vertex<V>, Double> entry : current.getAdjacentVertices().entrySet()) {
                Vertex<V> neighbor = entry.getKey();
                double newDist = distances.get(current) + entry.getValue();

                if (newDist < distances.getOrDefault(neighbor, Double.MAX_VALUE)) {
                    distances.put(neighbor, newDist);
                    parentMap.put(neighbor, current);
                    pq.add(neighbor);
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
