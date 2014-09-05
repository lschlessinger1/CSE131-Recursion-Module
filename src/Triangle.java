import java.util.ArrayList;
import java.util.Arrays;


public class Triangle {

	private Point a;
	private Point b;
	private Point c;
	private ArrayList<Point> points;
	
	public Triangle(Point a, Point b, Point c) {
		this.a = a;
		this.b = b;
		this.c = c;
		points = new ArrayList<Point>(Arrays.asList(a, b, c));
	}

	/**
	 * @return the a point
	 */
	public Point getA() {
		return a;
	}

	/**
	 * @param a the a point to set
	 */
	public void setA(Point a) {
		this.a = a;
	}

	/**
	 * @return the b point
	 */
	public Point getB() {
		return b;
	}

	/**
	 * @param b the b point to set
	 */
	public void setB(Point b) {
		this.b = b;
	}

	/**
	 * @return the c point
	 */
	public Point getC() {
		return c;
	}

	/**
	 * @param c the c point to set
	 */
	public void setC(Point c) {
		this.c = c;
	}

	/**
	 * @return the points
	 */
	public ArrayList<Point> getPoints() {
		return points;
	}

	/**
	 * @param points the points to set
	 */
	public void setPoints(ArrayList<Point> points) {
		this.points = points;
	}

	
}
