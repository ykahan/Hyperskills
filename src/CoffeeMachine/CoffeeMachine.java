package CoffeeMachine;

import java.util.Scanner;

public class CoffeeMachine {
    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        CoffeeMachine cf = new CoffeeMachine();
        int waterAvailable = cf.getWaterAvailable();
        int cups = cf.getCupsCoffee();
        cf.print(cups);
    }

    public int getMlWater(int cups) {
        return cups * 200;
    }

    public int getMlMilk(int cups) {
        return cups * 50;
    }

    public int getGramsCoffeeBeans(int cups) {
        return cups * 15;
    }

    public int getAmount(String material, String units){
        boolean gotPositiveInt = false;
        double amountDouble = 0.0;
        while(!gotPositiveInt){
            System.out.println("How many " + units + " of " + material + "?");
            System.out.println("Please make sure to enter a positive integer.");
            String amountString = scanner.nextLine();
            amountDouble = Numbers.getNumber(amountString);

            if (Numbers.enforcePositiveInteger(amountDouble)) continue;
            gotPositiveInt = true;
        }
        return (int) amountDouble;
    }

    public int getCoffeeBeansAvailable(){
        return getAmount("coffee beans", "grams");
    }

    public int getMilkAvailable(){
        return getAmount("milk", "milliliters");
    }

    public int getWaterAvailable(){
       return getAmount("water", "milliliters");
    }

    public int getCupsCoffee() {
        return getAmount("coffee", "cups");
    }


    public String toString(int cups) {
        int water = getMlWater(cups);
        int milk = getMlMilk(cups);
        int beans = getGramsCoffeeBeans(cups);

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
