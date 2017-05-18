/**This is the abstract class from which all levels are
 * subclasses and created, managing the drawing of graphics
 * 
 * @author Rachael Thompson, Marshall Morton, Diana Shao
 * @date 5/17/2017
 * Period 2
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
	
	private final int FONT_SIZE = 18;
	private final int TEXT_HEIGHT = 570;
	private final int TEXT_LEFT = 10;
	private final int TEXT_RIGHT = 700;
	private final int RANDOM_VAR = 4;
	private final int RANDOM_MIN = 5;
	
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
										b.getBounds().y, 
										(int) b.getBounds().getWidth(), 
										(int) b.getBounds().getHeight(), null);
    	}
    	
    	//Draw Paddle
    	gr2.drawImage(paddle.getImage(), paddle.getBounds().x, 
				paddle.getBounds().y, paddle.getWidth(), paddle.getHeight(), null);
    	
    	//Draw Balls
    	for(Ball b: balls)
    	{
    		if(!b.inPlay())
    		{
    			b.updateBounds(paddle.getBounds().x + paddle.getWidth() / 2,
    						   paddle.getBounds().y);
    		}
    		else
    		{
    			b.move();
    		}
    		gr2.drawImage(b.getImage(), (int)(b.getBounds().x), 
    									(int)(b.getBounds().y), 
    									b.getRadius() * 2, 
    									b.getRadius() * 2, null);
    	}
    	
    	//Draw Lives
    	g.setColor(Color.WHITE);
    	Font myFont = new Font("SanSerif", Font.BOLD, FONT_SIZE);
    	g.setFont(myFont);
    	g.drawString("Lives: " + lives, TEXT_RIGHT, TEXT_HEIGHT);
    	
    	g.setColor(Color.WHITE);
    	g.setFont(myFont);
    	g.drawString("Score: " + score, TEXT_LEFT, TEXT_HEIGHT);
    	
    	//Draw falling powerups
    	for(Powerup p: powerups)
    	{
    		if(!p.isActive()) gr2.drawImage(p.getImage(), p.getBounds().x, 
    									    p.getBounds().y, p.WIDTH, 
    									    p.HEIGHT, null);
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
		return (int) (Math.random() * RANDOM_VAR) + RANDOM_MIN;
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