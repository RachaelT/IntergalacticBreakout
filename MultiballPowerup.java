import java.awt.Rectangle;

/**
 * @(#)MultiballPowerup.java
 *
 *
 * @author 
 * @version 1.00 2017/4/27
 */


public class MultiballPowerup extends Powerup {
	
    public MultiballPowerup(int x, int y) {
    	super(x, y, "multiball.png");
    }
    
    public String getEffect(){
    	return "Multiball";
    }
    
    public String getEffectDescription(){
    	return "A second ball is put into play";
    }
    
    @Override
    public boolean stop(){
    	return (isActive());
    }
    
    
}