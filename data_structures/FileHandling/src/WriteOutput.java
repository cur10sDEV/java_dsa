import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class WriteOutput {
    public static void main(String[] args) {
        try (OutputStreamWriter osw = new OutputStreamWriter(System.out)) {
            osw.write('a');
            osw.write("\n");
            osw.write("Hello World!");
            osw.write("\n");
            osw.write(98);
            osw.write("\n");
            char[] arr = "this is a char array".toCharArray();
            osw.write(arr);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        // write to file
        try (FileWriter fw = new FileWriter("resources/note.txt")) {
            // overwriting
            fw.write("This is file writer, writing to a file");
            // appending
            fw.append("\nThis is file writer, appending to a file");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        // write to file
        try (BufferedWriter bfw = new BufferedWriter(new FileWriter("resources/note.txt"))) {
            // overwriting
            bfw.write("This is buffered writer, writing to a file");
            // inserting a new line separator
            bfw.newLine();
            // appending
            bfw.append("This is buffered writer, appending to a file");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
