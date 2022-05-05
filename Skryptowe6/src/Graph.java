import java.util.*;
public class Graph<T> {
    Map<T, List<Edge>>  adjList;

    public Graph() {
        adjList = new HashMap<>();
    }

    public void addEdge(T source, T dest, int weight){
        Edge edge = new Edge(source,dest,weight);
            if(adjList.containsKey(source)){
                adjList.get(source).add(edge);
            }
            else{
                ArrayList<Edge> tmp = new ArrayList<Edge>();
                tmp.add(edge);
                adjList.put(source,tmp);
            }
    }

    public String printGraph(){
        String output = "";
        for(T elem : adjList.keySet()){
            for(Edge e: adjList.get(elem)){
                output+= e.toString() + "\n";
            }
        }
        return output;
    }

    public String BFS(T source){
        if(adjList.keySet().contains(source)) {
            LinkedList<T> queue = new LinkedList();
            ArrayList<T> visited = new ArrayList<>();
            queue.push(source);
            visited.add(source);
            while (!queue.isEmpty()) {
                T current = queue.pop();
                if (adjList.keySet().contains(current)) {
                    for (Edge elem : adjList.get(current)) {
                        if (!visited.contains(elem.getDest())) {
                            queue.push((T) elem.getDest());
                            visited.add((T) elem.getDest());
                        }

                    }
                }
            }
            return visited.toString();
        }
        else{
            return "Graph doesn't contain source!";
        }
    }

    public String DFS(T source) {
        if(adjList.keySet().contains(source)) {
            ArrayList<T> visited = new ArrayList<>();
            DFSHelper(source, visited);
            return visited.toString();
        }
        else{
            return ("Graph doesn't contain source!");
        }
    }
    public void DFSHelper(T source, ArrayList<T> visited){
            String output = "";
            visited.add(source);
            output += (source + " ");
            if(adjList.containsKey(source)) {
                for (Edge edge : adjList.get(source)) {
                    if (!visited.contains(edge.getDest())) {
                        DFSHelper((T) edge.getDest(), visited);

                    }
                }
            }
        }

    public void changeWeight(T source, T dest,  int weight){
        List<Edge> tmp = adjList.get(source);
        for(Edge edge: tmp){
            if(edge.getDest().equals(dest)){
                edge.setWeight(weight);
                break;
            }
        }
    }

    public void changeDest(T source, T old_dest, T new_dest){
        List<Edge> tmp = adjList.get(source);
        for(Edge edge: tmp){
            if(edge.getDest().equals(old_dest)){
                edge.setDest(new_dest);
                break;
            }
        }
    }

}

class Edge<T>{
    private T source;
    private T dest;
    private int weight;
    public Edge(T source, T dest, int weight) {
        this.source = source;
        this.dest = dest;
        this.weight = weight;
    }

    public T getSource() {
        return source;
    }

    public void setSource(T source) {
        this.source = source;
    }

    public T getDest() {
        return dest;
    }

    public void setDest(T dest) {
        this.dest = dest;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "source=" + source + "dest= " + dest + " weight=" + weight;

    }
}

