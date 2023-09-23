package toys;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.Scanner;

public class ToyShop {
    private static PriorityQueue<Toy> prizeToys = new PriorityQueue<>();
    private static ArrayList<Toy> toys = new ArrayList<>();
    private static int toyId = 0;

    public void addToy() {
        Scanner scan = new Scanner(System.in);
        String title;
        int weight;
        while (true) {
            System.out.print("Enter Toy name: ");
            title = scan.nextLine();
            if (title.isEmpty()) {
                System.out.println("Field cannot be empty. Please, try again. ");
                break;
            }

            System.out.print("What are the chances of winning this Toy : ");
            String value = scan.nextLine();
            if (toInt(value)) {
                weight = Integer.parseInt(value);
                if (weight <= 0) {
                    System.out.println("Value should be greater than 0. Please, try again. ");
                } else {
                    Toy toy = new Toy(toyId, title, weight);
                    if (!toys.contains(toy) || toys.size() == 0) {
                        toyId++;
                        toys.add(toy);
                        System.out.println("Successfully added");
                    } else {
                        System.out.println("The Toy is already in the draw. Please enter a new item. ");
                    }
                }
            } else {
                System.out.println("Input error. Please, try again.");
            }
            break;
        }
    }

    public void setWeight() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter Toy id : ");
        String idEntered = scan.nextLine();

        if (toInt(idEntered)) {
            int idSelected = Integer.parseInt(idEntered);
            if (idSelected >= 0 && idSelected < toys.size()) {
                System.out.println("Chances to win " + toys.get(idSelected).getToyName() +
                        " are " + toys.get(idSelected).getToyWeight());
                System.out.print("Enter new chances of winning the Toy : ");
                idEntered = scan.nextLine();
                if (toInt(idEntered)) {
                    int newWeight = Integer.parseInt(idEntered);
                    toys.get(idSelected).setToyWeight(newWeight);
                    System.out.println("Chances updated. ");
                } else {
                    System.out.println("Input error. Please, try again. ");
                }
            } else {
                System.out.println("Toy id is incorrect.");
            }
        } else {
            System.out.println("Input error. Please, try again.");
        }
    }

    public Toy getPrize() {
        if (prizeToys.size() == 0) {
            Random random = new Random();
            for (Toy toy : toys) {
                for (int i = 0; i < toy.getToyWeight(); i++) {
                    Toy newToy = new Toy(toy.getToyId(), toy.getToyName(), random.nextInt(1, 100));
                    prizeToys.add(newToy);
                }
            }
        }
        return prizeToys.poll();
    }

    public void draw() {
        if (toys.size() >= 3) {
            Toy winnerToy = getPrize();
            System.out.println("You won a " + winnerToy.getToyName() + ". Congratulations :D ");
            saveToFIle(winnerToy.getInfo());
        } else {
            System.out.println("At least three toys needed for the lucky draw. Please, add more toys. ");
        }
    }

    private void saveToFIle(String text) {
        File file = new File("Winners.txt");

        try {
            file.createNewFile();
        } catch (Exception ignored) {
            throw new RuntimeException();
        }
        try (FileWriter fileWriter = new FileWriter("Winners.txt", true)) {
            fileWriter.write(text + "\n");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static boolean toInt(String string) throws NumberFormatException {
        try {
            Integer.parseInt(string);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
