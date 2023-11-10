import java.io.*;

public class FileOperations {
    public static void main(String[] args) {
        // create
        try {
            File fo = new File("resources/newFile.txt");
            fo.createNewFile();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        // write
        try (FileWriter fr = new FileWriter("resources/newFile.txt")) {
            fr.write("This is File Operations performing write operation");
            fr.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        // read
        try (BufferedReader bfr = new BufferedReader(new FileReader("resources/newFile.txt"))) {
            System.out.println(bfr.readLine());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        // create - delete
        try {
            File fo = new File("resources/random.txt");
            fo.createNewFile();
            fo.delete();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
