package threads_and_locks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class ChopstickII {
	
	private Lock lock;
	
	public ChopstickII () {
		lock = new ReentrantLock();
	}
	
	// Acquires the lock if it is available and returns immediately with the value true
	public boolean pickUp() {
		return lock.tryLock();
	}
	
	public void putDown() {
		lock.unlock();
	}
}

public class DiningPhilosopherII extends Thread {
	
	private int bites = 10;
	private ChopstickII left;
	private ChopstickII right;
	
	public DiningPhilosopherII(ChopstickII _left, ChopstickII _right) {
		left = _left;
		right = _right;
	}
	
	public void eat() {
		if (pickUp()) {
			chew();
			putDown();
		}
	}
	
	public boolean pickUp() {
		// try pick up left chopstick
		if (!left.pickUp()) {
			return false;
		}
		// try pick up right one once left one is successfully picked up
		if (!right.pickUp()) {
			left.putDown(); // put down left one, forcedly removed
			return false;
		}
		return true;
	}
	
	public void putDown() {
		left.putDown();
		right.putDown();
	}
	
	public void chew() {
		for (int i = 0; i < this.bites; i++) {}
	}
	
}

