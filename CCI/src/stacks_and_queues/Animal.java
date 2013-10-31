package stacks_and_queues;

public class Animal {
	
	public int id;
	public String type;
	
	public Animal(int _id, String _type) {
		this.id = _id;
		this.type = _type;
	}
	
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append("("+id+","+type+")");
		return str.toString();
	}
}