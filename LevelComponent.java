/**
 * @(#)LevelComponent.java
 *
 *
 * @author 
 * @version 1.00 2017/5/10
 */

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.*;

import javax.imageio.ImageIO;
import javax.swing.JComponent;

public abstract class LevelComponent extends JComponent {
	
	private ArrayList<Brick> bricks;
	private ArrayList<Ball> balls;
	private ArrayList<Powerup> powerups;
	private Paddle paddle;
	private String lives;
	private String score;
	private BufferedImage background;
	
	/**Initializes the game element collections
	 */
	public LevelComponent(String fn) 
    {
    	lives = "";
    	score = "";
    	background = testImage(fn);
    	bricks = new ArrayList<Brick>();
    	balls = new ArrayList<Ball>();
    	powerups = new ArrayList<Powerup>();
    	paddle = new Paddle();
    }
	
	/** Here is where the game elements are initialized
	 *  and added to the appropriate collection
	 */
	public abstract void init();
	
	/** Paints the various game elements and graphics
	 * @param g the graphics object that does the painting
	 */
    @Override
	public void paintComponent(Graphics g) 
	{
		Graphics2D gr2 = (Graphics2D) g;
		
		gr2.drawImage(background, 0, 
				0, background.getWidth(), background.getHeight(), null);
	
		// Draw Bricks
    	for(Brick b: bricks)
    	{
			gr2.drawImage(b.getColor(), b.getBounds().x, 
										b.getBounds().y, 50, 30, null);
    	}
    	
    	//Draw Paddle
    	gr2.drawImage(paddle.getImage(), paddle.getBounds().x, 
				paddle.getBounds().y, paddle.getWidth(), paddle.getHeight(), null);
    	
    	//Draw Balls
    	for(Ball b: balls)
    	{
    		if(!b.inPlay())
    		{
    			b.updateBounds(paddle.getBounds().x + paddle.getWidth()/2,
    						   paddle.getBounds().y);
    		}
    		else
    		{
    			b.move();
    		}
    		gr2.drawImage(b.getImage(), (int)(b.getBounds().x), 
    									(int)(b.getBounds().y), 20, 20, null);
    	}
    	
    	//Draw Lives
    	g.setColor(Color.WHITE);
    	Font myFont = new Font("SanSerif", Font.BOLD, 18);
    	g.setFont(myFont);
    	g.drawString("Lives: " + lives, 700, 570);
    	
    	g.setColor(Color.WHITE);
    	g.setFont(myFont);
    	g.drawString("Score: " + score, 10, 570);
    	
    	//Draw falling powerups
    	for(Powerup p: powerups)
    	{
    		if(!p.isActive()) gr2.drawImage(p.getImage(), p.getBounds().x, 
    									    p.getBounds().y, 30, 30, null);
    	}	
	}
	
    /**Returns the paddle object
	 * @return the paddle object
	 */
	public Paddle getPaddle()
	{
		return paddle;
	}
	
	/**Returns the list of bricks
	 * @return the list of bricks
	 */
	public ArrayList<Brick> getBricks()
	{
		return bricks;
	}
	
	/**Returns the list of balls
	 * @return the list of balls
	 */
	public ArrayList<Ball> getBalls()
	{
		return balls;
	}
	
	/**Returns the list of powerups
	 * @return the list of powerups
	 */
	public ArrayList<Powerup> getPowerups()
	{
		return powerups;
	}
	
	/**Sets the number of lives
	 * @param l the number of lives to set
	 */
	public void setLives(int l)
	{
		lives = Integer.toString(l);
	}
	
	/**Sets the score
	 * @param s the score to set
	 */
	public void setScore(int s)
	{
		score = Integer.toString(s);
	}
	
	/**Gets a random number to set ball speed
	 * @return a random integer between 5 and 9
	 */
	public int getRandom()
	{
		return (int) (Math.random() * 4) + 5;
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