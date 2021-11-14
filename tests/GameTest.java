import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import static org.junit.Assert.*;


public class GameTest {

    private Game game;

    @Test
    public void generateBlack() {

        String data = "example_file_1.csv";
        InputStream stdin = System.in;
        try {
            System.setIn(new ByteArrayInputStream(data.getBytes()));
            Scanner scanner = new Scanner(System.in);
            System.out.println(scanner.nextLine());
        } finally {
            System.setIn(stdin);
        }

        game.generateBlack(1,'x');





    }

    @Before
    public void setUp(){
        game = new Game();

    }
   @Test
    public void printMenu() {
        game.printMenu();


    }

    @Test
    public void setNoUsers() throws NoSuchFieldException, IllegalAccessException {

        game.setNoUsers(3);

        Field field;
        field = game.getClass().getDeclaredField("noUsers");
        field.setAccessible(true);
        assertEquals(field.get(game),3);
    }

    @Test
    public void getNoUsers() {
        Game game = new Game();
        game.setNoUsers(7);
        assertEquals(7, game.getNoUsers());

    }

    @Test
    public void getUsers() throws NoSuchFieldException, IllegalAccessException {
        Field field;
        field = game.getClass().getDeclaredField("users");
        field.setAccessible(true);
        Game.User user = game.new User("player1");
        ArrayList<Game.User> users = new ArrayList<Game.User>(Arrays.asList(user));
        field.set(game,users);
        assertEquals(field.get(game),users);
    }
}