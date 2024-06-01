import java.util.*;

public class DijkstraSearch<V> implements Search<V> {
    private Map<Vertex<V>, Double> distances = new HashMap<>();
    private Map<Vertex<V>, Vertex<V>> previous = new HashMap<>();
    private WeightedGraph<V> graph;

    public DijkstraSearch(WeightedGraph<V> graph) {
        this.graph = graph;
    }

    @Override
    public void search(Vertex<V> start) {
        PriorityQueue<Vertex<V>> priorityQueue = new PriorityQueue<>(Comparator.comparing(distances::get));
        distances.put(start, 0.0);
        priorityQueue.add(start);
        previous.put(start, null);

        while (!priorityQueue.isEmpty()) {
            Vertex<V> current = priorityQueue.poll();
            double currentDistance = distances.get(current);

            current.getAdjacentVertices().forEach((neighbor, weight) -> {
                double newDistance = currentDistance + weight;
                if (newDistance < distances.getOrDefault(neighbor, Double.MAX_VALUE)) {
                    distances.put(neighbor, newDistance);
                    previous.put(neighbor, current);
                    priorityQueue.add(neighbor);
                }
            });
        }
    }

    @Override
    public void search(Vertex<V> start, Vertex<V> target) {
        search(start);
    }

    @Override
    public Map<Vertex<V>, Vertex<V>> getPaths() {
        return previous;
    }
}