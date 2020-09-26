package webinar1_tasks.bye;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;

public class ByeUniverse {


    public static void main(String[] args) throws IOException {
        System.out.println("I did it!");
        String[] str = {"i", "did", "it"};
        OutputStream os = new OutputStream() {
            @Override
            public void write(int b) throws IOException {

            }
        };
        PrintStream ps = new PrintStream(os);
        System.setOut(ps);
        HelloWorld.main(str);
        ps.close();
        os.close();
    }
}
