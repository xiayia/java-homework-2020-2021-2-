package homework6;

/**
*
* @author _britney_
* @date 2021/5/17
* @description ≥Ã–Ú«Âµ•11-3
*/

public class RectangleFromSimpeGeometricObject
	extends SimpleGeometricObject {
	private double width;
	private double height;
	
	public RectangleFromSimpeGeometricObject(){
	}
	
	public RectangleFromSimpeGeometricObject(
	    double width, double height) {
	    this.width = width;
	    this.height = height;
	}
	
	public RectangleFromSimpeGeometricObject(
	    double width, double height, String color, boolean filled) {
	    this.width = width;
	    this.height = height;
	    setColor(color);
	    setFilled(filled);
	}
	
	/** Return width */
	public double getWidth() {
	    return width;
	}
	
	/** Set a new width */
	public void setWidth(double width) {
	    this.width = width;
	}
	
	/** Return height */
	public double getHeight() {
	    return height;
	}
	
	/** Set a new height */
	public void setHeight(double height) {
	    this.height = height;
	}
	
	/** Return area */
	public double getArea() {
	    return width * height;
	}
	
	/** Return perimeter */
	public double getPerimeter() {
	    return 2 * (width * height);
	}
	}