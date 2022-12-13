import java.util.ArrayList;

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Game extends World
{
    int speed = 5;
    int score = 0;
    Label scoreLabel = new Label(0, 50);
    TimerLabel timerLabel = new TimerLabel(60, () -> {endGame(); return null;});

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
        addObject(animal,getWidth()/2,getHeight()-50);
        spawnFood();
        addObject(scoreLabel,200,174);
        scoreLabel.setLocation(20,25);
        addObject(timerLabel,getWidth()-30,25);
    }

    public void spawnFood()
    {
        Food food = new Food();
        addObject(food,Greenfoot.getRandomNumber(getWidth()),0);
    }

    public void spawnBonus()
    {
        BonusTime bonus = new BonusTime();
        addObject(bonus,Greenfoot.getRandomNumber(getWidth()),0);
    }
    public void spawnBonusChance()
    {
        if (Greenfoot.getRandomNumber(Math.max(timerLabel.getTime()/3, 10)) == 0)
        {
            spawnBonus();
        }
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

        // increase speed
        speed = speed/15 + 5;
    }

    public void addTime(int seconds)
    {
        timerLabel.addTime(seconds);
    }

    public ArrayList<Actor> removingActors = new ArrayList<Actor>();
    public void removeDelayed(Actor actor)
    {
        removingActors.add(actor);
    }

    public void endGame()
    {
        Greenfoot.setWorld(new GameOver(score));
    }

    public void act()
    {
        for (Actor actor : removingActors)
        {
            removeObject(actor);
        }
        removingActors.clear();
    }
}
