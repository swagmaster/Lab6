
import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;

public class FractalFlake extends Shape {

	private final int numBranches;
	private final int size;
	
	public FractalFlake(int x, int y) {
		super(x,y);
		this.size = 10;
		this.numBranches = 3;
	}
	
	public void draw(Graphics g) { //a redirect or facade
		draw(g, getX(), getY(), size, numBranches);
	}
	
	public void draw(Graphics g, int x, int y, int size, int numBranches) {
		for (int a = 0; a < 360; a += 60) {
			double rad = a * Math.PI / 180;
			int x2 = (int) (x + Math.cos(rad) * size);
			int y2 = (int) (y + Math.sin(rad) * size);
			g.drawLine(x, y, x2, y2);
			if (numBranches > 0) {
				draw(g, x2, y2, size/3, numBranches-1);
			}
		}
	}
} 
