package src.strategies;

import src.Decision;
import src.Strategy;
import src.StrategyType;

import java.util.List;

public class AlwaysDefect implements Strategy {
    @Override
    public StrategyType getStrategyType() {
        return StrategyType.ALL_D;
    }
    @Override
    public Decision decide(List<Decision> playerHistory, List<Decision> opponentHistory) {
        return Decision.DEFECT;
    }
}
