import java.io.FileReader;
import java.io.IOException;

public class ReadFile {
    public static void main(String[] args) {
        try (FileReader fr = new FileReader("resources/note.txt")) {
            System.out.println((char) fr.read());
            while (fr.ready()) {
                System.out.println((char) fr.read());
            }
            System.out.println();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
