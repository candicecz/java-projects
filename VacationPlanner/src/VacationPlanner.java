import java.util.Scanner;
public class VacationPlanner {
    public static void main (String[] args) {
        greeting();
        budgettingTravel();
        timeDifference();

    }
    public static void greeting(){
        Scanner input = new Scanner(System.in);
        System.out.print("Welcome to Vacation Planner! What is your name?");
        String name = input.nextLine();
        System.out.print("Nice to meet you " + name + ", where are you travelling to?");
        String location = input.next();
        System.out.println("Great! "+ location + " sounds like a great trip");

    }
    public static void budgettingTravel(){
        Scanner input = new Scanner(System.in);
        System.out.print("How many days are you going to spend travelling?");
        int days = input.nextInt();
        int hours = 24 * days;
        int minutes = hours * 60;
        System.out.print("How much money, in USD are you planning to spend on your trip?");
        double budget = input.nextDouble();
        double dailyBudget = budget/days;
        System.out.print("What is the three letter currency symbol for your travel destination?");
        String currency = input.next();
        System.out.print("How many " + currency +" are there in 1 USD?");
        double amtPerDollar = input.nextDouble();
        double convertedBudget = amtPerDollar * budget;
        double convertedDailyBudget = amtPerDollar * dailyBudget;
        // Details Output
        System.out.println("If you are travelling for "+ days + " days, that is the same as " + hours + " hours or " + minutes + " minutes.");
        System.out.println("If you are going to spend $" + (int) (budget*100)/100.0 + "USD that means per day you can spend up to $"+ (int) (dailyBudget*100)/100.0 +" USD.");
        System.out.println("Your total budget in " + currency + " is " + (int) (convertedBudget*100)/100.0 + currency + ", which per day is " + (int) (convertedDailyBudget *100)/100.0+ currency);
    }
    public static void timeDifference(){
        Scanner input = new Scanner(System.in);
        System.out.print("What is the time difference, in hours, between your home and your destination?");
        int deltaHours = input.nextInt();
        int diff = deltaHours%24;
        System.out.print("That means that when it is midnight at home it will be "+ diff + ":00 and when it is noon it will be " + (12+diff)+":00");
    }
}

