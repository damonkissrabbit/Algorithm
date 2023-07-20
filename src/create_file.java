import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class create_file {
    public static void main(String[] args) throws IOException {
        try {
            File file = new File("a.txt");
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write("hello world");
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
