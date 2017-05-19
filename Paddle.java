/**This class represents a paddle in the breakout game,
 * maintaining it's boundaries, motion, and appearance
 * 
 * @author Rachael Thompson, Marshall Morton, Diana Shao
 * @date 5/17/2017
 * Period 2
 */

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import java.io.File;
import javax.imageio.ImageIO;

public class Paddle 
{

	public static final int DEFAULT_WIDTH = 150;
	public static final int DEFAULT_HEIGHT = 20;
	public static final int DEFAULT_X = 350;
	public static final int DEFAULT_Y = 550;
	
	private int width;
	private int height;
	private int x ;
	private int y ;
	
	private Rectangle bounds;
	private BufferedImage image;
	
	/**Generates a paddle with default position and size
	 */
    public Paddle() 
    {
    	width = DEFAULT_WIDTH;
    	height = DEFAULT_HEIGHT;
    	x = DEFAULT_X;
    	y = DEFAULT_Y;
    	updateBounds();
    }
    
    /**Returns the paddle's width
     * @return the paddle's width
     */
    public int getWidth()
    {
    	return width;
    }
    
    /**Returns the paddle's height
     * @return the paddle's height
     */
    public int getHeight()
    {
    	return height;
    }
    
    /**Updates the paddle's width
     * @param w the paddle's new width
     */
    public void setWidth(int w)
    {
    	width = w;
    	updateBounds();
    }
    
    /**Updates the paddle's x position
     * @param x the paddle's new x position
     */
    public void setX(int x)
    {
    	this.x = x;
    	updateBounds();
    }
    
    /**Returns the paddle's bounding rectangle
     * @return the paddle's bounding rectangle
     */
    public Rectangle getBounds()
    {
    	return bounds;
    }
    
    /**Returns the paddle's sprite
     * @return the paddle's sprite
     */
    public BufferedImage getImage()
    {
    	try{
    		image = ImageIO.read(new File("Space_Paddle.png"));
    	}
    	catch(Exception e) { }
    	return image;
    }
    
    /**Updates the boundaries of the paddle
     */
    private void updateBounds()
    {
    	bounds = new Rectangle(x, y, width, height);
    }
    


}