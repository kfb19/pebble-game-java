import java.util.ArrayList;


public class Main{

    private static PebbleGame pebbleGame;

    public static void createPebbleGame(){
        pebbleGame = new PebbleGame();
    }


    public static void main(String[] args) {

        Main.createPebbleGame();
        Main.pebbleGame.setNoUsers(Main.pebbleGame.printMenu());


        BlackBag blackBag1 = Main.pebbleGame.generateBlack(0);
        BlackBag blackBag2 = Main.pebbleGame.generateBlack(1);
        BlackBag blackBag3 = Main.pebbleGame.generateBlack(2);

        WhiteBag whiteBag1 = new WhiteBag(blackBag1);
        WhiteBag whiteBag2 = new WhiteBag(blackBag2);
        WhiteBag whiteBag3 = new WhiteBag(blackBag3);


        ArrayList<Thread> threads = new ArrayList<Thread>();
        ArrayList<PebbleGame.User> users = Main.pebbleGame.getUsers();



        for (int i = 0; i < Main.pebbleGame.getNoUsers(); i++){
            users.add(Main.pebbleGame.new User());
            threads.add(new Thread(new Players(users.get(i))));
            threads.get(i).start();

        }


    }
}

class Players implements Runnable{

    private final PebbleGame.User user;

    public void run(){
        user.setPebbles();
        System.out.println(user.getPebbles());

    }

    public Players(PebbleGame.User user){
        this.user = user;
    }
}
