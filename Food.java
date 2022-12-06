import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class food here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Food extends Actor
{
    GreenfootSound eatSound = new GreenfootSound("./sounds/elephantcub.mp3");

    /**
     * Act - do whatever the food wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setLocation(getX(), getY() + 5);
        
        // Player eats apple and gets point
        if (isTouching(Animal.class))
            eat();

        // Player misses apple (Game Over)
        if (isAtEdge())
            ((Game)getWorld()).endGame();
    }    
    
    public void eat()
    {
        // play noise
        eatSound.play();

        // respawn apple at top
        setLocation(Greenfoot.getRandomNumber(getWorld().getWidth()), 1);

        // increment score
        ((Game)getWorld()).incrementScore();
    }
}
