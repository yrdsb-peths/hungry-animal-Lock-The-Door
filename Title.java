import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Title here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Title extends World
{

    /**
     * Constructor for objects of class Title.
     * 
     */
    public Title()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        prepare();
    }
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Label titleLabel = new Label("Hungry Elephant", 75);
        titleLabel.setFillColor(Color.BLACK);
        addObject(titleLabel,getWidth()/2,75);

        Label startLabel = new Label("Press Space to Start", 50);
        startLabel.setFillColor(Color.BLACK);
        addObject(startLabel,getWidth()/2,300);
    }

    public void act()
    {
        if (Greenfoot.isKeyDown("space"))
        {
            Greenfoot.setWorld(new Game());
        }
    }
}
