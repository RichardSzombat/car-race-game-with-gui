
public class Motorcycle extends Vehicle {
    private static int nameNumber = 1;

    public static void setNameNumber(int nameNumber) {
        Motorcycle.nameNumber = nameNumber;
    }

    public Motorcycle() {
        this.setName();
        this.setNormalSpeed(100);
        this.setType("motorcycle");
    }

    public void setName() {
        this.setName("Motorcycle " + String.valueOf(Motorcycle.nameNumber));
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
