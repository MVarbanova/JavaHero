package game.graphicalInterface;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.*;
import java.awt.geom.Ellipse2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class PointOnScreen extends JPanel {	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1880984334999030223L;


	public PointOnScreen() {

		this.setBackground(new java.awt.Color(20, 145, 15));
		
	      addMouseListener(new MouseAdapter() { 
	          @Override
			public void mousePressed(MouseEvent me) { 
	            repaint();
	          } 
	        }); 

	  }
	
  @Override
public void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2d = (Graphics2D) g;    
    Dimension size = getSize();
    
    int w = size.width ;
    int h = size.height;
    int x,y;

    try
    {
	    x =  (int) this.getMousePosition().getX() % w;
	    y =  (int) this.getMousePosition().getY() % h;	    
    }
    catch (Exception e)
    {
    	x = w/2;
    	y = h/2;
    	e.getMessage();
    }
    Ellipse2D e = new Ellipse2D.Double(x,y,10,10);
    
    g2d.setColor(new java.awt.Color(20, 15, 10));
    g2d.fill(e);
      
  }

  
  public static void main(String[] args) {
	PointOnScreen points = new PointOnScreen();
	JFrame frame = new JFrame("Points");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.add(points);
    frame.setSize(250, 200);
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
  }
}