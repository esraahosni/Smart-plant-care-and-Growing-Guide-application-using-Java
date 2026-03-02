import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        GardenManager garden = new GardenManager();
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("1) Add Plant");
            System.out.println("2) Show Plants");
            System.out.println("3) Water Plant");
            System.out.println("4) Simulate Day");
            System.out.println("5) Exit");
            System.out.print("Choose: ");
            int choice = input.nextInt();
            input.nextLine();
            if (choice == 1) garden.addPlant();
            else if (choice == 2) garden.showPlants();
            else if (choice == 3) garden.waterPlant();
            else if (choice == 4) garden.simulateDay();
            else if (choice == 5) break;
            else System.out.println("Invalid choice.\n");
        }
    }
}