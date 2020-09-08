package model;

public class RandCustomer {
	
	private static RandomNumberGenerator rand = new RandomNumberGenerator(); 
	
	public static Customer generateCustomer(Integer i, Integer j ,Integer k, Integer l) {

		return  new Customer( rand.getRandomUpperBoundedNumber(99), 
							rand.getRandomNumberWithinRange(i, j),
							rand.getRandomNumberWithinRange(k, l));
	}
	
}
