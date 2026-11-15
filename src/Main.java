package src;

import src.strategies.TitForTat;
import src.strategies.AlwaysDefect;

public class Main {

    public static void main(String[] args) {

        Player p1 = new Player(new TitForTat());
        Player p2 = new Player(new AlwaysDefect());

        Game game = new Game(p1, p2, 200);

        game.play();

        if (p1.getScore() > p2.getScore()) {
            System.out.println("Player 1 wins!");
        } else if (p2.getScore() > p1.getScore()) {
            System.out.println("Player 2 wins!");
        } else {
            System.out.println("It's a tie!");
        }
    }
}