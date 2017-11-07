

public class Car {

    private int normalSpeed;// the normal speed of the car. Set to a random number in the constructor between 80-110km/h.
    private String name;

    private int carBreakCounter = 0;
    private int distanceTraveled;// holds the current distance traveled.

    public static int getSpeedLimit() {
        return Car.speedLimit;
    }

    private static int speedLimit;

    public int getDistanceTraveled(){
        return this.distanceTraveled;
    }

    public int getCarBreakCounter() {
        return this.carBreakCounter;
    }

    public String getName(){
        return this.name;
    }

    public int getNormalSpeed(){
        return this.normalSpeed;
    }

    // Call this from the Main class!
    public static void setSpeedLimit(int limit){
        Car.speedLimit=limit;
    }

    public void moveForAnHour(){
        if (RandomGenerator.carBreakDown()){
            this.carBreakCounter+=1;
            this.distanceTraveled += speedLimit;
        }else {
            this.distanceTraveled += this.normalSpeed;
        }
        // System.out.println(String.format("%s travelled : %s km ",this.name, this.distanceTraveled));

    }


    public Car(){
        this.name = RandomGenerator.randomCarName();
        this.normalSpeed = RandomGenerator.carNormalSpeed();
        System.out.println(String.format("%s created with the speed : %s",this.name, this.normalSpeed));
    }


}
