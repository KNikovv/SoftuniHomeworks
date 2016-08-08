package wasteDisposal.strategies;

import wasteDisposal.annotations.Burnable;
import wasteDisposal.annotations.Recyclable;
import wasteDisposal.annotations.Storable;
import wasteDisposal.contracts.GarbageDisposalStrategy;
import wasteDisposal.contracts.StrategyHolder;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class DefaultStrategyHolder implements StrategyHolder {

    private LinkedHashMap<Class, GarbageDisposalStrategy> strategies;

    public DefaultStrategyHolder() {
        this.initStrategies();
    }

    @Override
    public Map<Class, GarbageDisposalStrategy> getDisposalStrategies() {

        return Collections.unmodifiableMap(this.strategies);
    }

    @Override
    public boolean addStrategy(Class annotationClass, GarbageDisposalStrategy strategy) {

        this.strategies.put(annotationClass, strategy);
        return true;
    }

    @Override
    public boolean removeStrategy(Class annotationClass) {

        this.strategies.remove(annotationClass);
        return true;
    }

    private void initStrategies() {
        this.strategies = new LinkedHashMap<>();
        this.addStrategy(Burnable.class, new BurnableGarbageDisposalStrategy());
        this.addStrategy(Recyclable.class, new RecyclableGarbageDisposalStrategy());
        this.addStrategy(Storable.class, new StorableGarbageDisposalStrategy());
    }
}
