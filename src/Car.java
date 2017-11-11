

public class Car extends Vehicle {
    private static int speedLimit;

    public static int getSpeedLimit() {
        return Car.speedLimit;
    }


    public static void setSpeedLimit(int limit) {
        Car.speedLimit = limit;
    }
    //TODO When is THIS necessary?
    public void moveForAnHour() {
        if (RandomGenerator.carBreakDown()) {
            this.setDistanceTraveled(this.getDistanceTraveled() + speedLimit);
        } else {
            this.setDistanceTraveled(this.getDistanceTraveled() + getNormalSpeed());
        }
    }

    public Car() {
        this.setType("car");
        this.setName(RandomGenerator.randomCarName());
        this.setNormalSpeed(RandomGenerator.carNormalSpeed());
        System.out.println(String.format("%s created with the speed : %s", this.getName(), this.getNormalSpeed()));
    }


}
