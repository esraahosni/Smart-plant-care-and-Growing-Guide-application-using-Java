import java.util.ArrayList;
import java.util.Scanner;

public class GardenManager {
    ArrayList<Plant> plantList = new ArrayList<>();
    Scanner input = new Scanner(System.in);
    int currentDay = 0;

    public void addPlant() {
        System.out.println("Enter plant name:");
        String name = input.nextLine();

        System.out.println("Enter plant Season (SPRING, SUMMER, AUTUMN, WINTER):");
        String season = input.nextLine();

        System.out.println("Enter plant SoilType (LOAMY, SANDY, CLAY):");
        String soil = input.nextLine();

        System.out.println("Enter plant Watering Frequency (days):");
        int wateringDays = input.nextInt();
        input.nextLine();

        System.out.println("Enter plant SunlightLevel (LOW, MEDIUM, HIGH):");
        String sunlight = input.nextLine();

        Plant newPlant = new Plant(name, season, soil, wateringDays, sunlight);
        plantList.add(newPlant);

        System.out.println("Plant added successfully!\n");
    }

    public void showPlants() {
        if (plantList.isEmpty()) {
            System.out.println("No plants found.\n");
            return;
        }

        int i = 1;
        for (Plant p : plantList) {
            System.out.println(i + ") " + p.getName()
                    + " | Season: " + p.getPreferredSeason()
                    + " | Soil: " + p.getSoilType()
                    + " | Watering: " + p.getWateringFrequencyDays()
                    + " days | Sunlight: " + p.getSunlightLevel()
                    + " | Growth: " + p.getGrowthStage()
                    + " | Health: " + p.getHealth());
            i++;
        }
        System.out.println();
    }

    public void waterPlant() {
        if (plantList.isEmpty()) {
            System.out.println("No plants to water.\n");
            return;
        }

        showPlants();
        System.out.println("Choose plant number to water:");
        int index = input.nextInt() - 1;
        input.nextLine();

        if (index >= 0 && index < plantList.size()) {
            Plant p = plantList.get(index);
            p.watering(currentDay);
            System.out.println(p.getName() + " has been watered.\n");
        } else {
            System.out.println("Invalid choice.\n");
        }
    }

    public void simulateDay() {
        currentDay++;
        System.out.println("Day " + currentDay + " passed...\n");

        for (Plant p : plantList) {
            p.updateDailyStatus(currentDay);

            if (p.isDead()) {
                System.out.println("Plant " + p.getName() + " has died ");
            }
        }
        System.out.println();
    }
}