package src.strategies;

import src.Decision;
import src.Strategy;
import src.StrategyType;

import java.util.List;

public class TitForTat implements Strategy {
    @Override
    public StrategyType getStrategyType() {
        return StrategyType.TIT_FOR_TAT;
    }
    @Override
    public Decision decide(List<Decision> playerHistory, List<Decision> opponentHistory) {
        if (opponentHistory.isEmpty()) { // the first round
            return Decision.COOPERATE;
        }
        return opponentHistory.get(opponentHistory.size() - 1); // return the last move played by the opponent
    }
}
