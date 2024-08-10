public class Main {
    public static void main(String[] args) {
        ListGraph<Integer> g = new ListGraph<>();
        g.addVertex(1);
        g.addVertex(2);
        g.addVertex(3);
        g.addVertex(4);
        g.addVertex(5);
        g.addVertex(6);
        g.addEdge(1,6);
        g.addEdge(1,3);
        g.addEdge(1,2);
        g.addEdge(3,5);
        g.addEdge(2,4);
        g.addEdge(4,5);
        g.printGraph();
        g.dfsRec(1);
        g.bfs(1);
    }
}