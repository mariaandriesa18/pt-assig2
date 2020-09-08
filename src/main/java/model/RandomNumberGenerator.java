package model;

import java.util.Random;

public class RandomNumberGenerator {
	public RandomNumberGenerator() {
	}
	
	public Integer getRandomUpperBoundedNumber(Integer upperBound) {
		Random r = new Random();
		Integer res = r.nextInt((upperBound - 1) + 1) + 1;
	    return res;
	}

	public Integer getRandomNumberWithinRange(Integer lowerBound, Integer upperBound) {
		Random r = new Random();
		Integer res = r.nextInt((upperBound - 1) + 1) + 1;
	    return res;	
		
	}

}

