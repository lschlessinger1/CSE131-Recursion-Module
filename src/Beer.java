import java.util.Scanner;

/**
 * http://www.cs.wustl.edu/~cytron/cse131/Modules/7/lab.html
 * Find the recursive substructure in the song.
 * 		n  bottles of beer on the wall, n bottles of beer; you take one down, pass 
 * it around,(n - 1) bottles of beer on the wall. bottlesOfBeer(n-1)
 */

/**
 * @author Louis Schlessinger
 *
 */
public class Beer {

	private static final String BEER_ON_WALL = "bottles of beer on the wall";
	
	public static void main(String[] args) {
		System.out.print(bottlesOfBeer(5));
		System.out.println("Enter the number of bottles of beer on the wall.");
		Scanner scanner = new Scanner(System.in);
	    int n = scanner.nextInt();
		System.out.println(bottlesOfBeer(n));
		scanner.close();
	}
	
	/**
	 * Computes the song starting at n and ending at 0.
	 * @param n
	 * @return 
	 */
	public static String bottlesOfBeer(int n) {
		if (n < 0) {
			throw new IllegalArgumentException("You can't have negative bottles of beer!");
		} else {
			if (n == 0) {
				return n + " " + BEER_ON_WALL + ".";
			}
			return n + " " + BEER_ON_WALL + "," + n +" bottles of beer; you take one down, pass it around,"
			+ (n - 1) + " " + BEER_ON_WALL + "." + bottlesOfBeer(n-1);
		}
	}

}
