public class Main {
    public static void main(String[] args) {
        WeightedGraph<Integer> wg = new WeightedGraph<>();
        wg.addVertex(1);
        wg.addVertex(2);
        wg.addVertex(3);
        wg.addVertex(4);
        wg.addVertex(5);
        wg.addVertex(6);
        wg.addUndirectedEdge(1, 6, 7);
        wg.addUndirectedEdge(1, 3, 4);
        wg.addUndirectedEdge(1, 2, 3);
        wg.addDirectedEdge(3, 5, 6);
        wg.addUndirectedEdge(2, 4, 9);
        wg.addUndirectedEdge(4, 5, 2);
        wg.removeEdge(4, 5);
        wg.printGraph();
        wg.bfs(1);
        wg.dfs(1);
        wg.dfsRec(1);
    }
}