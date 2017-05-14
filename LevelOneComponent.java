
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


public class LevelOneComponent extends JComponent implements LevelComponent
{

	private ArrayList<Brick> bricks;
	private ArrayList<Ball> balls;
	private ArrayList<Powerup> powerups;
	private Paddle paddle;
	private String lives;

	/**
	 * 
	 */
    public LevelOneComponent() 
    {
    	lives = "";
    	bricks = new ArrayList<Brick>();
    	balls = new ArrayList<Ball>();
    	powerups = new ArrayList<Powerup>();
    	paddle = new Paddle();
    	init();
    }
    
    /**
	 * 
	 */
    public void init()
    {
    	//Generates Brick pattern
    	for(int i = 0; i < 8; i++)
    	{
    		bricks.add(new Brick(i*50, 0 + (i * 30),
    							 i%8 + 1, 
    							 new MeteorPowerup(i*50 + Brick.WIDTH / 2,
    							 0 + (i * 30))));
    		bricks.add(new Brick(i*50, 30 + (i * 30),
    							 i%8 + 1, 
    							 new FreeLifePowerup(i*50+ Brick.WIDTH / 2,
    							 30 + (i * 30))));
    		bricks.add(new Brick(i*50, 60 + (i * 30),
    							 i%8 + 1, 
    							 new MultiballPowerup(i*50+ Brick.WIDTH / 2,
    							 60 + (i * 30))));
    	}
    	
    	for(int i = 0; i < 8; i++)
    	{
    		bricks.add(new Brick(i*50 + 400, 270 - (i * 30),
    						  	 i%8 + 1, 
    						  	 new StickyBallPowerup(i*50 + 400 + Brick.WIDTH / 2,
    						  	 270 - (i * 30))));
    		bricks.add(new Brick(i*50 + 400, 240 - (i * 30),
    							 i%8 + 1, 
    							 new WidePaddlePowerup(i*50 + 400 + Brick.WIDTH / 2,
    							 240 - (i * 30))));
    		bricks.add(new Brick(i*50 + 400, 210 - (i * 30),
    							 i%8 +1, 
    							 new MeteorPowerup(i*50 + 400 + Brick.WIDTH / 2,
    							 210 - (i * 30))));
    	}
    	
    	//Adds a ball
    	balls.add(new Ball(paddle.getBounds().x + paddle.getWidth()/2,
    					   paddle.getBounds().y,
    					   2, -5));
    }
    
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
			gr2.drawImage(b.getColor(), b.getBounds().x, b.getBounds().y, 50, 30, null);
    	}
    	
    	//Draw Paddle
    	gr2.fill(paddle.getBounds());
    	
    	//Draw Balls
    	for(Ball b: balls)
    	{
    		if(!b.inPlay())
    		{
    			b.updateBounds(paddle.getBounds().x + paddle.getWidth()/2,
    						   paddle.getBounds().y, 10);
    		}
    		else
    		{
    			b.move();
    		}
    		gr2.draw(b.getBounds());
    	}
    	
    	//Draw Lives
    	g.setColor(Color.BLACK);
    	Font myFont = new Font("SanSerif", Font.BOLD, 18);
    	g.setFont(myFont);
    	g.drawString("Lives: " + lives, 700, 570);
    	
    	//Draw falling powerups
    	for(Powerup p: powerups)
    	{
    		if(!p.isActive()) gr2.fill(p.getBounds());
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

}