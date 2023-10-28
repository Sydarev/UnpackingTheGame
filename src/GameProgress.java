import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class GameProgress implements Serializable {
    private static final long serialVersionUID = 1L;

    private int health;
    private int weapons;
    private int lvl;
    private double distance;

    public GameProgress(int health, int weapons, int lvl, double distance) {
        this.health = health;
        this.weapons = weapons;
        this.lvl = lvl;
        this.distance = distance;
    }

    public void createFile(String path, String name) {
        File file = new File(path + "/" + name);
        try {
            file.createNewFile();
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public void saveGame(String path, String name) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path + "/" + name))) {
            oos.writeObject(this);
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public void zipFile(String path, String fileName, String zipName) {
        try (ZipOutputStream zout = new ZipOutputStream(new FileOutputStream(path + "/" + zipName+".zip"))) {
            ZipEntry ze = new ZipEntry(fileName);
            zout.putNextEntry(ze);
            FileInputStream fis = new FileInputStream(path + "/" + fileName);
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            zout.write(buffer);
            zout.closeEntry();
        } catch (FileNotFoundException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public void unZip(String path, String name) {
        try (ZipInputStream zis = new ZipInputStream(new FileInputStream(path + "/" + name + ".zip"))) {
            ZipEntry entry;
            while ((entry = zis.getNextEntry()) != null) {
                FileOutputStream fout = new FileOutputStream(path+"/"+entry.getName());
                for (int c = zis.read(); c != -1; c = zis.read()) {
                    fout.write(c);
                }
                openProgress(path+"/"+entry.getName());
                fout.flush();
                zis.closeEntry();
                fout.close();
            }
        } catch (FileNotFoundException e) {
            System.out.println(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void openProgress(String path) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path))) {
            GameProgress gp = (GameProgress) ois.readObject();
            System.out.println(gp);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteFile(String path, String name) {
        File file = new File(path + "/" + name);
        file.delete();
    }


    @Override
    public String toString() {
        return "GameProgress{" +
                "health=" + health +
                ", weapons=" + weapons +
                ", lvl=" + lvl +
                ", distance=" + distance +
                '}';
    }
}
