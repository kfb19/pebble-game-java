import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.lang.reflect.Field;
import java.util.Scanner;

import static org.junit.Assert.*;

public class GameTest {

    private Game game;

    @Test
    public void generateBlack() {

    }

    @Before
    public void setUp(){
        game = new Game();

    }
   @Test
    public void printMenu() {
        game.printMenu();

        String data = "7";
        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Scanner scanner = new Scanner(System.in);
        System.out.println(scanner.nextLine());
    }



    @Test
    public void setUsers() {
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
    public void getUsers() {
    }
}