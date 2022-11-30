import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class food here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Food extends Actor
{
    /**
     * Act - do whatever the food wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setLocation(getX(), getY() + 5);
        
        // Player gets collect apple and gets point
        if (isTouching(Animal.class))
            respawn();
    }    
    
    public void respawn()
    {
        setLocation(Greenfoot.getRandomNumber(getWorld().getWidth()), 0);
    }
}
