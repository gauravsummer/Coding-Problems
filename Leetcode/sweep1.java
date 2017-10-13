package common;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.TreeMap;

// Class for end points of the line
class Point {
	public Point(Double x, Double y, Integer lineNo, String type) {
		xCoordinate = x;
		yCoordinate = y;
		this.lineNo = lineNo;
		pointType = type;
	}
	Double xCoordinate = 0.0;
	Double yCoordinate = 0.0;
	Integer lineNo = 0;
	String pointType = "";
}

public class sweep1 {
	public static HashMap<Integer,Double[]> mapOfLine;
	public static PriorityQueue<Point> queueOfPoints;
	public static TreeMap<Double,Integer> yCoordinateTree;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer line = 1;
		Scanner scan = new Scanner(System.in);
		int numLines = scan.nextInt();
		//Initializing the data structures
		mapOfLine = new HashMap<Integer,Double[]>();
		yCoordinateTree = new TreeMap<Double,Integer>();
		queueOfPoints = new PriorityQueue<Point>(new Comparator<Point>() {
			    public int compare(Point p1, Point p2) {
			    // sorting based on x coordinate 1st	
		    	int result = p1.xCoordinate.compareTo(p2.xCoordinate);
		    	// sorting points based on left end points 1st
		    	if(result == 0) {
		    		result = p1.pointType.compareTo(p2.pointType);
		    	}
		    	// sorting points based on the y coordinate
		    	if(result == 0) {
		    		result = p1.yCoordinate.compareTo(p2.yCoordinate);	
		    	}
		        return result;
		    }
		});
		
		// Reading input and adding lines to map of Lines and points to sorted queue of points
		for(int i=0; i<numLines; i++) {
			double x1 = scan.nextDouble();
			double y1 = scan.nextDouble();
			double x2 = scan.nextDouble();
			double y2 = scan.nextDouble();
			if(x1 > x2) {
				double tmp = x1;
				x1 = x2;
				x2 = tmp;
				tmp = y1;
				y1 = y2;
				y2 = tmp;
			}
			mapOfLine.put(line, new Double[] {x1,y1,x2,y2});
			Point p = new Point(x1,y1,line,"left");
			queueOfPoints.add(p);
			Point p1 = new Point(x2,y2,line,"right");
			queueOfPoints.add(p1);
			line++;
		}
		scan.close();
		
		lineSweep(queueOfPoints);
		
	}
	
	//**** Remove points starting from left most point and check for neighboring lines
	//**   check for intersection between neighboring lines
	public static void lineSweep(PriorityQueue<Point>  queueOfPoints) {
		while(!queueOfPoints.isEmpty()) {
			Point point = queueOfPoints.remove();	
			// start end point of a line segment
			if(point.pointType == "left") {
				insertLineToTree(point.yCoordinate, point.lineNo);
				boolean hasULine = false;
				boolean hasLLine = false;
				Double[] lineCor = mapOfLine.get(point.lineNo);
				Double upperY = getUpperLine(point.yCoordinate);
				Double lowerY = getLowerLine(point.yCoordinate);
				if(upperY != null) {
					hasULine = true;
				}
				if(lowerY != null) {
					hasLLine = true;
				}
				
				///* Checking for intersection with line above this line
				if(hasULine) {
					Integer upperLine = yCoordinateTree.get(upperY);
					Double[] upperCor = mapOfLine.get(upperLine);
					//System.out.println(point.lineNo+" " +upperLine+" " +segmentIntersection(upperCor,lineCor));
					checkIntersection(upperCor,lineCor);
				}
				
				///* Checking for intersection with line below this line
				if(hasLLine) {
					Integer lowerLine = yCoordinateTree.get(lowerY);
					Double[] lowerCor = mapOfLine.get(lowerLine);
					//System.out.println(point.lineNo+" " +lowerLine+" " +segmentIntersection(lineCor,lowerCor));
					checkIntersection(lineCor,lowerCor);
				}
			}
			
			///* Right end point of  a line
			if(point.pointType == "right") {
				boolean hasULine = false;
				boolean hasLLine = false;
				Double upper = getUpperLine(mapOfLine.get(point.lineNo)[1]);
				Double lower = getLowerLine(mapOfLine.get(point.lineNo)[1]);
				yCoordinateTree.higherKey(mapOfLine.get(point.lineNo)[1]);
				if(upper != null) {
					hasULine = true;
				}
				if(lower != null) {
					hasLLine = true;
				}
				
				///* Checking for intersection with line above and below this line
				if(hasLLine && hasULine) {
					Integer upperLine = yCoordinateTree.get(upper);
					Integer lowerLine = yCoordinateTree.get(lower);
					Double[] upperCor = mapOfLine.get(upperLine);
					Double[] lowerCor = mapOfLine.get(lowerLine);
					//System.out.println(upperLine+" " +lowerLine+" " +segmentIntersection(upperCor,lowerCor));
					checkIntersection(upperCor,lowerCor);
						//break;
				}
				removeLineFromTree(mapOfLine.get(point.lineNo)[1]);
			}
		}
	}
	
	///*** Inserting the line coordinate in tree of points when left end point is observed
	public static void insertLineToTree(Double yCoordinate, Integer lineNo) {
		yCoordinateTree.put(yCoordinate,lineNo);
	}
		
	///*** Removing the line coordinate from tree of points when right end point of a line is observed
	public static void removeLineFromTree(Double yCoordinate) {
		yCoordinateTree.remove(yCoordinate);
	}
	
	///*** Retrieving upper neighboring line of the line based on y coordinates 
	public static Double getUpperLine(Double yCoordinate) {
		return yCoordinateTree.higherKey(yCoordinate);
	}
	///*** Retrieving lower neighboring line of the line based on y coordinates 
	public static Double getLowerLine(Double yCoordinate) {
		return yCoordinateTree.lowerKey(yCoordinate);
	}
	
	///*** Check for intersection between two lines
	public static void checkIntersection(Double[] upper, Double[] lower) {
		boolean intersecting = false;
		double x1 = upper[0];
		double y1 = upper[1];
		double x2 = upper[2];
		double y2 = upper[3];
		double x3 = lower[0];
		double y3 = lower[1];
		double x4 = lower[2];
		double y4 = lower[3];
		double d1 = direction(x1,y1, x2,y2, x3,y3);
		double d2 = direction(x1,y1, x2,y2, x4,y4);
		double d3 = direction(x3,y3, x4,y4, x1,y1);
		double d4 = direction(x3,y3, x4,y4, x2,y2);
		if (d1 != d2 && d3 != d4) {
			intersecting = true;
		}
		else if(d1 == 0 && onSegment(x1,y1, x2,y2, x3,y3)) {
			intersecting = true;
		}
		else if(d2 == 0 && onSegment(x1,y1, x2,y2, x4,y4)) {
			intersecting = true;
		}
		else if(d3 == 0 && onSegment(x3,y3, x4,y4, x1,y1)) {
			intersecting = true;
		}
		else if(d4 == 0 && onSegment(x3,y3, x4,y4, x2,y2)) {
			intersecting = true;
		}
		if(intersecting) {
			double denom = (x1-x2)*(y3-y4) - (y1-y2)*(x3-x4);
			double ua = ((x4 - x3) * (y1 - y3) - (y4 - y3) * (x1 - x3))/denom;
			double intX = x1 + ua*(x2 - x1);
			double intY = (y1 + ua*(y2 - y1));
			System.out.printf("%.2f %.2f",intX,intY);
			System.out.println();
		}
	}
	
	public static int direction(double xi, double yi, double xj, double yj, double xk, double yk) {
		double direction = ((yj - yi) * (xk - xj)) - ((xj - xi) * (yk - yj));
		if (direction > 0)
			return 1;
		else if(direction < 0)
	        return -1;
		else
			return 0;
	}

	public static boolean onSegment(double xi, double yi, double xj, double yj, double xk, double yk) {
		if(Math.min(xi, xj) <= xk && xk <= Math.max(xi, xj) && Math.min(yi, yj) <=yk && yk <= Math.max(yi, yj)) {
			return true;
		}
		else
			return false;
	}

}
