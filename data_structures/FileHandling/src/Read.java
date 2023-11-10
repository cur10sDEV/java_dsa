import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Read {
    public static void main(String[] args) {
        try {
            // byte to char stream and then reading char stream
            BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
            System.out.println(bfr.readLine());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        // read file
        try {
            // byte to char stream and then reading char stream
            BufferedReader bfr = new BufferedReader(new FileReader("resources/note.txt"));
            System.out.println(bfr.readLine());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}
