/**The Sticky Ball powerup causes the ball to stick to
 * the paddle when hit for 30 seconds after its
 * activation
 * 
 * @author Rachael Thompson, Marshall Morton, Diana Shao
 * @date 5/17/2017
 * Period 2
 */

public class StickyBallPowerup extends Powerup 
{
	
	/**Creates a new powerup
	 * @param x x coordinate of powerup
	 * @param y y coordinate of powerup
	 */
    public StickyBallPowerup(int x, int y) 
    {
    	super(x, y, "StickyBall.png");
    }
    
    /**Returns the effect of the powerup
     * @return the effect of the powerup
     */
    public String getEffect()
    {
    	return "Sticky Ball";
    }
    
    /**Returns a description of the powerup's effect
     * @return a description of the powerup's effect
     */
    public String getEffectDescription()
    {
    	return "The ball sticks to the paddle";
    }
    
}
