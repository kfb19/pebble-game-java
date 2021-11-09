import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class BlackBagTest {

    private BlackBag blackBag;
    private File file;
    private WhiteBag whiteBag;

    @Before
    public void setUp(){
        file = new File(System.getProperty("user.dir")+ "\\tests\\testFileBlackBag.txt");
    }


    @Test
    public void takeRock() throws FileNotFoundException, NoSuchFieldException, IllegalAccessException {
        blackBag = new BlackBag(file,'X');
        blackBag.takeRock(0);

        ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(3,4,3,4,5,3,2,67,5,3,
                4,6,4,3,5,7,3,5,4));
        Field field;
        field = blackBag.getClass().getDeclaredField("contents");
        field.setAccessible(true);

        assertEquals("Contents don't match after taking", field.get(blackBag),expected);

    }

    @Test
    public void takeRockEmptyBag() throws FileNotFoundException, NoSuchFieldException, IllegalAccessException {
        file = new File(System.getProperty("user.dir")+ "\\tests\\testFileBlackEmpty.txt");
        blackBag = new BlackBag(file,'X');

        WhiteBag whiteBag1 = new WhiteBag(blackBag,'A');

        whiteBag1.addPebble(2);
        whiteBag1.addPebble(2);

        Game game = new Game();
        Game.User user = game.new User("player1");

        game.addBlack(blackBag);

        blackBag.takeRock(1);

        ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(2));


        Field field;
        field = blackBag.getClass().getDeclaredField("contents");
        field.setAccessible(true);

        assertEquals(field.get(blackBag),expected);



    }

    @Test
    public void testSetContents() throws IllegalAccessException, NoSuchFieldException, FileNotFoundException {

        blackBag = new BlackBag(file,'X');

        ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(10,3,4,3,4,5,3,2,67,5,3,
                4,6,4,3,5,7,3,5,4));

        Field field;
        field = blackBag.getClass().getDeclaredField("contents");
        field.setAccessible(true);
        assertEquals(field.get(blackBag), expected);

    }

    @Test
    public void testSetContentsEmpty() throws FileNotFoundException, NoSuchFieldException, IllegalAccessException {
        file = new File(System.getProperty("user.dir")+ "\\tests\\testFileBlackEmpty.txt");
        blackBag = new BlackBag(file,'X');

        Field field;
        field = blackBag.getClass().getDeclaredField("contents");
        field.setAccessible(true);
        assertEquals(field.get(blackBag),new ArrayList<>());
    }


    @Test
    public void setWhiteBag() throws FileNotFoundException, NoSuchFieldException, IllegalAccessException {
        blackBag = new BlackBag(file,'X');
        whiteBag = new WhiteBag(blackBag,'A');
        blackBag.setWhiteBag(whiteBag);

        Field field;
        field = blackBag.getClass().getDeclaredField("whiteBag");
        field.setAccessible(true);
        assertEquals(field.get(blackBag),whiteBag);
    }

    @Test
    public void getContents() throws FileNotFoundException, NoSuchFieldException {
        BlackBag blackBag = new BlackBag(file,'X');

        Field field = blackBag.getClass().getDeclaredField("contents");
        field.setAccessible(true);

        List<Integer> result = blackBag.getContents();

        assertEquals("field wasn't retrieved properly", result, new ArrayList<>(Arrays.asList(10,3,
                4,3,4,5,3,2,67,5,3,4,6,4,3,5,7,3,5,4)));
    }

    @Test
    public void getNoRocks() throws NoSuchFieldException, IllegalAccessException, FileNotFoundException {

        BlackBag blackBag = new BlackBag(file,'X');

        int result = blackBag.getNoRocks();

        assertEquals(result, 20);
    }

    @Test
    public void getWhiteBag() throws FileNotFoundException, NoSuchFieldException, IllegalAccessException {

        blackBag = new BlackBag(file,'X');
        Field field = blackBag.getClass().getDeclaredField("whiteBag");
        field.setAccessible(true);
        whiteBag = new WhiteBag(blackBag,'A');
        field.set(blackBag, whiteBag);

        WhiteBag result = blackBag.getWhiteBag();
        assertEquals("field not received properly", result, whiteBag);

    }

    @Test
    public void getBagName() throws FileNotFoundException {
        blackBag = new BlackBag(file,'X');
        char name = blackBag.getBagName();
        assertEquals(name,'X');
    }
}