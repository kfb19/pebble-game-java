import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class PebbleGame {

    private int noUsers;
    private ArrayList<User> users = new ArrayList<>();
    private ArrayList<BlackBag> blackBags = new ArrayList<>();

    public BlackBag generateBlack(int num){
        Scanner input = new Scanner(System.in);
        boolean validInput = false;
        String fileName;
        BlackBag blackBag = null;

        do {
            System.out.print("Please enter location of bag number " + num + " to load: ");
            String type = input.nextLine();
            fileName = System.getProperty("user.dir") + "\\src\\" + type;

            if (type.equals("E")) {
                System.exit(0);
            }
            else if (new File(fileName).isFile()) {

                validInput = true;
                File file = new File(fileName);
                try {
                    blackBag = new BlackBag(file);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }catch (NumberFormatException ex){
                    validInput = false;
                    System.out.println("Invalid File Contents: File must be positive integers " +
                            "separated by commas");
                }

            }
            else {
                System.out.println("Invalid file name: file does not exist");
            }

        } while (!validInput);

        blackBags.add(blackBag);
        return blackBag;


    }

    public int printMenu() {
        System.out.println("""
                Welcome to the Pebble Game!!\s
                You will be asked to enter the number of players
                and then for the location of three files in turn containing comma separated
                integer values for the pebble weights.
                The integer values must be strictly positive.
                The game will then be simulated, and an output written to files in this directory.
                """);


        boolean validInput = false;
        Scanner input = new Scanner(System.in);
        String noUsers;
        do {
            System.out.print("Enter Number: ");
            noUsers = input.nextLine();
            try {

                if (noUsers.equals("E")) {
                    System.exit(0);
                } else if (Integer.parseInt(noUsers) > 0) {
                    validInput = true;
                } else {
                    System.out.println(("Invalid input: Must be integer > 0: "));
                }
            } catch (NumberFormatException ne) {
                System.out.println("Invalid input: Must be integer > 0: ");
            }

        } while (!validInput);

        return Integer.parseInt(noUsers);
    }

    class User{
        private List<Integer> pebbles = Collections.synchronizedList(new ArrayList<Integer>());

        /**
         * The constructor for the User class.
         * @author Kate Belson and Michael Hills
         */
        public User ()  {

        }

        //setter methods

        /**
         * Sets the list of pebbles.
         * @author Kate Belson and Michael Hills
         */

        public synchronized int getRandomNumber(int min, int max) {
            return (int) ((Math.random() * (max - min)) + min);
        }

        public void setPebbles() {
            BlackBag blackBag = blackBags.get(getRandomNumber(0,2));
            synchronized (blackBag.getContents()) {
                for (int i = 0; i < 10; i++) {
                    pebbles.add(blackBag.takeRock(getRandomNumber(0, blackBag.getNoRocks() - 1)));
                }
            }
        }

        public synchronized void addPebble(int Pebble){
            pebbles.add(Pebble);
        }

        //getter methods

        /**
         * Returns the list of pebbles held by the user.
         * @author Kate Belson and Michael Hills
         * @return the list of pebbles help by the user.
         */
        public synchronized List<Integer> getPebbles() {
            return pebbles;
        }


        /**
         * Returns the total value of the pebbles held by the user.
         * @author Kate Belson and Michael Hills
         * @return the total value of the pebbles help by the user.
         */
        public synchronized int getTotal() {
            int total = 0;
            for (Integer pebble : pebbles) {
                total = total + pebble;
            }
            return total;
        }

    }

    /*
    public void setUsers(){
        this.users = new ArrayList<User>();
        for (int i = 0; i < noUsers; i++) {
            users.add(new User());
            users.get(i).setPebbles();
        }
    }
    */


    public void setNoUsers(int noUsers) {
        this.noUsers = noUsers;
    }

    public int getNoUsers(){
        return noUsers;
    }

    public ArrayList<User> getUsers(){
        return users;
    }

    public PebbleGame() {
    }

}
