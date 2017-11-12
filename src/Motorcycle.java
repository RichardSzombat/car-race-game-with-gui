
public class Motorcycle extends Vehicle {
    private static int nameNumber = 1;
    public static int normalSpeed = 100;
    public static String customName = "Motorcycle";

    public static void setNameNumber(int nameNumber) {
        Motorcycle.nameNumber = nameNumber;
    }

    public Motorcycle() {
        this.setName();
        this.setNormalSpeed(normalSpeed);
        this.setType("motorcycle");
        System.out.println(String.format("%s created with the speed : %s", this.getName(), this.getNormalSpeed()));
    }

    public void setName() {
        this.setName(customName+" " + String.valueOf(Motorcycle.nameNumber));
        Motorcycle.nameNumber++;
    }

    public void moveForAnHour() {
        if (Race.isRaining) {
            this.setDistanceTraveled(this.getDistanceTraveled() + this.getNormalSpeed() - RandomGenerator.decreaseMotoSpeed());

        } else {
            setDistanceTraveled(this.getDistanceTraveled() + this.getNormalSpeed());
        }
    }
}
