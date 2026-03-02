public class Plant {
    private String name;
    private String preferredSeason;
    private String soilType;
    private String sunlightLevel;
    private String growthStage;
    private int health;
    private int wateringFrequencyDays;
    private int lastWateredDay;

    public Plant(String name, String preferredSeason, String soilType, int wateringFrequencyDays, String sunlightLevel) {
        this.name = name;
        this.preferredSeason = preferredSeason;
        this.soilType = soilType;
        this.wateringFrequencyDays = wateringFrequencyDays;
        this.sunlightLevel = sunlightLevel;
        this.lastWateredDay = 0;
        this.growthStage = "SEED";
        this.health = 100;
    }

    public String getName() { return name; }
    public String getPreferredSeason() { return preferredSeason; }
    public String getSoilType() { return soilType; }
    public int getWateringFrequencyDays() { return wateringFrequencyDays; }
    public String getSunlightLevel() { return sunlightLevel; }
    public String getGrowthStage() { return growthStage; }
    public int getHealth() { return health; }

    public void watering(int currentDay) {
        lastWateredDay = currentDay;
        health = Math.min(health + 10, 100);
    }

    public void updateDailyStatus(int currentDay) {
        int daysSinceWatered = currentDay - lastWateredDay;

        if (daysSinceWatered > wateringFrequencyDays) {
            health = Math.max(health - 10, 0);
        }

        if (sunlightLevel.equalsIgnoreCase("MEDIUM")) {
            health = Math.min(health + 2, 100);
        } else {
            health = Math.max(health - 2, 0);
        }

        if (health >= 70) {
            if (growthStage.equals("SEED")) growthStage = "SPROUT";
            else if (growthStage.equals("SPROUT")) growthStage = "MATURE";
        }
    }

    public boolean isDead() {
        return health == 0;
    }
}