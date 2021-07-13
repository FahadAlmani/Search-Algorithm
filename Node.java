import java.util.ArrayList;

public class Node implements Comparable<Node> {
	public Node parent;
	public String state;
	public int Pathcost;
	public int depth;
	public int heuristicFunction;
	public ArrayList<Person> west;
	public ArrayList<Person> east;
	public boolean ids = false;

// main
	public Node(ArrayList<Person> east, ArrayList<Person> west) {
		this.parent = null;
		this.state = null;
		this.Pathcost = 0;
		this.depth = 0;
		this.heuristicFunction = 0;
		this.west = west;
		this.east = east;
	}

//USC
	public Node(Node parent, int pathcost, int depth, ArrayList<Person> east, ArrayList<Person> west, String state) {
		this.parent = parent;
		this.state = state;
		this.Pathcost = pathcost;
		this.depth = depth;
		this.heuristicFunction = 0;
		this.west = west;
		this.east = east;
	}

//IDS
	public Node(Node parent, int pathcost, int depth, ArrayList<Person> east, ArrayList<Person> west, String state,
			boolean True) {
		this.parent = parent;
		this.state = state;
		this.Pathcost = pathcost;
		this.depth = depth;
		this.heuristicFunction = 0;
		this.west = west;
		this.east = east;
		this.ids = True;
	}

//A*
	public Node(Node parent, int pathcost, int depth, ArrayList<Person> east,
			ArrayList<Person> west, String state, int heuristicFunction) {
		this.parent = parent;
		this.state = state;
		this.Pathcost = pathcost;
		this.depth = depth;
		this.heuristicFunction = heuristicFunction;
		this.west = west;
		this.east = east;
	}

	@Override
	public int compareTo(Node o) {
		if (!this.ids) {
			if (this.Pathcost + this.heuristicFunction > o.Pathcost + o.heuristicFunction)
				return 1;
		}
		return -1;
	}
}
