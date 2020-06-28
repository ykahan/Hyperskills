package CoffeeMachine;

import java.util.Scanner;

public class CoffeeMachine {
    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        CoffeeMachine cf = new CoffeeMachine();
        int cups = cf.getCupsCoffee();
        cf.print(cups);
    }

    public int getMlWater(int cups) {
        return cups * 200;
    }

    public int getMlMilk(int cups) {
        return cups * 50;
    }

    public int getGramsCoffeeeans(int cups) {
        return cups * 15;
    }

    public int getCupsCoffee() {
        boolean gotPositiveInt = false;
        int integerResponse = -1;
        while (!gotPositiveInt) {
            System.out.println("How many cups of coffee do you want?");
            System.out.println("Please make sure to enter a positive integer.");
            String response = scanner.nextLine();
            try {
                integerResponse = Integer.parseInt(response);
                if (integerResponse > 0) gotPositiveInt = true;
                else System.out.println("Sorry, your response must be a postive number.");
            } catch (NumberFormatException e) {
                System.out.println("That's not an integer.  Please try again.");
            }
        }
        return integerResponse;
    }

    public String toString(int cups) {
        int water = getMlWater(cups);
        int milk = getMlMilk(cups);
        int beans = getGramsCoffeeeans(cups);

        StringBuilder sb = new StringBuilder();
        sb.append("For " + cups + " cups of coffee you will need:\n");
        sb.append(water + " milliliters of boiling water.\n");
        sb.append(milk + " milliliters of milk.\n");
        sb.append(beans + " grams of coffee beans.");

        return sb.toString();
    }

    public void print(int cups){
        System.out.println(toString(cups));
    }

}
