import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Elements here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Elements extends Actor
{
    public Elements(){
        GreenfootImage image = getImage();
        int scale = Math.max(image.getWidth(),image.getHeight());
        image.scale(image.getWidth()*50/scale, image.getHeight()*50/scale);
        setImage(image);
    }
    
    public void act() 
    {
        if(posX>getX()){
            move(10);
        }
        if(posX<getX()){
            move(-10);
        }
        if(posY>getY()){
            setRotation(90);
            move(10);
            setRotation(0);
        }
        if(posY<getY()){
            setRotation(90);
            move(-10);
            setRotation(0);
        }
        // Add your action code here.
    }
    
    int posX;
    int posY;
    public void motion(String key) 
    {   
        if("right".equals(key)) {
            if(posX>=450)
                posX = posX - 180;
            else
                posX = posX + 60;
        }
        if("left".equals(key)) {
            if(posX<=270)
                posX = posX + 180;
            else
                posX = posX - 60;
        }
        if(posX == 270){
            if("up".equals(key)) {
                if(posY>=210)
                    posY = posY - 120;
                else
                    posY = posY + 60;
            }
            if("down".equals(key)) {
                if(posY<=90)
                    posY = posY + 120;
                else
                    posY = posY - 60;
            }
        }
        // Add your action code here.
    } 
    public boolean isPivot(){
        return (posY==210 && posX==270);
    }
}
