package src;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AxelrodTournament {

    void generateAxelrodTournament(List<Strategy> strategies, int numberOfRounds) {
        Map<StrategyType, Integer> tournamentScores = new HashMap<>();

        for (Strategy strategy : strategies) {
            tournamentScores.put(strategy.getStrategyType(), 0);
        }

        List<Map<StrategyType, Integer>> detailedScore = new ArrayList<>();

        for (int i = 0; i < strategies.size(); i++) {
            for (int j = i + 1; j < strategies.size(); j++) {
                Player player1 = new Player(strategies.get(i));
                Player player2 = new Player(strategies.get(j));
                // strategies.get(i) vs strategies.get(j)
                Game tournament = new Game(player1, player2, numberOfRounds, 0.0f);
                tournament.play();
                Map<StrategyType, Integer> gameScores = tournament.getScore();
                for (StrategyType strategy : gameScores.keySet()) {
                    tournamentScores.merge(strategy, gameScores.get(strategy), Integer::sum);
                }
                detailedScore.add(new HashMap<>(gameScores));
            }
        }
            System.out.println("-------------------FINAL SCORE : ------------------");
            for (Map<StrategyType, Integer> match : detailedScore) {
                System.out.println(match);
            }
            tournamentScores.entrySet() // printing the tournament score sorted
                    .stream()
                    .sorted(Map.Entry.<StrategyType, Integer>comparingByValue().reversed())
                    .forEach(entry ->
                            System.out.println(entry.getKey() + " : " + entry.getValue())
                    );
        }
}
