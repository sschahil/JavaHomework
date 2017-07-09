//import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class GraphsTest {

	Graphs<String> graph = new Graphs<String>(true);
	ArrayList<Edge<String>> connected = new ArrayList<Edge<String>>();

	@Test
	public void test() {
		connected.add(new Edge<String>("B", 2));
		connected.add(new Edge<String>("C", 12));
		connected.add(new Edge<String>("D", 7));
		
		graph.add("A", connected);
		graph.addArc("C", "B", 1);
		graph.addArc("Z", "F", 4);
		graph.addArc("Z", "R", 5);
		graph.addArc("D", "Z", 1);
		graph.addArc("F", "D", 1);
		graph.addArc("W", "L", 1);
		
		System.out.println(graph.toString());
	}

}
