import org.example.TestApp;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class TestBot {

    public static String run(String input) {
        Scanner sc = new Scanner(input + "\n");

        ByteArrayOutputStream out = new ByteArrayOutputStream(); // 비어있는 스트림
        System.setOut(new PrintStream(out));

        TestApp app = new TestApp();
        app.run();

        return out.toString();
    }
}
