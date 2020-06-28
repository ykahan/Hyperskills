package CoffeeMachine;

import java.util.Scanner;

public class CoffeeMachine {
    Scanner scanner = new Scanner(System.in);
    public final int WATER_PER_CUP = 200;
    public final int MILK_PER_CUP = 50;
    public final int BEANS_PER_CUP = 15;

    public static void main(String[] args) {
        CoffeeMachine cf = new CoffeeMachine();
        int waterAvailable = cf.getWaterAvailable();
        int milkAvailable = cf.getMilkAvailable();
        int coffeeBeansAvailable = cf.getCoffeeBeansAvailable();
        int cups = cf.getCupsCoffee();
        boolean haveEnough = cf.haveEnough(cups, waterAvailable, milkAvailable, coffeeBeansAvailable);
        if(haveEnough) Messages.haveEnoughIngredients(cups);
        int extraCups = cf.extraCupsPossible(cups, waterAvailable, milkAvailable, coffeeBeansAvailable);
        if(extraCups > 0) Messages.extraCups(extraCups);
    }

    public int sufficientIngredient(String ingredient, int amount){
        if(ingredient.contains("water")) return amount / WATER_PER_CUP;
        if(ingredient.contains("milk")) return amount / MILK_PER_CUP;
        if(ingredient.contains("beans")) return amount / BEANS_PER_CUP;
        return -1;
    }

    public int extraCupsPossible(int cupsWanted, int waterAvailable, int milkAvailable, int coffeeBeansAvailable){
        int waterFor = sufficientIngredient("water", waterAvailable);
        int extraWater = waterFor - cupsWanted;
        int milkFor = sufficientIngredient("milk", milkAvailable);
        int extraMilk = milkFor - cupsWanted;
        int beansFor = sufficientIngredient("beans", coffeeBeansAvailable);
        int extraBeans = beansFor - cupsWanted;

        int least = extraWater;
        if(extraMilk < least) least = extraMilk;
        if(extraBeans < least) least = extraBeans;

        return least;

    }

    public boolean haveEnough(int cupsWanted, int waterAvailable, int milkAvailable, int coffeeBeansAvailable){
        boolean enoughWater = waterAvailable >= getMlWaterNeeded(cupsWanted);
        boolean enoughMilk = milkAvailable >= getMlMilkNeeded(cupsWanted);
        boolean enoughBeans = coffeeBeansAvailable >= getGramsCoffeeBeansNeeded(cupsWanted);
        return enoughWater && enoughMilk && enoughBeans;
    }

    public int getMlWaterNeeded(int cups) {
        return cups * WATER_PER_CUP;
    }

    public int getMlMilkNeeded(int cups) {
        return cups * MILK_PER_CUP;
    }

    public int getGramsCoffeeBeansNeeded(int cups) {
        return cups * BEANS_PER_CUP;
    }

    public int getAmount(String material, String units){
        boolean gotPositiveInt = false;
        double amountDouble = 0.0;
        while(!gotPositiveInt){
            Messages.amountsRequest(material, units);
            String amountString = scanner.nextLine();
            amountDouble = Numbers.getNumber(amountString);

            if (!Numbers.enforcePositiveInteger(amountDouble)) continue;
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
        int waterNeeded = getMlWaterNeeded(cups);
        int milkNeeded = getMlMilkNeeded(cups);
        int beansNeeded = getGramsCoffeeBeansNeeded(cups);

        StringBuilder sb = new StringBuilder();
        sb.append("For " + cups + " cups of coffee you will need:\n");
        sb.append(waterNeeded + " milliliters of boiling water.\n");
        sb.append(milkNeeded + " milliliters of milk.\n");
        sb.append(beansNeeded + " grams of coffee beans.");

        return sb.toString();
    }

    public void print(int cups){
        System.out.println(toString(cups));
    }

}
