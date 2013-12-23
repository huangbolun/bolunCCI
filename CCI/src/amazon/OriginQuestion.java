package amazon;

/* In order to get the K cloest points to origin, I maintain a linkedlist of upto K
 * points with the smallest distance to origin. Before adding to the list I will examine
 * distance so as to keep the top K points in the list. */
 
/* Enter your Big O Analysis here. */
 
/* Enter your code here. */
import java.util.LinkedList;

public class OriginQuestion {

    public static class Point {
        public double x;
        public double y;
    }
    /**
     * This class encapsulate Point class and the distance to origin for convenience
     */
    public static class myPoint {
        public Point p = new Point();
        public double distance_sq = 0.0;
    }
    /**
     * return the K nearest points to the origin
     * @param myList input list
     * @param k number of points
     * @return an array of points nearest to origin
     */
    public static Point[] closestk( Point  myList[], int k ) {
        LinkedList<myPoint> Knearest = new LinkedList<myPoint>();
        for (int i = 0; i < myList.length; i++) {
            double distance_sq = myList[i].x * myList[i].x + myList[i].y * myList[i].y;
            
            for (int j = 0; j < Knearest.size(); j++) {
                if (distance_sq < Knearest.get(j).distance_sq) {
                    myPoint mp = new myPoint();
                    mp.p.x = myList[i].x;
                    mp.p.y = myList[i].y;
                    mp.distance_sq = distance_sq;
                    Knearest.set(j, mp);
                }
            }
            if (Knearest.size() > k)
                Knearest.removeLast();
        }
        Point[] result = new Point[Knearest.size()];
        for (int i = 0; i < Knearest.size(); i++) {
            result[i] = Knearest.get(i).p;
        }
        return result;
    }    
}