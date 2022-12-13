import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class animal here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Animal extends Actor
{
    GreenfootImage[] animalAnimation = new GreenfootImage[8];
    GreenfootSound eatSound = new GreenfootSound("sounds/elephantcub.mp3");
    
    int animationFrame = 0;
    boolean isFacingRight = true;

    public Animal()
    {
        for (int i=0; i<animalAnimation.length; i++)
        {
            animalAnimation[i] = new GreenfootImage("images/elephant_idle/idle" + i + ".png");
            animalAnimation[i].scale(75,75);
        }
    }
    
    /**
     * Act - do whatever the animal wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Try to get world speed
        int speed;
        try {
            Game world = getWorldOfType(Game.class);
            speed = world.speed;
        }
        catch (Exception e) {
            speed = 2;
        }

        if (Greenfoot.isKeyDown("left"))
        {
            move(-speed);
            if (isFacingRight)
                flip();
        }
        if (Greenfoot.isKeyDown("right"))
        {
            move(speed);
            if (!isFacingRight)
                flip();
        }

        // next frame (new frame every 5 updates)
        int actualFrame = animationFrame++/5;
        setImage(animalAnimation[actualFrame]);
        if (actualFrame >= animalAnimation.length-1)
            animationFrame = 0;
            
        //try to eat
        if (isTouching(Food.class))
            eat();
    }
    
    private void flip()
    {
        // movement
        for (int i=0; i<animalAnimation.length; i++)
        {
            animalAnimation[i].mirrorHorizontally();
        }
        isFacingRight = !isFacingRight;
    }

    public void eat()
    {
        Game world = getWorldOfType(Game.class);

        // play noise
        eatSound.play();

        // remove apple
        removeTouching(Food.class);

        // spawn new apple at top
        world.spawnFood();

        // increment score
        world.incrementScore();
    }
}
