/**
 * @author Sage Miller
 * 22/04/2019
 */
public class CartoonTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CartoonCelebrity bigBird = new CartoonCelebrity("Big Bird", "Sesame Street,Covered in yellow feathers");
		System.out.println(bigBird);
		System.out.println("Clue: " + bigBird.getClue());
		System.out.println("Show: " + bigBird.getShow());
	}

}
