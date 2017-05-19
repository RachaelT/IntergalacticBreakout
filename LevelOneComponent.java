/**
 * 
 * @author Rachael Thompson, Marshall Morton, Diana Shao
 * @date 5/17/2017
 * Period 2
 */

import java.util.ArrayList;

public class LevelOneComponent extends LevelComponent
{
	private static final int NUM_COLORS = 8;
	
	/**Initializes the game element collections
	 */
    public LevelOneComponent() 
    {
    	super("MilkyWay.jpg");
    	init();
    }
    
    /**Initializes the game elements
     * and adds them to the appropriate collection
	 * 
	 */
    public void init()
    {
    	
    	ArrayList<Brick> bricks = super.getBricks(); 
    	
    	//Generates Brick pattern
    	for(int i = 0; i < NUM_COLORS; i++)
    	{
    		
    		bricks.add(new Brick(i * Brick.WIDTH, 0 + (i * Brick.HEIGHT),
    							 i % NUM_COLORS + 1, 
    							 new MeteorPowerup(i * Brick.WIDTH + 
    									 		   Brick.WIDTH / 2,
    									 		   0 + (i * 
    									 		   Brick.HEIGHT))));
    		
    		bricks.add(new Brick(i * Brick.WIDTH, Brick.HEIGHT + 
    							(i * Brick.HEIGHT),
    							 i % NUM_COLORS + 1, 
    							 new FreeLifePowerup(i * Brick.WIDTH + 
    									 			 Brick.WIDTH / 2, 
    									 			 Brick.HEIGHT + 
    									 			 (i * Brick.HEIGHT))));
    		
    		bricks.add(new Brick(i * Brick.WIDTH, 2 * Brick.HEIGHT + 
    						    (i * Brick.HEIGHT),
    							 i % NUM_COLORS + 1, 
    							 new MeteorPowerup(i * Brick.WIDTH + 
    									 		   Brick.WIDTH / 2,
    									 		   2 * Brick.HEIGHT + 
    									 		   (i * Brick.HEIGHT))));
    	}
    	
    	for(int i = NUM_COLORS; i >= 0; i--)
    	{
    		bricks.add(new Brick(i * Brick.WIDTH + NUM_COLORS * 
    				             Brick.WIDTH, (NUM_COLORS + 1) * 
    				             Brick.HEIGHT - (i * Brick.HEIGHT),
    							 NUM_COLORS - (i % NUM_COLORS), 
    						  	 new MeteorPowerup(i * Brick.WIDTH + NUM_COLORS
    						  			           * Brick.WIDTH + Brick.WIDTH
    						  			           / 2, (NUM_COLORS + 1) * 
    						  			           Brick.HEIGHT - 
    						  			           (i * Brick.HEIGHT))));
    		
    		bricks.add(new Brick(i * Brick.WIDTH + NUM_COLORS * 
    							 Brick.WIDTH, NUM_COLORS * 
    							 Brick.HEIGHT - (i * Brick.HEIGHT),
    							 NUM_COLORS - (i % NUM_COLORS), 
    							 new WidePaddlePowerup(i * Brick.WIDTH + 
    							    		 		   NUM_COLORS * Brick.WIDTH
    							    		 		   + Brick.WIDTH / 2, 
    							    		 		   NUM_COLORS * Brick.HEIGHT
    							    		 		   - (i * Brick.HEIGHT))));
    		
    		bricks.add(new Brick(i * Brick.WIDTH + NUM_COLORS * Brick.WIDTH, 
    				  			(NUM_COLORS - 1) * Brick.HEIGHT - 
    				  			(i * Brick.HEIGHT), NUM_COLORS - 
    				  			(i % NUM_COLORS), 
    							new MeteorPowerup(i * Brick.WIDTH + NUM_COLORS
    											  * Brick.WIDTH + Brick.WIDTH / 2,
    									 	     (NUM_COLORS - 1) * Brick.HEIGHT - 
    									 	     (i * Brick.HEIGHT))));
    	}
    	
    	ArrayList<Ball> balls = super.getBalls(); 
    	Paddle paddle = super.getPaddle();
    	
    	//Adds a ball
    	balls.add(new Ball(paddle.getBounds().x + paddle.getWidth()/2,
    					   paddle.getBounds().y,
    					   super.getRandom(), -super.getRandom()));
    	
    	
    }
    
    

}