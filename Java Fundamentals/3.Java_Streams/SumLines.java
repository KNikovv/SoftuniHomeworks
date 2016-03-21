import java.io.*;

public class SumLines {

    public static void main(String[] args) {
        File file = new File("resources/sumlines.txt");
        try(BufferedReader reader= new BufferedReader(new FileReader(file))){
            String input = reader.readLine();
            while(input!=null){
                int sum =0;
                for(int i=0;i<input.length();i++){
                    sum += input.charAt(i);
                }
                System.out.println(sum);
                input = reader.readLine();
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
