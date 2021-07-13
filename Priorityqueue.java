class qNode{
public	Node data;
public int cost;
public qNode next;
public qNode(Node data, int cost) {
	this.data = data;
	this.cost = cost;
	this.next =null;
}
}
public class Priorityqueue {
public qNode head;
public qNode current;

public Priorityqueue() {
	head = current = null;
}

public void add(Node data,int cost) {
	qNode newelement = new qNode(data, data.Pathcost);
	if(head == null)
		head = newelement;
		
}
public int size() {
	if(head == null)
		return 0;
	current =head;
	int size = 1;
	while(current.next !=null) {
		size++;
		current = current.next;
	}
	return size;
}
public Node remove() {
	if(head == null)
		return null;
	Node element =head.data;
	head = head.next;
	return element;
}
}
