
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
	
	/**Creates a new Ball with the given parameters
	 * @param x the ball's X position
	 * @param y the ball's Y position
	 * @param xspeed the ball's horizontal speed
	 * @param yspeed the ball's vertical speed
	 */
    public Ball(double x, double y, int xspeed, int yspeed) 
    {
    	updateBounds(x, y);
    	this.yspeed = yspeed;
    	this.xspeed = xspeed;
    	pic = testImage("Ball.png");
    	inPlay = false;
   }
    
    /** Move's the ball's bound by the magnitude of the X and Y speed
     */
    public void move(){
    	circle = new Ellipse2D.Double(circle.x + xspeed,
    						   circle.y + yspeed,
    						   RADIUS, RADIUS);
    }
    
    /**Updates the speed and direction of the ball
     * @param xspeed the ball's horizontal speed
     * @param yspeed the ball's vertical speed
     */
    public void updateSpeed(int xspeed, int yspeed)
    {
    	this.yspeed = yspeed;
    	this.xspeed = xspeed;
    }
    
    /**Sets the ball "in play" meaning it's no longer
     * stuck to the paddle
     * @param i whether the ball is in play
     */
    public void setPlay(boolean i)
    {
    	inPlay = i;
    }
    
    /**Returns whether the ball has left the paddle
     * @return whether the ball has left the paddle
     */
    public boolean inPlay()
    {
    	return inPlay;
    }
    
    /**Returns the bounding ellipse of the ball
     * @return the bounding ellipse of the ball
     */
    public Ellipse2D.Double getBounds()
    {
    	return circle;
    }
    
    /**Returns the ball's radius
     * @return the ball's radius
     */
    public int getRadius()
    {
    	return RADIUS;
    }
    
    /**Updates the boundaries of the ball
     * @param x the new X coordinate
     * @param y the new Y coordinate
     */
    public void updateBounds(double x, double y)
    {
    	circle = new Ellipse2D.Double(x - RADIUS, y - 2 * RADIUS, 
    							     RADIUS, RADIUS);
    }
    
    /**Returns the ball's horizontal speed
     * @return the ball's horizontal speed
     */
    public int getXspeed()
    {
    	return xspeed;
    }
   
    /**Returns the ball's vertical speed
     * @return the ball's vertical speed
     */
    public int getYspeed()
    {
    	return yspeed;
    }
    
    /**Returns the ball's sprite
     * @return the ball's sprite
     */
    public BufferedImage getImage()
    {
    	return pic;
    }
   
    /** Finds the ball's sprite from a filename
     * @param fileName the filename of the ball's sprite
     * @return the ball's sprite
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