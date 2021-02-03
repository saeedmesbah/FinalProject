
public class Chopper {
    
    private int locationX;
    private int locationY;
    private int limitX;
    
    // get method for location
    public int getLocationY() {
        return locationY;
    }
    
    // set method for location
    public void setLocationY(int locationY) {
        this.locationY = locationY;
    }

    // get method for location
    public int getLimitX() {
        return limitX;
    }
    
    // set method for location
    public void setLimitX(int limitX) {
        this.limitX = limitX;
    }
    
    public Chopper(){}
    
    // set method for location
    public void setLocationX(int location){
        this.locationX=location;
    }
    // get method for location
    public int getLocationX(){
        return locationX;
    }
    
    public void moveChopper(){
        limitX=8;
    }
    
}
