package basicMath;

public class MathUtil {

    public static double sum(double value1, double value2){
        return value1+value2;
    }
    public static double multiply(double value1,double value2){
        return value1*value2;
    }
    public static double divide(double value1,double value2){
        return value1/value2;
    }
    public static double subtract(double value1,double value2){
        return value1-value2;
    }
    public static double percentage(double number, double percentage){
        return ((percentage/100)* number);
    }
}
