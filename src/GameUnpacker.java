public class GameUnpacker {
    public void unpack() {
        String path = "/Users/Sydarrr/Desktop/testHW/Games";
        CreateFile createFile = new CreateFile(path);
        createFile.createFolder();
        createFile.setPath(path + "/src");
        createFile.createFolder();
        createFile.setPath(path + "/res");
        createFile.createFolder();
        createFile.setPath(path + "/res/drawables");
        createFile.createFolder();
        createFile.setPath(path + "/res/vectors");
        createFile.createFolder();
        createFile.setPath(path + "/res/icons");
        createFile.createFolder();
        createFile.setPath(path + "/savegames");
        createFile.createFolder();
        createFile.setPath(path + "/src/test");
        createFile.createFolder();
        createFile.setPath(path + "/src/main");
        createFile.createFolder();
        createFile.createFile("Main.java");
        createFile.createFile("Utils.java");
        createFile.setPath(path + "/temp");
        createFile.createFolder();
        createFile.createFile("temp.txt");
        createFile.end();
    }
}
