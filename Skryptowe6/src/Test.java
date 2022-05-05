public class Test {
    public static void main(String[] args) {
        Graph<String> graph = new Graph();
        graph.addEdge("1","2",5);
        graph.addEdge("1","3",4);
        graph.addEdge("1","4",4);
        graph.addEdge("2","4",5);
        graph.addEdge("3","5",5);
        graph.addEdge("5","6",5);
        graph.addEdge("5","8",5);
        graph.addEdge("6","3",5);
        graph.addEdge("4","6",5);
        graph.addEdge("4","7",5);
        graph.changeWeight("4","7",200);
        graph.changeDest("4","6","8");
        System.out.println(graph.DFS("1"));

    }
}
