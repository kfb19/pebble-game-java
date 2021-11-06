import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.io.*;

/**
 * The BlackBag class processes the Black Bag file and the information it contains.
 * @author Kate Belson and Michael Hills
 */

public class BlackBag {

    private List<Integer> contents = Collections.synchronizedList(new ArrayList<Integer>());
    private WhiteBag whiteBag;

    /**
     * The constructor for the Node class.
     * @author Kate Belson and Michael Hills
     * @param file the file containing the information about the Black Bag.
     * @throws FileNotFoundException
     */
    public BlackBag (File file) throws FileNotFoundException {
        setContents(file);
    }

    public int takeRock(int pos){
        synchronized (contents) {
            int pebble = contents.get(pos);
            contents.remove(pos);
            return pebble;
        }

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
            data = data.replaceAll("\\s+","");
            String[] values = data.split(",");

            for (int i = 0; i < values.length; i++) {
                contents.add(Integer.parseInt(values[i]));
            }

        }
        fileReader.close();
    }

    public void setWhiteBag(WhiteBag whiteBag){
        this.whiteBag = whiteBag;
    }

    public int getLength(){
        return contents.size();
    }

    //getter methods

    /**
     * Returns the contents of the Black Bag.
     * @author Kate Belson and Michael Hills
     * @return the contents of the Black Bag.
     */
    public List<Integer> getContents() {

        return this.contents;
    }

    public int getNoRocks(){
        synchronized (contents){
            return contents.size();
        }

    }


}

