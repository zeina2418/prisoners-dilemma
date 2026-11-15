package src;

import src.strategies.*;


import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Strategy> strategies = List.of(new Joss(), new Tester(), new TitForTat(), new AlwaysDefect(), new Random(), new Majority(), new AlwaysCooperate());
        AxelrodTournament tournament = new AxelrodTournament();
        tournament.generateAxelrodTournament(strategies, 200);

        // player vs player
        /*Player p1 = new Player(new TitForTat());
        Player p2 = new Player(new Joss());

        Game game = new Game(p1, p2, 200);

        game.play();

        if (p1.getScore() > p2.getScore()) {
            System.out.println(p1.getStrategy().getStrategyType() + " wins!");
        } else if (p2.getScore() > p1.getScore()) {
            System.out.println(p2.getStrategy().getStrategyType() + " wins!");
        } else {
            System.out.println("It's a tie!");
        }*/


        // count the number of JOSS DEFECT to ensure we have a 1 DEFECT out of 10 COOPERATE
        /*Joss joss = (Joss) p2.getStrategy();
        joss.numberOfCandD(p2.getDecisions());*/

    }
}