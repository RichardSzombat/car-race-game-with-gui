

// speed is 100km/h. If rains, travels with 5-50km/h slower (randomly).
public class Motorcycle extends Vehicle {
    private int rainCounter = 0;
    private static int nameNumber=1;


    public static void setNameNumber(int nameNumber) {
        Motorcycle.nameNumber = nameNumber;
    }

    public int getRainCounter(){
        return this.rainCounter;
    }

    public void increaseRainCounter(){
        this.rainCounter += 1;
    }

    public Motorcycle(){
        this.setNormalSpeed(100);
        this.setName();
    }

    public void setName(){
        this.setName("Motorcycle "+String.valueOf(Motorcycle.nameNumber));
        Motorcycle.nameNumber++;
    }

    public void moveForAnHour(){
        if (Race.isRaining){
            this.increaseRainCounter();
            this.setDistanceTraveled(this.getDistanceTraveled()+this.getNormalSpeed()-RandomGenerator.decreaseMotoSpeed());

        }else {
            setDistanceTraveled(this.getDistanceTraveled() + this.getNormalSpeed());
        }
    }
}
