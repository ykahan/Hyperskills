package CoffeeMachine;
public class Main {
    public static void main(String args[]) {
        System.out.println(checkBurg("Auburg"));
        System.out.println(checkBurg("Chicago"));
        System.out.println(checkBurg("Pittsburgh"));
        System.out.println(checkBurg("Iceburg"));
}

    public static boolean checkBurg(String city){
        String lastFour = city.substring(city.length() - 5);
        return lastFour.contentEquals("burg");
    }
}


