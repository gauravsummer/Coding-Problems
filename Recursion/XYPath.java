package Recursion;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;

public class XYPath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x=400, y=500;
		ArrayList<Point> path = new ArrayList<Point>();
		HashMap cache = new HashMap<Point, Boolean>();
		System.out.println(findPath(x,y,path, cache));
		for(Point p: path) {
			System.out.println(p.getX()+", "+p.getY());
		}
	}
	public static boolean findPath(int x, int y, ArrayList<Point> path, HashMap<Point, Boolean> cache) {
		Point p = new Point(x,y);
//		path.add(p);
		if(cache.containsKey(p))
			return cache.get(p);
		if(x==0 && y==0)
			return true;
		boolean success = false;
		if(x >= 1)
			success = findPath(x-1,y,path, cache);
		if(!success && y>=1) 
			success = findPath(x,y-1,path,cache);
		if(success)
			path.add(p);
		cache.put(p, success);
		return success;
	}
}
