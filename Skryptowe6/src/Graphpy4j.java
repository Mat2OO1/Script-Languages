import py4j.GatewayServer;

public class Graphpy4j {
    private Graph<String> graph;

    public Graphpy4j() {
        graph = new Graph<String>();
    }

    public Graph get_graph() {
        return graph;
    }

    public static void main(String[] args) {
        Graphpy4j graph = new Graphpy4j();
        GatewayServer gatewayServer = new GatewayServer(graph);
        gatewayServer.start();
    }

}