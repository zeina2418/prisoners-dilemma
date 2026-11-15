package src;

import src.strategies.Joss;
import src.strategies.TitForTat;
import src.strategies.AlwaysDefect;

public class Main {

    public static void main(String[] args) {

        Player p1 = new Player(new TitForTat());
        Player p2 = new Player(new Joss());

        Game game = new Game(p1, p2, 200);

        game.play();

        if (p1.getScore() > p2.getScore()) {
            System.out.println(p1.getStrategy().getStrategyType() + " wins!");
        } else if (p2.getScore() > p1.getScore()) {
            System.out.println(p2.getStrategy().getStrategyType() + " wins!");
        } else {
            System.out.println("It's a tie!");
        }
        Joss joss = (Joss) p2.getStrategy();
        joss.numberOfCandD(p2.getDecisions());


    }
}