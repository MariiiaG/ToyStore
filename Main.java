import toys.ToyShop;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ToyShop toyShop = new ToyShop();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("""
                    Please, select :
                    1. Add a new Toy into the Lucky Draw
                    2. Change the chances of winning a Toy
                    3. Start the Lucky Draw and save results
                    4. Exit
                    >\s""");
            var selection = scanner.next();
            switch (selection) {
                case "1" -> toyShop.addToy();
                case "2" -> toyShop.setWeight();
                case "3" -> toyShop.draw();
                case "4" -> {
                    System.out.println("See you again ! ");
                    System.exit(0);
                }
                default -> System.out.println("Input error. Please, try again.");
            }
        }
    }
}