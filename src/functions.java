import java.util.Scanner;

public class functions {
    public static void playerTurn() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Coins: "+Main.player.coins + "\nPoints: "+Main.player.points);
        System.out.println("Options: (C)onvert Coins to Points, (S)teal Coins from Bot (Risky), (I)nvest Coins");
        System.out.println("Conversion Rate: 20 Coins = 1 Point");
        String choice = sc.nextLine().toLowerCase();

        if(choice.equals("c")) {
            convertCoinsToPoints(1);
        }
    }
    public static void convertCoinsToPoints(int id) {
        if(id == 0) {
            if(Main.bot.coins >=20) {
                Main.bot.coins = Main.bot.coins - 20;
                Main.bot.points++;
            }

        } else if(id == 1) {
            if(Main.player.coins >=20) {
                while (Main.player.coins >=20) {
                    Main.player.coins = Main.player.coins - 20;
                    Main.player.points++;
                }
                System.out.println("Points successfully converted");
                System.out.println("Current Points: " + Main.player.points);
            } else  {
            System.out.println("Not Enough Points");
            }
        }
    }
}
