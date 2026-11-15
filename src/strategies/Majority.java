package src.strategies;

import src.Decision;
import src.Strategy;
import src.StrategyType;

import java.util.Collections;
import java.util.List;

public class Majority implements Strategy {
    @Override
    public StrategyType getStrategyType() {
        return StrategyType.MAJORITY;
    }
    @Override
    public Decision decide(List<Decision> playerHistory,
                           List<Decision> opponentHistory) {

        int cooperations = Collections.frequency(
                opponentHistory, Decision.COOPERATE
        );

        int defections = Collections.frequency(
                opponentHistory, Decision.DEFECT
        );

        return cooperations >= defections ? Decision.COOPERATE : Decision.DEFECT;
    }
}
