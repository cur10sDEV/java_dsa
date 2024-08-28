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
        System.out.println();
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

    // topo sort - dfs
    public T[] sort() {
        HashSet<T> visited = new HashSet<>();
        Stack<T> stack = new Stack<>();

        for (T ele : this.adjList.keySet()) {
            if (!visited.contains(ele)) {
                sort(ele, stack, visited);
            }
        }

        T[] sorted = (T[]) new Object[this.getNumVertices()];
        int i = 0;
        while (!stack.isEmpty()) {
            T ele = stack.pop();
            sorted[i++] = ele;
        }

        return sorted;
    }

    private void sort(T ele, Stack<T> stack, HashSet<T> visited) {
        visited.add(ele);

        for (Edge<T> neighbour : this.adjList.get(ele)) {
            if (!visited.contains(neighbour.destination)) {
                sort(neighbour.destination, stack, visited);
            }
        }

        stack.push(ele);
    }

    // topo sort - bfs - # Kahn's Algorithm #
    public T[] sortByBfs() {
        // to store in degrees of vertices
        HashMap<T, Integer> indegree = new HashMap<>();

        // calculate the in-degrees of all the vertices
        for (T ele : this.adjList.keySet()) {
            // handling vertices with zero in-degree
            if (!indegree.containsKey(ele)) {
                indegree.put(ele, 0);
            }
            for (Edge<T> edge : this.adjList.get(ele)) {
                indegree.put(edge.destination, indegree.getOrDefault(edge.destination, 0) + 1);
            }
        }

        Queue<T> q = new LinkedList<>();
        // add all vertices having indegree 0 to queue
        for (T ele : indegree.keySet()) {
            if (indegree.get(ele) == 0) {
                q.add(ele);
            }
        }

        T[] sorted = (T[]) new Object[this.getNumVertices()];
        int i = 0;
        while (!q.isEmpty()) {
            T ele = q.poll();
            sorted[i++] = ele;

            for (Edge<T> neighbour : this.adjList.get(ele)) {
                // decrement the degree
                indegree.put(neighbour.destination, indegree.get(neighbour.destination) - 1);
                // if in-degree == 0 then add to queue
                if (indegree.get(neighbour.destination) == 0) {
                    q.add(neighbour.destination);
                }
            }
        }

        return sorted;
    }

    public Map<T, Double> printShortestDistances(T source) {
        PriorityQueue<Pair<T>> pq = new PriorityQueue<>((a, b) -> (int) (a.getDist() - b.getDist()));
        Map<T, Double> dist = new HashMap<>();

        for (T node : this.adjList.keySet()) {
            dist.put(node, Double.MAX_VALUE);
        }

        pq.add(new Pair<>(source, 0));
        dist.put(source, 0.0);

        while (!pq.isEmpty()) {
            Pair<T> ele = pq.poll();
            T node = ele.getNode();
            double distSoFar = ele.getDist();

            for (Edge<T> neighbour : this.adjList.get(node)) {
                if (distSoFar + neighbour.getWeight() < dist.get(neighbour.getDestination())) {
                    dist.put(neighbour.getDestination(), distSoFar + neighbour.getWeight());
                    pq.add(new Pair<>(neighbour.getDestination(), dist.get(neighbour.getDestination())));
                }
            }
        }

        return dist;
    }

    public boolean detectCycle() {
        HashSet<T> visited = new HashSet<>();
        HashSet<T> pathVisited = new HashSet<>();

        for (T ele : this.adjList.keySet()) {
            if (!visited.contains(ele)) {
                if (dfsCheck(ele, visited, pathVisited)) return true;
            }
        }
        return false;
    }

    private boolean dfsCheck(T ele, HashSet<T> visited, HashSet<T> pathVisited) {
        visited.add(ele);
        pathVisited.add(ele);

        for (Edge<T> edge : this.adjList.get(ele)) {
            if (!visited.contains(edge.destination)) {
                if (dfsCheck(edge.destination, visited, pathVisited)) return true;
            } else if (pathVisited.contains(edge.destination)) return true;
        }

        pathVisited.remove(ele);
        return false;
    }

    // using Kahn's algorithm
    public boolean detectCycleByBfs() {
        // to store in degrees of vertices
        HashMap<T, Integer> indegree = new HashMap<>();

        // calculate the in-degrees of all the vertices
        for (T ele : this.adjList.keySet()) {
            // handling vertices with zero in-degree
            if (!indegree.containsKey(ele)) {
                indegree.put(ele, 0);
            }
            for (Edge<T> edge : this.adjList.get(ele)) {
                indegree.put(edge.destination, indegree.getOrDefault(edge.destination, 0) + 1);
            }
        }

        Queue<T> q = new LinkedList<>();
        // add all vertices having indegree 0 to queue
        for (T ele : indegree.keySet()) {
            if (indegree.get(ele) == 0) {
                q.add(ele);
            }
        }

        int count = 0;
        while (!q.isEmpty()) {
            T ele = q.poll();
            count++;

            for (Edge<T> neighbour : this.adjList.get(ele)) {
                // decrement the degree
                indegree.put(neighbour.destination, indegree.get(neighbour.destination) - 1);
                // if in-degree == 0 then add to queue
                if (indegree.get(neighbour.destination) == 0) {
                    q.add(neighbour.destination);
                }
            }
        }

        // if no cycle then topo sort will have all the vertices as it only works with DAG
        // but if there is one then it will not have all the vertices hence the count will be different
        return count == this.getNumVertices();
    }

    public int colorGraph() {
        // to store colors assigned to every vertex
        Map<T, Integer> colorMap = new HashMap<>();
        int maxColors = 0;
        for (T vertex : this.adjList.keySet()) {
            // store neighbours colors
            HashSet<Integer> neighbourColors = new HashSet<>();
            for (Edge<T> neighbour : this.adjList.get(vertex)) {
                if (colorMap.containsKey(neighbour.destination)) {
                    neighbourColors.add(colorMap.get(neighbour.destination));
                }
            }

            // check if the colors matched if then increment
            int color = 1;
            while (neighbourColors.contains(color)) {
                color++;
            }
            maxColors = Math.max(color, maxColors);
            colorMap.put(vertex, color);
        }
        // return the min colors used to color the graph
        return maxColors;
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

    private class Pair<T> {
        private final T node;
        private final double dist;

        Pair(T node, double dist) {
            this.dist = dist;
            this.node = node;
        }

        T getNode() {
            return this.node;
        }

        double getDist() {
            return this.dist;
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