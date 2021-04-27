import UndirectedGraph.AdjacencyListGraph;
import org.junit.jupiter.api.Test;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.junit.Assert.assertTrue;

class AdjacencyListGraphTest {

    AdjacencyListGraph graph = new AdjacencyListGraph(10);

    @Test
    void connectEdgeFromV1ToV2() {

        graph.addEdge(0, 6);
        graph.addEdge(0, 5);
        graph.addEdge(0, 7);
        graph.addEdge(0, 1);


        Set<Integer> adjVertices =  StreamSupport.stream(graph.adj(0).spliterator(), false).collect(Collectors.toSet());

        assertTrue(adjVertices.contains(6));
        assertTrue(adjVertices.contains(5));
        assertTrue(adjVertices.contains(7));
        assertTrue(adjVertices.contains(1));


    }

}