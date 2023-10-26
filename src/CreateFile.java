import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CreateFile {
    private String path;
    private StringBuilder sb = new StringBuilder();

    public CreateFile(String path) {
        this.path = path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void createFolder() {
        File file = new File(path);
        if (file.mkdir()) sb.append("the folder " + path + " was created \n");
        else sb.append("Error creating folder " + path + "\n");
    }

    public void createFile(String name) {
        File file = new File(path + "/" + name);
        try {
            if (file.createNewFile()) sb.append("the file " + name + " was created \n");
        } catch (IOException e) {
            System.out.println("Error creating file " + name + "\n");
        }
    }

    public void end() {
        path = "/Users/Sydarrr/Desktop/testHW/Games/temp/temp.txt";
        try (FileWriter fw = new FileWriter(path)) {
            fw.write(sb.toString());
            System.out.println("Для просмотра информации о создании о создании файлов: " + path);
        } catch (IOException e) {
            System.out.println();
        }

    }
}

