public class Main {
    public static void main(String[] args) {
        WeightedGraph<Integer> wg = new WeightedGraph<>();
        wg.addVertex(1);
        wg.addVertex(2);
        wg.addVertex(3);
        wg.addVertex(4);
        wg.addVertex(5);
        wg.addVertex(6);
        wg.addVertex(7);
        wg.addVertex(8);
        wg.addVertex(9);
        wg.addVertex(10);
//        wg.addUndirectedEdge(1, 2, 7);
//        wg.addUndirectedEdge(1, 3, 9);
//        wg.addUndirectedEdge(1, 5, 3);
//        wg.addUndirectedEdge(2, 3, 8);
//        wg.addUndirectedEdge(2, 5, 13);
//        wg.addUndirectedEdge(3, 4, 4);
//        wg.addUndirectedEdge(3, 7, 18);
//        wg.addUndirectedEdge(4, 7, 5);
//        wg.addUndirectedEdge(5, 6, 11);
//        System.out.println("Min no of colors used to color the graph: " + wg.colorGraph());

        wg.addDirectedEdge(1, 2, 0);
        wg.addDirectedEdge(2, 3, 0);
        wg.addDirectedEdge(3, 4, 0);
        wg.addDirectedEdge(4, 5, 0);
        wg.addDirectedEdge(5, 6, 0);
        wg.addDirectedEdge(3, 7, 0);
        wg.addDirectedEdge(7, 5, 0);
        wg.addDirectedEdge(8, 2, 0);
        wg.addDirectedEdge(8, 9, 0);
        wg.addDirectedEdge(9, 10, 0);
        wg.addDirectedEdge(10, 8, 0);
        System.out.println(wg.detectCycleByBfs());


//        wg.addVertex(0);
//        wg.addVertex(1);
//        wg.addVertex(2);
//        wg.addVertex(3);
//        wg.addVertex(4);
//        wg.addVertex(5);
//        wg.addDirectedEdge(5, 0, 0);
//        wg.addDirectedEdge(5, 2, 0);
//        wg.addDirectedEdge(4, 0, 0);
//        wg.addDirectedEdge(4, 1, 0);
//        wg.addDirectedEdge(2, 3, 0);
//        wg.addDirectedEdge(3, 1, 0);
//        System.out.println(wg.getNumVertices());
//        System.out.println(Arrays.toString(wg.sort()));

        wg.printGraph();
        // TODO: update dfs and bfs traversal for components
//        wg.bfs(1);
//        wg.dfs(1);
//        wg.dfsRec(1);
    }
}