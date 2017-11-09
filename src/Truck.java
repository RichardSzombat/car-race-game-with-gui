
import java.util.ArrayList;
import java.util.List;

// speed: 100km/h. 5% chance of breaking down for 2 hours.
public class Truck {
    private int distanceTraveled;
    private int normalSpeed = 100;
    private String name;
    private int breakdownCounter = 0;
    static List<String> truckNames = new ArrayList<>();
    // Truck drivers are boring. They call all their trucks a random number between 0 and 1000.
    private int breakdownTurnsLeft = 0; // holds how long its still broken down.

    public int getDistanceTraveled(){
        return this.distanceTraveled;
    }

    public int getBreakdownCounter() {
        return breakdownCounter;
    }

    public void increaseBreakdownCounter() {
        this.breakdownCounter += 1;
    }

    public int getBreakdownTurnsLeft(){
        return this.breakdownTurnsLeft;
    }

    public void setBreakdownTurnsLeft(int breakdownHours){
        this.breakdownTurnsLeft = breakdownHours;
    }

    public String getTruckName(){
        return this.name;
    }

    public void setName(){
        int randomNameNumber;
        do {
            randomNameNumber = RandomGenerator.randomTruckName();
        }while (truckNames.contains(String.valueOf(randomNameNumber)));

        this.name = String.valueOf(randomNameNumber);
        truckNames.add(this.name);
    }



    public void moveForAnHour(){
        if (this.getBreakdownTurnsLeft()==0){
            if (!(RandomGenerator.truckBreakdown())){
                this.distanceTraveled += this.normalSpeed;
            }else{
                this.setBreakdownTurnsLeft(2);
                this.increaseBreakdownCounter();
            }
        }else{
            this.breakdownTurnsLeft--;
        }

    }

    public Truck(){
        this.setName();
        System.out.println(String.format("%s truck has been created",this.getTruckName()));
    }


}
