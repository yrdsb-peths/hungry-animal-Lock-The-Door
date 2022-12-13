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
        super();

        // pick random food image
        int foodNumber = Greenfoot.getRandomNumber(3);
        String foodImage = "images/foods/" + foodNumber + ".png";
        GreenfootImage image = new GreenfootImage(foodImage);
        image.scale(50,50);
        setImage(image);
    }
}
