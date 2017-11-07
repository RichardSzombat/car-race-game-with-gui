

import java.util.Random;

public class RandomGenerator {

    static int decreaseMotoSpeed(){
        return new Random().nextInt(45)+5;
    }

    static void isRaining(){
        int raining = new Random().nextInt(100)+1;
        Race.isRaining = raining <= 30;
    }
    //TODO can a truck stack its breakdown ?
    static boolean truckBreakdown(){
        int breakdown = new Random().nextInt(100)+1;
        return breakdown < 6;

    }

    static boolean carBreakDown(){
        int carBreakDown = new Random().nextInt(100)+1;
        return carBreakDown <= 35;
    }


    static int carNormalSpeed(){

        return new Random().nextInt(30)+80;
    }

    static int randomTruckName(){
        return new Random().nextInt(1000)+1;
    }

    static String randomCarName(){

        int firstName ;
        int lastName;
        String[] carNames = new String[]{"Celestial","Desire","Crusader","Pyre","Parallel","Behemoth","Blast",
                "Union","Lightning","Starlight" };
        do {
            firstName = new Random().nextInt(carNames.length);
            lastName = new Random().nextInt(carNames.length);

        }while (firstName==lastName);

        return String.format("%s %s", carNames[firstName], carNames[lastName]);











    }
}
