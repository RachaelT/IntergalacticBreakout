/**
 * @(#)Brick.java
 *
 *
 * @author 
 * @version 1.00 2017/4/24
 */


import java.awt.Rectangle;
import java.awt.Color;

import java.io.File;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.Graphics2D;

public class Brick {
	
	static final int WIDTH = 50;
	private static final int HEIGHT = 30;
	private int durability;
	
	private int x;
	private int y;
	
	private Rectangle bounds;
	
	private boolean destroyed;
	
	private Powerup p;
	
	private BufferedImage c;
	
	public Brick(int x, int y, int durability) {
		bounds = new Rectangle(x, y, WIDTH, HEIGHT);
    	this.x = x;
    	this.y = y;
    	this.durability = durability;
    	c = setDurability(durability);
	}

    public Brick(int x, int y, int durability, Powerup p) {
    	bounds = new Rectangle(x, y, WIDTH, HEIGHT);
    	this.x = x;
    	this.y = y;
    	this.durability = durability;
    	c = setDurability(durability);
    	this.p = p;
    }
    
 	public void touched(){
 		durability--;
 		c = setDurability(durability);
 	}
 	
 	
 	public int getDurability(){
 		return durability;
 	}
 	
 	public BufferedImage getColor(){
 		c = setDurability(durability);
 		return c;
 	}
 	
 	public Powerup getPowerup(){
 		return p;
 	}
 	
 	public Rectangle getBounds(){
 		return bounds;
 	}
 	
 	public boolean isDestroyed(){
 		return destroyed;
 	}
 	
 	private BufferedImage setDurability(int durability){
 		BufferedImage image;
 		if(durability == 0){
 			destroyed = true;
 			image = testImage("Delete_Brick");
 			return image;  
 		}
 		if(durability == 1){
 			image = testImage("Red_Brick.png");
 			return image;
 		}
 		else if (durability == 2){
 			image = testImage("Orange_Brick.png");
 			return image;
 		}
 		else if (durability == 3){
 			image = testImage("Yellow_Brick.png");
 			return image;
 		}
 		else if (durability == 4){
 			image = testImage("Green_Brick.png");
 			return image;
 		}
 		else if (durability == 5){
 			image = testImage("Blue_Brick.png");
 			return image;
 		}
 		else if (durability == 6){
 			image = testImage("Indigo_Brick.png");
 			return image;
 		}
 		else if (durability == 7){
 			image = testImage("Violet_Brick.png");
 			return image;
 		}
 		else{
 			image = testImage("Magenta_Brick.png");
 			return image;
 		}
 			
 	}
	

	//This method iis need because otherwise using ImageIO.read brings up an IOException 
	private BufferedImage testImage(String fileName)
	{
		BufferedImage image = null;
		try
		{
			image = ImageIO.read(new File(fileName));
		}
		catch (Exception e) { }
		return image;
	}

}