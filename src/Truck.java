
import java.util.ArrayList;
import java.util.List;

// speed: 100km/h. 5% chance of breaking down for 2 hours.
public class Truck extends Vehicle {


    private int breakdownCounter = 0;
    static List<String> truckNames = new ArrayList<>();
    // Truck drivers are boring. They call all their trucks a random number between 0 and 1000.
    private int breakdownTurnsLeft = 0; // holds how long its still broken down.



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



    public void setName(){
        int randomNameNumber;
        do {
            randomNameNumber = RandomGenerator.randomTruckName();
        }while (truckNames.contains(String.valueOf(randomNameNumber)));

        this.setName(String.valueOf(randomNameNumber));
        truckNames.add(this.getName());
    }



    public void moveForAnHour(){
        if (this.getBreakdownTurnsLeft()==0){
            if (!(RandomGenerator.truckBreakdown())){
                this.setDistanceTraveled(this.getDistanceTraveled()+this.getNormalSpeed());
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
        this.setNormalSpeed(100);
        System.out.println(String.format("%s truck has been created",this.getName()));
    }


}
