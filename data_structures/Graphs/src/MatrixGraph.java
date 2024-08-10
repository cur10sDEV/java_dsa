import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class MatrixGraph {
    private int numVertices;
    private int[][] adjMatrix;

    public MatrixGraph(int numVertices) {
        this.numVertices = numVertices + 1;
        this.adjMatrix = new int[numVertices + 1][numVertices + 1];
    }

    public void addVertex() {
        int[][] newAdjMatrix = new int[this.numVertices + 1][this.numVertices + 1];
        for (int i = 0; i < this.numVertices; i++) {
            for (int j = 0; j < this.numVertices; j++) {
                newAdjMatrix[i][j] = adjMatrix[i][j];
            }
        }

        this.adjMatrix = newAdjMatrix;
        this.numVertices++;
    }

    public void removeVertex(int v) {
        if (v < 1 && v >= this.numVertices) {
            throw new IllegalArgumentException("This vertex " + v + " does not exist in the graph!");
        }
        int[][] newAdjMatrix = new int[this.numVertices - 1][this.numVertices - 1];
        int newI = 0, newJ;

        for (int i = 0; i < this.numVertices; i++) {
            if (i == v) continue;
            newJ = 0;
            for (int j = 0; j < this.numVertices; j++) {
                if (j == v) continue;
                newAdjMatrix[newI][newJ] = adjMatrix[i][j];
                newJ++;
            }
            newI++;
        }

        this.adjMatrix = newAdjMatrix;
        this.numVertices--;
    }


    public void addEdge(int i, int j) {
        if (i < 1 && i >= this.numVertices) {
            throw new IllegalArgumentException("This vertex " + i + " does not exist in the graph!");
        }
        if (j < 1 && j >= this.numVertices) {
            throw new IllegalArgumentException("This vertex " + j + " does not exist in the graph!");
        }
        this.adjMatrix[i][j] = 1;
        this.adjMatrix[j][i] = 1;

    }

    public void removeEdge(int i, int j) {
        if (i < 1 && i >= this.numVertices) {
            throw new IllegalArgumentException("This vertex " + i + " does not exist in the graph!");
        }
        if (j < 1 && j >= this.numVertices) {
            throw new IllegalArgumentException("This vertex " + j + " does not exist in the graph!");
        }
        this.adjMatrix[i][j] = 0;
        this.adjMatrix[j][i] = 0;
    }

    public void bfs(int startVertex) {
        if (startVertex < 1 && startVertex >= this.numVertices) {
            throw new IllegalArgumentException("This vertex " + startVertex + " does not exist in the graph!");
        }
        System.out.print("BFS: ");
        HashSet<Integer> visited = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        q.add(startVertex);
        visited.add(startVertex);
        while (!q.isEmpty()) {
            int ele = q.poll();
            System.out.print(ele + " ");
            for (int i = 1; i < this.numVertices; i++) {
                if (this.adjMatrix[ele][i] == 1 && !visited.contains(i)) {
                    q.add(i);
                    visited.add(i);
                }
            }
        }
        System.out.println();
    }

    public void dfs(int startVertex) {
        if (startVertex < 1 && startVertex >= this.numVertices) {
            throw new IllegalArgumentException("This vertex " + startVertex + " does not exist in the graph!");
        }
        System.out.print("DFS: ");
        HashSet<Integer> visited = new HashSet<>();
        Stack<Integer> stack = new Stack<>();
        stack.push(startVertex);
        visited.add(startVertex);
        while (!stack.empty()) {
            int ele = stack.pop();
            System.out.print(ele + " ");
            for (int i = 1; i < this.numVertices; i++) {
                if (this.adjMatrix[ele][i] == 1) {
                    if (!visited.contains(i)) {
                        stack.push(i);
                        visited.add(i);
                    }
                }
            }
        }
        System.out.println();
    }

    public void dfsRec(int startVertex) {
        if (startVertex < 1 && startVertex >= this.numVertices) {
            throw new IllegalArgumentException("This vertex " + startVertex + " does not exist in the graph!");
        }
        System.out.print("DFS: ");
        HashSet<Integer> visited = new HashSet<>();
        visited.add(startVertex);
        dfsRec(startVertex, visited);
        System.out.println();

    }

    private void dfsRec(int vertex, HashSet<Integer> visited) {
        System.out.print(vertex + " ");
        for (int i = 1; i < this.numVertices; i++) {
            if (this.adjMatrix[vertex][i] == 1) {
                if (!visited.contains(i)) {
                    visited.add(i);
                    dfsRec(i, visited);
                }
            }
        }
    }

    public void printGraph() {
        System.out.println("Adjacency Matrix:");
        for (int i = 0; i < this.numVertices; i++) {
            if (i == 0) System.out.print(" ".repeat((int) Math.log10(this.numVertices) + 1) + "    ");
            else System.out.print(i + "  ");
        }
        System.out.println();
        for (int i = 1; i < this.numVertices; i++) {
            System.out.print(i + " -> ");
            for (int j = 1; j < this.numVertices; j++) {
                System.out.print(adjMatrix[i][j] + "  ");
            }
            System.out.println();
        }
    }

}


