/**The Free life powerup adds one
 * to the player's life count
 * 
 * @author Rachael Thompson, Marshall Morton, Diana Shao
 * @date 5/17/2017
 * Period 2
 */

public class FreeLifePowerup extends Powerup 
{

	/**Creates a powerup with a specific image
	 * @param x the x position of the powerup's image
	 * @param y the y position of the powerup's image
	 */
    public FreeLifePowerup(int x, int y)
    {
    	super(x, y, "FreeLife.png");
    	
    }
    
    /**Gets the powerup's effect
     * @return the name of the powerup
     */
    public String getEffect()
    {
    	return "Free Life";
    }
    
    /**Gets a description of the powerup's effects
     * @return a description of the powerup's effects
     */
    public String getEffectDescription()
    {
    	return "The player gets an extra life";
    }
    
    /**Returns whether the powerup is still active.
     * Stops immediately after activation.
     * @returns whether the powerup is stopped.
     */
    @Override
    public boolean stop()
    {
    	return (isActive());
    }
}