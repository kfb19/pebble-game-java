import java.util.ArrayList;


public class PebbleGame {

    private static Game game;


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


        ArrayList<Thread> threads = new ArrayList<>();
        ArrayList<Game.User> users = PebbleGame.game.getUsers();



        for (int i = 0; i < game.getNoUsers(); i++){
            users.add(game.new User("player"+(i+1)));
            threads.add(new Thread(new Players(users.get(i))));
            threads.get(i).start();

        }


    }

    public static Game getPebbleGame() {
        return game;
    }
}

class Players implements Runnable{

    private final Game.User user;
    private Game game;

    public void run(){
        user.setPebbles();
        while (user.getTotal() != 100){
            user.addPebble();
        }

        user.addToFile("You have won!");

        for (int i = 0; i < game.getUsers().size(); i++){
            if (!game.getUsers().get(i).equals(user)){
                game.getUsers().get(i).addToFile(user.getPlayerName() + " has won");
            }
        }
        System.out.println(user.getPlayerName() + " has won");
        System.exit(0);

    }

    public Players(Game.User user){
        this.user = user;
        setPebbleGame();
    }

    private void setPebbleGame(){
        game = PebbleGame.getPebbleGame();
    }
}
