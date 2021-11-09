import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The WhiteBag class contains the contents and information of each white bag
 * @author Kate Belson and Michael Hills
 */

public class WhiteBag {

    private List<Integer> contents = Collections.synchronizedList(new ArrayList<Integer>());
    private BlackBag blackBag;
    private char bagName;


    /**
     * Empties the contents of the white bag into the black bag.
     * @author Kate Belson and Michael Hills
     * @return the list containing the contents of the white bag to be put in the black bag.
     */
    public List<Integer> switchBags(){
        synchronized (contents) {
                List<Integer> black = Collections.synchronizedList(new ArrayList<Integer>(contents));
                contents.clear();
                return black;
        }
    }

    /**
     * The constructor for the White Bag class
     * @author Kate Belson and Michael Hills
     */
    public  WhiteBag (BlackBag blackBag,char bagName) {
        this.blackBag = blackBag;
        this.bagName = bagName;
        blackBag.setWhiteBag(this);
    }


    /**
     * Adds a pebble to the white bag.
     * @author Kate Belson and Michael Hills
     * @param pebble contains the pebble to be added to the bag.
     */
    public void addPebble(int pebble){
        synchronized (contents){
            contents.add(pebble);
        }
    }

    //getter methods

    /**
     * Returns the contents of the White Bag.
     * @author Kate Belson and Michael Hills
     * @return the contents of the White Bag.
     */
    public List<Integer> getContents() {
        return contents;
    }

    /**
     * Returns the name of the White Bag.
     * @author Kate Belson and Michael Hills
     * @return the name of the White Bag.
     */
    public char getBagName() {
        return bagName;
    }
}