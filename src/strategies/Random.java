package src.strategies;

import src.Decision;
import src.Strategy;
import src.StrategyType;

import java.util.List;


public class Random implements Strategy {

    private final java.util.Random random = new java.util.Random(42); // Fixing Random Seed for reproducible results

    @Override
    public StrategyType getStrategyType() {
        return StrategyType.RANDOM;
    }

    @Override
    public Decision decide(List<Decision> playerHistory,
                           List<Decision> opponentHistory) {

        int randomNum = random.nextInt(2);
        return Decision.values()[randomNum];
    }
}
