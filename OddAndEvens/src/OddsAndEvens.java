import java.util.*;

public class OddsAndEvens {
    public static void main(String[] args){
        sumFingers();
    }
    public static void sumFingers(){
        Scanner input = new Scanner(System.in);
        System.out.print("Let's play a game called Odds and Events! What is your name?");
        String name = input.nextLine();
        System.out.print("Hi " + name + ", which do you choose?(O)dds or (E)vens?");
        String choice = input.next();
        if (choice.equals("O")){
            System.out.println(name + " has picked odds! The computer will choose evens");
        } else {
            System.out.println(name + " has picked evens! The computer will choose odd");
        }
        System.out.print("How many fingers do you put out?");
        int user = input.nextInt();
        Random rand = new Random();
        int computer = rand.nextInt(6);
        System.out.println("The computer has played " + computer + " fingers");
        int sum = computer + user;
        System.out.println(user + " + " + computer + " = " + sum);
        if (sum % 2 == 1){
            System.out.print(sum + " is ...odd! ");
            if (choice == "O") {
                System.out.print("The user wins.");
            } else {
                System.out.print("The computer wins.");
            }
        } else {
            System.out.print(sum + " is ...even! ");
            if (choice == "E") {
                System.out.print("The user wins.");
            } else {
                System.out.print("The computer wins.");
            }
        }


    }
}
