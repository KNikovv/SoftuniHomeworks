package wasteDisposal.core;

import wasteDisposal.contracts.*;
import wasteDisposal.strategies.DefaultStrategyHolder;
import wasteDisposal.utilities.Constants;
import wasteDisposal.utilities.Messages;

import java.lang.annotation.Annotation;

public class DefaultGarbageProcessor implements GarbageProcessor {

    private StrategyHolder strategyHolder;

    public DefaultGarbageProcessor(StrategyHolder strategyHolder) {
        this.setStrategyHolder(strategyHolder);
    }

    public DefaultGarbageProcessor() {
        this(new DefaultStrategyHolder());
    }

    private void setStrategyHolder(StrategyHolder strategyHolder) {
        this.strategyHolder = strategyHolder;
    }

    @Override
    public StrategyHolder getStrategyHolder() {
        return this.strategyHolder;
    }

    @Override
    public ProcessingData processWaste(Waste garbage) {
        if(garbage == null) {
            throw new NullPointerException();
        }
        Class type = garbage.getClass();
        Annotation[] garbageAnnotations = type.getAnnotations();
        Class disposableAnnotation = garbageAnnotations[Constants.ANNOTATION_INDEX].annotationType();

        GarbageDisposalStrategy currentStrategy;
        if (disposableAnnotation == null ||
                !this.getStrategyHolder().getDisposalStrategies().containsKey(disposableAnnotation)) {
            throw new IllegalArgumentException(
                    Messages.FAILED_TO_GET_STRATEGY);
        }

        currentStrategy = this.getStrategyHolder().getDisposalStrategies().get(disposableAnnotation);
        return currentStrategy.processGarbage(garbage);
    }
}
