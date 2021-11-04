import java.util.ArrayList;

/**
 * The User class records details of all the different users playing the game.
 * @author Kate Belson and Michael Hills
 */

public class User {

    private ArrayList<Integer> pebbles;

    /**
     * The constructor for the User class.
     * @author Kate Belson and Michael Hills
     */
    public User ()  {
        setPebbles();
    }

    //setter methods

    /**
     * Sets the list of pebbles.
     * @author Kate Belson and Michael Hills
     */
    public void setPebbles() {
        this.pebbles = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++){
            
        }
    }

    public void addPebble(int Pebble){
        pebbles.add(Pebble);
    }

    //getter methods

    /**
     * Returns the list of pebbles held by the user.
     * @author Kate Belson and Michael Hills
     * @return the list of pebbles help by the user.
     */
    public ArrayList<Integer> getPebbles() {
        return this.pebbles;
    }

    /**
     * Returns the total value of the pebbles held by the user.
     * @author Kate Belson and Michael Hills
     * @return the total value of the pebbles help by the user.
     */
    public int getTotal() {
        int total = 0;
        for (Integer pebble : pebbles) {
            total = total + pebble;
        }
        return total;
    }

}