/**
 * @(#)LevelThreeComponent.java
 *
 *
 * @author 
 * @version 1.00 2017/5/18
 */




/**
 * 
 * 
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


public class LevelThreeComponent extends LevelComponent
{

	/**
	 * 
	 */
    public LevelThreeComponent() 
    {
    	super("GameOverSpace.jpg");
    	init();
    }
    
    /**
	 * 
	 */
    @Override
    public void init()
    {
    	ArrayList<Brick> bricks = super.getBricks(); 
    	//Generates Brick pattern
		
		//yellowstar pattern
		bricks.add(new Brick(200, 0, 3));
    	for(int i = 0; i < 3; i++)
    	{
    		bricks.add(new Brick((i * 50) + 150, 30, 3));
    	}
    	for(int i = 0; i < 5; i++)
    	{
    		bricks.add(new Brick((i * 50) + 100, 60, 3));
    	}
    	for(int i = 0; i < 9; i++)
    	{
    		bricks.add(new Brick((i * 50), 90, 3));
    	}
    	for(int i = 0; i < 7; i++)
    	{
    		bricks.add(new Brick((i * 50) + 50, 120, 3));
    	}
    	for(int i = 0; i < 5; i++)
    	{
    		bricks.add(new Brick((i * 50) + 100, 150, 3));
    	}
    	for(int i = 0; i < 3; i++)
    	{
    		bricks.add(new Brick((i * 50) + 50, 180, 3));
    	}
    	for(int i = 0; i < 3; i++)
    	{
    		bricks.add(new Brick((i * 50) + 250, 180, 3));
    	}
    	for(int i = 0; i < 3; i++)
    	{
    		bricks.add(new Brick((i * 50), 210, 3));
    	}
    	for(int i = 0; i < 3; i++)
    	{
    		bricks.add(new Brick((i * 50) + 300, 210, 3));
    	}
    	
    	//Magenta Sparkle
    	bricks.add(new Brick(400, 0, 8));
    	bricks.add(new Brick(600, 0, 8));
    	bricks.add(new Brick(350, 30, 8));
    	bricks.add(new Brick(700, 30, 8));
    	bricks.add(new Brick(500, 90, 8));
    	bricks.add(new Brick(700, 180, 8));
    	
    	
    	ArrayList<Ball> balls = super.getBalls(); 
    	Paddle paddle = super.getPaddle();
    	//Adds a ball
    	balls.add(new Ball(paddle.getBounds().x + paddle.getWidth()/2,
    					   paddle.getBounds().y,
    					   2, -5));
    }
    
}