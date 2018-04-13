import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Right here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Right extends Actor
{
    public Right(){
        GreenfootImage image = getImage();
        int scale = Math.max(image.getWidth(),image.getHeight());
        image.scale(image.getWidth()*50/scale, image.getHeight()*50/scale);
        setImage(image);
    }
    /**
     * Act - do whatever the Right wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
}
