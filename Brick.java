/**
 * @(#)Brick.java
 *
 *
 * @author 
 * @version 1.00 2017/4/24
 */


import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import java.io.File;
import javax.imageio.ImageIO;



public class Brick {
	
	static final int WIDTH = 50;
	private static final int HEIGHT = 30;
	
	private int durability;

	private boolean destroyed;
	
	private Rectangle bounds;
	private Powerup p;
	private BufferedImage c;
	
	/** Creates a new Brick with the given parameters
	 * @param x x coordinate of the brick
	 * @param y y coordinate of the brick
	 * @param durability the number of hits to destroy the brick
	 */
	public Brick(int x, int y, int durability) 
	{
		bounds = new Rectangle(x, y, WIDTH, HEIGHT);

    	this.durability = durability;
    	c = setDurability(durability);
	}

	/** Creates a new brick with a powerup inside
	 * @param x x coordinate of the brick
	 * @param y y coordinate of the brick
	 * @param durability the number of hits to destroy the brick
	 * @param p the brick's powerup
	 */
    public Brick(int x, int y, int durability, Powerup p)
    {
    	bounds = new Rectangle(x, y, WIDTH, HEIGHT);
    	this.durability = durability;
    	c = setDurability(durability);
    	this.p = p;
    }
    
    /**Decrements the durability if the brick has been hit
     */
 	public void touched()
 	{
 		durability--;
 		c = setDurability(durability);
 	}
 	
 	/**Returns the number of hits the brick has left
 	 * @return the number of hits the brick has left
 	 */
 	public int getDurability()
 	{
 		return durability;
 	}
 	
 	/**Returns the color (image) of the brick
 	 * @return the brick's color
 	 */
 	public BufferedImage getColor()
 	{
 		c = setDurability(durability);
 		return c;
 	}
 	
 	/**Returns the brick's powerup
 	 * @return the brick's powerup
 	 */
 	public Powerup getPowerup()
 	{
 		return p;
 	}
 	
 	/**Returns the brick's bounding rectangle
 	 * @return the brick's bounding rectangle
 	 */
 	public Rectangle getBounds()
 	{
 		return bounds;
 	}
 	
 	/**Returns if the brick is destroyed
 	 * @return whether the brick is destroyed
 	 */
 	public boolean isDestroyed()
 	{
 		return destroyed;
 	}
 	
 	/**Updates the brick's color based on its durability
 	 * @param durability the number of hits the brick has left
 	 * @return the brick's color (image)
 	 */
 	private BufferedImage setDurability(int durability)
 	{
 		BufferedImage image;
 		if(durability == 0)
 		{
 			destroyed = true;
 			image = testImage("Delete_Brick");
 			return image;  
 		}
 		if(durability == 1)
 		{
 			image = testImage("Red_Brick.png");
 			return image;
 		}
 		else if (durability == 2)
 		{
 			image = testImage("Orange_Brick.png");
 			return image;
 		}
 		else if (durability == 3)
 		{
 			image = testImage("Yellow_Brick.png");
 			return image;
 		}
 		else if (durability == 4)
 		{
 			image = testImage("Green_Brick.png");
 			return image;
 		}
 		else if (durability == 5)
 		{
 			image = testImage("Blue_Brick.png");
 			return image;
 		}
 		else if (durability == 6)
 		{
 			image = testImage("Indigo_Brick.png");
 			return image;
 		}
 		else if (durability == 7)
 		{
 			image = testImage("Violet_Brick.png");
 			return image;
 		}
 		else
 		{
 			image = testImage("Magenta_Brick.png");
 			return image;
 		}	
 	}
	

	/**Finds an image file from it's filename
	 * @param fileName the filename of a brick sprite
	 * @return the brick sprite
	 */
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