
import java.awt.Rectangle;
import java.io.*;
import java.util.*;
public class StickyBallPowerup extends Powerup {
	
    public StickyBallPowerup(int x, int y) {
    	super(x, y);
    }
    
    public String getEffect(){
    	return "Sticky Ball";
    }
    
    public String getEffectDescription(){
    	return "The ball sticks to the paddle";
    }
    
}
