package UndirectedGraph;

public interface Graph {

    void addEdge(Integer vertex1, Integer vertex2);

    Iterable<Integer> adj(Integer vertex);

    Integer vertices();

    Integer edges();

}
