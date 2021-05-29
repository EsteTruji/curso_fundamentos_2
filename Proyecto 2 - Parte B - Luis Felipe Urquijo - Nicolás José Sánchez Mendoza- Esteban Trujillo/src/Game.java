import java.util.Random;
import java.util.Scanner;

public class Game {

    public static Bug[][] board = new Bug[2][2];

    public static void main(String[] args) {

        Random random = new Random();
        Scanner in = new Scanner(System.in);

        int numOfBugs = random.nextInt(4) + 1;
        int bugsToAdd = numOfBugs;
        for (int i = 0; i < Game.board.length; i ++) {
            for (int j = 0; j < Game.board.length; j ++) {
                if (bugsToAdd == 0) {
                    break;
                }
                bugsToAdd --;
                int bugType = random.nextInt(2) + 1;
                switch (bugType) {
                    case 1 -> Game.board[i][j] = new Normal_Bug();
                    case 2 -> Game.board[i][j] = new Alien_Bug ();
                }
            }
            if (bugsToAdd == 0) {
                break;
            }
        }

        while(true) {
            int dead = 0;
            for (int i = 0; i < Game.board.length; i ++) {
                for (int j = 0; j < Game.board.length; j ++) {
                    if (Game.board[i][j] == null) {
                        break;
                    }
                    else if (Game.board[i][j].getHealth() <= 0) {
                        dead ++;
                    }
                }
            }
            if (dead >= numOfBugs) {
                System.out.println("    | THERE'S NO BUGS LEFT ALIVE");
                break;
            }

            Game.showBoard();
            System.out.println("** Choose your next action. ***********");
            System.out.println("    | (1). Shoot.                   |");
            System.out.println("    | (2). Deploy atomic bomb.      |");
            System.out.println("    | (3). Activate mutant bug.     |");
            System.out.print  ("    |  > ");  String action = in.next();

            switch (action) {
                case "1" -> {
                    System.out.println("** Shoot ******************************");
                    System.out.println("    | -----------------             |  ");
                    System.out.println("    | |   1   |   2   |             |  ");
                    System.out.println("    | -----------------             |  ");
                    System.out.println("    | |   3   |   4   |             |  ");
                    System.out.println("    | -----------------             |  ");
                    System.out.print  ("    |   > Shoot to position ");  String position = in.next();

                    try {
                        Integer.parseInt(position);
                    }
                    catch (NumberFormatException e) {
                        System.out.println("    | POSITION MUST BE AN INTEGER");
                        break;
                    }

                    int pos = Integer.parseInt(position);
                    if (pos < 0 || pos > Math.pow(Game.board.length, 2)) {
                        System.out.println("    | " +pos+ " IS NOT A VALID POSITION");
                        break;
                    }
                    int x = 0;  int y;
                    if (pos >= 3) {
                        x = 1;
                        y = pos - 3;
                    }
                    else {
                        y = pos - 1;
                    }

                    if (Game.board[x][y] == null) {
                        System.out.println("    | THERE'S NO BUG IN POSITION [" +pos+ "]");
                    }
                    else if (Game.board[x][y].getHealth() <= 0) {
                        System.out.println("    | BUG IN POSITION [" +pos+ "] IS ALREADY DEAD.");
                    }
                    else {
                        Game.board[x][y].setHealth(Game.board[x][y].getHealth() - 5);
                    }
                }
                case "2" -> {
                    boolean killed = false;
                    while (!killed) {
                        int toKill = random.nextInt(numOfBugs) + 1;
                        int x = 0;
                        int y;
                        if (toKill >= 3) {
                            x = 1;
                            y = toKill - 3;
                        }
                        else {
                            y = toKill - 1;
                        }
                        if (Game.board[x][y].getHealth() > 0) {
                            Game.board[x][y].setHealth(0);
                            System.out.println("    | KILLED BUG IN POSITION [" + toKill + "]");
                            killed = true;
                        }
                    }
                }
                case "3" -> {
                    int min = 30;  int[] pos = {0, 0};
                    for (int i = 0; i < Game.board.length; i ++) {
                        for (int j = 0; j < Game.board.length; j ++) {
                            if (Game.board[i][j] == null) {
                                break;
                            }
                            if (Game.board[i][j].getHealth() < min && Game.board[i][j].getHealth() > 0) {
                                min = Game.board[i][j].getHealth();
                                pos[0] = i;
                                pos[1] = j;
                            }
                        }
                    }
                    assert Game.board[pos[0]][pos[1]] != null;
                    Game.board[pos[0]][pos[1]].setHealth(Game.board[pos[0]][pos[1]].getHealth() * 2);
                    System.out.println("    | BUG IN POSITION [" +(pos[0] + pos[1] + 1)+ "] HAS MUTATED");
                }
                default -> System.out.println("    | CHOOSE A VALID OPTION.");
            }
        }
    }

    public static void showBoard() {

        System.out.print("\n** CURRENT BOARD **********************");
        for (int i = 0; i < Game.board.length; i ++) {
            System.out.println("\n    | -----------------             |");
            System.out.print("    | ");
            for (int j = 0; j < Game.board.length; j ++) {
                if (Game.board[i][j] == null) {
                    System.out.print("|-empty-");
                }
                else if (Game.board[i][j].getHealth() < 10) {
                    System.out.print("| " + Game.board[i][j].getName() + "-0" + Game.board[i][j].getHealth()+ " ");
                }
                else {
                    System.out.print("| " + Game.board[i][j].getName() + "-" + Game.board[i][j].getHealth()+ " ");
                }
            }
            System.out.print("|             |");
        }
        System.out.println("\n    | -----------------             |");
    }
}
