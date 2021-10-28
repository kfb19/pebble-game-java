import java.util.ArrayList;

/**
* The BlackBag class processes the Black Bag file and the information it contains. 
* @author Kate Belson and Michael Hills
*/

public class WhiteBag {

private ArrayList<Integer> contents = new ArrayList<Integer>(); 

    /**
	 * The constructor for the White Bag Class
	 * @author Kate Belson and Michael Hills
	 */
	public WhiteBag () {
        setContents();
    }

    //setter methods 

	/**
	 * Sets the contents of the White Bag. 
	 * @author Kate Belson and Michael Hills                    
	 */
	public void setContents() {
        this.contents = new ArrayList<Integer>(); 
	}

    //getter methods 

    /**
	 * Returns the contents of the White Bag. 
	 * @author Kate Belson and Michael Hills 
	 * @return the contents of the White Bag. 
	 */
	public ArrayList<Integer> getContents() {
		return this.contents;
	}

}