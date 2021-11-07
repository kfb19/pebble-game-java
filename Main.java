import java.util.ArrayList;


public class Main{

    private static PebbleGame pebbleGame;

    public static void createPebbleGame(){
        pebbleGame = new PebbleGame();
    }

    public static void main(String[] args) {

        Main.createPebbleGame();
        Main.pebbleGame.setNoUsers(Main.pebbleGame.printMenu());


        BlackBag blackBag1 = Main.pebbleGame.generateBlack(0,'X');
        BlackBag blackBag2 = Main.pebbleGame.generateBlack(1,'Y');
        BlackBag blackBag3 = Main.pebbleGame.generateBlack(2,'Z');

        WhiteBag whiteBag1 = new WhiteBag(blackBag1,'A');
        WhiteBag whiteBag2 = new WhiteBag(blackBag2,'B');
        WhiteBag whiteBag3 = new WhiteBag(blackBag3,'C');

        blackBag1.setWhiteBag(whiteBag1);
        blackBag2.setWhiteBag(whiteBag2);
        blackBag3.setWhiteBag(whiteBag3);


        ArrayList<Thread> threads = new ArrayList<>();
        ArrayList<PebbleGame.User> users = Main.pebbleGame.getUsers();



        for (int i = 0; i < Main.pebbleGame.getNoUsers(); i++){
            users.add(Main.pebbleGame.new User("player"+(i+1)));
            threads.add(new Thread(new Players(users.get(i))));
            threads.get(i).start();

        }


    }
}

class Players implements Runnable{

    private final PebbleGame.User user;

    public void run(){
        user.setPebbles();
        while (user.getTotal() != 100){
            user.addPebble();
        }
        System.out.println("Player won");

    }

    public Players(PebbleGame.User user){
        this.user = user;
    }
}
