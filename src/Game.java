package src;


// a game is a tournament between two players that keeps track of the players decisions
public class Game {
    private final Player player1;
    private final Player player2;
    private final Score score;
    private final int numberOfRounds;

    public Game(Player player1, Player player2, int numberOfRounds) {
        this.player1 = player1;
        this.player2 = player2;
        this.score = new Score();
        this.numberOfRounds = numberOfRounds;
    }

    void play() {
        for (int i = 0; i < numberOfRounds; i++) {

            Decision d1 = player1.getStrategy().decide(
                    player1.getDecisions(),
                    player2.getDecisions()
            );

            Decision d2 = player2.getStrategy().decide(
                    player2.getDecisions(),
                    player1.getDecisions()
            );

            player1.addDecision(d1);
            player2.addDecision(d2);

            score.calculateScore(player1, player2);
            System.out.println("Round " + (i + 1));
            System.out.println(player1.getStrategy().getStrategyType() + " : " + d1);
            System.out.println(player2.getStrategy().getStrategyType() + " : " + d2);
            System.out.println("Score: " + player1.getScore() + " - " + player2.getScore());
            System.out.println("--------------------");
        }
        System.out.println("FINAL RESULTS");
        System.out.println(player1.getStrategy().getStrategyType() + " : " + player1.getScore());
        System.out.println(player2.getStrategy().getStrategyType() + " : " + player2.getScore());
    }
}
