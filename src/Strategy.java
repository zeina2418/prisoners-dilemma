package src;

import java.util.List;

public interface Strategy {
    StrategyType getStrategyType();
    Decision decide(
            List<Decision> playerHistory,
            List<Decision> opponentHistory
    );
}
