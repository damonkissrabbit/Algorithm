import java.io.File;

public class fileTraversal {
    public static void main(String[] args) {
        File directory = new File("C:\\Users\\star\\Desktop\\java_demo");
        traverseDirectory(directory);
    }

    public static void traverseDirectory(File directory) {
        if (directory.isDirectory()) {
            File[] files = directory.listFiles();
            assert files != null;
            for (File file : files) {
                if (file.isDirectory()) {
                    traverseDirectory(file);
                } else {
                    System.out.println(file.getAbsoluteFile());
                }
            }
        }
    }
}
