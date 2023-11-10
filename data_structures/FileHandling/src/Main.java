import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        // any class that starts or ends with InputStream or OutputStream
        // deals with byte data

        // any class that starts or ends with InputReader or OutputReader
        // deals with character data

        // taking input as byte data
        try (InputStreamReader isr = new InputStreamReader(System.in);){
            System.out.print("Enter some letters: ");
            // printing output as character data
            System.out.println((char) isr.read());
            while (isr.ready()) {
                // printing output as character data
                System.out.println((char) isr.read());
            }
            // after the operation you have to close the stream
            isr.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}