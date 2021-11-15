import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PebbleGame {

    private static Game game;
    public static List<Boolean> finished = Collections.synchronizedList(new ArrayList<Boolean>());
    private static ArrayList<Thread> threads;


    public static void main(String[] args) {

        game = new Game();
        game.setNoUsers(game.printMenu());

        BlackBag blackBag1 = game.generateBlack(0,'X');
        BlackBag blackBag2 = game.generateBlack(1,'Y');
        BlackBag blackBag3 = game.generateBlack(2,'Z');

        WhiteBag whiteBag1 = new WhiteBag(blackBag1,'A');
        WhiteBag whiteBag2 = new WhiteBag(blackBag2,'B');
        WhiteBag whiteBag3 = new WhiteBag(blackBag3,'C');

        blackBag1.setWhiteBag(whiteBag1);
        blackBag2.setWhiteBag(whiteBag2);
        blackBag3.setWhiteBag(whiteBag3);


        ArrayList<Game.User> users = PebbleGame.game.getUsers();

        threads = new ArrayList<>();

        for (int i = 0; i < game.getNoUsers(); i++){
            finished.add(false);
            users.add(game.new User("player"+(i+1)));
            threads.add(new Thread(new Players(users.get(i))));
            threads.get(i).start();
        }
    }

    public static Game getPebbleGame() {
        return game;
    }

    public synchronized static void stopThreads(int num, Game.User user){
        user.addToFileWon("You have won!");

        for (int i=0; i<threads.size(); i++){
            if (i != num){
                game.getUsers().get(i).addToFileWon("Player " + (num + 1) + " has won");
            }
        }
        System.exit(0);

    }
}

class Players implements Runnable{

    private final Game.User user;
    private Game game;

    public void run() {

        if (!PebbleGame.finished.contains(true)) {
            user.setPebbles();
            while (user.getTotal() != 100) {
                if (!PebbleGame.finished.contains(true)) {
                    user.addPebble();
                }
            }
            PebbleGame.finished.set(game.getUsers().indexOf(user), true);
            PebbleGame.stopThreads(game.getUsers().indexOf(user), user);
        }


    }


    public Players(Game.User user){
        this.user = user;
        setPebbleGame();
    }

    private void setPebbleGame(){
        game = PebbleGame.getPebbleGame();
    }
}



