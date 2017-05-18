
/**
 * 
 * 
 */

import java.util.ArrayList;



public class LevelOneComponent extends LevelComponent
{
	
	
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
    	for(int i = 0; i < 8; i++)
    	{
    		
    		bricks.add(new Brick(i * 50, 0 + (i * 30),
    							 i%8 + 1, 
    							 new MeteorPowerup(i * 50 + Brick.WIDTH / 2,
    							 0 + (i * 30))));
    		bricks.add(new Brick(i * 50, 30 + (i * 30),
    							 i%8 + 1, 
    							 new FreeLifePowerup(i * 50 + Brick.WIDTH / 2,
    							 30 + (i * 30))));
    		bricks.add(new Brick(i * 50, 60 + (i * 30),
    							 i%8 + 1, 
    							 new MeteorPowerup(i * 50+ Brick.WIDTH / 2,
    							 60 + (i * 30))));
    	}
    	
    	for(int i = 0; i < 8; i++)
    	{
    		bricks.add(new Brick(i * 50 + 400, 270 - (i * 30),
    						  	 i%8 + 1, 
    						  	 new MeteorPowerup(i * 50 + 400 + 
    						  			 			   Brick.WIDTH / 2, 
    						  			 			   270 - (i * 30))));
    		bricks.add(new Brick(i * 50 + 400, 240 - (i * 30),
    							 i%8 + 1, 
    							 new WidePaddlePowerup(i * 50 + 400 + 
    									 			   Brick.WIDTH / 2, 
    									 			   240 - (i * 30))));
    		bricks.add(new Brick(i * 50 + 400, 210 - (i * 30),
    							 i%8 +1, 
    							 new MeteorPowerup(i * 50 + 400 + 
    									 	       Brick.WIDTH / 2,
    									 	       210 - (i * 30))));
    	}
    	
    	ArrayList<Ball> balls = super.getBalls(); 
    	Paddle paddle = super.getPaddle();
    	
    	//Adds a ball
    	balls.add(new Ball(paddle.getBounds().x + paddle.getWidth()/2,
    					   paddle.getBounds().y,
    					   super.getRandom(), -super.getRandom()));
    	
    	
    }
    
    

}