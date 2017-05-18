
import java.awt.Rectangle;
import java.io.*;
import java.util.*;
public class MeteorPowerup extends Powerup{
	
	
    public MeteorPowerup(int x, int y) {
    	super(x, y, "Comet.png");
    }
    
    public String getEffect(){
    	return "Meteor";
    }
    
    public String getEffectDescription(){
    	return "The ball goes through blocks, not bouncing off";
    }

}
