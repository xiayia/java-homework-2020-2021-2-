package homework9;

/**
 * @author _britney_ 
 * @date 2021/6/7
 * @description Chapter12 ≥Ã–Ú«Âµ•12-8
 */

public class TestCircleWithException {
	  public static void main(String[] args) {
	    try {
	      CircleWithException c1 = new CircleWithException(5);
	      CircleWithException c2 = new CircleWithException(-5);
	      CircleWithException c3 = new CircleWithException(0);
	    }
	    catch (IllegalArgumentException ex) {
	      System.out.println(ex);
	    }

	    System.out.println("Number of objects created: " +
	      CircleWithException.getNumberOfObjects());
	  }
	}
