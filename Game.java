import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * The Game class provides the functionality and running of the game.
 * @author Kate Belson and Michael Hills
 */

public class Game {

    private int noUsers;
    private ArrayList<User> users = new ArrayList<>();
    private ArrayList<BlackBag> blackBags = new ArrayList<>();


    /**
     * Generates a black bag based on the number of users in the game.
     * @author Kate Belson and Michael Hills
     * @param num the number of the bag being created.
     * @param bagName the name of the bag being created.
     * @return the black bag that has just been created.
     */
    public BlackBag generateBlack(int num, char bagName){
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
                    blackBag = new BlackBag(file,bagName);
                    if (blackBag.getContents().size() < noUsers*11){
                        System.out.println("Invalid file contents: File must contain at least 11" +
                                " times as many pebbles as players");
                        validInput = false;
                    }
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

/*
    public void addBlack(BlackBag blackBag){
        blackBags.add(blackBag);
    }

 */

    /**
     * Prints the menu options for the start of the game.
     * @author Kate Belson and Michael Hills
     * @return the integer number of users for the game.
     */
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

    /**
     * The User class with information about the users of the game.
     * @author Kate Belson and Michael Hills
     */
    class User{
        private List<Integer> pebbles = Collections.synchronizedList(new ArrayList<Integer>());
        private Writer file;
        private String playerName;

        /**
         * The constructor for the User class.
         * @author Kate Belson and Michael Hills
         */
        public User (String playerName)  {
            this.playerName = playerName;
            createFile();

        }


        //setter methods

        /**
         * Generates a random number.
         * @author Kate Belson and Michael Hills
         * @param min the minimum value of the random number.
         * @param max the maximum value of the random number.
         * @return the random number generated.
         */
        public synchronized int getRandomNumber(int min, int max) {
            return (int)Math.floor(Math.random()*(max-min+1)+min);
        }

        /**
         * Creates the user's output file.
         * @author Kate Belson and Michael Hills
         */
        public void createFile() {
            try {
                file = new FileWriter(playerName + "_output.txt", false);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        /**
         * Adds the user information to their file.
         * @param s is the name of the file.
         * @author Kate Belson and Michael Hills
         */
        public void addToFile(String s){
            try {
                file.write(s + System.getProperty("line.separator"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                file.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        /**
         * Sets the list of pebbles.
         * @author Kate Belson and Michael Hills
         */
        public void setPebbles() {
            BlackBag blackBag = blackBags.get(getRandomNumber(0,2));
            synchronized (blackBag.getContents()) {
                for (int i = 0; i < 10; i++) {
                    pebbles.add(blackBag.takeRock(getRandomNumber(0, blackBag.getNoRocks() - 1)));
                }
                addToFile(playerName + " hand is " + pebbles);
            }
        }

        /**
         * Adds a pebble to the user's hand.
         * @author Kate Belson and Michael Hills
         */
        public void addPebble(){
            BlackBag blackBag = blackBags.get(getRandomNumber(0,2));
            synchronized (blackBag.getContents()){

                int toRemove = getRandomNumber(0, 9);
                int removePebble = pebbles.get(toRemove);

                blackBag.getWhiteBag().addPebble(pebbles.get(toRemove));
                pebbles.remove(toRemove);

                addToFile(playerName + "has discarded " + removePebble + " to bag "
                        + blackBag.getWhiteBag().getBagName());
                addToFile(playerName + " hand is " + pebbles);

                int toAdd = getRandomNumber(0, blackBag.getNoRocks() - 1);
                int addPebble = blackBag.takeRock(toAdd);
                pebbles.add(addPebble);

                addToFile(playerName + " has drawn " + addPebble + " from bag "
                        + blackBag.getBagName());
                addToFile(playerName + " hand is " + pebbles);

            }
        }

        //getter methods
        /**
         * Returns the total value of the pebbles held by the user.
         * @author Kate Belson and Michael Hills
         * @return the total value of the pebbles help by the user.
         */
        public int getTotal() {
            synchronized (pebbles) {
                int total = 0;
                for (Integer pebble : pebbles) {
                    total = total + pebble;
                }
                return total;
            }
        }

        /**
         * Returns the name of the player.
         * @author Kate Belson and Michael Hills
         * @return the name of the player.
         */
        public String getPlayerName(){
            return playerName;
        }

    }


    /**
     * Sets the number of users playing the game.
     * @author Kate Belson and Michael Hills
     * @param noUsers contains the number of game players.
     */
    public void setNoUsers(int noUsers) {
        this.noUsers = noUsers;
    }


    /**
     * Returns the number of game players.
     * @author Kate Belson and Michael Hills
     * @return the number of users.
     */public int getNoUsers(){
        return noUsers;
    }


    /**
     * Returns the list of game players.
     * @author Kate Belson and Michael Hills
     * @return the list of users.
     */
    public ArrayList<User> getUsers(){
        return users;
    }

    /**
     * The constructor for the PebbleGame class.
     * @author Kate Belson and Michael Hills
     */
    public Game() {
    }

}
