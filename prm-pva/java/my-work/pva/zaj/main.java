import java.io.File;
public class main {
    public static void main(String[] args) {
        File file = new File("example.txt");
        if (file.exists()) {
            System.out.println("File exists.");
        } else {
            System.out.println("File does not exist.");
        }

        // Check if the file is a directory
        if (file.isDirectory()) {
            System.out.println("File is a directory.");
        } else {
            System.out.println("File is not a directory.");
        }
        // Check if the file is readable
        if (file.canRead()) {
            System.out.println("File is readable.");
        } else {
            System.out.println("File is not readable.");
        }
        // Create a new file
        try {
            File newFile = new File("newFile.txt");
            if (newFile.createNewFile()) {
                System.out.println("New file created: " + newFile.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
