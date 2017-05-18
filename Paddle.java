/**
 * @(#)Paddle.java
 *
 *
 * @author 
 * @version 1.00 2017/5/10
 */
import java.awt.Rectangle;

import java.io.File;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.Graphics2D;

public class Paddle {

	private int width = 150;
	private int height = 20;
	private int x = 350;
	private int y = 550;
	private Rectangle bounds;
	private BufferedImage image;
	
    public Paddle() {
    	updateBounds();
    }
    
    
    public int getWidth(){
    	return width;
    }
    
    public int getHeight(){
    	return height;
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
    
    public BufferedImage getImage()
    {
    	try{
    		image = ImageIO.read(new File("Space_Paddle.png"));
    	}
    	catch(Exception e) { }
    	return image;
    }
    
    private void updateBounds(){
    	bounds = new Rectangle(x, y, width, height);
    }
    


}