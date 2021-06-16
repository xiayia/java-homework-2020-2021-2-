package homework9;

/**
 * @author _britney_ 
 * @date 2021/6/7
 * @description Chapter12 ≥Ã–Ú«Âµ•12-10
 */

public class InvalidRadiusException extends Exception {
	  private double radius;

	  /** Construct an exception */
	  public InvalidRadiusException(double radius) {
	    super("Invalid radius " + radius);
	    this.radius = radius;
	  }

	  /** Return the radius */
	  public double getRadius() {
	    return radius;
	  }
	}
