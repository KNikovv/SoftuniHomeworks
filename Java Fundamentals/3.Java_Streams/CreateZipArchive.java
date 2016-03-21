import java.io.*;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Created by kaloy on 3/2/2016.
 */
public class CreateZipArchive {
    public static void main(String[] args) {


        final File zipArchive = new File("resources/textfiles.zip");

        String[] files = {"resources/words.txt", "resources/sumlines.txt", "resources/countchars.txt"};
        try (ZipOutputStream out = new ZipOutputStream(new FileOutputStream(zipArchive))) {
            byte[] buffer = new byte[1024];
            for (int i = 0; i < files.length; i++) {
                File currentFile = new File(files[i]);
                FileInputStream fis = new FileInputStream(currentFile);
                out.putNextEntry(new ZipEntry(currentFile.getName()));
                int j;
                while ((j = fis.read(buffer)) != -1) {
                    out.write(buffer, 0, j);
                }
                fis.close();
            }
        } catch (FileNotFoundException ex) {

        } catch (IOException ex) {

        }
    }
}