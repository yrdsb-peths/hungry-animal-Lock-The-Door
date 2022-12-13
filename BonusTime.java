import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BonusTime here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BonusTime extends FallingObject
{
    public BonusTime()
    {
        super(new GreenfootSound("sounds/blip.mp3"));
    }

    protected int getSpeed(Game world)
    {
        return world.speed / 2; // make bonus fall slower
    }

    protected void eat()
    {
        // add time
        Game world = getWorldOfType(Game.class);
        world.addTime(5);
    }
}
