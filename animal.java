import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class animal here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class animal extends Actor
{
    /**
     * Act - do whatever the animal wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (Greenfoot.isKeyDown("left"))
        {
            move(-1);
        }
        if (Greenfoot.isKeyDown("right"))
        {
            move(1);
        }
    }    
}
