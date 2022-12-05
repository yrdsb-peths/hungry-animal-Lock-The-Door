import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameOver here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameOver extends World
{
    private int score;

    /**
     * Constructor for objects of class GameOver.
     * 
     */
    public GameOver(int score)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 

        this.score = score;

        prepare();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Label gameOverLabel = new Label("Game Over", 100);
        addObject(gameOverLabel,getWidth()/2,getHeight()/2-50);
        String scoreText = "Your Score: " + score;
        Label scoreLabel = new Label(scoreText, 50);
        addObject(scoreLabel,getWidth()/2,getHeight()/2+50);
    }
}
