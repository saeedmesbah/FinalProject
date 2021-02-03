

/**
 *
 * @author Saeed & Maryam
 */
public class Player {
    private String firstName;
    private String lastName;
    private String userName;
    private int score;
    private Controller controller;
    
    
    public Player(String firstName,String lastName ,String userName){
        this.firstName=firstName;
        this.lastName=lastName;
        this.userName=userName;
    }
    
    //get method for firstName
    public String getFirstName() {
        return firstName;
    }
    /**
     * set method for firstName
     * @param firstName 
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    
    //get method for lastName
    public String getLastName() {
        return lastName;
    }    
    /**
     * set method for lastName
     * @param lastName 
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    //get method for userName
    public String getUserName() {
        return userName;
    }
    /**
     * set method for userName
     * @param userName 
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    //get method for score
    public int getScore() {
        return score;
    }
    /**
     * set method for score
     * @param score 
     */
    public void setScore(int score) {
        this.score = score;
    }
    
    public void startController(){}
    
}
