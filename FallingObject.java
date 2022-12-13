import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class FallingObject here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FallingObject extends Actor
{
    GreenfootSound eatSound;

    public FallingObject(GreenfootSound eatSound)
    {
        this.eatSound = eatSound;
    }

    /**
     * Act - do whatever the FallingObject wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        Game world = getWorldOfType(Game.class);
        setLocation(getX(), getY() + getSpeed(world));

        // Player eats
        if (isTouching(Animal.class))
        {
            // specific to each falling object
            this.eat();

            // same across all falling objects
            eatSound.play();
            world.removeDelayed(this);
        }

        // Player misses
        if (getY() >= world.getHeight()-1)
            miss();
    }

    protected int getSpeed(Game world)
    {
        return world.speed;
    }

    protected void eat()
    {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    protected void miss()
    {
        return;
    }
}
