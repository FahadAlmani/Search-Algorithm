
public class Person implements Comparable<Person>{
public char name;
public int cost;

public Person(char c,int cost) {
	this.name = c;
	this.cost = cost;
}

@Override
public int compareTo(Person o) {
	if(this.name > o.name)
		return 1;
	return -1;
}

}
