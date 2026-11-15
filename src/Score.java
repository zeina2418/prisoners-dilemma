package src;

public class Score {
    void calculateScore(Player p1, Player p2) {
        if(p1.getLastDecision() == Decision.COOPERATE && p2.getLastDecision() == Decision.COOPERATE) {
            p1.addScore(3);
            p2.addScore(3);
        } else if (p1.getLastDecision() == Decision.DEFECT && p2.getLastDecision() == Decision.DEFECT) {
            p1.addScore(2);
            p2.addScore(2);
        } else if (p1.getLastDecision() == Decision.COOPERATE && p2.getLastDecision() == Decision.DEFECT) {
            p2.addScore(5);
        }else {
            p1.addScore(5);
        }
    }

}
