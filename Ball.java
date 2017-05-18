
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
public class Ball {

	private static final int RADIUS = 10;
	private int xspeed;
	private int yspeed;
	
	private Ellipse2D.Double circle;
	private BufferedImage pic;
	private boolean inPlay;
	
	/**
	 * 
	 * @param x
	 * @param y
	 * @param xspeed
	 * @param yspeed
	 */
    public Ball(double x, double y, int xspeed, int yspeed) 
    {
    	updateBounds(x, y);
    	this.yspeed = yspeed;
    	this.xspeed = xspeed;
    	pic = testImage("Ball.png");
    	inPlay = false;
   }
    
    /**
     * 
     */
    public void move(){
    	circle = new Ellipse2D.Double(circle.x + xspeed,
    						   circle.y + yspeed,
    						   RADIUS, RADIUS);
    }
    
    /**
     * 
     * @param xspeed
     * @param yspeed
     */
    public void updateSpeed(int xspeed, int yspeed)
    {
    	this.yspeed = yspeed;
    	this.xspeed = xspeed;
    }
    
    /**
     * 
     * @param i
     */
    public void setPlay(boolean i)
    {
    	inPlay = i;
    }
    
    /**
     * 
     * @return
     */
    public boolean inPlay()
    {
    	return inPlay;
    }
    
    /**
     * 
     * @return
     */
    public Ellipse2D.Double getBounds()
    {
    	return circle;
    }
    
    /**
     * 
     * @return
     */
    public int getRadius()
    {
    	return RADIUS;
    }
    
    /**
     * 
     * @param x
     * @param y
     */
    public void updateBounds(double x, double y)
    {
    	circle = new Ellipse2D.Double(x - RADIUS, y - 2 * RADIUS, 
    							     RADIUS, RADIUS);
    }
    
    /**
     * 
     * @return
     */
    public int getXspeed()
    {
    	return xspeed;
    }
   
    /**
     * 
     * @return
     */
    public int getYspeed()
    {
    	return yspeed;
    }
    
    /**
     * 
     * @return
     */
    public BufferedImage getImage()
    {
    	return pic;
    }
   
    /**
     * 
     * @param fileName
     * @return
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