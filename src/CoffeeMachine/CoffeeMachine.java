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
        double cupsCoffeeNumber = -1.0;
        while (!gotPositiveInt) {
            System.out.println("How many cups of coffee do you want?");
            System.out.println("Please make sure to enter a positive integer.");
            String cupsCoffee = scanner.nextLine();
            cupsCoffeeNumber = Numbers.getNumber(cupsCoffee);

            boolean isPositiveInteger = Numbers.isPositiveInteger(cupsCoffeeNumber);
            if(!isPositiveInteger){
                System.out.println("Error: That was not a positive integer.");
                continue;
            }
            gotPositiveInt = true;


        }
        int integerResponse = (int) cupsCoffeeNumber;
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
