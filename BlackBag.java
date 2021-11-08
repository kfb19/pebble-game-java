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

    public int takeRock(int pos){
        synchronized (contents) {
                if (contents.size() == 0) {
                    contents = whiteBag.switchBags();
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

    public int getNoRocks(){
        synchronized (contents){
            return contents.size();
        }

    }

    public WhiteBag getWhiteBag() {
        return whiteBag;
    }

    public char getBagName() {
        return bagName;
    }
}

