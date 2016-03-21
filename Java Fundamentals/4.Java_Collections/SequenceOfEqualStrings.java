import java.util.Scanner;

/**
 * Created by kaloy on 3/7/2016.
 */
public class SequenceOfEqualStrings {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String [] strArray = sc.nextLine().split(" ");
        EqualString(strArray);
    }
    public static void EqualString(String[] strArray){
        for(int i=0;i<strArray.length;i++){
            if(i==0 && strArray.length==1){
                System.out.println(strArray[i]);
                break;
            }
            else if(i==strArray.length -1){
                if(strArray[i].equals(strArray[i-1])){
                    System.out.print(strArray[i]);
                }else{
                    System.out.println(strArray[i]);
                }
                break;
            }
            if(strArray[i].equals(strArray[i+1])){
                System.out.print(strArray[i]+ " ");
            }else{
                System.out.print(strArray[i]);
                System.out.println();
            }
        }
    }
}