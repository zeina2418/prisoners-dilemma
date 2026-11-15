package src;

import java.util.List;

public class Player {
    private Strategy strategy; // strategy chosen by the user
    private List<Decision> decisions; // this only stores the players own moves history, because a player is only allowed to look at the opponents history thru the strategy class so a player can't automatically access his opponents history but rather both histories are presented to the strategy and it decides
    private int score;         // Player knows their own score


}
