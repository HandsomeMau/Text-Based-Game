import java.util.Scanner;

public class functions {
    public static int x;

    public static void playerTurn() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Player: ");
        System.out.println("Coins: "+Main.player.coins + "\nPoints: "+Main.player.points);
        System.out.println("\nBot: ");
        System.out.println("Coins: "+Main.bot.coins + "\nPoints: "+Main.bot.points);
        System.out.println("Options: (C)onvert Coins to Points, (S)teal Coins from Bot (Risky), (I)nvest Coins");
        System.out.println("Conversion Rate: 20 Coins = 1 Point");
        String choice = sc.nextLine().toLowerCase();

        if(choice.equals("c")) {
            convertCoinsToPoints(1);
        }else if(choice.equals("i")) {
            System.out.println("Enter Coins to Invest: ");
            int coinsToInvest = sc.nextInt();
            investCoins(1,coinsToInvest);
        }
    }

    public static void convertCoinsToPoints(int id) { //Move id 0
        //id 0 for bot, 1 for player
        if(id == 0) {
            if (Main.bot.coins >= 20) {
                while (Main.bot.coins >= 20) {
                    Main.bot.coins = Main.bot.coins - 20;
                    Main.bot.points++;
                }
                System.out.println("Bot has Converted Coins. Current Points: " + Main.bot.points);
                playerTurn();
            }
        } else if(id == 1) {
            if(Main.player.coins >=20) {
                while (Main.player.coins >=20) {
                    Main.player.coins = Main.player.coins - 20;
                    Main.player.points++;
                }
                System.out.println("Points successfully converted");
                System.out.println("Current Points: " + Main.player.points);
                botAnalyse();
            } else  {
            System.out.println("Not Enough Points");
            }
        }
    }

    public static void botTurn(int moveId) {
        if(moveId == 0) {
            convertCoinsToPoints(0);
        } else if(moveId == 1){
            investCoins(0, decideCoinsToInvest());
        }
    }

    public static void botAnalyse() {
        if(Main.bot.coins >= 20) {
            botTurn(0);
        }else if(Main.bot.coins <20) {
            botTurn(1);
        }
    }

    public static void investCoins(int id, int coinsToInvest) { //Move id 1
        if(id==0) {
            System.out.println("Bot has invested: " + x + " coins");
            double investmentTotalReturn = (x * ((Math.random() * 100)/100.0)) + x;

            investmentTotalReturn = (int)Math.rint(investmentTotalReturn);


            System.out.println("Bot has obtained: "+ investmentTotalReturn + " coins!");
        }else if(id==1) {
            int investmentTotalReturn = (int)(x * ((Math.random() * 100.0))) + x;
            System.out.println(investmentTotalReturn);

            //investmentTotalReturn = (int)Math.rint(investmentTotalReturn);
            //System.out.println(investmentTotalReturn);

            Main.player.coins = Main.player.coins + investmentTotalReturn;
            System.out.println(Main.player.coins);
            System.out.println("You have obtained: "+investmentTotalReturn + " coins!");
        }
    }

    public static int decideCoinsToInvest() {
        x = (int)(Math.random() * 35);
        if(x>=20) {
            x = 19;
        } else if(x>Main.bot.coins) {
            for(int i = 0; i <= Main.bot.coins; i++) {
                if(i == Main.bot.coins) {
                    x = Main.bot.coins;
                }
            }
        }

        return x;
    }
}
