import java.util.List;

public interface Search<V> {
    List<Vertex<V>> getPath(Vertex<V> source, Vertex<V> destination);
}
