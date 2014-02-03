package leetcode;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
//
//
public class MaxPoints {
	
	static class Point {
		int x;
		int y;
		Point() { x = 0; y = 0; }
		Point(int a, int b) { x = a; y = b; }
	}
	
    public static int maxPoints(Point[] points) {
    	if (points == null || points.length == 0) return 0;
		if (points.length == 1) return 1;
		if (points.length == 2) return 2;
		int max = 0;
		for (int i = 0; i < points.length; i++) {
		    HashMap<Double, Integer> map = new HashMap<Double, Integer>();
		    int same = 0;
		    for (int j = i+1; j < points.length; j++) {
		        if (points[i].x == points[j].x && points[i].y == points[j].y) {
		            same += 1; // same point with current point
		            continue;
		        }
		        if (points[i].x == points[j].x) { // on the same vertical line
		            if (!map.containsKey(Double.MAX_VALUE)) map.put(Double.MAX_VALUE, 2);
		            else map.put(Double.MAX_VALUE, map.get(Double.MAX_VALUE)+1);
		        } else {
		            Double slope = (double) (points[i].y - points[j].y) / (points[i].x - points[j].x);
		            if (!map.containsKey(slope)) map.put(slope, 2);
		            else map.put(slope, map.get(slope)+1);
		        }
		    }
		    if (map.size() > 0) {
		       	for (Double d : map.keySet()) {
		            if (max < map.get(d)+same) max = map.get(d)+same; // don't forget duplicated points
		        }
		    } else {
		        max = Math.max(max, same+1);
		    }

		}
		return max;
    }
}


/**
 * @deprecated
 * @author Bolun
 *
 */
/*
public class MaxPoints {
	
	private static class Point {
		private int x;
		private int y;
		private Point() { x = 0; y = 0; }
		private Point(int a, int b) { x = a; y = b; }
	}
	
    private static class IndexedPoint {
    	private int x;
        private int y;
        private int index;
        private IndexedPoint(int a, int b, int _index) {
            x = a;
            y = b;
            index = _index;
        }
    }
    
    public boolean equals(IndexedPoint p1, IndexedPoint p2) {
        if (p1.x == p2.x && p1.y == p2.y && p1.index == p2.index)
            return true;
        else
            return false;
    }
    
    public boolean contains(ArrayList<IndexedPoint> list, IndexedPoint point) {
        for (IndexedPoint p : list) {
            if (equals(p, point))
                return true;
        }
        return false;
    }
    
    public int maxPoints(Point[] points) {
        HashMap<ArrayList<Double>, ArrayList<IndexedPoint>> myMap = new HashMap<ArrayList<Double>, ArrayList<IndexedPoint>>();
        
        if (points.length == 0)
            return 0;
        if (points.length == 1)
            return 1;
        
        for (int i = 0; i < points.length-1; i++) {
            for (int j = i+1; j < points.length; j++) {
                double slope = 0.0;
                double yshift = 0.0;
                double xshift = 0.0;
                if (points[i].y - points[j].y == 0) {
                    slope = 0.0;
                    yshift = (double)points[i].y;
                    xshift = Double.MAX_VALUE;
                }
                else if (points[i].x - points[j].x == 0) {
                    slope = Double.MAX_VALUE;
                    yshift = Double.MIN_VALUE;
                    xshift = points[i].x;
                } else {
                    slope = (double)(points[i].y - points[j].y)/(double)(points[i].x - points[j].x);
                    yshift = (double)points[i].y - slope*points[i].x;
                    xshift =  (double)(-yshift)/slope;
                }
                ArrayList<Double> tuple = new ArrayList<Double>();
                tuple.add(slope);
                tuple.add(yshift);
                tuple.add(xshift);
                if (!myMap.containsKey(tuple)) {
                    ArrayList<IndexedPoint> myList = new ArrayList<IndexedPoint>();
                    myList.add(new IndexedPoint(points[i].x, points[i].y, i));
                    myList.add(new IndexedPoint(points[j].x, points[j].y, j));
                    myMap.put(tuple, myList);
                } else {
                    ArrayList<IndexedPoint> myList = myMap.get(tuple);
                    IndexedPoint p1 = new IndexedPoint(points[i].x, points[i].y, i);
                    IndexedPoint p2 = new IndexedPoint(points[j].x, points[j].y, j);
                    if (!contains(myList, p1))
                        myList.add(p1);
                    if (!contains(myList, p2))
                        myList.add(p2);
                    myMap.put(tuple, myList);
                }
            }
        }
        int max_in_line = 0;
        for (ArrayList<Double> key : myMap.keySet()) {
            if (myMap.get(key).size() > max_in_line)
                max_in_line = myMap.get(key).size();
            System.out.print("[");
            for (IndexedPoint p : myMap.get(key)) {
            	System.out.print("("+p.x+" "+p.y+")");
            }
            System.out.println("]");
        }
        return max_in_line;
    }
    
    public static void main(String[] args) {
    	
    	HashMap<ArrayList<Double>, ArrayList<Point>> map = new HashMap<ArrayList<Double>, ArrayList<Point>>();
    	
    	ArrayList<Double> key = new ArrayList<Double>();
    	key.add(0.5);
    	key.add(1.0);
    	ArrayList<Double> key2 = new ArrayList<Double>();
    	key2.add(0.5);
    	key2.add(1.5);
    	
    	map.put(key, new ArrayList<Point>());
    	map.put(key2, new ArrayList<Point>());
    	System.out.println(map.size());
    	
    	MaxPoints mp = new MaxPoints();
    	Point[] points = {new Point(0,0), new Point(1,1), new Point(0,0)};
    	mp.maxPoints(points);
    	
    	char[] array = new char[10];
        Arrays.fill(array, '*');
        String s = new String(array);
        System.out.println(s);
    	
    }
	
}*/