package geometry;

import java.awt.Color;
import java.awt.Graphics;

public class Donut extends Circle {

	private int innerRadius;
	private Color fillcolor = Color.PINK;
	private Color bordercolor = Color.BLACK;
	
	public Donut() {
		
	}
	public Donut(Point center, int radius, int innerRadius) {
		super(center, radius);
		this.innerRadius = innerRadius;
	}
	
	public Donut(Point center, int radius, boolean selected, int innerRadius) {
		super(center, radius, selected);
		this.innerRadius = innerRadius;
	}
	
	@Override
	public void draw(Graphics g) {	
		g.setColor(bordercolor);
		super.draw(g);
		g.setColor(Color.PINK);
		g.fillOval(getCenter().getX()-innerRadius, getCenter().getY()-innerRadius, 
				innerRadius*2, innerRadius*2);
		g.setColor(bordercolor);
		g.drawOval(getCenter().getX()-innerRadius, getCenter().getY()-innerRadius, 
				innerRadius*2, innerRadius*2);
		
		if(selected) {
			g.setColor(Color.BLUE);
			g.drawRect(center.getX()-innerRadius-3, center.getY()-3, 6, 6);
			g.drawRect(center.getX()+innerRadius-3, center.getY()-3, 6, 6);
			g.drawRect(center.getX()-3, center.getY()-innerRadius-3, 6, 6);
			g.drawRect(center.getX()-3, center.getY()+innerRadius-3, 6, 6);
		}
	}
	
	@Override
	public boolean contains(int x, int y) {
		return super.contains(x, y) && 
				getCenter().distance(new Point(x,y))>=innerRadius;
	}
	
	@Override
	public boolean contains(Point p) {
		return contains(p.getX(), p.getY());
	}
	
	@Override
	public String toString() {
		return super.toString() + ", inner radius: " + innerRadius;
	}
	
	@Override
	public int compareTo(Object o) {
		if(o instanceof Donut) {
			Donut temp = (Donut) o;
			return (int)(area() - temp.area());
		}
		return 0;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof Donut) {
			Donut temp = (Donut) o;
			if(getCenter().equals(temp.getCenter()) && getRadius() == temp.getRadius() &&
					innerRadius == temp.getInnerRadius()) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public double area() {
		return super.area() - (Math.PI*innerRadius*innerRadius);
	}

	public int getInnerRadius() {
		return innerRadius;
	}

	public void setInnerRadius(int innerRadius) {
		this.innerRadius = innerRadius;
	}
	
	public int getShape() {
		return 4;
	}
	
	public Color getBorderColor() {
		return bordercolor;
	}
	
	public Color getFillColor() {
		return fillcolor;
	}
}
