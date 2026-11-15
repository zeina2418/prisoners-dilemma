
package src;

import src.strategies.*;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        if (args.length == 0) {
            printUsage();
            return;
        }

        String mode = args[0].toLowerCase();

        float noise = 0;
        float continuation = 1;
        int rounds = 200;

        List<Strategy> baseline = List.of(
                new AlwaysDefect(),
                new Random(),
                new TitForTat(),
                new Tester(),
                new Joss()
        );

        List<Strategy> extended = List.of(
                new AlwaysDefect(),
                new Random(),
                new TitForTat(),
                new Tester(),
                new Joss(),
                new Majority(),
                new AlwaysCooperate()
        );

        List<Strategy> strategies;

        try {
            switch (mode) {

                case "baseline":
                    strategies = baseline;
                    break;

                case "extended":
                    strategies = extended;
                    break;

                case "noise":
                    if (args.length < 2) {
                        printUsage();
                        return;
                    }
                    noise = Float.parseFloat(args[1]);
                    strategies = extended;
                    break;

                case "horizon":
                    if (args.length < 2) {
                        printUsage();
                        return;
                    }
                    continuation = Float.parseFloat(args[1]);
                    strategies = extended;
                    break;

                case "custom":
                    if (args.length < 3) {
                        printUsage();
                        return;
                    }
                    noise = Float.parseFloat(args[1]);
                    continuation = Float.parseFloat(args[2]);
                    strategies = extended;
                    break;

                default:
                    printUsage();
                    return;
            }

            int roundsIndex = switch (mode) {
                case "noise", "horizon" -> 2;
                case "custom" -> 3;
                default -> 1;
            };

            if (args.length > roundsIndex) {
                rounds = Integer.parseInt(args[roundsIndex]);
            }

            if (noise < 0 || noise > 1 ||
                    continuation < 0 || continuation > 1 ||
                    rounds <= 0) {
                System.out.println("Invalid parameters.");
                return;
            }

        } catch (NumberFormatException e) {
            System.out.println("Invalid numeric argument.");
            printUsage();
            return;
        }

        System.out.println("Starting " + mode + " tournament...");
        System.out.println("Noise: " + noise);
        System.out.println("Continuation probability: " + continuation);
        System.out.println("Maximum rounds: " + rounds);

        AxelrodTournament tournament =
                new AxelrodTournament(noise, continuation);

        tournament.generateAxelrodTournament(strategies, rounds);
    }

    private static void printUsage() {
        System.out.println("Usage:");
        System.out.println("  baseline [rounds]");
        System.out.println("  extended [rounds]");
        System.out.println("  noise <probability> [rounds]");
        System.out.println("  horizon <probability> [rounds]");
        System.out.println("  custom <noise> <continuation> [rounds]");
    }
}
