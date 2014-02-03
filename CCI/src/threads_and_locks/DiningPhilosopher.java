package threads_and_locks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Chopstick is essentially a reentrantLock
 * @author Bolun
 *
 */
class Chopstick {
	
	private Lock lock;
	
	public Chopstick () {
		lock = new ReentrantLock();
	}
	
	public void putDown() {
		lock.unlock();
	}
	
	public void pickUp() {
		lock.lock();
	}
}
/**
 * This implementation does not deal with deadlock when philosophers eat at the same time
 * extends Thread class
 * @author Bolun
 *
 */
public class DiningPhilosopher extends Thread {
	
	private int bites = 10;
	private Chopstick left;
	private Chopstick right;
	
	public DiningPhilosopher (Chopstick _left, Chopstick _right) {
		left = _left;
		right = _right;
	}
	
	public void eat() {
		pickUp();
		chew();
		putDown();
	}
	// pick up the chopsticks left to right
	public void pickUp() {
		left.pickUp();
		right.pickUp();
	}
	
	// put down the chopsticks left to right
	public void putDown() {
		left.putDown();
		right.putDown();
	}
	
	public void chew() {
		for (int i = 0; i < this.bites; i++) { }
	}
	
}