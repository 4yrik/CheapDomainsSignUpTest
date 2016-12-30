import org.junit.runner.JUnitCore;
import tests.TestClass;

public class Main {
    public static void main(String[] args) {
        JUnitCore runner = new JUnitCore();
        runner.run(TestClass.class);
    }
}
