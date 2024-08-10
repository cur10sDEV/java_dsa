import java.util.*;

public class ListGraph<T> {
    private Map<T, HashSet<T>> adjList;

    public ListGraph() {
        this.adjList = new HashMap<>();
    }

    public void addVertex(T vertex) {
        this.adjList.put(vertex, new HashSet<>());
    }

    public void removeVertex(T vertex) {
        if (!this.adjList.containsKey(vertex)) {
            throw new IllegalArgumentException("The vertex " + vertex + " does not exist in the graph!");
        }

        this.adjList.remove(vertex);
        for (HashSet<T> neighbours : this.adjList.values()) {
            neighbours.remove(vertex);
        }
    }

    public void addEdge(T i, T j) {
        if (!this.adjList.containsKey(i)) {
            throw new IllegalArgumentException("The vertex " + i + " does not exist in the graph!");
        }
        if (!this.adjList.containsKey(j)) {
            throw new IllegalArgumentException("The vertex " + j + " does not exist in the graph!");
        }
        this.adjList.get(i).add(j);
        this.adjList.get(j).add(i);
    }

    public void removeEdge(T i, T j) {
        if (!this.adjList.containsKey(i)) {
            throw new IllegalArgumentException("The vertex " + i + " does not exist in the graph!");
        }
        if (!this.adjList.containsKey(j)) {
            throw new IllegalArgumentException("The vertex " + j + " does not exist in the graph!");
        }
        this.adjList.get(i).remove(j);
        this.adjList.get(j).remove(i);
    }

    public void bfs(T startIndex) {
        if (!this.adjList.containsKey(startIndex)) {
            throw new IllegalArgumentException("The vertex " + startIndex + " does not exist in the graph!");
        }

        System.out.print("BFS: ");

        Queue<T> q = new LinkedList<>();
        HashSet<T> visited = new HashSet<>();
        q.add(startIndex);
        visited.add(startIndex);

        while (!q.isEmpty()) {
            T ele = q.poll();
            System.out.print(ele + " ");
            for (T neighbour : this.adjList.get(ele)) {
                if (!visited.contains(neighbour)) {
                    q.add(neighbour);
                    visited.add(neighbour);
                }
            }
        }
        System.out.println();
    }

    public void dfs(T startIndex) {
        if (!this.adjList.containsKey(startIndex)) {
            throw new IllegalArgumentException("The vertex " + startIndex + " does not exist in the graph!");
        }
        System.out.print("DFS: ");

        Stack<T> stack = new Stack<>();
        HashSet<T> visited = new HashSet<>();
        stack.push(startIndex);
        visited.add(startIndex);

        while (!stack.isEmpty()) {
            T ele = stack.pop();
            System.out.print(ele + " ");
            for (T neighbours : this.adjList.get(ele)) {
                if (!visited.contains(neighbours)) {
                    stack.push(neighbours);
                    visited.add(neighbours);
                }
            }
        }
        System.out.println();
    }

    public void dfsRec(T startIndex) {
        if (!this.adjList.containsKey(startIndex)) {
            throw new IllegalArgumentException("The vertex " + startIndex + " does not exist in the graph!");
        }
        System.out.print("DFS: ");
        HashSet<T> visited = new HashSet<>();
        visited.add(startIndex);
        dfsRec(startIndex, visited);
        System.out.println();
    }

    private void dfsRec(T ele, HashSet<T> visited) {
        System.out.print(ele + " ");

        for (T neighbour : this.adjList.get(ele)) {
            if (!visited.contains(neighbour)) {
                visited.add(neighbour);
                dfsRec(neighbour, visited);
            }
        }
    }

    public void printGraph() {
        for (T vertex : this.adjList.keySet()) {
            System.out.print(vertex + " -> ");
            for (T edge : this.adjList.get(vertex)) {
                System.out.print(edge + " ");
            }
            System.out.println();
        }
    }
}
