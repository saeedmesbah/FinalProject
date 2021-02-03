
import java.awt.Image;
import javax.swing.ImageIcon;


/**
 * 
 * @author Saeed & Maryam
 */

public abstract class Plant {
    private int locationX;
    private int locationY;
    private int life;
    private int timeToGenerate;
    private String ability;
    
    public Plant(int locationX,int locationY,int life){
        this.locationX = locationX;
        this.locationY = locationY;
        this.life=life;
    }
    
    // set method for location
    public void setLocationX(int locationX){    
        this.locationX = locationX;
    }
    public void setLocationY(int locationY){    
        this.locationY = locationY;
    }
    
    // get method for location
    public int getLocationX() {
        return locationX;
    }
    public int getLocationY() {
        return locationY;
    }
    
    // set method for life
    public void setLife(int life){
        this.life=life;
    }
    // get method for life
    public int getLife(){
        return life;
    }
    
    // set method for timeToGenerate
    public void setTimeToGenerate(){}
    // get method for timeToGenerate
    public int getTimeToGenerate(){
        return timeToGenerate;
    }
    
    // set method for ability
    public void setAbility(){}
    // set method for ability
    public String getAbility(){
        return ability;
    }
    
    public abstract  Image getIcon();
    
}
