import java.util.ArrayList;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		ArrayList<Person> personList = new ArrayList<Person>();
		Scanner input = new Scanner(System.in);
		System.out.print("Enter number of persons:");
		int numberP = input.nextInt();
		for (int i = 0; i < numberP; i++) {
			System.out.print("Number of minutes to across the bridge for person(" + (char) (i + 'a') + "):");
			int cost = input.nextInt();
			personList.add(new Person((char) (i + 'a'), cost));
		}
		input.close();
		Node start = new Node(personList, new ArrayList<Person>());
		searchAlgorithms.ucsSearch(start);
		searchAlgorithms.idsSearch(start);
		searchAlgorithms.aStarSearch(start);
	}
}
