import java.util.*;

public class WeightedGraph<T> {
    private int numVertices;
    private HashMap<T, HashSet<Edge<T>>> adjList;

    public WeightedGraph() {
        this.adjList = new HashMap<>();
    }

    public int getNumVertices() {
        return this.numVertices;
    }

    public void addVertex(T vertex) {
        this.adjList.put(vertex, new HashSet<>());
        this.numVertices++;
    }

    public void removeVertex(T vertex) {
        if (!this.adjList.containsKey(vertex)) {
            throw new IllegalArgumentException("The vertex " + vertex + " does not exist in the graph!");
        }
        // remove the vertex
        this.adjList.remove(vertex);
        // remove all edges connected to the vertex
        for (T v : this.adjList.keySet()) {
            this.adjList.get(v).removeIf(element -> element.getSource().equals(v) && element.getDestination().equals(vertex));
        }
        this.numVertices--;
    }

    public void addDirectedEdge(T source, T destination, double weight) {
        if (!this.adjList.containsKey(source)) {
            throw new IllegalArgumentException("The vertex " + source + " does not exist in the graph!");
        }
        if (!this.adjList.containsKey(destination)) {
            throw new IllegalArgumentException("The vertex " + destination + " does not exist in the graph!");
        }

        Edge<T> edge = new Edge<>(source, destination, weight);

        this.adjList.get(source).add(edge);
    }

    public void addUndirectedEdge(T source, T destination, double weight) {
        if (!this.adjList.containsKey(source)) {
            throw new IllegalArgumentException("The vertex " + source + " does not exist in the graph!");
        }
        if (!this.adjList.containsKey(destination)) {
            throw new IllegalArgumentException("The vertex " + destination + " does not exist in the graph!");
        }

        Edge<T> edge1 = new Edge<>(source, destination, weight);
        Edge<T> edge2 = new Edge<>(destination, source, weight);

        this.adjList.get(source).add(edge1);
        this.adjList.get(destination).add(edge2);
    }

    public void removeEdge(T source, T destination) {
        if (!this.adjList.containsKey(source)) {
            throw new IllegalArgumentException("The vertex " + source + " does not exist in the graph!");
        }
        if (!this.adjList.containsKey(destination)) {
            throw new IllegalArgumentException("The vertex " + destination + " does not exist in the graph!");
        }

        // remove for both directed and undirected edges
        this.adjList.get(source).removeIf(element -> element.getSource().equals(source) && element.getDestination().equals(destination));
        this.adjList.get(destination).removeIf(element -> element.getSource().equals(destination) && element.getDestination().equals(source));
    }

    public void bfs(T startVertex) {
        if (!this.adjList.containsKey(startVertex)) {
            throw new IllegalArgumentException("The vertex " + startVertex + " does not exist in the graph!");
        }

        System.out.print("BFS: ");
        Queue<T> q = new LinkedList<>();
        HashSet<T> visited = new HashSet<>();
        q.add(startVertex);
        visited.add(startVertex);
        while (!q.isEmpty()) {
            T ele = q.poll();
            System.out.print(ele + " ");
            for (Edge<T> neighbour : this.adjList.get(ele)) {
                if (!visited.contains(neighbour.getDestination())) {
                    q.add(neighbour.getDestination());
                    visited.add(neighbour.getDestination());
                }
            }
        }
        System.out.println();
    }

    public void dfs(T startVertex) {
        if (!this.adjList.containsKey(startVertex)) {
            throw new IllegalArgumentException("The vertex " + startVertex + " does not exist in the graph!");
        }

        System.out.print("DFS: ");
        Stack<T> stack = new Stack<>();
        HashSet<T> visited = new HashSet<>();
        stack.push(startVertex);
        visited.add(startVertex);
        while (!stack.isEmpty()) {
            T ele = stack.pop();
            System.out.print(ele + " ");

            for (Edge<T> neigbour : this.adjList.get(ele)) {
                if (!visited.contains(neigbour.getDestination())) {
                    stack.push(neigbour.getDestination());
                    visited.add(neigbour.getDestination());
                }
            }
        }
        System.out.println();
    }

    public void dfsRec(T startVertex) {
        if (!this.adjList.containsKey(startVertex)) {
            throw new IllegalArgumentException("The vertex " + startVertex + " does not exist in the graph!");
        }

        System.out.print("DFS: ");
        HashSet<T> visited = new HashSet<>();
        visited.add(startVertex);
        dfsRec(startVertex, visited);
    }

    public void dfsRec(T ele, HashSet<T> visited) {
        System.out.print(ele + " ");

        for (Edge<T> neighbour : this.adjList.get(ele)) {
            if (!visited.contains(neighbour.getDestination())) {
                visited.add(neighbour.getDestination());
                dfsRec(neighbour.getDestination(), visited);
            }
        }
    }

    public void printGraph() {
        System.out.println("Graph: ");
        for (T v : this.adjList.keySet()) {
            System.out.print(v + " -> ");
            for (Edge<T> e : this.adjList.get(v)) {
                System.out.print("{ d: " + e.getDestination() + ", w: " + e.getWeight() + " } ");
            }
            System.out.println();
        }
    }

    private static class Edge<T> {
        private final T source;
        private final T destination;
        private final double weight;

        Edge(T source, T destination, double weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }

        T getSource() {
            return this.source;
        }

        T getDestination() {
            return this.destination;
        }

        double getWeight() {
            return this.weight;
        }
    }
}