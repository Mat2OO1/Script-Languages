from py4j.java_gateway import JavaGateway


class Graph:
    def __init__(self):
        self.gateway = JavaGateway()
        self.graph = self.gateway.entry_point.get_graph()

    def addEdge(self, src, dest, weight):
        self.graph.addEdge(src, dest, weight)

    def showGraph(self):
        return self.graph.printGraph()

    def BFS(self, source):
        return self.graph.BFS(source)

    def DFS(self, source):
        return self.graph.DFS(source)

    def changeWeight(self, source, dest, weight):
        self.graph.changeWeight(source, dest, weight)

    def changeDest(self, source, old_dest, new_dest):
        self.graph.changeDest(source, old_dest, new_dest)


if __name__ == '__main__':
    graph = Graph()
    graph.addEdge("1", "2", 5)
    graph.addEdge("1", "3", 4)
    graph.addEdge("1", "4", 4)
    graph.addEdge("2", "4", 5)
    graph.addEdge("3", "5", 5)
    graph.addEdge("5", "6", 5)
    graph.addEdge("5", "8", 5)
    graph.addEdge("6", "3", 5)
    graph.addEdge("4", "6", 5)
    graph.addEdge("4", "7", 5)
    graph.changeWeight("1", "2", 100)
    graph.changeDest("4", "7", "10")
    print("GRAPH:")
    print(graph.showGraph())
    print("DFS:")
    print(graph.DFS("1"))
    print("BFS:")
    print(graph.BFS("1"))
