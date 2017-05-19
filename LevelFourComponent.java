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
		//Magenta swirl
    	ArrayList<Brick> bricks = super.getBricks();
		for(int i = 0; i < 2; i++)
		{
			bricks.add(new Brick((i * 50) + 350, 0, 8));
		}	
		for(int i = 0; i < 2; i++)
		{
			bricks.add(new Brick((i * 50) + 300, 30, 8));
		}
		for(int i = 0; i < 3; i++)
		{
			bricks.add(new Brick((i * 50) + 200, 60, 8));
		}
		for(int i = 0; i < 4; i++)
		{
			bricks.add(new Brick((i * 50) + 100, 90, 8));
		}
		for(int i = 0; i < 2; i++)
		{
			bricks.add(new Brick((i * 50) + 200, 120, 8));
		}
		for(int i = 0; i < 3; i++)
		{
			bricks.add(new Brick((i * 50) + 250, 150, 8));
		}
		for(int i = 0; i < 2; i++)
		{
			bricks.add(new Brick((i * 50) + 300, 180, 8));
		}
    	
    	//Violet Swirl
    	for(int i = 0; i < 2; i++)
		{
			bricks.add(new Brick((i * 50) + 350, 390, 7));
		}	
		for(int i = 0; i < 2; i++)
		{
			bricks.add(new Brick((i * 50) + 400, 360, 7));
		}
		for(int i = 0; i < 3; i++)
		{
			bricks.add(new Brick((i * 50) + 450, 330, 7));
		}
		for(int i = 0; i < 4; i++)
		{
			bricks.add(new Brick((i * 50) + 500, 300, 7));
		}
		for(int i = 0; i < 2; i++)
		{
			bricks.add(new Brick((i * 50) + 500, 270, 7));
		}
		for(int i = 0; i < 3; i++)
		{
			bricks.add(new Brick((i * 50) + 400, 240, 7));
		}
		for(int i = 0; i < 2; i++)
		{
			bricks.add(new Brick((i * 50) + 350, 210, 7));
		}
		
		//Indigo Swirl
		bricks.add(new Brick(400, 180, 6));
		for(int i = 0; i < 3; i++)
		{
			bricks.add(new Brick((i * 50) + 400, 150, 6));
		}
		for(int i = 0; i < 3; i++)
		{
			bricks.add(new Brick((i * 50) + 450, 120, 6));
		}
		for(int i = 0; i < 3; i++)
		{
			bricks.add(new Brick((i * 50) + 550, 90, 6));
		}
		bricks.add(new Brick(600, 60, 6));
		for(int i = 0; i < 2; i++)
		{
			bricks.add(new Brick((i * 50) + 650, 120, 6));
		}
		for(int i = 0; i < 2; i++)
		{
			bricks.add(new Brick((i * 50) + 700, 150, 6));
		}
		bricks.add(new Brick(750, 180, 6));
		
		//Blue Swirl
		bricks.add(new Brick(300, 210, 5));
		for(int i = 0; i < 3; i++)
		{
			bricks.add(new Brick((i * 50) + 200, 240, 5));
		}
		for(int i = 0; i < 3; i++)
		{
			bricks.add(new Brick((i * 50) + 150, 270, 5));
		}
		for(int i = 0; i < 3; i++)
		{
			bricks.add(new Brick((i * 50) + 50, 300, 5));
		}
		bricks.add(new Brick(100, 330, 5));
		for(int i = 0; i < 2; i++)
		{
			bricks.add(new Brick((i * 50), 270, 5));
		}
		bricks.add(new Brick(0, 240, 5));
		
    	//Adds a ball
		ArrayList<Ball> balls = super.getBalls(); 
    	Paddle paddle = super.getPaddle();
    	balls.add(new Ball(paddle.getBounds().x + paddle.getWidth()/2,
    					   paddle.getBounds().y,
    					   2, -5));
    }
    

}
    
    
