package basic;

import java.io.File;

public class CreateDirectory {
    public static void main(String[] args) {
        String directoryPath = "path1";

        File directory = new File(directoryPath);

        if (!directory.exists()) {
            boolean result = directory.mkdir();
            if (result) {
                System.out.println("Directory created successfully");
            } else {
                System.out.println("Failed to create directory");
            }
        }

        String multiLevelDirectoryPath = "path/to/multi/level/directory";
        File multiLevelDirectory = new File(multiLevelDirectoryPath);
        if (! multiLevelDirectory.exists()){
            boolean result = multiLevelDirectory.mkdirs();
            if (result){
                System.out.println("Successfully created multi-level directory");
            } else {
                System.out.println("Failed to create multi-level directory");
            }
        }
    }
}
