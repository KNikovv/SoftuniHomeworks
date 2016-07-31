package P03_DependencyInversion.strategies;

public class AdditionStrategy implements Strategy {

    public int calculate(int firstOperand, int secondOperand){
        return firstOperand + secondOperand;
    }
}
