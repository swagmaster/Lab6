import java.awt.*;

import javax.swing.JFrame;

class Shape extends JFrame {
	private int x = 0;
	private int y = 0;
	
	public Shape(){}

	public Shape( int nx, int ny) {
		
		setX(nx);
		setY(ny);
	}
	
	public double getArea(){ 
		return -1;		
	}
	
	public void draw( Graphics g ){}
	
	
	public int getX() { 
		return x; 
	}
	
	
	public void setX(int nx) {
		x = nx;
	}
	
	
	public int getY() { 
		return y; 
	}
	
	public void setY(int ny){
		y = ny;
	}
}