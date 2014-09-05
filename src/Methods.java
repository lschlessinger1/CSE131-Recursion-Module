import java.util.Scanner;

/**
 * http://www.cs.wustl.edu/~cytron/cse131/Modules/7/lab.html
 *
 * f(x) =    x-10     if x > 100
 * f(x) = f(f(x+11))  if x <= 100
 * 
 * Will this function terminate for all positive integers supplied as arguments.
 * yes
 * 
 * What do you expect this function to do for values of x > 100?
 * f(x) = x - 10
 * 
 * How will it behave for values <= 100?
 * f(x) = 91
 * 
 * g(x,y) = y+1               if x = 0
 * g(x,y) = g(x-1,1)          if x > 0 and y = 0
 * g(x,y) = g(x-1, g(x, y-1)) if x > 0 and y > 0
 * 
 * Using the substitution model, sketch the computations of
 * g(1,0)
 * g(1,2)
 * g(2,2)
 * 
 * Will this function terminate for all positive integers supplied as arguments?
 * theoretically yes, practically no. The call stack would become too big.
 * 
 * How do you expect this function behave with respect to x and y?
 * x will decrement from x until it reaches 0, then it will vary from 0 to 1
 * y will keep increasing until the call stack returns value for y, which is when x = 0
 * Implement it and try it out for values of x < 4 and various values of y.
 * Now try it for x = 4 and various values of y.
 * What do you see?
 * 		SOE iff (x >= 4) ^ (y > 0)
 * Why does the function behave this way?
 * 		When x > 0 and y = 0, g(x, y) gives a value of 1, which makes the function 
 * return a large value to the top of the method stack
 * g(3, n) ~ 1000(2^(n-7)) n > 7
 * /

/**
 * @author Louis Schlessinger
 */
public class Methods {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	    
		System.out.println("f(99) = " + f(99));
		System.out.println("f(87) = " + f(87));
		System.out.print(System.lineSeparator());
		System.out.println("g(1,0) = " + g(1,0));
		System.out.println("g(1,2) = " + g(1,2));
		System.out.println("g(2,2) = " + g(2,2));
		System.out.print(System.lineSeparator());
		
		Scanner scanner = new Scanner(System.in);
		boolean running = true;
		while (running) {
			System.out.println("Select function f or g by typing 'f' or 'g'.");
		    String function = scanner.next();
		    if (function.equals("f")) {
		    	System.out.println("Input function argument x: ");
		    	int x = scanner.nextInt();
		    	System.out.println("f(" + x + ") = " + f(x));
		    } else if (function.equals("g")) {
		    	System.out.println("Input function argument x: ");
		    	int x = scanner.nextInt();
		    	System.out.println("Input function argument y: ");
		    	int y = scanner.nextInt();
		    	System.out.println("g(" + x + ", " + y + ") = " + g(x, y));
		    } else {
		    	throw new IllegalArgumentException("'" + function + "' is not a function.");
		    }
		}
		scanner.close();
	}

	// how could I define these iteratively?
	
	public static int f(int x) {
//		System.out.println("calling f(" + x + ")");
		if (x > 100) {
			return x - 10;
		} else if (x <= 100){
			return f(f(x+11));
		} else {
			throw new IllegalArgumentException("Invalid arguments for f(x) x = " + x);
		}
	}
	
	public static int g(int x, int y) {
//		System.out.println("calling g(" + x + ", " + y + ")");
		if (x == 0) {
			return y + 1;
		} else if (x > 0 && y == 0) {
			return g(x - 1, 1);
		} else if (x > 0 && y > 0) {
			return g(x - 1, g(x, y - 1));
		} else {
			throw new IllegalArgumentException("Invalid arguments for g(x, y) x = " + x + ", y = " + y);
		}
	}
}
