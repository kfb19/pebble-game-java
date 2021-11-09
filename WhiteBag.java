import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The BlackBag class processes the Black Bag file and the information it contains.
 * @author Kate Belson and Michael Hills
 */

public class WhiteBag {

    private List<Integer> contents = Collections.synchronizedList(new ArrayList<Integer>());
    private BlackBag blackBag;
    private char bagName;


    public List<Integer> switchBags(){
        synchronized (contents) {
                List<Integer> black = Collections.synchronizedList(new ArrayList<Integer>(contents));
                contents.clear();
                return black;
        }
    }

    /**
     * The constructor for the White Bag Class
     * @author Kate Belson and Michael Hills
     */
    public  WhiteBag (BlackBag blackBag,char bagName) {
        this.blackBag = blackBag;
        this.bagName = bagName;
        blackBag.setWhiteBag(this);
    }

    //setter methods


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

    public char getBagName() {
        return bagName;
    }
}