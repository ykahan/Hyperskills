package CoffeeMachine;

public class Numbers {

    public static double getNumber(String str){
        double number = 0.0;
        try {
            number = Double.parseDouble(str);
        } catch (NumberFormatException e) {
        }
        return number;
    }

    public static boolean isPositive(double number){
        return number > 0;
    }

    public static boolean isInteger(double number){
        return number % 1 == 0;
    }

    public static boolean isPositiveInteger(double cupsCoffeeNumber) {
        boolean isPositive = isPositive(cupsCoffeeNumber);
        boolean isInteger = isInteger(cupsCoffeeNumber);
        return isPositive && isInteger;
    }

    static boolean enforcePositiveInteger(double amountDouble) {
        boolean isPositiveInteger = isPositiveInteger(amountDouble);
        if(!isPositiveInteger){
            Messages.notPositiveIntegerError();
            return false;
        }
        return true;
    }

}
