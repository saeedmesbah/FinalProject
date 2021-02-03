
import java.awt.Image;
import java.security.SecureRandom;
import java.util.*;
import javax.swing.ImageIcon;

/**
 * 
 * @author Saeed & Maryam
 */
public class Sun {
    
    private SecureRandom generator = new SecureRandom();
    private int money;
    private int locationX;
    private int locationY;
    private int startX;
    private int limitY;
    
    private Image sunImage;
    
    
    public Sun(int locationX,int locationY){
        this.locationX=locationX;
        this.locationY=locationY;
        sunImage=new ImageIcon(this.getClass().getResource("PVS Design Kit/images/sun.png")).getImage();
    }
    
    public Sun(){
        locationX=generator.nextInt(9);
        limitY=generator.nextInt(5);
        sunImage=new ImageIcon(this.getClass().getResource("PVS Design Kit/images/sun.png")).getImage();
    }
    

    public Image getSunImage() {
        return sunImage;
    }

    public int getLocationX() {
        return locationX;
    }

    public void setLocationX(int locationX) {
        this.locationX = locationX;
    }

    public int getLocationY() {
        return locationY;
    }

    public void setLocationY(int locationY) {
        this.locationY = locationY;
    }
    
   
    public int getLimitY(){
        return limitY;
    }
    
    // set method for money
    public void setMoney(int money){
        this.money=money;
    }
    // get method for money
    public int getMoney(){
        return money;
    }
    
    public void fall() {
        if(locationY<limitY){
            locationY=locationY-1;
        }
        else{
            locationY=limitY;
        }
    }
}
