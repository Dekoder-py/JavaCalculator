import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Choose an operation (+, -, *, /) >> ");
        String mode = sc.next();
        switch (mode) {
            case "+" -> add(sc);
            case "-" -> subtract(sc);
            case "*" -> multiply(sc);
            case "/" -> divide(sc);
            default -> System.out.println("Invalid input. Goodbye.");
        }

    }

    public static void add(Scanner sc) {
        System.out.println("Enter numbers to add, enter = when finished.");
        List<Float> items = getCalculations(sc);
        float result = items.get(0);
        for (int i = 1; i < items.size(); i++) result += items.get(i);
        System.out.println(result);
    }

    public static void subtract(Scanner sc) {
        System.out.println("Enter numbers to subtract, enter = when finished.");
        List<Float> items = getCalculations(sc);
        float result = items.get(0);
        for (int i = 1; i < items.size(); i++) result -= items.get(i);
        System.out.println(result);
    }

    public static void multiply(Scanner sc) {
        System.out.println("Enter numbers to multiply, enter = when finished.");
        List<Float> items = getCalculations(sc);
        float result = items.get(0);
        for (int i = 1; i < items.size(); i++) result *= items.get(i);
        System.out.println(result);
    }

    public static void divide(Scanner sc) {
        System.out.println("Enter numbers to divide, enter = when finished.");
        List<Float> items = getCalculations(sc);
        float result = items.get(0);
        for (int i = 1; i < items.size(); i++) result /= items.get(i);
        System.out.println(result);
    }

    public static List<Float> getCalculations(Scanner sc) {
        boolean finished = false;
        String input;
        List<Float> calculations = new ArrayList<>();
        while (!finished) {
            input = sc.next().strip();
            if (input.equals("=")) finished = true;
            else calculations.add(Float.parseFloat(input));
        }
        return calculations;
    }
}
