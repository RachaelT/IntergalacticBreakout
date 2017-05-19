/**Manages the game's mechanics and element interaction
 * 
 * @author Rachael Thompson, Marshall Morton, Diana Shao
 * @date 5/17/2017
 * Period 2
 */

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import javax.swing.Timer;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import javax.imageio.ImageIO;

public class IntergalacticBreakout extends MouseAdapter {

	//Constants
	private static final int WIDTH = 800;
	private static final int HEIGHT = 600; 
	private static final int DEFAULT_HIGH_SPEED = 8;
	private static final int DEFAULT_LOW_SPEED = 6;
	private static final int TIMER_SKIP = 60;
	//Menu elements
	private JButton start;
	private JButton highScores;
	private Iterator<LevelComponent> lIter;
	
	//Game elements
	private ArrayList<Ball> balls;
	private ArrayList<Brick> bricks;
	private ArrayList<Powerup> powerups;
	private ArrayList<LevelComponent> levels;
	private Paddle p;
	private int numLives;
	private int score;
	
	//Game display mechanics
	private JFrame frame;
	private JLabel picLabel;
	private static LevelComponent curComp;
	private Timer timer;
	private JTextField name;
	
	//For storing high scores
	private String hs1;
	private String hs2;
	private String hs3;
	private String hs4;
	private String hs5;
	
	private JLabel s1;
	private JLabel s2;
	private JLabel s3;
	private JLabel s4;
	private JLabel s5;
	
	private int h1;
	private int h2;
	private int h3;
	private int h4;
	private int h5;

	//Game state flags
	private boolean stickyBall;
	private boolean meteor;
	private boolean won;
	private boolean begin;
	private boolean end;
	private boolean highScore;
	private boolean menuM;
	
	
	/** Initializes variables for the game
	 * @throws FileNotFoundException 
	 */
    public IntergalacticBreakout() throws FileNotFoundException 
    {
    	//Initialize state flags
    	stickyBall = false;
    	won = false;
    	begin = false;
    	end = false;
    	highScore = false;
    	menuM = true;
    	
    	//Load levels
    	levels = new ArrayList<LevelComponent>();
    	levels.add(new LevelThreeComponent());
    	
    	//Initialize graphics components
    	s1 = new JLabel();
    	s2 = new JLabel();
    	s3 = new JLabel();
    	s4 = new JLabel();
    	s5 = new JLabel();
    	
    	//Sets up frame
    	frame = new JFrame();
		frame.setSize(WIDTH, HEIGHT);
		frame.setTitle("Intergalactic Breakout");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.addMouseMotionListener(this);
		frame.addMouseListener(this);
		frame.setResizable(false);

		run();
    }
    
    /**Moves the paddle to center on the X position of the mouse
     * whenever it moves
     * @param e an event representing the mouse's behavior
     */
    public void mouseMoved(MouseEvent e)
    {
    	p = curComp.getPaddle();
    	p.setX(e.getX() - p.getWidth() / 2);
    	
    	if(p.getBounds().x < 0) 
    		p.setX(0);
    	if(p.getBounds().x + p.getWidth() > WIDTH) 
    		p.setX(WIDTH - p.getWidth());
    }
    
    /**Releases balls stuck to paddle when the mouse
     * is clicked
     * @param e an event representing the mouse's behavior
     */
    public void mouseClicked(MouseEvent e)
    {
    	balls = curComp.getBalls();
    	
    	for(Ball b: balls)
    	{
    		if(!b.inPlay())
    		{
    			b.setPlay(true);
    			b.updateSpeed(curComp.getRandom() - DEFAULT_LOW_SPEED, -curComp.getRandom());
    		}
    	}
    }
    
    /**The game's start method
     */
    public void run(){
    	//Used by the menu buttons and the game's timer
		ActionListener al = (new ActionListener() 
		{
			/**The main loop of the game, managing all interactive elements
			 */
			@Override
		    public void actionPerformed(ActionEvent ae) 
		    {
		    	//If a name is entered in the text field
		    	if(ae.getSource() == name)
		    	{
		    		processScore(); 
		    	}
		    	
		    	//Transition to score viewing state
		    	if(ae.getSource() == highScores){
		    		highScore = true;
		    	}
		    	
		    	//Transition to game state
		    	if(ae.getSource() == start)
		    	{
		    		begin = true;
		    	}
		    	
		    	//High score viewing state
		    	if(highScore){
		    		displayScores();
		    	}
		    	
		    	//End screen state
		    	else if(end){
		    		name = new JTextField();
		    		name.addActionListener(this);
		    		endScreen();
		    	}

		    	//Game state
		    	else if(begin)
		    	{
		    		//Updates and resets the level graphics
		    		if(start.isEnabled() || won && curComp != levels.get(levels.size() - 1) )
		    		{
		    			resetLevel();
		    		}
				
		    		//Updates game elements
		    		balls = curComp.getBalls();
		    		bricks = curComp.getBricks();
		    		powerups = curComp.getPowerups();
		    		p = curComp.getPaddle();
		    	
		    		//Checks if the game has been won
		    		isWon();
		    	
		    		//Decrements lives and replaces missing balls
		    		lostBall();
		    		
		    		//Checks position of each ball
		    		ballHandler();
		    	
		    		//Checks position/activation of each powerup
		    		updatePowerups();
		    		
		    		//Repaint the screen sprites
		    		((JComponent)curComp).repaint();
		    	}
		    	else if (menuM)
		    	{
		    		 menuScreen();
				     start.addActionListener(this);
					highScores.addActionListener(this);
				}
		    	
		    }
		   
		});
			timer = new Timer(TIMER_SKIP, al);
			timer.start();	
	}

    
    /**Handles collisions between the ball and other elements
     * @param b the ball to be checked
     * @param i BallIterator, allows the ball to be removed if it moves
     * 			off screen
     */
    private void collision(Ball b, Iterator<Ball> i)
    {
    	bricks = curComp.getBricks();
    	p = curComp.getPaddle();
    	
    	//Bouncing off walls and ceiling
    	wallBounce(b, i);
    		
    	//Bouncing off/sticking to paddle
    	if(p.getBounds().intersects(b.getBounds().getBounds()))
    	{
    		stickyBallHandler(b, p);
    	}
    	
    	for(Brick k: bricks)
    	{
    		if(k.getBounds().intersects(b.getBounds().getBounds()))
    		{
    			if(!meteor)
    			{
    				if(horiz(k, b)) 
    					b.updateSpeed(b.getXspeed(), -b.getYspeed());
    				if(vert(k, b)) 
    					b.updateSpeed(-b.getXspeed(), b.getYspeed());
    			}
    			
    			k.touched();
    			score += 100;
    			curComp.setScore(score);
    			
    			if(k.getDurability() <= 0)
    			{
    				bricks.remove(k);
    				if(k.getPowerup() != null) 
    					powerups.add(k.getPowerup());
    			}
    			return;
    		}
    	}
    }
    
    /** Checks if the ball is touching the top or bottom of the brick
     * @param k the brick to be checked
     * @param b the ball to be checked
     * @return if the ball is touching the horizontal brick side
     */
    private boolean horiz(Brick k, Ball b)
    {
    	if(k.getBounds().getMaxY() < b.getBounds().getMaxY() || 
    	   k.getBounds().y > b.getBounds().y)
    		return true;
    	
    	return false;
    }
    
    /** Checks if the ball is touching the top or bottom of the brick
     * @param k the brick to be checked
     * @param b the ball to be checked
     * @return if the ball is touching the vertical brick side
     */
    private boolean vert(Brick k, Ball b)
    {
    	
    	if(k.getBounds().getMaxX() < b.getBounds().getMaxX() || 
    		k.getBounds().x > b.getBounds().x)
    		return true;
    	return false;
    }
    
    /**
     * 
     * @param b
     * @param i
     */
    private void wallBounce(Ball b, Iterator<Ball> i)
    {
    	if(b.getBounds().x + 2 * b.getRadius() > WIDTH)
    		b.updateSpeed((int)-Math.abs(b.getXspeed()), b.getYspeed());
    	
    	if(b.getBounds().x < 0)
    		b.updateSpeed((int)Math.abs(b.getXspeed()), b.getYspeed());
    	
    	if(b.getBounds().y < 0)
    		b.updateSpeed(b.getXspeed(), (int) Math.abs(b.getYspeed()));
    		
    	if(b.getBounds().y > HEIGHT)
    	{
    		i.remove();
    		return;
    	}
    }
    
    /**
     * 
     * @param b
     * @param p
     */
    private void stickyBallHandler(Ball b, Paddle p)
    {
    	if(stickyBall)
		{
			b.updateSpeed(0,0);
			b.setPlay(false);
		}
		else
		{
			if(b.getBounds().x + b.getRadius() < p.getBounds().x + p.getWidth()/4)
				b.updateSpeed(-DEFAULT_HIGH_SPEED, -DEFAULT_LOW_SPEED);
			else if(b.getBounds().x < p.getBounds().x + p.getWidth()/2)
				b.updateSpeed(-DEFAULT_LOW_SPEED, -DEFAULT_HIGH_SPEED);
			else if(b.getBounds().x < p.getBounds().x + 3 * p.getWidth()/4)
				b.updateSpeed(DEFAULT_LOW_SPEED, -DEFAULT_HIGH_SPEED);
			else
				b.updateSpeed(DEFAULT_HIGH_SPEED, -DEFAULT_LOW_SPEED);
		}
    }
    
    /** Adjusts state flags when powerups are disabled
     * @param p the powerup that is disabled
     */
    private void powerupStopHandler(Powerup p)
    {
    	Paddle pa = curComp.getPaddle();
    	
    	if(p.getEffect() == "Wide Paddle")
    	{
			if(pa.getWidth() > pa.DEFAULT_WIDTH) 
				pa.setWidth((int)(.5 * pa.getWidth()));
		}
    	
    	else if(p.getEffect() == "Sticky Ball")
    	{
    		stickyBall = false;
    	}
    	
    	else if(p.getEffect() == "Meteor")
    	{
    		meteor = false;
    	}
    }
    
    /** Implements powerup effects when the powerup is activated
     * @param p the powerup that is activated
     */
    private void powerupHandler(Powerup p)
    {
   
    	//Doubles the paddle width
    	if(p.getEffect() == "Wide Paddle")
    	{
    		Paddle pa = curComp.getPaddle();
    		if(pa.getWidth() < 2 * pa.DEFAULT_WIDTH) pa.setWidth(2 * pa.getWidth());
    	}
    		
    	//Puts an extra ball into play
    	else if (p.getEffect() == "Multiball")
    	{
    		Paddle pa = curComp.getPaddle();
    		balls.add(new Ball(pa.getBounds().x + pa.getWidth()/2,
							   pa.getBounds().y,
							   curComp.getRandom() - DEFAULT_LOW_SPEED, -curComp.getRandom()));
    	}
    		
    	//The ball goes through bricks
    	else if(p.getEffect() == "Meteor")
    	{
    		meteor = true;
    	}
    		
    	//Adds another life
    	else if(p.getEffect() == "Free Life")
    	{
    		numLives++;
    		curComp.setLives(numLives);
    	}
    		
    	//The paddle "catches" the ball
    	else if(p.getEffect() == "Sticky Ball")
    	{
    		stickyBall = true;
    	}
    } 
    
    /**Reads the known high scores from a file
     * @throws FileNotFoundException
     */
    private void updateScores() throws FileNotFoundException
    {
    	Scanner scan = new Scanner(new File("HighScores.txt"));
    	
    	hs1 =scan.nextLine();
    	h1 = scan.nextInt();
    	scan.nextLine();
    	
    	hs2 = scan.nextLine();
    	h2 = scan.nextInt();
    	scan.nextLine();
    	
    	hs3 = scan.nextLine();
    	h3 = scan.nextInt();
    	scan.nextLine();
    	
    	hs4 = scan.nextLine();
    	h4 = scan.nextInt();
    	scan.nextLine();
    	
    	hs5 = scan.nextLine();
    	h5 = scan.nextInt();
    }
    
    /**Updates the high scores list in a file
     */
    private void processScore()
    {
    	String s = name.getText();
		String[]  j = {hs1, hs2, hs3, hs4, hs5};
		int[] h = {h1, h2, h3, h4, h5};
		
		try 
		{
			FileWriter fw = new FileWriter(new File("HighScores.txt"));
			for(int i = 0; i < j.length; i++)
			{
    			 if(score > h[i])
    			 {
    				 fw.write(s + "\n");
    				 fw.write(score + "\n");
    				 score = h[i];
    				 s = j[i];
    			 }
    			 else
    			 {
    				 
    				 fw.write(j[i] + "\n");
    				 fw.write(h[i] + "\n");
    			 }
    		 }
			
			fw.close();
			updateScores();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		 menuM = true;
		 begin = false;
    }
    
    /**Generates graphics for the high score display screen
     */
    private void displayScores()
    {
    	frame.getContentPane().removeAll();
		picLabel.removeAll();
		
		Box b = Box.createVerticalBox();
		s1.setText(hs1 + " " + h1);
		s1.setForeground(Color.WHITE);
		s1.setAlignmentX(Component.CENTER_ALIGNMENT);
		b.add(s1);
		
		s2.setText(hs2 + " " + h2);
		s2.setForeground(Color.WHITE);
		s2.setAlignmentX(Component.CENTER_ALIGNMENT);
		b.add(s2);
		
		s3.setText(hs3 + " " + h3);
		s3.setForeground(Color.WHITE);
		s3.setAlignmentX(Component.CENTER_ALIGNMENT);
		b.add(s3);
		
		s4.setText(hs4 + " " + h4);
		s4.setForeground(Color.WHITE);
		s4.setAlignmentX(Component.CENTER_ALIGNMENT);
		b.add(s4);
		
		s5.setText(hs5 + " " + h5);
		s5.setForeground(Color.WHITE);
		s5.setAlignmentX(Component.CENTER_ALIGNMENT);
		b.add(s5);
		
		b.add(start);
		
		GridBagConstraints gbc = new GridBagConstraints();
		picLabel.add(b, gbc);
		frame.add(picLabel);
		
		frame.revalidate();
		frame.repaint();
		frame.setVisible(true);
		
		highScore = false;
		start.setEnabled(true);
    }
    
    /**Generates the graphics for the endgame screen
     */
    private void endScreen()
    {
    	frame.getContentPane().removeAll();
		picLabel.removeAll();

		JLabel scores = new JLabel("Your Score: " + score );
		JLabel enter = new JLabel("Put your name here to record" +
								  "your high score!");
		scores.setForeground(Color.WHITE);
		enter.setForeground(Color.WHITE);
		
		Box b = Box.createVerticalBox();
		b.add(scores);
		b.add(enter);
		b.add(name);
		GridBagConstraints gbc = new GridBagConstraints();
		
		picLabel.add(b,gbc);
		frame.add(picLabel);
		frame.revalidate();
		frame.repaint();
		frame.setVisible(true);
		
		end = false;
    }
    
    /**Resets game mechanics for the new level
     */
    private void resetLevel()
    {
    	meteor = false;
		stickyBall = false;
		
		start.setEnabled(false);
		
		frame.getContentPane().removeAll();
		
		curComp = lIter.next();
		curComp.setLives(numLives);
		frame.add((JComponent) curComp);
		
		frame.revalidate();
		frame.repaint();
		frame.setVisible(true);
		
		won = false;
    }
    
    /**Deals with balls that have left the screen
     */
    private void lostBall()
    {
    	if(balls.isEmpty())
    	{
    		numLives--;
    		if(numLives <= 0) 
    			end = true;
    		curComp.setLives(numLives);
    		balls.add(new Ball(p.getBounds().x + p.getWidth()/2,
    						   p.getBounds().y,
    						   curComp.getRandom(), -curComp.getRandom()));
    	}
    }
    
    /**Updates and processes powerup effects/animation
     */
    private void updatePowerups()
    {
    	Iterator<Powerup> pIter = powerups.iterator();
		while(pIter.hasNext())
		{
			Powerup p = pIter.next();
			
			if(!p.isActive())
			{
				p.getBounds().translate(0, DEFAULT_HIGH_SPEED);
				if(p.getBounds().intersects(curComp.getPaddle().getBounds()))
				{
					p.activate(System.currentTimeMillis());
					powerupHandler(p);
				}
			}
			
			else
			{
				p.update(System.currentTimeMillis());
				if(p.stop())
				{
					powerupStopHandler(p);
					pIter.remove();
				}
			}
		}
    }
    
    /**Generates the graphics for the menu screen
     * 
     */
    private void menuScreen(){

			//Queues and resets all the levels
	    	levels = new ArrayList<LevelComponent>();
	    	levels.add(new LevelOneComponent());
	    	levels.add(new LevelTwoComponent());
	    	levels.add(new LevelThreeComponent());
	    	levels.add(new LevelFourComponent());
	    	
	    	lIter = levels.iterator();
	    	curComp = levels.get(0);
	    	numLives = 5;
	    	curComp.setLives(numLives);
	    	score = 0;
	    	curComp.setScore(score);
	    	
	    	//Clears the frame
		 	frame.getContentPane().removeAll();

		 	//Generate graphics
			JLabel howTo = new JLabel("<html><body>How to play:<br>" +
									  "Move the mouse to move the paddle<br>" +
									  "Click to release the ball<br>" +
									  "Collect falling powerups for an" +
									  "extra bonus!</body></html>");
			howTo.setForeground(Color.WHITE);
			howTo.setAlignmentX(Component.CENTER_ALIGNMENT);
			
			BufferedImage background = testImage("MenuBack.png");
			picLabel = new JLabel(new ImageIcon(background));
			picLabel.setLayout(new GridBagLayout());
			picLabel.setAlignmentX(Component.TOP_ALIGNMENT);
			
			start = new JButton("Start Game");
			start.setAlignmentX(Component.CENTER_ALIGNMENT);
			highScores = new JButton("High Scores");
			highScores.setAlignmentX(Component.CENTER_ALIGNMENT);
			GridBagConstraints gbc = new GridBagConstraints();
			
			Box box = Box.createVerticalBox();
			box.add(start);
			box.add(highScores);
			box.add(Box.createVerticalStrut(130));
			box.add(howTo);
			
			picLabel.add(box, gbc);
			frame.add(picLabel);
			frame.setVisible(true);
			
	    	try 
	    	{
				updateScores();
			} 
	    	catch (FileNotFoundException e) 
	    	{
				e.printStackTrace();
			}
	    	
	    	menuM = false;
    }
    
    /**Increments the level if the current level has been completed
     */
    private void isWon()
    {
    	if(bricks.isEmpty())
    	{
			won = true;
			if(curComp == levels.get(levels.size() - 1)){
				end = true;
				begin = false;
			}
		}
    }
    
    /**Checks for collisions between balls and other game elements
     */
    private void ballHandler()
    {
    	Iterator<Ball> bIter = balls.listIterator();
		while(bIter.hasNext())
		{
			Ball b = bIter.next();
			collision(b, bIter);
		}
    }
    
    /**Finds an image from the image's filename
     * @param fileName the filename of the image
     * @return the image
     */
    private BufferedImage testImage(String fileName)
	{
		BufferedImage image = null;
		try
		{
			image = ImageIO.read(new File(fileName));
		}
		catch (Exception e) { }
		return image;
	}
}