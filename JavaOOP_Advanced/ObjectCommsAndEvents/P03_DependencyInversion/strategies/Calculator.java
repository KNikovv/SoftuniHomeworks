package P03_DependencyInversion.strategies;

public interface Calculator {

    int performCalculation(int firstOperand, int secondOperand);

    void changeStrategy(Strategy strategy);
}
