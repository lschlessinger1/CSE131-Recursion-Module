import java.util.ArrayList;

/**
 * http://www.cs.wustl.edu/~cytron/cse131/Modules/7/lab.html
 * Think about what you see: what is foreground and what is background?
 * 		Foreground is the outer triangle. Background is the inner triangles
 * Develop an approach for drawing the figure recursively.
 * 		1. a = getMidpoint(A, B), b = getMidpoint(B, C), and c = getMidpoint(A, C)
 * 		2. drawLine(a, b), drawLine(b, c), drawLine(a, c)
 * What is the base case?
 * 		An arbitrary number.
 * What are the recursive calls doing?
 *		Drawing triangles inside of the main triangle.
 */

/**
 * @author Louis Schlessinger
 */
public class Triangles {
	
	ArrayList<Triangle> triangles;
	
	public Triangles() {
		triangles = new ArrayList<>();
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Triangles t = new Triangles();
		int length = 10;
		int iterations = 2;
		Point aInitial = new Point (0 , 0);
		Point bInitial = new Point (length/2 , length);
		Point cInitial = new Point (length , 0);

		t.drawTriangle(iterations, aInitial, bInitial, cInitial);
		t.prettyPrint();
	}

	public void drawTriangle(int iterations, Point a, Point b, Point c) {
		if (iterations == 0) {
			// actually draw the triangle here
			// maybe Triangle class could fill the polygon here...
			Triangle triangle = new Triangle(new Point(a.getX(), a.getY()), 
					new Point(b.getX(), b.getY()),
					new Point(c.getX(), c.getY()));
			triangles.add(triangle);
			return;
		}
		
		Point abMid = a.getMidpoint(b);
        Point bcMid = b.getMidpoint(c);
        Point acMid = a.getMidpoint(c);

		drawTriangle(iterations - 1, a, abMid, acMid);
		drawTriangle(iterations - 1, abMid, b, bcMid);
		drawTriangle(iterations - 1, acMid, bcMid, c);
	}

	public void prettyPrint() {
		for (int i = 0; i < triangles.size(); i++) {
			Triangle t = triangles.get(i);
			Point a = t.getA();
			Point b = t.getB();
			Point c = t.getC();
			System.out.println("Triangle " + (i + 1) + ":("+a.getX() +", " +a.getY()+"), ("+b.getX() +", " +b.getY()+"), ("+c.getX() +", " +c.getY()+")");
		}
	}
	
}
