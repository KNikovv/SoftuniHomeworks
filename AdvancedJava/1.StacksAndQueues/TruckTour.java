import java.util.*;

public class TruckTour {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        ArrayDeque<Long> fuelQueue = new ArrayDeque<>();
        ArrayDeque<Long> distanceQueue = new ArrayDeque<>();
        while(n>0){
            String [] arr = sc.nextLine().split(" ");
            long fuel = Long.parseLong(arr[0]);
            long distance = Long.parseLong(arr[1]);
            fuelQueue.add(fuel);
            distanceQueue.add(distance);
            n--;
        }
        int index = 0;
        int winIndex;
        while(true){
            ArrayDeque<Long> tempFuel = fuelQueue.clone();
            ArrayDeque<Long> tempDist = distanceQueue.clone();
            long fuelLeft = 0;
            if(tempFuel.peek()>=tempDist.peek()){
                while(!tempFuel.isEmpty()){
                    fuelLeft += tempFuel.poll();
                    fuelLeft -= tempDist.poll();
                    if(fuelLeft<0){
                        reArrangeQueue(fuelQueue,distanceQueue);
                        break;
                    }
                }
            }else{
                reArrangeQueue(fuelQueue,distanceQueue);
            }

            if(tempFuel.isEmpty()){
                winIndex = index;
                break;
            }
            index++;
        }
        System.out.println(winIndex);
    }
    private static void reArrangeQueue(ArrayDeque<Long> petrolPumpQueue , ArrayDeque<Long> distanceQueue ){
        distanceQueue.addLast(distanceQueue.getFirst());
        petrolPumpQueue.addLast(petrolPumpQueue.getFirst());
        petrolPumpQueue.poll();
        distanceQueue.poll();
    }
}
