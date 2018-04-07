import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bug here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bug extends Actor
{
    /**
     * Act - do whatever the Bug wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
   {
       move();
   }  
    public void move()
   {
       int y = getY();
       int x = getX();
       if(Greenfoot.isKeyDown("W"))y--;
       if(Greenfoot.isKeyDown("S"))y++;
       if(Greenfoot.isKeyDown("A"))x--;
       if(Greenfoot.isKeyDown("D"))x++;
       setLocation(x,y);
    }   
   
}
