import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

/**
* The BlackBag class processes the Black Bag file and the information it contains. 
* @author Kate Belson and Michael Hills
*/

public class BlackBag {

private ArrayList<Integer> contents = new ArrayList<Integer>(); 

    /**
	 * The constructor for the Black Bag class. 
	 * @author Kate Belson and Michael Hills
	 * @param file the file containing the information about the Black Bag. 
     * @throws FileNotFoundException
	 */
	public BlackBag (File file) throws FileNotFoundException {
        setContents(file);
    }

    //setter methods 

	/**
	 * Sets the contents of the Black Bag. 
	 * @author Kate Belson and Michael Hills 
	 * @param file the file containing the information about the Black Bag. 
	 * @throws FileNotFoundException
	 */
	public void setContents(File file) throws FileNotFoundException {
        Scanner fileReader = new Scanner(file);
        while (fileReader.hasNextLine()) {
            String data = fileReader.nextLine();
            String[] values = data.split(",");
            for (int i=0; i<values.length; i++) {
                contents.add(Integer.parseInt(values[i]));
            }
        }
        fileReader.close();
	}

    //getter methods 

    /**
	 * Returns the contents of the Black Bag. 
	 * @author Kate Belson and Michael Hills 
	 * @return the contents of the Black Bag. 
	 */
	public ArrayList<Integer> getContents() {
		return this.contents;
	}

}