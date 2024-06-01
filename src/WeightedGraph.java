import java.util.HashSet;
import java.util.Set;

public class WeightedGraph<V> {
    private Set<Vertex<V>> vertices;

    public WeightedGraph() {
        this.vertices = new HashSet<>();
    }

    public void addVertex(Vertex<V> vertex) {
        vertices.add(vertex);
    }

    public Set<Vertex<V>> getVertices() {
        return vertices;
    }

    public void addEdge(Vertex<V> from, Vertex<V> to, double weight) {
        from.addAdjacentVertex(to, weight);
        to.addAdjacentVertex(from, weight);
    }
}