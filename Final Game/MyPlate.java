import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyPlate here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyPlate extends Actor
{
    /**
     * Act - do whatever the MyPlate wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public MyPlate(){
        GreenfootImage image = getImage();
        int scale = Math.max(image.getWidth(),image.getHeight());
        image.scale(image.getWidth()*150/scale, image.getHeight()*150/scale);
        setImage(image);
    }
    public void act() 
    {
        
    }
}
