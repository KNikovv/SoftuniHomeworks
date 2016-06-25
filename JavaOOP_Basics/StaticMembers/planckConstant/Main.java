package planckConstant;

public class Main {

    public static void main(String[] args) {
        System.out.println(Calculation.returnValue());
    }

}

 class Calculation {

    private static final double PLANCK_CONSTANT = 6.62606896e-34;
    private  static final double PI = 3.14159;

    public static double returnValue(){
        double result = PLANCK_CONSTANT / (2* PI);
        return result;
    }
}
