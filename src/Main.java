import java.util.*;

public class Main {
    public static void main(String[] args) {
        WeightedGraph<String> graph = new WeightedGraph<>();
        Vertex<String> Zhezkazgan = new Vertex<>("Zhezkazgan");
        Vertex<String> astana = new Vertex<>("Astana");
        Vertex<String> aktobe = new Vertex<>("Aktobe");
        Vertex<String> almaty = new Vertex<>("Almaty");
        Vertex<String> ulytau = new Vertex<>("Ulytau");
        Vertex<String> kyzylorda = new Vertex<>("Kyzylorda");

        graph.addVertex(Zhezkazgan);
        graph.addVertex(astana);
        graph.addVertex(aktobe);
        graph.addVertex(almaty);
        graph.addVertex(ulytau);
        graph.addVertex(kyzylorda);

        graph.addEdge(Zhezkazgan, astana, 1.0);
        graph.addEdge(aktobe, almaty, 1.0);
        graph.addEdge(almaty, astana, 1.0);
        graph.addEdge(Zhezkazgan, aktobe, 1.0);
        graph.addEdge(aktobe, astana, 1.0);
        graph.addEdge(astana, ulytau, 1.0);
        graph.addEdge(aktobe, kyzylorda, 1.0);

        // Perform BFS
        System.out.println("BFS from Almaty:");
        BreadthFirstSearch<String> bfs = new BreadthFirstSearch<>(graph);
        bfs.search(Zhezkazgan);
        outputPath(bfs, kyzylorda);

        // Perform Dijkstra's search
        System.out.println("Dijkstra from Almaty:");
        DijkstraSearch<String> dijkstra = new DijkstraSearch<>(graph);
        dijkstra.search(Zhezkazgan);
        outputPath(dijkstra, kyzylorda);
    }

    public static void outputPath(Search<String> search, Vertex<String> target) {
        Map<Vertex<String>, Vertex<String>> paths = search.getPaths();
        if (paths.containsKey(target)) {
            System.out.println("Path to " + target.getData() + ":");
            List<String> path = new ArrayList<>();
            for (Vertex<String> at = target; at != null; at = paths.get(at)) {
                path.add(at.getData());
            }
            Collections.reverse(path);
            System.out.println(String.join(" -> ", path));
        } else {
            System.out.println(target.getData() + " not found.");
        }
    }
}
