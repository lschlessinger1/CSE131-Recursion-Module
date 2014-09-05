/**
 * @author Lou
 *
 */
public class Point {
		
		private double x;
		private double y;
		
		/**
		 * @param x
		 * @param y
		 */
		public Point(double x, double y) {
			super();
			this.x = x;
			this.y = y;
		}
		/**
		 * @return the x coordinate
		 */
		public double getX() {
			return x;
		}
		/**
		 * @param x the x coordinate to set
		 */
		public void setX(double x) {
			this.x = x;
		}
		/**
		 * @return the y coordinate
		 */
		public double getY() {
			return y;
		}
		/**
		 * @param y the y coordinate to set
		 */
		public void setY(double y) {
			this.y = y;
		}
		

		/**
		 * @param a
		 * @param b
		 * @return the midpoint
		 */
		public Point getMidpoint(Point a) {
			double xAvg = (a.getX() + this.getX()) / 2;
			double yAvg = (a.getY() + this.getY()) / 2;
			Point p = new Point(xAvg, yAvg);
			return p;
		}
	}