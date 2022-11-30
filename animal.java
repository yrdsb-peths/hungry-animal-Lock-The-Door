import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class animal here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class animal extends Actor
{
    int SPEED = 5;
    
    boolean facingRight = true;
    
    /**
     * Act - do whatever the animal wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (Greenfoot.isKeyDown("left"))
        {
            move(-SPEED);
            if (facingRight)
                flip();
        }
        if (Greenfoot.isKeyDown("right"))
        {
            move(SPEED);
            if (!facingRight)
                flip();
        }
    }    
    
    private void flip()
    {
        getImage().mirrorHorizontally();
        facingRight = !facingRight;
    }
}
