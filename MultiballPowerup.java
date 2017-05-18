/**The multiball powerup adds an extra ball into play
 * which remains until it flies off screen
 * 
 * @author Rachael Thompson, Marshall Morton, Diana Shao
 * @date 5/17/2017
 * Period 2
 */

public class MultiballPowerup extends Powerup 
{
	
	/**Creates a new powerup
	 * @param x x coordinate of powerup
	 * @param y y coordinate of powerup
	 */
    public MultiballPowerup(int x, int y) 
    {
    	super(x, y, "multiball.png");
    }
    
    /**Returns the effect of the powerup
     * @return the effect of the powerup
     */
    public String getEffect()
    {
    	return "Multiball";
    }
    
    /**Returns a description of the powerup's effect
     * @return a description of the powerup's effect
     */
    public String getEffectDescription()
    {
    	return "A second ball is put into play";
    }
    
    /**Returns whether the powerup is stopped. 
     * This powerup stops as soon as it is activated
     * @return whether the powerup is stopped
     */
    @Override
    public boolean stop()
    {
    	return (isActive());
    }
    
    
}