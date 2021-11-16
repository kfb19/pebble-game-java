import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class UserTest {

    private Game game;
    private Game.User user;
    private File file;

    @Before
    public void setUp() throws FileNotFoundException {
        game = new Game();
        user = game.new User("player1");
        File file = new File(System.getProperty("user.dir")+ "\\tests\\testFileBlackBag11.txt");
        BlackBag blackBag1 = new BlackBag(file,'X');
        BlackBag blackBag2 = new BlackBag(file,'Y');
        BlackBag blackBag3 = new BlackBag(file,'X');
        WhiteBag whiteBag1 = new WhiteBag(blackBag1,'A');
        WhiteBag whiteBag2 = new WhiteBag(blackBag1,'B');
        WhiteBag whiteBag3 = new WhiteBag(blackBag1,'C');
        blackBag1.setWhiteBag(whiteBag1);
        blackBag2.setWhiteBag(whiteBag2);
        blackBag3.setWhiteBag(whiteBag3);
        game.addBlack(blackBag1);
        game.addBlack(blackBag2);
        game.addBlack(blackBag3);

    }



    @Test
    public void createFileTest() throws NoSuchFieldException, IOException {
        user.createFile();

        Field field;
        field = user.getClass().getDeclaredField("file");
        field.setAccessible(true);

        File file = new File(System.getProperty("user.dir") + "\\player1_output.txt");
        assertTrue(file.exists());


    }



    @Test
    public void setPebbles() throws NoSuchFieldException, IllegalAccessException {

        Field field;
        field = user.getClass().getDeclaredField("pebbles");
        field.setAccessible(true);

        user.setPebbles();

        ArrayList<Integer> expected = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6,7,8,9,10,11));
        List<Integer> result = (List<Integer>) field.get(user);
        assertFalse(Collections.disjoint(expected, result));


    }

    @Test
    public void addPebble() throws NoSuchFieldException, IllegalAccessException {
        Field field;
        field = user.getClass().getDeclaredField("pebbles");
        field.setAccessible(true);

        user.setPebbles();
        user.addPebble();
        ArrayList<Integer> expected = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6,7,8,9,10,11));
        List<Integer> result = (List<Integer>) field.get(user);
        assertFalse(Collections.disjoint(expected, result));

    }

    @Test
    public void getTotal() throws NoSuchFieldException, IllegalAccessException {

        List<Integer> pebbles = Collections.synchronizedList(
                new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6,7,8,9,10)));
        Field field;
        field = user.getClass().getDeclaredField("pebbles");
        field.setAccessible(true);

        field.set(user,pebbles);

        assertEquals(55,user.getTotal());
    }

    @Test
    public void getPlayerName() throws NoSuchFieldException, IllegalAccessException {
        Field field;
        field = user.getClass().getDeclaredField("playerName");
        field.setAccessible(true);
        field.set(user,"player1");

        assertEquals("player1",user.getPlayerName());
    }


}
