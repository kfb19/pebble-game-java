import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class WhiteBagTest {

    private File file;
    private WhiteBag whiteBag;
    private BlackBag blackBag;


    @Before
    public void setUp() throws FileNotFoundException {
        file = new File(System.getProperty("user.dir")+ "\\tests\\testFileBlackBag.txt");
        blackBag = new BlackBag(file,'X');
        whiteBag = new WhiteBag(blackBag,'A');
    }

    @Test
    public void switchBags() {


    }

    @Test
    public void addPebble() throws NoSuchFieldException, IllegalAccessException {
        whiteBag.addPebble(7);

        Field field;
        field = whiteBag.getClass().getDeclaredField("contents");
        field.setAccessible(true);

        ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(7));

        assertEquals(expected,field.get(whiteBag));
    }

    @Test
    public void getContentsEmpty() throws FileNotFoundException, NoSuchFieldException {
        Field field = whiteBag.getClass().getDeclaredField("contents");
        field.setAccessible(true);

        file = new File(System.getProperty("user.dir")+ "\\tests\\testFileBlackEmpty.txt");
        blackBag = new BlackBag(file,'X');
        whiteBag = new WhiteBag(blackBag,'A');

        List<Integer> result = blackBag.getContents();

        assertEquals("field wasn't retrieved properly", result, new ArrayList<>(Arrays.asList()));
    }

    @Test
    public void getContentsAfterSwitch(){

    }

    @Test
    public void getBagName() throws FileNotFoundException {
        char name = whiteBag.getBagName();
        assertEquals(name,'A');


    }
}