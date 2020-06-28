package CoffeeMachine;

public class Messages {
    static void notPositiveIntegerError() {
        System.out.println("Error: Not a positive integer");
    }

    static void amountsRequest(String material, String units) {
        System.out.println("How many " + units + " of " + material + "?");
        System.out.println("Please make sure to enter a positive integer.");
    }
}
