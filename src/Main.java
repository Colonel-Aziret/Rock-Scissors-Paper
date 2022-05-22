import java.util.Random;
import java.util.Scanner;

public class Main {
    static int counterComp = 0;
    static int counterUser = 0;
    static int counterDraw = 0;

    public static void main(String[] args) {
        System.out.println("======Start Game=====");
        boolean b = true;
        while (b) {
            String comp = getRnd();
            String user = getUserAction();
            compare(comp, user);

            int round = (counterDraw + counterUser + counterComp);
            double rate = Math.round(counterUser * 100 / round);
            System.out.println("Comp action : " + comp);
            System.out.println("+---------------------------------------+");
            System.out.println("| Win | Lost | Draw | Rounds | Win Rate | ");
            System.out.println("|-----|------|------|--------|----------|");
            System.out.println(String.format("| %s   | %s    | %s    | %s      |   %s    |", counterUser, counterComp, counterDraw, round, rate));
            System.out.println("+---------------------------------------+");
            if (counterComp >= 5) {
                b = false;
                System.out.println("Comp win");
            }
            if (counterUser >= 5) {
                b = false;
                System.out.println("User win");
            }
        }
    }

    private static void compare(String comp, String user) {
        if (comp.equals(user)) {
            counterDraw++;
        } else {
            switch (user) {
                case "rock":
                    whenRock(comp);
                    break;
                case "paper":
                    whenPaper(comp);
                    break;
                case "scissors":
                    whenScissors(comp);
                    break;
                default:
                    break;
            }
        }
    }

    private static void whenScissors(String comp) {
        if (comp.equals("paper")) {
            counterUser++;
        } else {
            counterComp++;
        }
    }

    private static void whenPaper(String comp) {
        if (comp.equals("rock")) {
            counterUser++;
        } else {
            counterComp++;
        }
    }

    private static void whenRock(String comp) {
        if (comp.equals("scissors")) {
            counterUser++;
        } else {
            counterComp++;
        }
    }

    private static String getUserAction() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("user action : ");
        String action = scanner.nextLine();
        if (action.equals("rock") || action.equals("scissors") || action.equals("paper")) {
            return action;
        } else {
            System.out.println("Wrong action, try again");
            return getUserAction();
        }
    }

    private static String getRnd() {
        Random random = new Random();
        int i = random.nextInt(3) + 1;
        if (i == 1) {
            return "rock";
        } else if (i == 2) {
            return "scissors";
        } else {
            return "paper";
        }
    }
}