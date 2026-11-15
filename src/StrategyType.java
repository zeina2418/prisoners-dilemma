package src;

public enum StrategyType {
    TIT_FOR_TAT,
    JOSS,
    RANDOM,
    ALL_D,
    ALL_C,   // Always Cooperate
    MAJORITY, // Cooperate if the opponent has cooperated more often than they've defected; otherwise, defect
    TESTER
}
