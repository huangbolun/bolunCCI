package amazon;

import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Iterator;
import amazon.Point;
/**
 * find the K nearest points to the origin in a 2D plane
 * @author Bolun
 *
 */
public class Knearests {
	
	public LinkedList<Point> findKnearests2origin(ArrayList<Point> input, int K) {
		//Point p = new Point();
		LinkedList<Point> result = new LinkedList<Point>(); // use linkedlist to store the result
		Iterator<Point> it = input.iterator();
		while (it.hasNext()) {
			Point p = it.next();
			p.distance = Math.sqrt(p.x*p.x + p.y*p.y);
			
			for (int i = 0; i < result.size(); i++) {
				if (p.distance < result.get(i).distance)
					result.set(i, p);
			}
			if (result.size() > K) {
				result.removeLast();
			}
		}
		return result;
	}
}