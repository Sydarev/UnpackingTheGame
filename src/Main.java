import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Main {
    public static void main(String[] args) {
        //это распаковка игры (1 задание)
        var gu = new GameUnpacker();
        gu.unpack();
        //сохранение прогресса (задание 2)
        GameProgress gp1 = new GameProgress(100, 3, 80, 15.5);
        GameProgress gp2 = new GameProgress(50, 2, 15, 10.3);
        GameProgress gp3 = new GameProgress(30, 5, 120, 43.1);
        String path = "/Users/Sydarrr/Desktop/testHW/Games/savegames/saves.txt";
        File file = new File(path);
        try {
            file.createNewFile();
        } catch (IOException e) {
            System.out.println(e);
        }

        gp1.saveGame(path);

        try (ZipOutputStream zout = new ZipOutputStream(new FileOutputStream("/Users/Sydarrr/Desktop/testHW/Games/savegames/saves.zip"))){
            ZipEntry ze = new ZipEntry("saves.txt");
            zout.putNextEntry(ze);
            FileInputStream fis = new FileInputStream("/Users/Sydarrr/Desktop/testHW/Games/savegames/saves.txt");
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            zout.write(buffer);
            zout.closeEntry();
            file.delete();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
