/**
 * 
 * 
 * @author Saeed & Maryam
 */
public class Bullet {
    
    private int damage;
    private int locationX;
    private int locationY;
    
    public Bullet(int locationX,int locationY){
        this.locationX=locationX;
        this.locationY=locationY;
    }
    
    // set method for damage
    public void setDamage(int damage){    
        this.damage = damage;
    }
    // get method for damage
    public int getDamage() {
        return damage;
    }
    
   
    public void setLocationX(int x){
        locationX=x;
    }
    public void setLocationY(int y){
        locationY=y;
    }
    
    public int getLocationX(){
        return locationX;
    }
    public int getLocationY(){
        return locationY;
    }
    
    public void move(){
        locationX+=1;
    }
}
