import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Jumper here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Jumper extends Actor
{
    /**
     * Act - do whatever the Jumper wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private final int GRAVITY = 1;
    private int velocity;
    public Jumper()
    {
        velocity = 0;
    }
    public void act() 
    {
        fall();
        if(Greenfoot.isKeyDown("space") && isOnSolidGround()) jump();
        move();
    }   
    public void fall()
    {
        setLocation(getX(),getY() + velocity);
        if(isOnSolidGround())
        {
            while(isOnSolidGround())
            {
                setLocation(getX(),getY()-1);
            }
            setLocation(getX(),getY()+1);
            velocity = 0;
        }
        if(velocity < 0 && didBumpHead()) velocity = 0;
        else velocity +=GRAVITY;
    }
    public void jump()
    {
        velocity = -20;
    }
    public void move()
    {
        int y = getY();
       int x = getX();
       if(Greenfoot.isKeyDown("left"))x -=3;
       if(Greenfoot.isKeyDown("right"))x +=3;
       setLocation(x,y);
    }
    public boolean isOnSolidGround()
    {
        boolean isOnGround = false;
        if (getY() > getWorld().getHeight() - 50) isOnGround = true;
        int imageWidth = getImage().getWidth();
        int imageHeight = getImage().getHeight();
        
        if(getOneObjectAtOffset(imageWidth / -2, imageHeight / 2 , Platform.class) != null ||
        getOneObjectAtOffset(imageWidth / 2, imageHeight / 2 , Platform.class) != null) isOnGround = true;
        
        return isOnGround;
    }
    public boolean didBumpHead()
    {
        boolean didBumpHead = false;
        int imageWidth = getImage().getWidth();
        int imageHeight = getImage().getHeight();
        
        if(getOneObjectAtOffset(imageWidth / -2, imageHeight / -2 , Platform.class) != null ||
        getOneObjectAtOffset(imageWidth / 2, imageHeight / -2 , Platform.class) != null) didBumpHead = true;
        
        return didBumpHead;
    }
}
