import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class animal here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Animal extends Actor
{
    int SPEED = 10;
    GreenfootImage[] animalAnimation = new GreenfootImage[8];
    
    int animationFrame = 0;
    boolean isFacingRight = true;

    public Animal()
    {
        for (int i=0; i<animalAnimation.length; i++)
        {
            animalAnimation[i] = new GreenfootImage("images/elephant_idle/idle" + i + ".png");
        }
    }
    
    /**
     * Act - do whatever the animal wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if (Greenfoot.isKeyDown("left"))
        {
            move(-SPEED);
            if (isFacingRight)
                flip();
        }
        if (Greenfoot.isKeyDown("right"))
        {
            move(SPEED);
            if (!isFacingRight)
                flip();
        }

        // next frame
        setImage(animalAnimation[animationFrame++]);
        if (animationFrame >= animalAnimation.length)
            animationFrame = 0;
    }
    
    private void flip()
    {
        for (int i=0; i<animalAnimation.length; i++)
        {
            animalAnimation[i].mirrorHorizontally();
        }
        isFacingRight = !isFacingRight;
    }
}
