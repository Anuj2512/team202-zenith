import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class FlappyBird here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FlappyBird extends Actor
{
   
    double dy =0;
    double gConst = 1.3;
    
    /**
     * Act - do whatever the FlappyBird wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here
   
        setLocation(getX(),(int)(getY()+dy));
        if(Greenfoot.isKeyDown("up") == true){
            dy = -15;
        }
       
        
        if(getY() > getWorld().getHeight() ){
            //getWorld().stopped();
            GameOver over = new GameOver();
            getWorld().addObject(over,getWorld().getWidth()/2,getWorld().getHeight()/2);
            Greenfoot.stop();
        }
        dy = dy+gConst;
    }    
}
