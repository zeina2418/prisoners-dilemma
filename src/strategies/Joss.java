package src.strategies;

import src.Decision;
import src.Strategy;
import src.StrategyType;

import java.util.Collections;
import java.util.List;

public class Joss implements Strategy {
    @Override
    public StrategyType getStrategyType() {
        return StrategyType.JOSS;
    }
    @Override
    public Decision decide(List<Decision> playerHistory, List<Decision> opponentHistory) {
        int numberOfCooperation = Collections.frequency(playerHistory, Decision.COOPERATE);
        int numberOfDefect = Collections.frequency(playerHistory, Decision.DEFECT);
        if(numberOfCooperation % 10 == 0 && numberOfCooperation > 0 && numberOfCooperation / 10 > numberOfDefect ) {
            return Decision.DEFECT;
        }
        Strategy strategy = new TitForTat();
        return strategy.decide(playerHistory, opponentHistory);
    }

    public void numberOfCandD(List<Decision> playerHistory){
        int numberOfCooperation = Collections.frequency(playerHistory, Decision.COOPERATE);
        int numberOfDefect = Collections.frequency(playerHistory, Decision.DEFECT);
        System.out.println("Cooperations: " + numberOfCooperation);
        System.out.println("Defections: " + numberOfDefect);
    }

}
