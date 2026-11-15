package src;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private Strategy strategy; // strategy chosen by the user
    private List<Decision> decisions = new ArrayList<>(); // this only stores the players own moves history, because a player is only allowed to look at the opponents history through the strategy class so a player can't automatically access his opponents history but rather both histories are presented to the strategy and it decides
    private int score = 0;         // Player knows their own score


    public Player(Strategy strategy) {
        this.strategy = strategy;
    }

    Decision getLastDecision() {
        return decisions.getLast();
    }
    void addScore(int score) {
        this.score += score;
    }
    int getScore() {
        return score;
    }

    public List<Decision> getDecisions() {
        return decisions;
    }

    public void addDecision(Decision decision) {
        decisions.add(decision);
    }

    public Strategy getStrategy() {
        return strategy;
    }
}
