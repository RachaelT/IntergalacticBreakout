/**
 * @(#)LevelFourComponent.java
 *
 *
 * @author 
 * @version 1.00 2017/5/18
 */

import javax.swing.JComponent;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.Font;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.awt.geom.Ellipse2D;


public class LevelFourComponent extends LevelComponent
{
	private static final int WIDTH = 50;
	private static final int HEIGHT = 30;
	private static final int BLUE = 5;
	private static final int INDIGO = 6;
	private static final int VIOLET = 7;
	private static final int MAGENTA = 8;

	/**
	 * 
	 */
    public LevelFourComponent() 
    {
    	super("CenterOfUniverseWinner.jpg");
    	init();
    }
    
    /**
	 * 
	 */
    public void init()
    {
    	//Generates Brick pattern
    	//Generates Brick pattern
    	//Magenta swirl
    	ArrayList<Brick> bricks = super.getBricks();
    	for(int i = 0; i < 2; i++)
    			{
    				bricks.add(new Brick((i * WIDTH) + (WIDTH * VIOLET),
    						              0, MAGENTA));
    			}	
    			for(int i = 0; i < 2; i++)
    			{
    				bricks.add(new Brick((i * WIDTH) + (WIDTH * INDIGO),
    									  HEIGHT, MAGENTA));
    			}
    			for(int i = 0; i < (2 + 1); i++)
    			{
    				bricks.add(new Brick((i * WIDTH) + (WIDTH * (BLUE - 1)),
    									  HEIGHT * 2, MAGENTA));
    			}
    			for(int i = 0; i < (2 +2); i++)
    			{
    				bricks.add(new Brick((i * WIDTH) + (WIDTH * 2), HEIGHT *
    									 (BLUE - 2), MAGENTA));
    			}
    			for(int i = 0; i < 2; i++)
    			{
    				bricks.add(new Brick((i * WIDTH) + (WIDTH * (BLUE - 1)),
    						    		  HEIGHT * (BLUE - 1), MAGENTA));
    			}
    			for(int i = 0; i < (2 + 1); i++)
    			{
    				bricks.add(new Brick((i * WIDTH) + (WIDTH * BLUE),
    								      HEIGHT * BLUE, MAGENTA));
    			}
    			
    			for(int i = 0; i < 2; i++)
    			{
    				bricks.add(new Brick((i * WIDTH) + (WIDTH * INDIGO),
    								      HEIGHT * INDIGO, MAGENTA));
    			}
    	    	
    	    	//Violet Swirl
    	    	for(int i = 0; i < 2; i++)
    			{
    				bricks.add(new Brick((i * WIDTH) + (WIDTH * VIOLET),
    									  HEIGHT * (MAGENTA + BLUE), VIOLET));
    			}	
    			for(int i = 0; i < 2; i++)
    			{
    				bricks.add(new Brick((i * WIDTH) + (WIDTH * MAGENTA), 
    								     HEIGHT * (MAGENTA + BLUE - 1), VIOLET));
    			}
    			for(int i = 0; i < (2 + 1); i++)
    			{
    				bricks.add(new Brick((i * WIDTH) + (WIDTH * (MAGENTA + 1)),
    									  HEIGHT * (MAGENTA + 2 + 1), VIOLET));
    			}
    			for(int i = 0; i < (2 + 2); i++)
    			{
    				bricks.add(new Brick((i * WIDTH) + (WIDTH * (MAGENTA + 2)),
    								      HEIGHT * (MAGENTA + 2), VIOLET));
    			}
    			for(int i = 0; i < 2; i++)
    			{
    				bricks.add(new Brick((i * WIDTH) + (WIDTH * (MAGENTA + 2)),
    								      HEIGHT * (MAGENTA + 1), VIOLET));
    			}
    			for(int i = 0; i < (2 + 1); i++)
    			{
    				bricks.add(new Brick((i * WIDTH) + (WIDTH * MAGENTA),
    									  HEIGHT * MAGENTA, VIOLET));
    			}
    			for(int i = 0; i < 2; i++)
    			{
    				bricks.add(new Brick((i * WIDTH) + (WIDTH * VIOLET), 
    									  HEIGHT * VIOLET, VIOLET));
    			}
    			
    			//Indigo Swirl
    			bricks.add(new Brick(WIDTH * MAGENTA, HEIGHT * INDIGO, 
    								INDIGO));
    			
    			for(int i = 0; i < (2 + 1); i++)
    			{
    				bricks.add(new Brick((i * WIDTH) + (WIDTH * MAGENTA ), 
    									  HEIGHT * BLUE, INDIGO));
    			}
    			for(int i = 0; i < (2 + 1); i++)
    			{
    				bricks.add(new Brick((i * WIDTH) + (WIDTH * (MAGENTA + 1)),
    									  HEIGHT * (BLUE - 1), INDIGO));
    			}
    			for(int i = 0; i < (2 + 1); i++)
    			{
    				bricks.add(new Brick((i * WIDTH) + (WIDTH * (MAGENTA + 2 + 1)),
    									  HEIGHT * (2 + 1), INDIGO));
    			}
    			bricks.add(new Brick(WIDTH * (MAGENTA + 2 + 2), HEIGHT * 2, INDIGO));
    			for(int i = 0; i < 2; i++)
    			{
    				bricks.add(new Brick((i * WIDTH) + (WIDTH * (MAGENTA + BLUE)), 
    							     	  HEIGHT * (BLUE - 1), INDIGO));
    			}
    			for(int i = 0; i < 2; i++)
    			{
    				bricks.add(new Brick((i * WIDTH) + (WIDTH * (MAGENTA + INDIGO)), 
    									  HEIGHT * BLUE, INDIGO));
    			}
    			bricks.add(new Brick(WIDTH * (MAGENTA + 2 + BLUE), HEIGHT * INDIGO, 
    								 INDIGO));
    			
    			//Blue Swirl
    			bricks.add(new Brick(WIDTH * INDIGO, HEIGHT * VIOLET, BLUE));
    			for(int i = 0; i < (2 + 1); i++)
    			{
    				bricks.add(new Brick((i * WIDTH) + (WIDTH * (BLUE - 1)), 
    									  HEIGHT * MAGENTA, BLUE));
    			}
    			for(int i = 0; i < (2 + 1); i++)
    			{
    				bricks.add(new Brick((i * WIDTH) + (WIDTH * (2 + 1)), 
    								      HEIGHT * (MAGENTA + 1), BLUE));
    			}
    			for(int i = 0; i < (2 + 1); i++)
    			{
    				bricks.add(new Brick((i * WIDTH) + WIDTH, HEIGHT * 
    							  		 (MAGENTA + 2), BLUE));
    			}
    			bricks.add(new Brick(WIDTH * 2, HEIGHT * (MAGENTA + 2 + 1),
    						         BLUE));
    			
    			for(int i = 0; i < 2; i++)
    			{
    				bricks.add(new Brick((i * WIDTH), HEIGHT * (MAGENTA + 1),
    									 BLUE));
    			}
    			bricks.add(new Brick(0, HEIGHT * MAGENTA, BLUE));
		
    	//Adds a ball
		ArrayList<Ball> balls = super.getBalls(); 
    	Paddle paddle = super.getPaddle();
    	balls.add(new Ball(paddle.getBounds().x + paddle.getWidth()/2,
    					   paddle.getBounds().y,
    					   2, -5));
    }
    

}
    
    
