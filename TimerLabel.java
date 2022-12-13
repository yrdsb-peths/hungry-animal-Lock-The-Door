import java.util.concurrent.Callable;

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TimerLabel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TimerLabel extends Label
{
    SimpleTimer timer = new SimpleTimer();
    int time;

    Callable<Void> callback;
    
    public TimerLabel(int startTime, Callable<Void> callback)
    {
        super(startTime, 50);
        this.time = startTime;
        this.callback = callback;
        timer.mark();
    }
    
    /**
     * Act - do whatever the TimerLabel wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        int secondsElapsed = timer.millisElapsed()/1000;
        int secondsRemaining = time - secondsElapsed;
        setValue(secondsRemaining);

        // reposition text
        int offset = String.valueOf(secondsRemaining).length() * 10;
        setLocation(getWorld().getWidth()-10-offset,25);

        // check if time is up
        if (secondsRemaining < 0)
        {
            try
            {
                callback.call();
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }

    public void addTime(int seconds)
    {
        time += seconds;
    }

    public int getTime()
    {
        return time;
    }
}
