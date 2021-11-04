import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class PebbleGame {


    static File getFile(int num){
        Scanner input = new Scanner(System.in);
        boolean validInput = false;
        String fileName = null;

        do {
            System.out.println("Please enter location of bag number " + num + " to load: ");
            String type = input.nextLine();
            fileName = System.getProperty("user.dir")+"\\src\\" + type;

            if (type.equals("E")){
                System.exit(0);
            }
            else if(new File(fileName).isFile()) {
                validInput = true;

            }
            else{
                System.out.println("Invalid file name: file does not exist");
            }

        } while (!validInput);

        File file = new File(fileName);
        return file;
    }

    public static void main(String[] args) {
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
        String noUsers = null;
        do {
            System.out.print("Enter Number: ");
            noUsers = input.nextLine();
            try{

                if (noUsers.equals("E")) {
                    System.exit(0);
                }
                else if (Integer.parseInt(noUsers) > 0) {
                    validInput = true;
                }
                else {
                    System.out.println(("Invalid input: Must be integer > 0: "));
                }
            }catch (NumberFormatException ne) {
                System.out.println("Invalid input: Must be integer > 0: ");
            }

        } while (!validInput);

        File black0 = getFile(0);
        File black1 = getFile(1);
        File black2 = getFile(2);

        input.close();


        BlackBag blackBag1 = null;
        BlackBag blackBag2 = null;
        BlackBag blackBag3 = null;

        try {
            blackBag1 = new BlackBag(black0);
            blackBag2 = new BlackBag(black1);
            blackBag3 = new BlackBag(black2);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        ArrayList<User> users = new ArrayList<User>();

        ArrayList<Integer> contents1 = blackBag1.getContents();
        ArrayList<Integer> contents2 = blackBag2.getContents();
        ArrayList<Integer> contents3 = blackBag3.getContents();

        System.out.println(contents1);
        System.out.println(contents2);
        System.out.println(contents3);

        Boolean winner = false;

        for (int i=0; i < Integer.parseInt(noUsers); i++){
            users.add(new User());
            users.get(i).setPebbles();
        }

    }
}
