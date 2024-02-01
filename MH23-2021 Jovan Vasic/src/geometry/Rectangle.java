package geometry;

import java.awt.Color;
import java.awt.Graphics;

public class Rectangle extends Shape {

	private Point upperLeft;
	private int width;
	private int height;
	private Color bordercolor = Color.BLACK;
	private Color fillcolor = Color.PINK;
	
	public Rectangle() {
		
	}
	
	public Rectangle(Point upperLeft, int width, int heigth) {
		this.upperLeft = upperLeft;
		this.width = width;
		this.height = heigth;
	}
	
	public Rectangle(Point upperLeft, int width, int heigth,boolean selected) {
		this(upperLeft, width, heigth);
		this.selected = selected;
	}
	
	@Override
	public void draw(Graphics g) {
		g.setColor(fillcolor);
		g.fillRect(upperLeft.getX()+1, upperLeft.getY()+1, width-1, height-1);
		g.setColor(bordercolor);
		g.drawRect(upperLeft.getX(), upperLeft.getY(), width, height);
		if(selected) {
			g.setColor(Color.BLUE);
			g.drawRect(upperLeft.getX()-3, upperLeft.getY()-3, 6, 6);
			g.drawRect(upperLeft.getX()+width-3, upperLeft.getY()-3, 6, 6);
			g.drawRect(upperLeft.getX()-3, upperLeft.getY()+height-3, 6, 6);
			g.drawRect(upperLeft.getX()+width-3, upperLeft.getY()+height-3, 6, 6);
		}
		
	}
	
	@Override
	public void moveTo(int x, int y) {
		upperLeft.moveTo(x, y);
	}

	@Override
	public void moveBy(int byX, int byY) {
		upperLeft.moveBy(byX, byY);
	}

	public int area() {
		return width * height;
	}

	public int circumference() {
		return 2 * width + 2 * height;
	}
	
	@Override
	public String toString() {
		return "Upper left: (" + upperLeft.getX() + "," + upperLeft.getY() + "), "
				+ "width = " + width + ", height = " + height; 
	}
	
	@Override
	public int compareTo(Object o) {
		if(o instanceof Rectangle) {
			Rectangle temp = (Rectangle) o;
			return area() - temp.area();
		}
		return 0;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof Rectangle) {
			Rectangle temp = (Rectangle) o;
			if(width == temp.getWidth() && height == temp.getHeight()) {
				return true;
			}
		}
		return false;
	}
	
	public boolean contains(int x, int y) {
		if( (x >= upperLeft.getX() && x <= upperLeft.getX() + width)
				&& (y>= upperLeft.getY() && y <= upperLeft.getY() + height) ) {
			return true;
		}
		return false;
	}

	public Point getUpperLeft() {
		return upperLeft;
	}

	public void setUpperLeft(Point upperLeft) {
		this.upperLeft = upperLeft;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	
	public int getShape() {
		return 3;
	}
	
	public void setFillColor(Color color) {
		this.fillcolor = color;
	}
	
	public void setBorderColor(Color color) {
		this.bordercolor = color;
	}
	
	public Color getBorderColor() {
		return bordercolor;
	}
	
	public Color getFillColor() {
		return fillcolor;
	}

}
