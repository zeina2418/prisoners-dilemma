package src;

import java.util.List;

public interface Strategy {
    Decision decide(
            List<Decision> playerHistory,
            List<Decision> opponentHistory
    );
}
