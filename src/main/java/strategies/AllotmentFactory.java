package strategies;

import models.AllotmentStrategyType;

public class AllotmentFactory {
    public static AllotmentStrategy getStrategyForType(AllotmentStrategyType type){
        return new RandomAllotmentStrategy(); //todo add if else for all types

    }
}
