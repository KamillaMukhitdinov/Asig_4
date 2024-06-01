import java.util.*;

public class Main {
    public static void main(String[] args) {
        WeightedGraph<String> graph = new WeightedGraph<>();
        Vertex<String> almaty = new Vertex<>("Zhezkazgan");
        Vertex<String> astana = new Vertex<>("Astana");
        Vertex<String> shymkent = new Vertex<>("Aktobe");
        Vertex<String> atyrau = new Vertex<>("Almaty");
        Vertex<String> kostanay = new Vertex<>("Ulytau");
        Vertex<String> kyzylorda = new Vertex<>("Almaty");

        graph.addVertex(almaty);
        graph.addVertex(astana);
        graph.addVertex(shymkent);
        graph.addVertex(atyrau);
        graph.addVertex(kostanay);
        graph.addVertex(kyzylorda);

        graph.addEdge(almaty, astana, 1.0);
        graph.addEdge(shymkent, atyrau, 1.0);
        graph.addEdge(atyrau, astana, 1.0);
        graph.addEdge(almaty, shymkent, 1.0);
        graph.addEdge(shymkent, astana, 1.0);
        graph.addEdge(astana, kostanay, 1.0);
        graph.addEdge(shymkent, kyzylorda, 1.0);

        // Perform BFS
        System.out.println("BFS from Almaty:");
        BreadthFirstSearch<String> bfs = new BreadthFirstSearch<>(graph);
        bfs.search(almaty);
        outputPath(bfs, kyzylorda);

        // Perform Dijkstra's search
        System.out.println("Dijkstra from Almaty:");
        DijkstraSearch<String> dijkstra = new DijkstraSearch<>(graph);
        dijkstra.search(almaty);
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