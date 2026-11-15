package src.strategies;

import src.Decision;
import src.Strategy;
import src.StrategyType;

import java.util.List;

public class Tester implements Strategy {
    @Override
    public StrategyType getStrategyType() {
        return StrategyType.TESTER;
    }
    @Override
    public Decision decide(List<Decision> playerHistory, List<Decision> opponentHistory) {
        if (playerHistory.isEmpty()) { // the first round
            return Decision.DEFECT;
        }else if (playerHistory.size() == 1 && opponentHistory.getLast() == Decision.DEFECT) {
                Strategy newStrategy = new TitForTat();
                return newStrategy.decide(playerHistory, opponentHistory);
        }else {
            if (playerHistory.size() == 1) {
                return Decision.COOPERATE;
            }
            Decision[] lastTowMoves = {playerHistory.getLast(), playerHistory.get(playerHistory.size() - 2)};
            if (lastTowMoves[0] == Decision.COOPERATE && lastTowMoves[1] == Decision.COOPERATE) {
                return Decision.DEFECT;
            }else{
                return Decision.COOPERATE;
            }
        }
    }
}
