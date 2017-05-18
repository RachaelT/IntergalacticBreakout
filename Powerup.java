/**
 * @(#)Powerup.java
 *
 *
 * @author 
 * @version 1.00 2017/4/24
 */

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;;
public abstract class Powerup {
	
	public static final long DURATION = 30000;
	public static final int WIDTH = 10;
	public static final int HEIGHT = 10;
	
	private boolean active;
	
	private long startTime;
	private long timeLeft; 

	private Rectangle bounds;
	private BufferedImage pic;
	
	public Powerup(int x, int y, String p)
	{
		active = false;
		timeLeft = DURATION;
		pic = testImage(p);
		bounds = new Rectangle(x, y, pic.getWidth(), pic.getHeight());
		
	}
	
	/** Returns the powerup's effect
	 * @return the powerup's effect
	 */
    public abstract String getEffect();
    
    /**Gets a description of the powerup's effects
     * @return a description of the powerup's effects
     */
    public abstract String getEffectDescription();
    
    /**Updates the remaining duration of the powerup's effect
     * @param currentTime the current system time in milliseconds
     */
    public void update(long currentTime)
    {
    	timeLeft -= (currentTime - startTime);
    	startTime = currentTime;
    }
    
    /**Returns whether the powerup's duration has been exceeded
     * @return whether the powerup is out of time
     */
    public boolean stop()
    {
    	if(timeLeft <= 0) return true;
    	return false;
    } 
     
    /**Returns whether the powerup has been activated
     * @return whether the powerup has been activated
     */
    public boolean isActive()
    {
    	return active;
    }
    
    /**Activates the powerup's effect and starts its timer
     * @param time the current system time in milliseconds
     */
    public void activate(long time)
    {
    	active = true;
    	startTime = time;
    }
    
    /**Returns the boundaries of the powerup's sprite
     * @return the powerup's bounds
     */
    public Rectangle getBounds()
    {
    	return bounds;
    }
    
    /**Returns the powerup's sprite
     * @return the powerup's sprite
     */
    public BufferedImage getImage()
    {
    	return pic;
    }
    
    /** Get's the powerup's sprite from a filename
     * @param fileName the name of the sprite's image file
     * @return the sprite
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