import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class searchAlgorithms {

	public static void ucsSearch(Node start) {
		int spaceRequirement = 0;
		int searchCost = 0;
		int solutionCost = 0;
		ArrayList<Node> path = new ArrayList<Node>();
		Node current = start;
		Node target = null;
		PriorityQueue<Node> fringe = new PriorityQueue<Node>();
		fringe.add(current);

		while (!fringe.isEmpty()) {
			if (spaceRequirement < fringe.size())
				spaceRequirement = fringe.size();

			current = fringe.poll();
			if (current.east.isEmpty()) {
				target = current;
				solutionCost = current.Pathcost;
				break;
			}
			// east side
			if (current.depth % 2 == 0) {
				for (int i = 0; i < current.east.size() - 1; i++) {
					for (int j = i + 1; j < current.east.size(); j++) {
						Person person1 = current.east.get(i);
						Person person2 = current.east.get(j);
						ArrayList<Person> newWest = new ArrayList<Person>(current.west);
						ArrayList<Person> newEast = new ArrayList<Person>(current.east);
						newEast.remove(person1);
						newEast.remove(person2);
						newWest.add(person1);
						newWest.add(person2);
						Collections.sort(newEast);
						Collections.sort(newWest);
						String stata = String.format("(%c, %c) move to the west side", person1.name, person2.name);
						Node newNode = new Node(current, current.Pathcost + Math.max(person1.cost, person2.cost),
								current.depth + 1, newEast, newWest, stata);
						fringe.add(newNode);
						searchCost++;
					}
				}
			}
			// west side
			else {
				for (int i = 0; i < current.west.size(); i++) {
					Person personReturn = current.west.get(i);
					ArrayList<Person> newWest = new ArrayList<Person>(current.west);
					ArrayList<Person> newEast = new ArrayList<Person>(current.east);
					newWest.remove(personReturn);
					newEast.add(personReturn);
					Collections.sort(newEast);
					Collections.sort(newWest);
					String stata = String.format("(%c) returns with the flashlight", personReturn.name);
					Node newNode = new Node(current, current.Pathcost + personReturn.cost, current.depth + 1, newEast,
							newWest, stata);
					fringe.add(newNode);
					searchCost++;
				}
			}
		}
		if (target != null) {
			Node folowpath = target;
			while (folowpath.parent != null) {
				path.add(folowpath);
				folowpath = folowpath.parent;
			}
			Collections.reverse(path);
			System.out.println("-------------------------------------------");
			System.out.println("\t\tUCS");
			for (int i = 0; i < path.size(); i++) {
				System.out.println((i + 1) + "\t" + path.get(i).state);
			}
			System.out.println();
			System.out.println("Solution Cost: " + solutionCost);
			System.out.println("Search Cost: " + searchCost);
			System.out.println("Space Requirement: " + spaceRequirement);
		} else
			System.out.println("no solution");
	}

	public static void idsSearch(Node start) {
		int depth = 1;
		Node result = null;
		while (true) {
			result = Recursive(start, depth);
			if (result != null)
				return;
			depth++;
		}
	}

	private static Node Recursive(Node start, int depth) {
		int spaceRequirement = 0;
		int searchCost = 0;
		int solutionCost = 0;
		ArrayList<Node> path = new ArrayList<Node>();
		Node current = start;
		Node target = null;
		PriorityQueue<Node> fringe = new PriorityQueue<Node>();
		fringe.add(current);

		while (!fringe.isEmpty()) {
			if (spaceRequirement < fringe.size())
				spaceRequirement = fringe.size();

			current = fringe.poll();
			if (current.east.isEmpty()) {
				target = current;
				solutionCost = current.Pathcost;
				break;
			}
			// east side
			if (current.depth % 2 == 0 && current.depth < depth) {
				for (int i = current.east.size() - 2; i > -1; i--) {
					for (int j = current.east.size() - 1; j > i; j--) {
						Person person1 = current.east.get(i);
						Person person2 = current.east.get(j);
						ArrayList<Person> newWest = new ArrayList<Person>(current.west);
						ArrayList<Person> newEast = new ArrayList<Person>(current.east);
						newEast.remove(person1);
						newEast.remove(person2);
						newWest.add(person1);
						newWest.add(person2);
						Collections.sort(newEast);
						Collections.sort(newWest);
						String stata = String.format("(%c, %c) move to the west side", person1.name, person2.name);
						Node newNode = new Node(current, current.Pathcost + Math.max(person1.cost, person2.cost),
								current.depth + 1, newEast, newWest, stata, true);
						fringe.add(newNode);
						searchCost++;
					}
				}
			}
			// west side
			else if (current.depth % 2 != 0 && current.depth < depth) {
				for (int i = current.west.size() - 1; i > -1; i--) {
					Person personReturn = current.west.get(i);
					ArrayList<Person> newWest = new ArrayList<Person>(current.west);
					ArrayList<Person> newEast = new ArrayList<Person>(current.east);
					newWest.remove(personReturn);
					newEast.add(personReturn);
					Collections.sort(newEast);
					Collections.sort(newWest);
					String stata = String.format("(%c) returns with the flashlight", personReturn.name);
					Node newNode = new Node(current, current.Pathcost + personReturn.cost, current.depth + 1, newEast,
							newWest, stata, true);
					fringe.add(newNode);
					searchCost++;
				}
			}
		}
		if (target != null) {
			Node folowpath = target;
			while (folowpath.parent != null) {
				path.add(folowpath);
				folowpath = folowpath.parent;
			}
			Collections.reverse(path);
			System.out.println("-------------------------------------------");
			System.out.println("\t\tIDS");
			for (int i = 0; i < path.size(); i++) {
				System.out.println((i + 1) + "\t" + path.get(i).state);
			}
			System.out.println();
			System.out.println("Solution Cost: " + solutionCost);
			System.out.println("Search Cost: " + searchCost);
			System.out.println("Space Requirement: " + spaceRequirement);
		}
		return target;
	}

	public static void aStarSearch(Node start) {
		int spaceRequirement = 0;
		int searchCost = 0;
		int solutionCost = 0;
		ArrayList<Node> path = new ArrayList<Node>();
		Node current = start;
		Node target = null;
		PriorityQueue<Node> fringe = new PriorityQueue<Node>();
		fringe.add(current);

		while (!fringe.isEmpty()) {
			if (spaceRequirement < fringe.size())
				spaceRequirement = fringe.size();

			current = fringe.poll();
			if (current.east.isEmpty()) {
				target = current;
				solutionCost = current.Pathcost;
				break;
			}
			// east side
			if (current.depth % 2 == 0) {
				for (int i = 0; i < current.east.size() - 1; i++) {
					for (int j = i + 1; j < current.east.size(); j++) {
						Person person1 = current.east.get(i);
						Person person2 = current.east.get(j);
						ArrayList<Person> newWest = new ArrayList<Person>(current.west);
						ArrayList<Person> newEast = new ArrayList<Person>(current.east);
						newEast.remove(person1);
						newEast.remove(person2);
						newWest.add(person1);
						newWest.add(person2);
						Collections.sort(newEast);
						Collections.sort(newWest);
						String stata = String.format("(%c, %c) move to the west side", person1.name, person2.name);
						Node newNode = new Node(current, current.Pathcost + Math.max(person1.cost, person2.cost),
								current.depth + 1, newEast, newWest, stata, Math.max(person1.cost, person2.cost) - 1);
						fringe.add(newNode);
						searchCost++;
					}
				}
			}
			// west side
			else {
				for (int i = 0; i < current.west.size(); i++) {
					Person personReturn = current.west.get(i);
					ArrayList<Person> newWest = new ArrayList<Person>(current.west);
					ArrayList<Person> newEast = new ArrayList<Person>(current.east);
					newWest.remove(personReturn);
					newEast.add(personReturn);
					Collections.sort(newEast);
					Collections.sort(newWest);
					String stata = String.format("(%c) returns with the flashlight", personReturn.name);
					Node newNode = new Node(current, current.Pathcost + personReturn.cost, current.depth + 1, newEast,
							newWest, stata, personReturn.cost - 1);
					fringe.add(newNode);
					searchCost++;
				}
			}
		}
		if (target != null) {
			Node folowpath = target;
			while (folowpath.parent != null) {
				path.add(folowpath);
				folowpath = folowpath.parent;
			}
			Collections.reverse(path);
			System.out.println("-------------------------------------------");
			System.out.println("\t\tA*");
			for (int i = 0; i < path.size(); i++) {
				System.out.println((i + 1) + "\t" + path.get(i).state);
			}
			System.out.println();
			System.out.println("Solution Cost: " + solutionCost);
			System.out.println("Search Cost: " + searchCost);
			System.out.println("Space Requirement: " + spaceRequirement);
		} else
			System.out.println("no solution");
	}
}
