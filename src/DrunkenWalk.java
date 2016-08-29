/**
 * Created by Elias on 2016-01-17.
 */
import java.util.Scanner;
public class DrunkenWalk {
    public static void main(String[] args) {
        System.out.println();
        Scanner scan = new Scanner(System.in);
        RandomWalk rand = new RandomWalk();
        System.out.println("Ange storlek på spelplanen: ");
        try{
            int storlek = scan.nextInt();
            if(storlek > 0)
                rand.setBoardSize(storlek);
            else
                System.err.println("Invalid board size.");
        }catch(Exception e){

        }

        System.out.println("Ange max antal steg: ");

        try{
            int storlek = scan.nextInt();
            if(storlek > 0)
                rand.maxSteps = storlek;
            else
                System.err.printf("Invadlid amount of steps");
        }catch(Exception e){
            System.err.printf("Invalid size.");
        }
        System.out.println("Ange slumpvandringar: ");
        int slump = scan.nextInt();

        int safe = 0;
        int fellIn = 0;
        for(int i = 0; i < slump; i++){
            rand.walk();
            if(rand.inBounds()) {
                safe++;
            }
            else {
                fellIn++;
            }
            rand.setX(0);
            rand.setY(0);
            rand.setStepsTaken(0);

        }
        double fail = ((fellIn*1.0)/(safe*1.0));
        double percent = fail*100;
        System.out.println("Failed: " + fellIn);
        System.out.println("Safe: " + safe);
        System.out.printf("Av %d onyktra personer, föll %d ", slump, fellIn);
        if(fellIn != 0){
            System.out.printf("(%.2f", percent);
            System.out.print("%) ");
        }
        System.out.println("i vattnet.");
    }

}