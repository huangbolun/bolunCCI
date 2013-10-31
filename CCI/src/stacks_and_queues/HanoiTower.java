package stacks_and_queues;

import java.util.Stack;

/**
 * move the disk from the first tower to the last using stacks
 * and print out the steps to do the moving
 * moveDisks(int n, Tower origin, Tower destination, Tower buffer) {
 *   // base case
 *   if (n == 0) return;
 *   
 *   // move top n-1 disks from original to buffer, using destination as a buffer
 *   moveDisks(n-1, origin, buffer, destination);
 *   
 *   // move the nth disk from origin to destination
 *   moveTop(origin, destination);
 *   
 *   // move the n-1 disk from buffer back to origin, using destination as a buffer
 *   moveDisks(n-1, buffer, origin, destination);
 * }
 * @author Bolun
 *
 */
public class HanoiTower {
	
	private Stack<Integer> disks;
	private int index;
	
	public HanoiTower(int i) {
		disks = new Stack<Integer>();
		index = i;
	}
	
	public int index() {
		return index;
	}
	
	public void add(int d) {
		if (!disks.isEmpty() && disks.peek() < d)
			System.err.println("Error placing disk " + d);
		else
			disks.push(d);
	}
	
	public void moveTop(HanoiTower t) {
		if (disks.isEmpty())
		{
			System.err.println("Error moving Top");
		} else {
			System.out.println("move " + disks.peek() + " from tower " + this.index() 
					+ " to " + t.index());
			t.add(disks.pop());
		}
	}
	
	public void moveDisks(int n, HanoiTower destination, HanoiTower buffer) {
		if (n > 0) {
			moveDisks(n-1, buffer, destination);
			System.out.println("move " + disks.peek() + " from tower " + this.index() 
					+ " to " + destination.index());
			moveTop(destination);
			buffer.moveDisks(n-1, destination, this);
		}
	}
	
	public String toString() {
		StringBuffer str = new StringBuffer();
		for (int i = disks.size() - 1; i > 0; i--)
			str.append(disks.get(i));
		return str.toString();
	}
	
	public static void main(String[] args) {
		HanoiTower[] towers = new HanoiTower[3];
		int n = 5;
		
		for (int i = 0; i < 3; i++)
		{
			towers[i] = new HanoiTower(i);
		}
		
		for (int i = n; i > 0; i--)
		{
			towers[0].add(i);
		}
		System.out.println(towers[0].toString());
		towers[0].moveDisks(n, towers[2], towers[1]);
		System.out.println(towers[2].toString());
	}
}