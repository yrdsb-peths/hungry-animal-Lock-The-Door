import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Game extends World
{
    int score = 0;
    Label scoreLabel = new Label(0, 50);

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public Game()
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
        Animal animal = new Animal();
        addObject(animal,getWidth()/2,getHeight()-30);
        Food food = new Food();
        addObject(food,Greenfoot.getRandomNumber(getWidth()),0);
        addObject(scoreLabel,200,174);
        scoreLabel.setLocation(20,25);
    }

    public void incrementScore()
    {
        incrementScore(1);
    }
    public void incrementScore(int increment)
    {
        score += increment;
        scoreLabel.setValue(score);

        // reposition text
        int offset = String.valueOf(score).length() * 10;
        scoreLabel.setLocation(offset+10,25);
    }

    public void endGame()
    {
        Greenfoot.setWorld(new GameOver(score));
    }
}
