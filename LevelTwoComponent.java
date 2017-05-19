import java.util.ArrayList;

/**
 * 
 * @author Rachael Thompson, Marshall Morton, Diana Shao
 * @date 5/17/2017
 * Period 2
 */



public class LevelTwoComponent extends LevelComponent
{

	private static final int YELLOW = 3;
	private static final int GREEN = 4;
	private static final int NUM_COLORS = 8;
	
	/**Creates a new level with the specified image file as a background
	 */
    public LevelTwoComponent() 
    {
    	super("KnownUniverse.jpg");
    	init();
    }
    
    /**Generates the graphics for this level
	 */
    public void init()
    {
    	ArrayList<Brick> bricks = super.getBricks();
    	
    	for(int i = 0; i < NUM_COLORS; i++){
    		bricks.add(new Brick(YELLOW * Brick.WIDTH, i * Brick.HEIGHT, GREEN));
    		
    	}
    	
    	for(int i = 0; i < NUM_COLORS; i++)
    	{
    		 bricks.add(new Brick(i * Brick.WIDTH + GREEN * Brick.WIDTH, 180, GREEN));

    	}						 					 
    							 
    	for(int i = 0; i < NUM_COLORS; i++)
    	{
    		bricks.add(new Brick(i * 2 * Brick.WIDTH, 300, 5));
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