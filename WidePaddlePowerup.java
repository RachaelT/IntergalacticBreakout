/**
 * @(#)WidePaddlePowerup.java
 *
 *
 * @author 
 * @version 1.00 2017/4/24
 */

import java.awt.Rectangle;
public class WidePaddlePowerup extends Powerup {
	
    public WidePaddlePowerup( int x, int y) {
    	super(x, y, "WidePaddle.png");
    }
    
    public String getEffect(){
    	return "Wide Paddle";
    }
    
    public String getEffectDescription(){
    	return "Increases paddle width for 30 seconds.";
    }
    
    
}