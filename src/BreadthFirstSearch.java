import java.util.*;

public class BreadthFirstSearch<V> implements Search<V> {
    private Map<Vertex<V>, Vertex<V>> paths = new HashMap<>();
    private WeightedGraph<V> graph;

    public BreadthFirstSearch(WeightedGraph<V> graph) {
        this.graph = graph;
    }

    @Override
    public void search(Vertex<V> start) {
        Queue<Vertex<V>> queue = new LinkedList<>();
        Set<Vertex<V>> visited = new HashSet<>();
        queue.add(start);
        visited.add(start);
        paths.put(start, null);

        while (!queue.isEmpty()) {
            Vertex<V> current = queue.poll();

            for (Map.Entry<Vertex<V>, Double> entry : current.getAdjacentVertices().entrySet()) {
                Vertex<V> neighbor = entry.getKey();
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    paths.put(neighbor, current);
                    queue.add(neighbor);
                }
            }
        }
    }

    @Override
    public void search(Vertex<V> start, Vertex<V> target) {
        search(start);
    }

    @Override
    public Map<Vertex<V>, Vertex<V>> getPaths() {
        return paths;
    }
}