import java.util.Scanner;

public class MultiplyBigNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String number = sc.nextLine();
        String multiplier = sc.nextLine();
        String temp = multiply(number,multiplier);
        StringBuilder deleteZeroBuilder = new StringBuilder(temp);
        while(deleteZeroBuilder.charAt(0)=='0'){
            if(deleteZeroBuilder.length()==1){
                break;
            }
            deleteZeroBuilder.deleteCharAt(0);
        }
        String result = deleteZeroBuilder.toString();
        System.out.println(result);
    }
    public static String multiply(String num , String multiplier){
        StringBuilder sb = new StringBuilder();
        int numIndex = num.length()-1;
        int carryNum = 0;
        int multi = Integer.parseInt(multiplier);
        while(numIndex>=0 || carryNum!=0){
            int digit = numIndex < 0 ? 0 : Integer.parseInt(Character.toString(num.charAt(numIndex)));

            int result  =  (digit * multi) + carryNum;

            if(result>9){
                carryNum = result / 10;
                result = result % 10;
            }else{
                carryNum = 0;
            }
            sb.append(result);
            numIndex--;
        }
        return sb.reverse().toString();
    }
}
