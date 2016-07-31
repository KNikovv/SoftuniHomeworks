package P03_DependencyInversion;


import P03_DependencyInversion.strategies.AdditionStrategy;
import P03_DependencyInversion.strategies.Calculator;
import P03_DependencyInversion.strategies.Strategy;

public class PrimitiveCalculator implements Calculator {

    private Strategy currentStrategy;

    public PrimitiveCalculator() {
        this.currentStrategy = new AdditionStrategy();
    }

    public void changeStrategy(Strategy strategy) {
        this.currentStrategy = strategy;
    }

    public int performCalculation(int firstOperand, int secondOperand) {
        return this.currentStrategy.calculate(firstOperand, secondOperand);
    }
}
