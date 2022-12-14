import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Title here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Title extends World
{
    SimpleTimer timer = new SimpleTimer();
    Label startLabel;
    
    /**
     * Constructor for objects of class Title.
     * 
     */
    public Title()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        GreenfootSound music = new GreenfootSound("christmas.mp3");
        music.playLoop();
        prepare();
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Label titleLabel = new Label("Hungry Elephant", 75);
        addObject(titleLabel,getWidth()/2,75);

        startLabel = new Label("Press Space to Start", 50);
        addObject(startLabel,getWidth()/2,350);
        timer.mark();

        Animal animal = new Animal();
        addObject(animal,getWidth()/2,getHeight()/2-35);

        Label instructionsLabel = new Label("Use \u2190 and \u2192 to move\nand eat the apples!", 40);
        addObject(instructionsLabel,getWidth()/2,getHeight()/2+60);

        GreenfootSound music = new GreenfootSound("christmas.mp3");
        music.playLoop();
    }

    boolean isStartLabelVisible = true;
    public void act()
    {
        if (Greenfoot.isKeyDown("space"))
        {
            Greenfoot.setWorld(new Game());
        }

        // animate start label
        if (timer.millisElapsed() > 500)
        {
            timer.mark();
            isStartLabelVisible = !isStartLabelVisible;
            startLabel.setLineColor(isStartLabelVisible ? Color.BLACK : new Color(0, 0, 0, 0));
            startLabel.setFillColor(isStartLabelVisible ? Color.WHITE : new Color(0, 0, 0, 0));
        }
    }
}
