package src.strategies;

import src.Decision;
import src.Strategy;

import java.util.List;

public class Random implements Strategy {
    @Override
    public Decision decide(List<Decision> playerHistory, List<Decision> opponentHistory) {
        int randomNum = (int)(Math.random() * 2); // 0 or 1
        return Decision.values()[randomNum];
    }
}
