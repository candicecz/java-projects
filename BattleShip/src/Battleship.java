import java.util.Arrays;
import java.util.Scanner;
public class Battleship {
    public static void main(String[] args){
        String[][] ocean = new String[10][10];
        // ships is an array of the score [player ships, computers ships]
        int[] ships = new int[2];
        ships[0] = 5;
        ships[1] = 5;
        greeting();
        mapOcean(ocean,ships);
        deployUserShips(ocean);
        mapOcean(ocean,ships);
        deployComputerShips(ocean);
        while (ships[0]>0 && ships[1]>0){
            playerTurn(ocean,ships);
            computerTurn(ocean,ships);
            mapOcean(ocean,ships);
        }
        if(ships[0]==0){
            System.out.print("YOU LOSE");
        } else {
            System.out.print("YOU WIN!");
        }
        mapOcean(ocean,ships);
    }

    public static void greeting () {
        System.out.println("**** Welcome to BattleShip ****");
        System.out.println("Right now, the sea is empty");
    }

    public static void mapOcean(String[][] ocean, int[] ships){
        System.out.print("   ");
        for (int i=0;i<ocean.length;i++){
            System.out.print(i);
        }
        System.out.println();
        for (int col=0; col<ocean.length; col++){
            System.out.print(col+" |");
            for (int row=0; row<ocean[col].length;row++){
                if (ocean[row][col]==null){
                    ocean[row][col] = " ";
                } else if (ocean[row][col].equals("1")){
                    ocean[row][col]= "@";
                }
                if (ships[0] > 0 || ships[1]>0) {
                    if (ocean[row][col].equals("2")){
                        System.out.print(" ");
                    } else {
                        System.out.print(ocean[row][col]);
                    }
                } else {
                    System.out.print(ocean[row][col]);
                }
            }
            System.out.println("| "+col);
        }
        System.out.print("   ");
        for (int i=0;i<ocean.length;i++){
            System.out.print(i);
        }
        System.out.println();
    }

    public static void deployUserShips(String[][] ocean){
        Scanner input = new Scanner(System.in);
        int ships = 1;
        while (ships<=5) {
            System.out.println("Enter the X coordinate for your ship #" + ships + " :");
            int x = input.nextInt();
            System.out.println("Enter the Y coordinate for your ship #" + ships + " :");
            int y = input.nextInt();
            if(x>9 || y>9){
                System.out.println("Choose a location within the grid.");
            } else {
                if (ocean[x][y].equals(" ")){
                    ocean[x][y]="1";
                    ships++;
                } else {
                    System.out.println("Choose a different location");
                }
            }
        }
     }
    public static void deployComputerShips(String[][] ocean){
        System.out.println("Computer is deploying ships");
        int ships = 1;
        while (ships <= 5) {
            double randX = Math.floor(Math.random() * 9);
            double randY = Math.floor(Math.random() * 9);
            int x = (int) randX;
            int y = (int) randY;
            if (ocean[x][y].equals(" ")) {
                System.out.println("ship #"+ ships + " is deployed.");
                ocean[x][y]="2";
                ships ++;
            }
        }
    }
    public static void playerTurn(String[][] ocean, int[] ships){
        Scanner input = new Scanner(System.in);
        System.out.println("YOUR TURN");
        System.out.println("Enter X coordinate:");
        int x = input.nextInt();
        System.out.println("Enter Y coordinate:");
        int y = input.nextInt();
        if (ocean[x][y].equals("2")){
            System.out.println("YOU SUNK A SHIP!");
            ocean[x][y] = "!";
            ships[1] = ships[1]-1;
        } else if (ocean[x][y].equals("@")){
            System.out.println("YOU SUNK YOUR OWN SHIP FOOL!");
            ships[0] = ships[0]-1;
            ocean[x][y] = "x";
        } else if (ocean[x][y].equals(" ")){
            System.out.println("YOU MISSED");
            ocean[x][y] = "-";
        } else {
            System.out.println(" ");
        }
    }
    public static void computerTurn(String[][] ocean, int[] ships){
        double randX = Math.floor(Math.random() * 10);
        double randY = Math.floor(Math.random() * 10);
        int x = (int) randX;
        int y = (int) randY;
        System.out.println("COMPUTERS TURN");
        System.out.println("The computer chose the coordinates:( " + x + "," + y + " )");
        if (ocean[x][y].equals("-")){
            while (ocean[x][y].equals("-")){
                randX = Math.floor(Math.random() * 10);
                randY = Math.floor(Math.random() * 10);
                x = (int) randX;
                y = (int) randY;
            }
        }
        if (ocean[x][y].equals("@")){
            System.out.println("THE COMPUTER SUNK YOUR SHIP!");
            ocean[x][y] = "x";
            ships[0] = ships[0]-1;
        } else if (ocean[x][y].equals("2")){
            ships[1] = ships[1]-1;
            System.out.println("THE COMPUTER SUNK ITS OWN SHIP!");
            ocean[x][y] = "!";
        } else if (ocean[x][y].equals(" ")){
            System.out.println("THE COMPUTER MISSED!");
            ocean[x][y] = "-";
        }
        System.out.println("The score: \n you = "+ ships[0]+" pts \n computer = " + ships[1] + "pts");
    }
}
