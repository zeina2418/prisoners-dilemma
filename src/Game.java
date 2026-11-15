package src;


import java.util.HashMap;
import java.util.Map;
import java.util.Random;

// a game is a tournament between two players that keeps track of the players decisions
public class Game {
    private final Player player1;
    private final Player player2;
    private final Map<StrategyType, Integer> score;
    private final int numberOfRounds;
    private final Random random = new Random(); // java instance Random for adding noise
    private final float noise;
    private final float continuationProbability;

    public Game(Player player1, Player player2, int numberOfRounds, float noise, float continuationProbability) {
        this.player1 = player1;
        this.player2 = player2;
        this.score = new HashMap<>();
        this.numberOfRounds = numberOfRounds;
        this.noise = noise;
        this.continuationProbability = continuationProbability;
    }

    // Applies a probability of inversion to a player's decision
    private Decision applyNoise(Decision decision) {
        if (random.nextDouble() < this.noise) {
            return decision == Decision.COOPERATE ? Decision.DEFECT : Decision.COOPERATE;
        }
        return decision;
    }

    void play() {
        Score score = new Score();
        for (int i = 0; i < numberOfRounds; i++) {

            Decision d1 = player1.getStrategy().decide(
                    player1.getDecisions(),
                    player2.getDecisions()
            );

            Decision d2 = player2.getStrategy().decide(
                    player2.getDecisions(),
                    player1.getDecisions()
            );

            // application du bruit
            Decision finalDecision1 = applyNoise(d1);
            Decision finalDecision2 = applyNoise(d2);

            player1.addDecision(finalDecision1);
            player2.addDecision(finalDecision2);

            score.calculateScore(player1, player2);
            System.out.println("Round " + (i + 1));
            System.out.println(player1.getStrategy().getStrategyType() + " : " + finalDecision1);
            System.out.println(player2.getStrategy().getStrategyType() + " : " + finalDecision2);
            System.out.println("Score: " + player1.getScore() + " - " + player2.getScore());
            System.out.println("--------------------");
            if (random.nextDouble() >= continuationProbability) {
                break;
            }
        }
        this.score.put(player1.getStrategy().getStrategyType(), player1.getScore());
        this.score.put(player2.getStrategy().getStrategyType(), player2.getScore());

        System.out.println("FINAL RESULTS");
        System.out.println(player1.getStrategy().getStrategyType() + " : " + player1.getScore());
        System.out.println(player2.getStrategy().getStrategyType() + " : " + player2.getScore());
        System.out.println("SCORE : " + this.score);
    }

    Map<StrategyType, Integer> getScore() {
        return score;
    }
}
