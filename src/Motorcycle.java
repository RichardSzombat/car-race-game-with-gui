

// speed is 100km/h. If rains, travels with 5-50km/h slower (randomly).
public class Motorcycle {
    private int rainCounter = 0;

    public static void setNameNumber(int nameNumber) {
        Motorcycle.nameNumber = nameNumber;
    }

    private static int nameNumber=1; // The number of the instance created. Used for its name. increase it when const called
    private String name; // Are called "Motorcycle 1", "Motorcycle 2", "Motorcycle 3",... Unique.
    private int normalSpeed = 100;
    private int distanceTraveled;

    public int getRainCounter(){
        return this.rainCounter;
    }

    public void increaseRainCounter(){
        this.rainCounter += 1;
    }

    public int getDistanceTraveled(){
        return this.distanceTraveled;
    }

    public String getName(){
        return this.name;
    }

    public Motorcycle(){
        this.setName();
    }

    public void setName(){
        this.name = "Motorcycle "+String.valueOf(Motorcycle.nameNumber);
        Motorcycle.nameNumber++;
    }

    public void moveForAnHour(){
        if (Race.isRaining){
            this.increaseRainCounter();
            this.distanceTraveled += this.normalSpeed-RandomGenerator.decreaseMotoSpeed();

        }else {
            this.distanceTraveled += this.normalSpeed;
        }

    }


}
