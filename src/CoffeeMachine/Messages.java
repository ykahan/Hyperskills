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
        System.out.println("Can make " + cups + " cups of coffee.");
    }

    static void extraCups(int extraCups){
        System.out.println("Can make an extra " + extraCups + " cups of coffee.");
    }
}
