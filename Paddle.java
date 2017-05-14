/**
 * @(#)Paddle.java
 *
 *
 * @author 
 * @version 1.00 2017/5/10
 */
import java.awt.Rectangle;

public class Paddle {

	private int width = 100;
	private int height = 10;
	private int x = 350;
	private int y = 550;
	private Rectangle bounds;
	
    public Paddle() {
    	updateBounds();
    }
    
    public int getWidth(){
    	return width;
    }
    
    
    public void setWidth(int w){
    	width = w;
    	updateBounds();
    }
    
    public void setX(int x){
    	this.x = x;
    	updateBounds();
    }
    
    public Rectangle getBounds(){
    	return bounds;
    }
    
    private void updateBounds(){
    	bounds = new Rectangle(x, y, width, height);
    }
    
}