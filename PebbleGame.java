import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class PebbleGame {

    static String getFile(){
        Scanner input = new Scanner(System.in);
        boolean validInput = false;
        String fileName = null;

        do {
            System.out.println("Please enter location of bag number 0 to load: ");
            fileName = System.getProperty("user.dir")+"\\src\\" + input.nextLine();
            if(new File(fileName).isFile()) {
                validInput = true;

            }
            else{
                System.out.println("Invalid file name: file does not exist");
            }

        } while (!validInput);

        return fileName;
    }

    public static void main(String[] args) {
        System.out.println("Welcome to the Pebble Game!! \n You will be asked to enter the number of players" +
                "\nand then for the location of three files in turn containing comma separated" +
                "\ninteger valus for the pebble weights." +
                "\nThe integer values must be strictly positive." +
                "\nThe game will then be simulated, and an output written to files in this directory." +
                "\n");


        boolean validInput = false;
        Scanner input = new Scanner(System.in);
        String noUsers = null;
        do {
            System.out.print("Enter Number: ");
            noUsers = input.nextLine();
            try{
                if (Integer.parseInt(noUsers) > 0) {
                    validInput = true;
                } else {
                    System.out.println(("Invalid input: Must be integer > 0: "));
                }
            }catch (NumberFormatException ne) {
                System.out.println("Invalid input: Must be integer > 0: ");
            }

        } while (!validInput);

        String black1 = getFile();
        String black2 = getFile();
        String black3 = getFile();







    }
}
