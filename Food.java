import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class food here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Food extends FallingObject
{
    public Food()
    {
        super(new GreenfootSound("sounds/elephantcub.mp3"));

        // pick random food image
        int foodNumber = Greenfoot.getRandomNumber(3);
        String foodImage = "images/foods/" + foodNumber + ".png";
        GreenfootImage image = new GreenfootImage(foodImage);
        image.scale(75,75);
        setImage(image);
    }

    protected void eat()
    {
        // add score
        Game world = getWorldOfType(Game.class);
        world.incrementScore();

        // spawn new food
        world.spawnFood();

        // random chance to spawn bonus
        world.spawnBonusChance();
    }

    protected void miss()
    {
        Game world = getWorldOfType(Game.class);
        world.endGame();
    }
}
