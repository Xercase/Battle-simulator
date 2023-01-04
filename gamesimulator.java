import java.util.*;

public class gamesimulator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        String[] elements = {"Water", "Earth", "Fire", "Grass", "Ice", "Telepath"};

        String[] bossNames = {"Duma", "Stein", "Chlorovenom", "Halostone", "Flaro", "Nightmare", "Septo", "Stadin"};


        System.out.print("Player Name: ");
        String name = scanner.next();
        System.out.print("Starting player HP: ");
        int playerHP = scanner.nextInt();


        System.out.println();

        int x = 30;
        int y = 20;
        int x1 = 8;
        int y1 = 5;
        int bossHP = 400;
        for (int i = 0; i < bossNames.length; i++) {
            String bossName = bossName(bossNames, i);

            if (i > 0) {
                x = x + 30;
                y = y + 25;
                x1 = x1 + 10;
                y1 = y1 + 8;
                bossHP = bossHP + 200;
                playerHP = (int) (bossHP * .30);
            }

            System.out.println("------------------- Round " + (i + 1) + " -------------------");
            calcBossDmg(random, x1, y1);

            int playerHPHolder = calcPlayerDmg(elements, random, bossName, name, x, y, bossHP, playerHP, x1, y1);
            if (playerHPHolder < 0) {
                break;
            }
            System.out.println();
            if (i == bossNames.length - 1) {
                System.out.println("Congratulations on clearing the boss lap!");
            }


        }
            System.out.println();

            System.out.println("------------------- Finish -------------------");

    }


    public static String bossName(String[] bossNames, int i) {
        String bossName = bossNames[i];

        return bossName;
    }

    public static int calcBossDmg(Random random, int x1, int y1) {
        int bossDmg;
        bossDmg = random.nextInt(x1 - y1) + y1;
        return bossDmg;
    }

    public static int calcPlayerDmg(String[] elements, Random random, String bossName, String name, int x, int y, int bossHP, int playerHP, int x1, int y1) {


        int element = random.nextInt(elements.length);
        System.out.println("Player element: " + elements[element] + "     Boss: " + bossName);
        System.out.println();

        int baseDmg;
        int placeholder = 0;

        while (bossHP > 0 && playerHP > 0) {
            baseDmg = random.nextInt(x - y) + y;
            int bossDmg = calcBossDmg(random, x1, y1);
            if (elements[element].equals("Water") && bossName.equals("Duma") || elements[element].equals("Earth") && bossName.equals("Stein") || elements[element].equals("Fire") && bossName.equals("Chlorovenom") || elements[element].equals("Grass") && bossName.equals("Terra") || elements[element].equals("Ice") && bossName.equals("Flaro") || elements[element].equals("Telepath") && bossName.equals("Nightmare")) {
                bossHP = bossHP - (baseDmg * 2);
                playerHP = playerHP - bossDmg;
                if (bossHP > 0 && playerHP > 0) {
                    System.out.println(name + " did " + (baseDmg * 2) + " damage!" + " It's super effective!" + " " + bossName + " has " + bossHP + " HP left.");
                    System.out.println(bossName + " did " + (bossDmg) + " damage!" + " " + name + " has " + playerHP + " HP left.");
                    System.out.println();
                } else if (bossHP <= 0) {
                    System.out.println("You won!");
                } else {
                    System.out.println(name + " did " + (baseDmg) + " damage!" + " " + bossName + " has " + bossHP + " HP left.");
                    System.out.println();
                    System.out.println("You have fallen...");
                }
            } else {
                bossHP = bossHP - baseDmg;
                playerHP = playerHP - bossDmg;
                if (bossHP > 0 && playerHP > 0) {
                    System.out.println(name + " did " + (baseDmg) + " damage!" + " " + bossName + " has " + bossHP + " HP left.");
                    System.out.println(bossName + " did " + (bossDmg) + " damage!" + " " + name + " has " + playerHP + " HP left.");
                    System.out.println();
                    placeholder = playerHP;
                } else if (bossHP <= 0) {
                    System.out.println("You won!");
                } else {
                    System.out.println(name + " did " + (baseDmg) + " damage!" + " " + bossName + " has " + bossHP + " HP left.");
                    System.out.println();
                    System.out.println("You have fallen...");
                    placeholder = playerHP;

                }
            }
        }
        return placeholder;
    }
}






