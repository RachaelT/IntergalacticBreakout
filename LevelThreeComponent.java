/**
 * 
 * @author Rachael Thompson, Marshall Morton, Diana Shao
 * @date 5/17/2017
 * Period 2
 */

import java.util.ArrayList;

public class LevelThreeComponent extends LevelComponent
{
	private static final int WIDTH = 50;
	private static final int HEIGHT = 30;
	private static final int YELLOW = 3;
	private static final int ORANGE = 2;
	private static final int MAGENTA = 8;
	
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
    public void init()
    {
    	ArrayList<Brick> bricks = super.getBricks();
    	//Generates Brick pattern
		
		//yellowstar pattern
		bricks.add(new Brick(WIDTH * (ORANGE + ORANGE), 0, YELLOW));
    	for(int i = 0; i < 3; i++)
    		bricks.add(new Brick((i * WIDTH) + (WIDTH * YELLOW), HEIGHT, YELLOW));
    	for(int i = 0; i < 5; i++)
    		bricks.add(new Brick((i * WIDTH) + (WIDTH * ORANGE), HEIGHT * ORANGE,
    		 YELLOW));
    	for(int i = 0; i < 9; i++)
    		bricks.add(new Brick((i * WIDTH), HEIGHT * YELLOW, YELLOW));
    	for(int i = 0; i < 7; i++)
    		bricks.add(new Brick((i * WIDTH) + WIDTH, HEIGHT * 
    			(ORANGE * ORANGE), YELLOW));
    	for(int i = 0; i < 5; i++)
    		bricks.add(new Brick((i * WIDTH) + (WIDTH * ORANGE), HEIGHT * 
    			(ORANGE + YELLOW), YELLOW));
    	for(int i = 0; i < 3; i++)
    		bricks.add(new Brick((i * WIDTH) + WIDTH, HEIGHT * (YELLOW + YELLOW)
    			, YELLOW));
    	for(int i = 0; i < 3; i++)
    		bricks.add(new Brick((i * WIDTH) + (WIDTH * (ORANGE + YELLOW)), HEIGHT * 
    			(YELLOW + YELLOW), YELLOW));
    	for(int i = 0; i < 3; i++)
    		bricks.add(new Brick((i * WIDTH), HEIGHT * (YELLOW + (ORANGE * ORANGE)), 
    			YELLOW));
    	for(int i = 0; i < 3; i++)
    		bricks.add(new Brick((i * WIDTH) + (WIDTH * (YELLOW + YELLOW)), HEIGHT * 
    			(YELLOW + (ORANGE * ORANGE)), YELLOW));

    	
    	//Magenta Sparkle
    	bricks.add(new Brick(WIDTH * MAGENTA, 0, MAGENTA));
    	bricks.add(new Brick(WIDTH * (MAGENTA + (ORANGE * ORANGE)), 0, MAGENTA));
    	bricks.add(new Brick(WIDTH * (MAGENTA - 1), HEIGHT, MAGENTA));
    	bricks.add(new Brick(WIDTH * (MAGENTA + (YELLOW + YELLOW)), HEIGHT, 
    		MAGENTA));
    	bricks.add(new Brick(WIDTH * (MAGENTA + ORANGE), HEIGHT * YELLOW, 
    		MAGENTA));
    	bricks.add(new Brick(WIDTH * (MAGENTA + (YELLOW + YELLOW)), HEIGHT * 
    		(YELLOW + YELLOW), MAGENTA));
    	
    	
    	ArrayList<Ball> balls = super.getBalls(); 
    	Paddle paddle = super.getPaddle();
    	//Adds a ball
    	balls.add(new Ball(paddle.getBounds().x + paddle.getWidth() / 2,
    					   paddle.getBounds().y,
    					   2, -(YELLOW + ORANGE)));
    }
    
}