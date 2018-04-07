import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * Write a description of class ant here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ant extends Actor
{
    /**
     * Act - do whatever the ant wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        move(10);
        if(Greenfoot.getRandomNumber(2)==1)
            turn(Greenfoot.getRandomNumber(30));
        else
            turn(-1*Greenfoot.getRandomNumber(30));
        
        Actor b = getOneIntersectingObject(ant.class);
         
        if(b != null)
        {
            getWorld().removeObject(b); 
            getWorld().removeObject(this); 
            
        }
    }    
}
