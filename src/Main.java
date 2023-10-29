import java.io.*;
import java.util.ArrayList;
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
        String path = "/Users/Sydarrr/Desktop/testHW/Games/savegames";
        String fileName = "saves";
        String zipName = "saves";
        String[] saves = new String[3];

        gp1.saveGame(path, fileName+"gp1.txt");
        saves[0] = fileName+"gp1.txt";
        gp2.saveGame(path, fileName+"gp2.txt");
        saves[1] = fileName+"gp2.txt";
        gp3.saveGame(path, fileName+"gp3.txt");
        saves[2] = fileName+"gp3.txt";

        gp1.zipFile(path, saves, zipName);
        gp1.deleteFile(path, fileName+"gp1.txt");
        gp2.deleteFile(path, fileName+"gp2.txt");
        gp3.deleteFile(path, fileName+"gp3.txt");
        //распаковка прогресса (задание 3)
        gp1.unZip(path, zipName);
    }
}
