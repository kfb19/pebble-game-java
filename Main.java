import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        PebbleGame pebbleGame = new PebbleGame();
        pebbleGame.setNoUsers(pebbleGame.printMenu());

        File black0 = pebbleGame.getFile(0);
        File black1 = pebbleGame.getFile(1);
        File black2 = pebbleGame.getFile(2);

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

        pebbleGame.setUsers();

        






    }
}
