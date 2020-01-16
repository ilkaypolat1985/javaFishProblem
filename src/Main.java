import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        
        int[] weights1 = {4, 8, 2, 6, 7};
        int[] directions1 = {0, 1, 1, 0, 0};
        System.out.println("1. Survived Fishes : " + solution(weights1, directions1));

        int[] weights2 = {4, 3, 2, 1, 5};
        int[] directions2 = {0, 1, 0, 0, 0};
        System.out.println("2. Survived Fishes : " + solution(weights2, directions2));

    }

    public static int solution(int[] weights, int[] directions){

        Stack<Integer> rightDirectionFishes = new Stack<>();
        int leftSurvivedFishesCount = 0;

        int lastDirection = -1;
        for(int i = 0; i < weights.length; i++){
            int weight = weights[i];

            if(directions[i] == 1)
                rightDirectionFishes.push(weight);
            else{
                if(rightDirectionFishes.isEmpty())
                    leftSurvivedFishesCount++;
                else{
                    while(rightDirectionFishes.peek() < weight)
                    {
                        rightDirectionFishes.pop();
                        if(rightDirectionFishes.isEmpty()){
                            leftSurvivedFishesCount++;
                            break;
                        }
                    }

                }
            }
        }

        return leftSurvivedFishesCount + rightDirectionFishes.size();
    }

    public static boolean isDirectionMatched(int leftFishDirection, int rightFishDirection){
        if(leftFishDirection == 1 && rightFishDirection == 0)
            return true;
        else
            return false;
    }
}
