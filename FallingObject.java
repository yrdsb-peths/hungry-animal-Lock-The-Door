import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class FallingObject here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FallingObject extends Actor
{
    /**
     * Act - do whatever the FallingObject wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        fall();

        // Player misses
        if (getY() >= getWorld().getHeight()-1)
            miss();
    }

    public void fall()
    {
        Game world = getWorldOfType(Game.class);
        setLocation(getX(), getY() + world.speed);
    }

    public void miss()
    {
        Game world = getWorldOfType(Game.class);
        world.endGame();
    }
}
