package geometry;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Stack;
import java.awt.event.MouseMotionAdapter;




public class PnlDrawing extends JPanel {

	private static final long serialVersionUID = 1L;
	private boolean started = false;
	private Stack<Shape> stck2;
	private int X1, Y1, Y2, X2;


//PNLDRAWING KLASA
	
	public PnlDrawing(Stack <Shape> stck2) {
		this.stck2 = stck2;
		addMouseListener(new MouseAdapter() {
			
			
			@Override
			public void mouseClicked(MouseEvent e) {
				switch (frame2.getshape()) {
					case 0: {
						Point p1 = new Point(e.getX(), e.getY());
						stck2.push(p1);
						break;
					}
					case 1: {
						if (!started) {
							X1 = e.getX();
							Y1 = e.getY();
							started = true;
						}
						else if (started){							
							X2 = e.getX();
							Y2 = e.getY();
							Line l1 = new Line(new Point(X1, Y1), new Point(X2, Y2));
							stck2.push(l1);
							started = false;
						}
						break;	
					}
					case 2: {
						try {
							circDialog frame = new circDialog(new Point(e.getX(), e.getY()), stck2);
							frame.setModal(true);
							frame.setVisible(true);
						} catch (Exception ex) {
							ex.printStackTrace();
						}
						break;
						
					}
					case 3: {
						try {
							JRect frame = new JRect(stck2, new Point(e.getX(), e.getY()));
							frame.setModal(true);
							frame.setVisible(true);
						} catch (Exception ex) {
							ex.printStackTrace();
						}
						break;
						
					}
					case 4: {
						try {
							JDonut frame = new JDonut(stck2,new Point(e.getX(), e.getY()));
							frame.setModal(true);
							frame.setVisible(true);
						} catch (Exception ex) {
							ex.printStackTrace();
						}
						break;
						
					}
					case 5: {
						boolean temp = false;						
						for (int i = stck2.size() - 1; i >= 0; i--) {
							Shape s = stck2.get(i);
							s.setSelected(false);
							if (s.contains(e.getX(), e.getY())) {
								if (!temp) {
									s.setSelected(true);
									temp = true;
								}
							}
						}
						break;
					}
					default:
						break;
				}
				paint(getGraphics());
			}
		});
	}
	
	public void paint(Graphics g) {
		 super.paint(g);
	        for (Shape shape : stck2) {
	            shape.draw(g);
	        }
	}
	
	public void loop() {
		paint(getGraphics());
	}
	
	
	
	
}
