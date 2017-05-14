/**
 * @(#)Powerup.java
 *
 *
 * @author 
 * @version 1.00 2017/4/24
 */

import java.awt.Rectangle;
public abstract class Powerup {
	public static final long DURATION = 30000;
	public static final int WIDTH = 10;
	public static final int HEIGHT = 10;
	private boolean active;
	private long startTime;
	private long timeLeft; 
	private double rarity;
	private Rectangle bounds;
	
	public Powerup(int x, int y){
		active = false;
		timeLeft = DURATION;
		bounds = new Rectangle(x, y, WIDTH, HEIGHT);
	}
	
    public abstract String getEffect();
    
    public abstract String getEffectDescription();
    
    
    public void update(long currentTime){
    	timeLeft -= (currentTime - startTime);
    	startTime = currentTime;
    }
    
    public boolean stop(){
    	if(timeLeft <= 0) return true;
    	return false;
    } 
     
    public boolean isActive(){
    	return active;
    }
    
    public void activate(long time){
    	active = true;
    	startTime = time;
    	
    }
    
    public Rectangle getBounds(){
    	return bounds;
    }
}