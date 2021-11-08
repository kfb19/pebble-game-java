import java.util.ArrayList;

/**
 * The Main class is used for starting and running the game. 
 * @author Kate Belson and Michael Hills
 */

public class Main{

    private static PebbleGame pebbleGame;

    //static void main 
    public static void main(String[] args) {

        pebbleGame = new PebbleGame();
        pebbleGame.setNoUsers(pebbleGame.printMenu());


        BlackBag blackBag1 = pebbleGame.generateBlack(0,'X');
        BlackBag blackBag2 = pebbleGame.generateBlack(1,'Y');
        BlackBag blackBag3 = pebbleGame.generateBlack(2,'Z');

        WhiteBag whiteBag1 = new WhiteBag(blackBag1,'A');
        WhiteBag whiteBag2 = new WhiteBag(blackBag2,'B');
        WhiteBag whiteBag3 = new WhiteBag(blackBag3,'C');

        blackBag1.setWhiteBag(whiteBag1);
        blackBag2.setWhiteBag(whiteBag2);
        blackBag3.setWhiteBag(whiteBag3);


        ArrayList<Thread> threads = new ArrayList<>();
        ArrayList<PebbleGame.User> users = Main.pebbleGame.getUsers();



        for (int i = 0; i < pebbleGame.getNoUsers(); i++){
            users.add(pebbleGame.new User("player"+(i+1)));
            threads.add(new Thread(new Players(users.get(i))));
            threads.get(i).start();

        }


    }

    //other methods 

     /**
     * Get the pebbleGame instance of the game being played. 
     * @author Kate Belson and Michael Hills
     * @return the instance of the PebbleGame class that is being played. 
     */
    public static PebbleGame getPebbleGame() {
        return pebbleGame;
    }
}

/**
 * The Players class is used for processing information about the players, and running the player threads. 
 * @author Kate Belson and Michael Hills
 */

class Players implements Runnable{

    private final PebbleGame.User user;
    private PebbleGame pebbleGame;

    /**
     * The constructor for the Players class. 
     * @author Kate Belson and Michael Hills
     * @param user is the user for that particular thread. 
     */
    public Players(PebbleGame.User user){
        this.user = user;
        setPebbleGame();
    }

    //setter methods 

    /**
     * Sets the pebble game being played. 
     * @author Kate Belson and Michael Hills
     */
    private void setPebbleGame(){
        pebbleGame = Main.getPebbleGame();
    }

    //other methods 

     /**
     * Runs the player threads. 
     * @author Kate Belson and Michael Hills
     */
    public void run(){
        user.setPebbles();
        while (user.getTotal() != 100){
            user.addPebble();
        }

        user.addToFile("You have won!");

        for (int i=0; i < pebbleGame.getUsers().size(); i++){
            if (!pebbleGame.getUsers().get(i).equals(user)){
                pebbleGame.getUsers().get(i).addToFile(user.getPlayerName() + " has won");
            }
        }
        System.out.println(user.getPlayerName() + " has won");
        System.exit(0);

    }
}
