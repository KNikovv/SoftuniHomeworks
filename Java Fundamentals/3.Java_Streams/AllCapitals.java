import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kaloy on 3/1/2016.
 */
public class AllCapitals {
    public static void main(String[] args) {
        File file = new File("resources/allcapitals.txt");
        try(BufferedReader reader= new BufferedReader(new FileReader(file))){
            FileWriter fw = new FileWriter(file,true);
            PrintWriter pw = new PrintWriter(fw,true);
            String line = reader.readLine();
            List<String> stringList = new ArrayList<>();
            while (line != null){
                String upper = line.toUpperCase();
                stringList.add(upper);
                line = reader.readLine();
            }
           try( FileOutputStream writer = new FileOutputStream(file)){

                writer.write((new String()).getBytes());
                writer.close();}
            catch(FileNotFoundException ex){
                System.out.println("error");
            }catch(IOException eex){
                System.out.println("error");
            }
            for (String upper:stringList) {
                pw.println(upper);
            }
        }
        catch(FileNotFoundException ex){
            System.out.println("error");
        }
        catch(IOException ex){
            System.out.println("error");
        }
    }
}
