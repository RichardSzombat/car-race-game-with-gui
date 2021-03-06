import java.util.ArrayList;
import java.util.List;

public class Truck extends Vehicle {
    static int normalSpeed = 100;
    static int breakdownChance = 5;
    static int breakdownHours = 2;
    static List<String> truckNames = new ArrayList<>();

    private int breakdownTurnsLeft = 0;

    public int getBreakdownTurnsLeft() {
        return this.breakdownTurnsLeft;
    }

    public void setBreakdownTurnsLeft(int breakdownHours) {
        this.breakdownTurnsLeft = breakdownHours;
    }

    public void setName() {

        int randomNameNumber;
        do {
            randomNameNumber = RandomGenerator.randomTruckName();
        } while (truckNames.contains(String.valueOf(randomNameNumber)));

        this.setName(String.valueOf(randomNameNumber));
        truckNames.add(this.getName());
    }

    public static void clearTrucknames(){
        if (!truckNames.isEmpty()){
        truckNames.clear();

        }
    }

    public void moveForAnHour() {

        if (this.getBreakdownTurnsLeft() == 0) {
            if (!(RandomGenerator.truckBreakdown())) {
                this.setDistanceTraveled(this.getDistanceTraveled() + this.getNormalSpeed());
            } else {
                this.setBreakdownTurnsLeft(breakdownHours);
            }
        } else {
            this.breakdownTurnsLeft--;
        }
    }

    public Truck() {
        this.setName();
        this.setType("truck");
        this.setNormalSpeed(normalSpeed);
        System.out.println(String.format("%s created with the speed : %s", this.getName(), this.getNormalSpeed()));
    }


}
