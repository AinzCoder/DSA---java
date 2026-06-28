
import java.util.Arrays;

public class Car_fleet {
    private static int carFleet(int target,int[] position,int[] speed){
        int n = position.length;
        double[][] cars = new double[n][2];

        // You need to keep position and time linked together
        for(int i=0;i<n;i++){
            cars[i][0]=position[i]; //position
            cars[i][1]=(double)(target - position[i])/speed[i]; //time to reach target
        }
        Arrays.sort(cars, (a,b) -> Double.compare(b[0],a[0])); //position (descending)

        // car[1]   → time taken by current car to reach target
        // prevTime → time of the last formed fleet
        // count    → number of fleets

        // If a car takes MORE time than the fleet ahead → it forms a NEW fleet
        // If it takes LESS or equal time → it joins the existing fleet
        int count=0;
        double prevTime=0;
        for(double[] car:cars){
            if(car[1]>prevTime){
                count++;
                prevTime=car[1];
            }
        }
        return count;

        // Ahead car (slow):   -----> (takes 5h)
        // Behind car (fast): -----> (takes 3h) 
        // → catches up → 1 fleet

        // Ahead car (fast):   -----> (takes 3h)
        // Behind car (slow): -----> (takes 5h)
        // → cannot catch → 2 fleets
    }
    public static void main(String[] args) {

        int target = 12;
        int[] position = {10, 8, 0, 5, 3};
        int[] speed = {2, 4, 1, 1, 3};

        int result = carFleet(target, position, speed);

        System.out.println("Number of Car Fleets: " + result);
    }
    
}
