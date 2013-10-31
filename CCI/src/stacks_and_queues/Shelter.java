package stacks_and_queues;

import java.util.LinkedList;
/**
 * solution to problem 3.7
 * implement a shelter containing dog or cats
 * @author Bolun
 *
 */
public class Shelter {
	
	private LinkedList<Animal> shelter;
	
	public Shelter () {
		shelter = new LinkedList<Animal>();
	}
	
	public Animal enqueue (Animal a) {
		shelter.add(a);
		return a;
	}
	
	public Animal dequeueAny () {
		if (shelter.isEmpty())
			return null;
		Animal ra = shelter.get(0);
		shelter.remove(0);
		return ra;
	}
	
	public Animal dequeueCat() {
		int i;
		for (i = 0; i < shelter.size(); i++)
		{
			if (shelter.get(i).type.equals("Cat"))
			{
				break;
			}
		}
		return shelter.remove(i);
	}
	
	public Animal dequeueDog () {
		int i;
		for (i = 0; i < shelter.size(); i++)
		{
			if (shelter.get(i).type.equals("Dog"))
			{
				break;
			}
		}
		return shelter.remove(i);
	}
	
	public String toString() {
		StringBuffer str = new StringBuffer();
		for (int i = 0; i < shelter.size(); i++)
		{
			if (i == shelter.size() - 1)
				str.append(shelter.get(i).toString());
			else
				str.append(shelter.get(i).toString()+"->");
		}
		return str.toString();
	}
	
	public static void main(String[] args) {
		Shelter myShelter = new Shelter();
		myShelter.enqueue(new Animal(1, "Dog"));
		myShelter.enqueue(new Animal(2, "Cat"));
		myShelter.enqueue(new Animal(3, "Cat"));
		myShelter.enqueue(new Animal(4, "Dog"));
		myShelter.enqueue(new Animal(5, "Dog"));
		myShelter.enqueue(new Animal(6, "Cat"));
		myShelter.enqueue(new Animal(7, "Dog"));
		myShelter.enqueue(new Animal(8, "Cat"));

		System.out.println("Original:   "+myShelter.toString());
		myShelter.dequeueCat();
		System.out.println("DequeueCat: "+myShelter.toString());
		myShelter.dequeueAny();
		System.out.println("DequeueAny: "+myShelter.toString());
		myShelter.dequeueDog();
		System.out.println("DequeueDog: "+myShelter.toString());
		
	}
}