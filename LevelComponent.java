/**
 * @(#)LevelComponent.java
 *
 *
 * @author 
 * @version 1.00 2017/5/10
 */

import java.util.*;

public interface LevelComponent  {
    
    public Paddle getPaddle();
    public ArrayList<Brick> getBricks();
    public ArrayList<Ball> getBalls();
    public ArrayList<Powerup> getPowerups();
    public void setLives(int l);
    
}