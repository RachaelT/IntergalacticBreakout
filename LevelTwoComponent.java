/**
 * @(#)LevelTwoComponent.java
 *
 *
 * @author 
 * @version 1.00 2017/5/17
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


public class LevelTwoComponent extends LevelComponent
{

	private static final int YELLOW = 3;
	private static final int GREEN = 4;
	private static final int BLUE = 5;
	private static final int NUM_COLORS = 8;
	/**
	 * 
	 */
    public LevelTwoComponent() 
    {
    	super("KnownUniverse.jpg");
    	init();
    }
    
    /**
	 * 
	 */
    public void init()
    {
    	ArrayList<Brick> bricks = super.getBricks();
    	//Generates Brick pattern
    	for(int i = 0; i < YELLOW; i++)
    	{
    		for(int j = 0; j <= GREEN; j++)
    		{
    			bricks.add(new Brick(i * Brick.WIDTH + BLUE * Brick.WIDTH, i * Brick.HEIGHT,
    							 i % YELLOW + 1 ));
    		
    		}
    	}
    	
    	for(int i = 0; i < YELLOW; i++)
    	{
    		for(int j = 0; j <= GREEN; j++)
    		{
    			bricks.add(new Brick(i * Brick.WIDTH + Brick.WIDTH * NUM_COLORS, i * Brick.HEIGHT,
    								(YELLOW - i) ));
    	
    		}
    	}
    				 
		
		for(int i = 0; i < NUM_COLORS; i++)
		{
    	
    		bricks.add(new Brick(i * Brick.WIDTH + Brick.WIDTH * NUM_COLORS, (i * Brick.HEIGHT), YELLOW));
    		bricks.add(new Brick(i * Brick.WIDTH + Brick.WIDTH * NUM_COLORS,  (i * Brick.HEIGHT) + Brick.HEIGHT,
    							 YELLOW));
    	}
    	
    	for(int i = 0; i < NUM_COLORS; i++)
    	{
    		bricks.add(new Brick(i * Brick.WIDTH + Brick.WIDTH * NUM_COLORS, (i * Brick.HEIGHT),
    						  	 YELLOW));
    		bricks.add(new Brick(i * Brick.WIDTH + Brick.WIDTH * NUM_COLORS,  (i * Brick.HEIGHT) + Brick.HEIGHT,
    							 YELLOW));
    	}
    	
    	for(int i = 0; i < NUM_COLORS; i++)
    	{
    		bricks.add(new Brick(i * Brick.WIDTH, Brick.HEIGHT * NUM_COLORS -((i * Brick.HEIGHT)),
    						  	 YELLOW));
    		bricks.add(new Brick(i * Brick.WIDTH, Brick.HEIGHT * NUM_COLORS -((i * Brick.HEIGHT) + Brick.HEIGHT),
    							 YELLOW)); 
    	}
    	ArrayList<Ball> balls = super.getBalls(); 
    	Paddle paddle = super.getPaddle();

    	//Adds a ball
    	balls.add(new Ball(paddle.getBounds().x + paddle.getWidth()/2,
    					   paddle.getBounds().y,
    					   super.getRandom(), -super.getRandom()));
    }
   

}