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
    private char bagName;

    /**
     * The constructor for the Node class.
     * @author Kate Belson and Michael Hills
     * @param file the file containing the information about the Black Bag.
     * @throws FileNotFoundException
     */
    public BlackBag (File file,char bagName) throws FileNotFoundException {
        this.bagName = bagName;
        setContents(file);

    }

    /** Takes in a min and max value and generates a random number in that range
     * @author Kate Belson and Michael Hills
     * @param min the minimum value of the number generated
     * @param max the maximum value of number generated
     * @return the random number
     */
    public int getRandomNumber(int min, int max) {
        synchronized (contents) {
            return (int) Math.floor(Math.random() * (max - min + 1) + min);
        }
    }

    /**
     * Takes a rock from the bag, and if the bag is empty, put the contents of the
     * corresponding white bag in it.
     * @author Kate Belson and Michael Hills
     * @param pos the position of the rock taken.
     * @return the pebble taken from the bag.
     */
    public int takeRock(int pos){
        synchronized (contents) {
            if (contents.size() == 0) {
                contents = whiteBag.switchBags();
                pos = getRandomNumber(0,this.getNoRocks()-1);
            }

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


    /**
     * Sets the corresponding white bag to the black bag object.
     * @author Kate Belson and Michael Hills
     * @param whiteBag the corresponding white bag to the black bag selected.
     */
    public void setWhiteBag(WhiteBag whiteBag){
        this.whiteBag = whiteBag;
    }


    //getter methods

    /**
     * Returns the contents of the Black Bag.
     * @author Kate Belson and Michael Hills
     * @return the contents of the Black Bag.
     */
    public List<Integer> getContents() {
        synchronized (contents){
            return this.contents;
        }
    }

    /**
     * Returns the number of rocks in the bag.
     * @author Kate Belson and Michael Hills
     * @return the number of rocks in the bag.
     */
    public int getNoRocks(){
        synchronized (contents){
            return contents.size();
        }

    }


    /**
     * Returns the corresponding white bag to the black bag.
     * @author Kate Belson and Michael Hills
     * @return the corresponding white bag.
     */
    public WhiteBag getWhiteBag() {
        return whiteBag;
    }

    /**
     * Returns the name of the Black Bag.
     * @author Kate Belson and Michael Hills
     * @return the name of the Black Bag.
     */
    public char getBagName() {
        return bagName;
    }
}

