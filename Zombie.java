
import java.awt.Image;
import java.security.SecureRandom;
import javax.swing.ImageIcon;

/**
 * 
 * @author Saeed & Maryam
 */
public class Zombie {
    private SecureRandom generator = new SecureRandom();
    private int health;
    private int locationX;
    private int locationY;
    private int speedMovement=2;
    private int damage;
    
    public Zombie(int damage){
        this.damage=damage;
        this.health=health;
        locationX=8;
        locationY=generator.nextInt(5);
    }
    
    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
    
    // set method for power
    public void setHealth(int health){
        this.health=health;
    }
    // set method for power
    public int getHealth(){
        return health;
    }
    
    
    // set method for location
    public void setLocationX(int x){
        locationX=x;
    }
    public void setLocationY(int y){
        locationY=y;
    }
    
    
    // get method for location
    public int getLocationX(){
        return locationX;
    }
    public int getLocationY(){
        return locationY;
    }
    
    public void move(){
        locationX-=1;
    }
    
    public Image getIcon(){
        return null;
    }

    public int getSpeedMovement() {
        return speedMovement;
    }

    public void halfSpeedMovement() {
        speedMovement=1;
    }
    
    
}
