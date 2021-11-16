import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)

@Suite.SuiteClasses({
        BlackBagTest.class,
        GameTest.class,
        UserTest.class,
        WhiteBagTest.class
})

public class TestSuite {
}

