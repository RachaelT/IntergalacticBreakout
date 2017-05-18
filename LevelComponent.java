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
import java.util.*;

import javax.swing.JComponent;

public abstract class LevelComponent extends JComponent {
	
	private ArrayList<Brick> bricks;
	private ArrayList<Ball> balls;
	private ArrayList<Powerup> powerups;
	private Paddle paddle;
	private String lives;
	private String score;
	
	public LevelComponent() 
    {
    	lives = "";
    	score = "";
    	bricks = new ArrayList<Brick>();
    	balls = new ArrayList<Ball>();
    	powerups = new ArrayList<Powerup>();
    	paddle = new Paddle();
    }
	
	public abstract void init();
	
	/**
	 * 
	 */
    @Override
	public void paintComponent(Graphics g) 
	{
		Graphics2D gr2 = (Graphics2D) g;
	
		// Draw Bricks
    	for(Brick b: bricks)
    	{
			gr2.drawImage(b.getColor(), b.getBounds().x, 
										b.getBounds().y, 50, 30, null);
    	}
    	
    	//Draw Paddle
    	gr2.fill(paddle.getBounds());
    	
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
    	g.setColor(Color.BLACK);
    	Font myFont = new Font("SanSerif", Font.BOLD, 18);
    	g.setFont(myFont);
    	g.drawString("Lives: " + lives, 700, 570);
    	
    	g.setColor(Color.BLACK);
    	g.setFont(myFont);
    	g.drawString("Score: " + score, 10, 570);
    	
    	//Draw falling powerups
    	for(Powerup p: powerups)
    	{
    		if(!p.isActive()) gr2.drawImage(p.getImage(), p.getBounds().x, 
    									    p.getBounds().y, 30, 30, null);
    	}	
	}
    

	
    /**
	 * 
	 */
	public Paddle getPaddle()
	{
		return paddle;
	}
	
	/**
	 * 
	 */
	public ArrayList<Brick> getBricks()
	{
		return bricks;
	}
	
	/**
	 * 
	 */
	public ArrayList<Ball> getBalls()
	{
		return balls;
	}
	
	/**
	 * 
	 */
	public ArrayList<Powerup> getPowerups()
	{
		return powerups;
	}
	
	/**
	 * 
	 */
	public void setLives(int l)
	{
		lives = Integer.toString(l);
	}
	
	public void setScore(int s){
		score = Integer.toString(s);
	}
	
	public int getRandom(){
		return (int) (Math.random() * 4) + 5;
	}
   
    
}