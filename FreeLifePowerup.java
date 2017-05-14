import java.awt.Rectangle;

/**
 * @(#)FreeLifePowerup.java
 *
 *
 * @author 
 * @version 1.00 2017/4/27
 */


public class FreeLifePowerup extends Powerup {

    public FreeLifePowerup(int x, int y) {
    	super(x, y);
    }
    
    public String getEffect(){
    	return "Free Life";
    }
    
    public String getEffectDescription(){
    	return "The player gets an extra life";
    }
    
    @Override
    public boolean stop(){
    	return (isActive());
    }
}