/**
 * Created by Elias on 2016-01-17.
 */
import java.util.Random;
public class RandomWalk {
    public int X;
    public int Y;
    public int maxSteps;
    public int stepsTaken = 0;
    public int boardSize;
    public boolean isDead = false;
    public String vädersträck = "";

    public RandomWalk(){
        X = 0;
        Y = 0;
    }
    public void randomWalk(int max, int size){
        maxSteps = max;
        boardSize = size;
        Y = 0;
        X = 0;
    }

    public String toString(){
        return null;
    }
    public void setStepsTaken(int steps){
        stepsTaken = steps;
    }
    public void takeStep(){

        Random rnd = new Random();
        int tal = rnd.nextInt(4) + 1;
        if (tal == 1) {
            X++;
        }

        if (tal == 2) {
            Y++;
        }
        if (tal == 3) {
            X--;
        }
        if (tal == 4) {
            Y--;
        }
    }
    public boolean moreSteps(){
        return  stepsTaken <= maxSteps;
    }

    public boolean inBounds(){
        if(X<boardSize && Y<boardSize && X>-boardSize && Y>-boardSize)
            return true;
        else return false;
    }

    public void walk(){
        while (inBounds() && stepsTaken < maxSteps) {
            stepsTaken++;
            takeStep();
        }
    }
    public void setBoardSize(int size){
        boardSize = size;
    }
    public int getBoardSize(){
        return boardSize;
    }

    public int getX(){
        return X;
    }
    public int getY(){
        return Y;
    }
    public void setY(int y) {
        this.Y = y;
    }
    public void setX(int x) {
        this.X = x;
    }
}