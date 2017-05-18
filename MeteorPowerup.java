
/**The Meteor powerup causes the ball to go
 * through bricks for 30 seconds after its
 * activation
 * 
 * @author Rachael Thompson, Marshall Morton, Diana Shao
 * @date 5/17/2017
 * Period 2
 */

public class MeteorPowerup extends Powerup{
	
	/**Creates a new powerup
	 * @param x x coordinate of powerup
	 * @param y y coordinate of powerup
	 */
    public MeteorPowerup(int x, int y) 
    {
    	super(x, y, "Comet.png");
    }
    
    /**Returns the effect of the powerup
     * @return the effect of the powerup
     */
    public String getEffect()
    {
    	return "Meteor";
    }
    
    /**Returns a description of the powerup's effect
     * @return a description of the powerup's effect
     */
    public String getEffectDescription()
    {
    	return "The ball goes through blocks, not bouncing off";
    }

}
