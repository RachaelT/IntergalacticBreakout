/**The Wide Paddle powerup causes the paddle
 * to double in width for 30 seconds after
 * its activation
 * 
 * @author Rachael Thompson, Marshall Morton, Diana Shao
 * @date 5/17/2017
 * Period 2
 */

public class WidePaddlePowerup extends Powerup 
{
	
	/**Creates a new powerup
	 * @param x x coordinate of powerup
	 * @param y y coordinate of powerup
	 */
    public WidePaddlePowerup( int x, int y) 
    {
    	super(x, y, "WidePaddle.png");
    }
    
    /**Returns the effect of the powerup
     * @return the effect of the powerup
     */
    public String getEffect()
    {
    	return "Wide Paddle";
    }
    
    /**Returns a description of the powerup's effect
     * @return a description of the powerup's effect
     */
    public String getEffectDescription()
    {
    	return "Increases paddle width for 30 seconds.";
    }
    
    
}