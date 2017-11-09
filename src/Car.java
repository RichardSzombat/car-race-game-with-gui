

public class Car extends Vehicle {

    private int carBreakCounter = 0;
    public static int getSpeedLimit() {
        return Car.speedLimit;
    }
    private static int speedLimit;
    public int getCarBreakCounter() {
        return this.carBreakCounter;
    }


    public static void setSpeedLimit(int limit) {
        Car.speedLimit = limit;
    }

    public void moveForAnHour() {
        if (RandomGenerator.carBreakDown()) {
            this.carBreakCounter += 1;
            this.setDistanceTraveled(this.getDistanceTraveled() + speedLimit);
        } else {
            this.setDistanceTraveled(this.getDistanceTraveled() + getNormalSpeed());
        }
    }

    public Car() {
        this.setName(RandomGenerator.randomCarName());
        this.setNormalSpeed(RandomGenerator.carNormalSpeed());
        System.out.println(String.format("%s created with the speed : %s", this.getName(), this.getNormalSpeed()));
    }


}
