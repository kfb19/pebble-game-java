import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.lang.reflect.Field;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import static org.junit.Assert.*;


public class GameTest {

    private Game game;

    @Before
    public void setUp() {
        game = new Game();
    }

    @Test
    public void generateBlack() throws NoSuchFieldException, IllegalAccessException, IOException {

        Writer file = null;
        try {
            file = new FileWriter(System.getProperty("user.dir") +
                    "\\src\\testfile.txt", false);
        } catch (IOException e) {
            e.printStackTrace();
        }

        file.write("1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16");
        file.close();

        InputStream stdin = System.in;
        System.setIn(new ByteArrayInputStream("testfile.txt".getBytes()));


        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(byteArrayOutputStream);
        PrintStream stdout = System.out;
        System.setOut(ps);

        game.generateBlack(1,'X');

        System.setIn(stdin);
        System.setOut(stdout);

        Field field;
        field = game.getClass().getDeclaredField("blackBags");
        field.setAccessible(true);
        ArrayList<BlackBag> blackBags = (ArrayList<BlackBag>) field.get(game);
        assertTrue(blackBags.size() == 1);

    }

    @Test
    public void generateBlackNotExist() throws NoSuchFieldException, IllegalAccessException, IOException {

        Writer file = null;
        try {
            file = new FileWriter(System.getProperty("user.dir") +
                    "\\src\\testfile.txt", false);
        } catch (IOException e) {
            e.printStackTrace();
        }

        file.write("1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16");
        file.close();

        InputStream stdin = System.in;
        System.setIn(new ByteArrayInputStream("jsadjka.txt".getBytes()));
        System.setIn(new ByteArrayInputStream("testfile.txt".getBytes()));


        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(byteArrayOutputStream);
        PrintStream stdout = System.out;
        System.setOut(ps);

        game.generateBlack(1,'X');

        System.setIn(stdin);
        System.setOut(stdout);

        Field field;
        field = game.getClass().getDeclaredField("blackBags");
        field.setAccessible(true);
        ArrayList<BlackBag> blackBags = (ArrayList<BlackBag>) field.get(game);
        assertTrue(blackBags.size() == 1);

    }


    @Test
    public void generateBlackStringInFile() throws NoSuchFieldException, IllegalAccessException, IOException {

        Writer file1 = null;
        Writer file2 = null;
        try {
            file1 = new FileWriter(System.getProperty("user.dir") +
                    "\\src\\testFileWrongFormat.txt", false);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            file2 = new FileWriter(System.getProperty("user.dir") +
                    "\\src\\testfile.txt", false);
        } catch (IOException e) {
            e.printStackTrace();
        }

        file1.write("1,2,3,4,5,6,7,fgf,5,7,5");
        file2.close();
        file1.close();

        InputStream stdin = System.in;
        System.setIn(new ByteArrayInputStream("testFileWrongFormat.txt".getBytes()));
        System.setIn(new ByteArrayInputStream("testfile.txt".getBytes()));


        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(byteArrayOutputStream);
        PrintStream stdout = System.out;
        System.setOut(ps);

        game.generateBlack(1,'X');

        System.setIn(stdin);
        System.setOut(stdout);

        Field field;
        field = game.getClass().getDeclaredField("blackBags");
        field.setAccessible(true);
        ArrayList<BlackBag> blackBags = (ArrayList<BlackBag>) field.get(game);
        assertTrue(blackBags.size() == 1);

    }

    @Test
    public void generateBlackNegativeWeight() throws NoSuchFieldException, IllegalAccessException, IOException {

        Writer file1 = null;
        Writer file2 = null;
        try {
            file1 = new FileWriter(System.getProperty("user.dir") +
                    "\\src\\testFileWrongFormat.txt", false);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            file2 = new FileWriter(System.getProperty("user.dir") +
                    "\\src\\testfile.txt", false);
        } catch (IOException e) {
            e.printStackTrace();
        }

        file1.write("1,2,3,4,5,6,7,-2,5,7,5");
        file2.close();
        file1.close();

        InputStream stdin = System.in;
        System.setIn(new ByteArrayInputStream("testFileWrongFormat.txt".getBytes()));
        System.setIn(new ByteArrayInputStream("testfile.txt".getBytes()));


        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(byteArrayOutputStream);
        PrintStream stdout = System.out;
        System.setOut(ps);

        game.generateBlack(1,'X');

        System.setIn(stdin);
        System.setOut(stdout);

        Field field;
        field = game.getClass().getDeclaredField("blackBags");
        field.setAccessible(true);
        ArrayList<BlackBag> blackBags = (ArrayList<BlackBag>) field.get(game);
        assertTrue(blackBags.size() == 1);

    }
    @Test
    public void generateBlackNotEnoughPebbles() throws NoSuchFieldException, IllegalAccessException, IOException {

        game.setNoUsers(2);
        Writer file = null;
        try {
            file = new FileWriter(System.getProperty("user.dir") +
                    "\\src\\testfile.txt", false);
        } catch (IOException e) {
            e.printStackTrace();
        }


        file.write("1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16");

        InputStream stdin = System.in;
        System.setIn(new ByteArrayInputStream("testfile.txt".getBytes()));
        file.write(",17,18,19,20,21,22");
        file.close();
        System.setIn(new ByteArrayInputStream("testfile.txt".getBytes()));


        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(byteArrayOutputStream);
        PrintStream stdout = System.out;
        System.setOut(ps);

        game.generateBlack(1,'X');

        System.setIn(stdin);
        System.setOut(stdout);

        Field field;
        field = game.getClass().getDeclaredField("blackBags");
        field.setAccessible(true);
        ArrayList<BlackBag> blackBags = (ArrayList<BlackBag>) field.get(game);
        assertTrue(blackBags.size() == 1);

    }



   @Test
    public void printMenu() {
       InputStream stdin = System.in;
       System.setIn(new ByteArrayInputStream("1".getBytes()));

       ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
       PrintStream ps = new PrintStream(byteArrayOutputStream);
       PrintStream stdout = System.out;
       System.setOut(ps);

       int result = game.printMenu();

       System.setIn(stdin);
       System.setOut(stdout);

       assertEquals(1,result);


    }

    @Test
    public void printMenuNegative() {
        InputStream stdin = System.in;
        System.setIn(new ByteArrayInputStream("-1".getBytes()));
        System.setIn(new ByteArrayInputStream("1".getBytes()));

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(byteArrayOutputStream);
        PrintStream stdout = System.out;
        System.setOut(ps);

        int result = game.printMenu();

        System.setIn(stdin);
        System.setOut(stdout);

        assertEquals(1,result);

    }

    @Test
    public void printMenuEdgeCase() {
        InputStream stdin = System.in;
        System.setIn(new ByteArrayInputStream("0".getBytes()));
        System.setIn(new ByteArrayInputStream("1".getBytes()));

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(byteArrayOutputStream);
        PrintStream stdout = System.out;
        System.setOut(ps);

        int result = game.printMenu();

        System.setIn(stdin);
        System.setOut(stdout);

        assertEquals(1,result);

    }

    @Test
    public void printMenuTestLetter() {
        InputStream stdin = System.in;
        System.setIn(new ByteArrayInputStream("H".getBytes()));
        System.setIn(new ByteArrayInputStream("1".getBytes()));

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(byteArrayOutputStream);
        PrintStream stdout = System.out;
        System.setOut(ps);

        int result = game.printMenu();

        System.setIn(stdin);
        System.setOut(stdout);

        assertEquals(1,result);

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

    @After
    public void deleteFiles() throws IOException {

        Files.deleteIfExists(Path.of(System.getProperty("user.dir") +
                "\\src\\testfile.txt"));
        Files.deleteIfExists(Path.of(System.getProperty("user.dir") +
                "\\src\\testFileWrongFormat.txt"));
    }
}