import java.util.ArrayList;
import java.util.List;

public class Truck extends Vehicle {

    private int breakdownCounter = 0;
    static List<String> truckNames = new ArrayList<>();
    private int breakdownTurnsLeft = 0;


    public void increaseBreakdownCounter() {
        this.breakdownCounter += 1;
    }

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

    public void moveForAnHour() {
        if (this.getBreakdownTurnsLeft() == 0) {
            if (!(RandomGenerator.truckBreakdown())) {
                this.setDistanceTraveled(this.getDistanceTraveled() + this.getNormalSpeed());
            } else {
                this.setBreakdownTurnsLeft(2);
                this.increaseBreakdownCounter();
            }
        } else {
            this.breakdownTurnsLeft--;
        }
    }

    public Truck() {
        this.setName();
        this.setNormalSpeed(100);
        System.out.println(String.format("%s truck has been created", this.getName()));
    }


}
