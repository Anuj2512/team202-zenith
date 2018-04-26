import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Level3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level3 extends World
{
    int timer;
    Text timerText;
    Elements[] grid;
    Elements[] myPlateGrid;
    MyPlate plate;
    Elements pizza;
    Elements fries;
    Elements drink;
    Elements burger;
    Elements[] rPlateGrid;
    MyPlate rplate;
    Elements rpizza;
    Elements rfries;
    Elements rdrink;
    Elements rburger;
    int levelTime;

    /**
     * Constructor for objects of class Level3.
     * 
     */
    public Level3()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 600, 1); 
        levelTime = 600;
        timerText = new Text();
        addObject(timerText, 100, 15);
        timerText.setText("Time Left: " + (timer/60));
        Text demoText = new Text();
        addObject(demoText, 400, 15);
        
        
        demoText.setText("Press Arrow keys to navigate");
        Text demoText2 = new Text();
        addObject(demoText2, 150, 180);
        demoText2.setText("Press return key ");
        Text demoText3 = new Text();
        addObject(demoText3, 150, 210);
        demoText3.setText("to add this");
        Text demoText4 = new Text();
        addObject(demoText4, 150, 240);
        demoText4.setText("to your plate");
        Text demoText5 = new Text();
        addObject(demoText5, 100, 510);
        demoText5.setText("Build this plate");
        addObject (new Box(), 270, 210);
        
        grid  = new Elements[12];
        myPlateGrid  = new Elements[12];
        rPlateGrid  = new Elements[12];
        
        //addObject (new Up(), 30, 150);
        //addObject (new Down(), 150, 150);
        //addObject (new Left(), 90, 90);
        //addObject (new Right(), 90, 210);
        plate = new MyPlate();
        addObject (plate, 270, 330);
        rplate = new MyPlate();
        addObject (rplate, 270, 510);
        
        
        grid[3] = new f1(330,90);
        addObject (grid[3], 330, 90);
        grid[4] = new f2(330,150);
        addObject (grid[4], 330, 150);
        grid[5] = new f3(330,210);
        addObject (grid[5], 330, 210);
        grid[6] = new d1(390,90);
        addObject (grid[6], 390, 90);
        grid[7] = new d2(390,150);
        addObject (grid[7], 390, 150);
        grid[8] = new d3(390,210);
        addObject (grid[8], 390, 210);
        grid[9] = new b1(450, 90);
        addObject (grid[9], 450, 90);
        grid[10] = new b2(450, 150);
        addObject (grid[10], 450, 150);
        grid[11] = new b3(450, 210);
        addObject (grid[11], 450, 210);
        grid[0] = new p1(270, 90);
        addObject (grid[0], 270, 90);
        grid[1] = new p2(270, 150);
        addObject (grid[1], 270, 150);
        grid[2] = new p3(270, 210);
        addObject (grid[2], 270, 210);
        
        
        rPlateGrid[3] = new f1(310,510);
        rPlateGrid[4] = new f2(310,510);
        rPlateGrid[5] = new f3(310,510);
        rPlateGrid[6] = new d1(240,510);
        rPlateGrid[7] = new d2(240,510);
        rPlateGrid[8] = new d3(240,510);
        rPlateGrid[9] = new b1(270, 490);
        rPlateGrid[10] = new b2(270, 490);
        rPlateGrid[11] = new b3(270, 490);
        rPlateGrid[0] = new p1(270, 530);
        rPlateGrid[1] = new p2(270, 530);
        rPlateGrid[2] = new p3(270, 530);
        
        myPlateGrid[3] = new f1(310,330);
        myPlateGrid[4] = new f2(310,330);
        myPlateGrid[5] = new f3(310,330);
        myPlateGrid[6] = new d1(240,330);
        myPlateGrid[7] = new d2(240,330);
        myPlateGrid[8] = new d3(240,330);
        myPlateGrid[9] = new b1(270, 310);
        myPlateGrid[10] = new b2(270, 310);
        myPlateGrid[11] = new b3(270, 310);
        myPlateGrid[0] = new p1(270, 350);
        myPlateGrid[1] = new p2(270, 350);
        myPlateGrid[2] = new p3(270, 350);
        newGame();
    }
    public void act() 
    {
        if (timer%60==0) timerText.setText("Time Left: " + (timer/60));
        timer = timer -1;
        if(timer < 0){
            Text WinText = new Text();
            addObject(WinText, 300, 420);
            WinText.setText("YOU LOSE!!");
            String answer = "N";
            while(!"y".equals(answer) && !"Y".equals(answer)){
                answer = Greenfoot.ask("Do you want to try again(Y/N)");
                if("y".equals(answer) || "Y".equals(answer))
                {
                    Greenfoot.setWorld(new MyWorld());
                }
            }    
        }
        String key = Greenfoot.getKey();
        if("enter".equals(key)){
            int i;
            for(i = 0; i< 12; i++){
               if(grid[i].isPivot())
                    break;
            }
            if(i/3==0){
                removeObject(pizza);
                pizza = myPlateGrid[i];
                addObject(pizza,270,210);
            }else if(i/3==1){
                removeObject(fries);
                fries = myPlateGrid[i];
                addObject(fries,270,210);
            }else if(i/3==2){
                removeObject(drink);
                drink = myPlateGrid[i];
                addObject(drink,270,210);
            }else if(i/3==3){
                removeObject(burger);
                burger = myPlateGrid[i];
                addObject(burger,270,210);
            }
            if(isCorrect()){
                pizza.setLocation(270, 350);
                fries.setLocation(310,330);
                drink.setLocation(240,330);
                burger.setLocation(270, 310);
                Text WinText = new Text();
                addObject(WinText, 300, 420);
                WinText.setText("Congratulations!! Task Completed in time = " + ((levelTime-timer)/60));
                String answer = "N";
                while(!"y".equals(answer) && !"Y".equals(answer)){
                    answer = Greenfoot.ask("CONGRATULATIONS!!! Do you wish to play again(Y/N)");
                    if("y".equals(answer) || "Y".equals(answer))
                    {
                        Greenfoot.setWorld(new MyWorld());
                    }
                }
            }
        }else{
            for(int i = 0; i< 12; i++){
               grid[i].motion(key);
            }
        }
        
    } 
    public void newGame() {
        
        removeObject(pizza);
        removeObject(fries);
        removeObject(drink);
        removeObject(burger);
        
        pizza = null;
        fries = null;
        drink = null;
        burger = null;
        
        rpizza = rPlateGrid[Greenfoot.getRandomNumber(3)];
        rfries = rPlateGrid[Greenfoot.getRandomNumber(3)+3];
        rdrink = rPlateGrid[Greenfoot.getRandomNumber(3)+6];
        rburger = rPlateGrid[Greenfoot.getRandomNumber(3)+9];
        
        addObject(rpizza,270, 530);
        addObject(rfries,310,510);
        addObject(rdrink,240,510);
        addObject(rburger,270, 490);
        timer = levelTime;
    }
    public boolean isCorrect() {
        
        if(pizza==null || !(rpizza.getClass().getName()).equals(pizza.getClass().getName()))
            return false;
        if(fries==null || !(rfries.getClass().getName()).equals(fries.getClass().getName()))
            return false;
        if(drink==null || !(rdrink.getClass().getName()).equals(drink.getClass().getName()))
            return false;
        if(burger==null || !(rburger.getClass().getName()).equals(burger.getClass().getName()))
            return false;
        
        return true;
    }
}
