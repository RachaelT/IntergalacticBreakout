/**
 * @(#)IntergalacticBreakout.java
 *
 *
 * @author 
 * @version 1.00 2017/4/27
 */

import javax.swing.JFrame;

import java.util.ArrayList;
import java.util.Iterator;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JComponent;

import java.awt.event.MouseMotionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseAdapter;


public class IntergalacticBreakout extends MouseAdapter {

	private ArrayList<Ball> balls;
	private ArrayList<Brick> bricks;
	private ArrayList<Powerup> powerups;
	private static Timer drawTimer;
	private static LevelComponent curComp;
	private Paddle p;
	private int numLives;
	private Timer timer;
	
	boolean stickyBall;
	boolean meteor;

	
    public IntergalacticBreakout() {
    	stickyBall = false;
	
    	JFrame frame = new JFrame();
		frame.setSize(800, 600);
		
		numLives = 5;
		
		frame.setTitle("Intergalactic Breakout");
		frame.setLocation(0, 0);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		LevelComponent screen = new LevelOneComponent();
		curComp = screen;
		curComp.setLives(numLives);
		frame.add((JComponent) screen);
		frame.addMouseMotionListener(this);
		frame.addMouseListener(this);
		frame.setResizable(false);

		
		
		frame.setVisible(true);
		
		timer = new Timer(40, new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent ae) {
		    
		    	
		    	balls = curComp.getBalls();
		    	powerups = curComp.getPowerups();
		    	if(balls.isEmpty()){
		    		numLives--;
		    		if(numLives <= 0) System.exit(0);
		    		curComp.setLives(numLives);
		    		balls.add(new Ball(p.getBounds().x + p.getWidth()/2,
    						p.getBounds().y,
    						2, -5));
		    	}
		    	Iterator<Ball> bIter = balls.listIterator();
		    	while(bIter.hasNext()){
		    		Ball b = bIter.next();
		    		collision(b, bIter);
		    	}
		    	Iterator<Powerup> pIter = powerups.iterator();
		    	while(pIter.hasNext()){
		    		Powerup p = pIter.next();
		    		if(!p.isActive()){
		    			p.getBounds().translate(0, 7);
		    			if(p.getBounds().intersects(curComp.getPaddle().getBounds())){
		    				p.activate(System.currentTimeMillis());
		    				powerupHandler(p);
		    			}
		    		}
		    		else{
		    				p.update(System.currentTimeMillis());
		    				if(p.stop()){
		    					powerupStopHandler(p);
		    					pIter.remove();
		    				}
		    			}
		    		
		    		
		    	}
		    	((JComponent)curComp).repaint();
		    }
		});
		timer.start();
		
    }
    
    private void levelOne(){
    	
    }
    
    public void mouseMoved(MouseEvent e){
    	
    	p = curComp.getPaddle();
    	p.setX(e.getX() - p.getWidth()/2);
    	if(p.getBounds().x < 0) p.setX(0);
    	if(p.getBounds().x + p.getWidth() > 800) p.setX(800 - p.getWidth());
    }
    
    public void mouseClicked(MouseEvent e){
    	
    	balls = curComp.getBalls();
    	for(Ball b: balls){
    		if(!b.inPlay()){
    			b.setPlay(true);
    			b.updateSpeed(2, -5);
    		}
    	}
    }
    
    private void collision(Ball b, Iterator<Ball> i){
    	bricks = curComp.getBricks();
    	p = curComp.getPaddle();
    	if(b.getBounds().x + 2 * b.getRadius() > 800 ||
    			b.getBounds().x < 0)
    		b.updateSpeed(-b.getXspeed(), b.getYspeed());
    	if(b.getBounds().y < 0)
    		b.updateSpeed(b.getXspeed(), -b.getYspeed());
    		
    	if(b.getBounds().y > 600){
    		i.remove();
    		
    		return;
    	}
    		
    		
    	if(p.getBounds().intersects(b.getBounds().getBounds())){
    		if(stickyBall){
    			b.updateSpeed(0,0);
    			b.setPlay(false);
    		}
    		else{
    			if(b.getBounds().x + b.getRadius() < p.getBounds().x + p.getWidth()/4)
    				b.updateSpeed(-7, -5);
    			else if(b.getBounds().x < p.getBounds().x + p.getWidth()/2)
    				b.updateSpeed(-5, -7);
    			else if(b.getBounds().x < p.getBounds().x + 3 * p.getWidth()/4)
    				b.updateSpeed(5, -7);
    			else
    				b.updateSpeed(7, -5);
    		}
    		
    	}
    	
    	for(Brick k: bricks){
    		if(k.getBounds().intersects(b.getBounds().getBounds())){
    			if(!meteor){
    				if(horiz(k, b)) b.updateSpeed(b.getXspeed(), -b.getYspeed());
    				if(vert(k, b)) b.updateSpeed(-b.getXspeed(), b.getYspeed());
    			}
    			k.touched();
    			if(k.getDurability() <= 0){
    				bricks.remove(k);
    				powerups.add(k.getPowerup());
    			}
    			return;
    		}
    	}
    	
    }
    
    private void powerupStopHandler(Powerup p){
    	Paddle pa = curComp.getPaddle();
    	if(p.getEffect() == "Wide Paddle"){
			pa.setWidth((int)(.5 * pa.getWidth()));
		}
    	else if(p.getEffect() == "Sticky Ball"){
    		stickyBall = false;
    	}
    	else if(p.getEffect() == "Meteor"){
    		meteor = false;
    	}
    }
    
    
    private void powerupHandler(Powerup p){
    	Paddle pa = curComp.getPaddle();
    	
    	
    		if(p.getEffect() == "Wide Paddle"){
    			pa.setWidth(2 * pa.getWidth());
    		}
    		else if (p.getEffect() == "Multiball"){
    			balls.add(new Ball(pa.getBounds().x + pa.getWidth()/2,
						pa.getBounds().y,
						2, -5));
    		}
    		else if(p.getEffect() == "Meteor"){
    			meteor = true;
    		}
    		else if(p.getEffect() == "Free Life"){
    			numLives++;
    			curComp.setLives(numLives);
    		}
    		else if(p.getEffect() == "Sticky Ball"){
    			stickyBall = true;
    		}
    	
    	
    	
    } 
    
    private boolean horiz(Brick k, Ball b){
    	if(k.getBounds().getMaxY() < b.getBounds().getMaxY() || 
    		k.getBounds().y > b.getBounds().y)
    		return true;
    	return false;
    }
    
    private boolean vert(Brick k, Ball b){
    	
    	if(k.getBounds().getMaxX() < b.getBounds().getMaxX() || 
    		k.getBounds().x > b.getBounds().x)
    		return true;
    	return false;
    }
    
}