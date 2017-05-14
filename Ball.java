import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

public class Ball {

	private int radius;
	
	private int xspeed;
	private int yspeed;
	
	
	private Ellipse2D.Double circle;
	
	private boolean inPlay;
	
		
    public Ball(double x, double y, int xspeed, int yspeed) {
    	radius = 10;
    	updateBounds(x, y, radius);
    	this.yspeed = yspeed;
    	this.xspeed = xspeed;
    	
    	inPlay = false;
   }
    
    public void move(){
    	circle = new Ellipse2D.Double(circle.x + xspeed,
    						   circle.y + yspeed,
    						   radius, radius);
    }
    
    public void updateSpeed(int xspeed, int yspeed){
    	this.yspeed = yspeed;
    	this.xspeed = xspeed;
    }
    
    
    public void setPlay(boolean i){
    	inPlay = i;
    }
    
    public boolean inPlay(){
    	return inPlay;
    }
    
    public Ellipse2D.Double getBounds(){
    	return circle;
    }
    
    public int getRadius(){
    	return radius;
    }
    
    public void updateBounds(double x, double y, int radius){
    	circle = new Ellipse2D.Double(x - radius, y - 2 * radius, radius, radius);
    }
    
    public int getXspeed(){
    	return xspeed;
    }
   
    public int getYspeed(){
    	return yspeed;
    }
   
    
    
    
}