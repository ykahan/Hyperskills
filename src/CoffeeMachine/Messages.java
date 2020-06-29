package CoffeeMachine;

public class Messages {
    static void notPositiveIntegerError() {
        System.out.println("Error: Not a positive integer");
    }

    static void amountsRequest(String material, String units) {
        System.out.println("How many " + units + " of " + material + "?");
        System.out.println("Please make sure to enter a positive integer.");
    }

    static void haveEnoughIngredients(int cups){
        System.out.println("Yes, I can make that amount of coffee.");
    }

    static void extraCups(int extraCups){
        System.out.println("Yes, I can make that amount of coffee (and even " + extraCups + " more than that)");
    }

    static void doNotHaveEnoughIngredients(int cups){
        System.out.println("No, I can make only " + cups + " cup(s) of coffee");
    }
}
