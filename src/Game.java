//v1.0.0
import java.util.Random;
import java.util.Scanner;
//runs with some serious bugs, to be correct in the next version v1.0.1

public class Game {
    public static void main(String[] args) {
        System.out.println("----------------A guessing game!-----------------");
        System.out.println("================Choose a level====================");
        System.out.println("=> 1. Easy: 5 attempts allowed and minimum range of 10 numbers");
        System.out.println("=> 2. Novice: 3 attempts allowed and minimum range of 30 numbers");
        System.out.println("=> 3. Legend: 1 attempts allowed and minimum range of 50 numbers");
        System.out.println("--------------------------------------------------------------------");
        int level = getLevel();
        int trials = 0;
        if(level == 1){
            trials = 5;
        }else if(level == 2){
            trials = 3;
        }else{
            trials = 1;
        }
        if(level <= 0 || level > 3){
            System.out.println("Invalid game level");
        }else {
            printLevelDetails(level);
            int [] range = getUserRange(level);
            System.out.println(range[1]);
            boolean hasWon = checkUserGuess(range[0], range[1],trials);
        }
    }
    static int guessNumber(int min, int max){
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }
    static int getUserGuess(){
        System.out.println("Enter your guess in the specified range: ");
        Scanner userGuess = new Scanner(System.in);
        return userGuess.nextInt();
    }
    static int getLevel(){
        System.out.print("Enter you level: ");
        Scanner level = new Scanner(System.in);
        return level.nextInt();
    }
    static int[] getUserRange(int level){
        System.out.println("==> Enter your range below:");
        Scanner range = new Scanner(System.in);
        System.out.print("Starting point: ");
        int firstGuess = range.nextInt();
        System.out.print("End point: ");
        int secondGuess = range.nextInt();

        int minRange = Math.min(firstGuess, secondGuess);
        int maxRange = Math.max(firstGuess, secondGuess);
        int userRange = maxRange - minRange;
        int[] errorArr = {0,0};

        switch (level){
            case 1:
                if (userRange < 9)
                    System.out.println("==> Range for easy level should be 10+");
                return errorArr;
            case 2:
                if (userRange < 19)
                    System.out.println("==> Range for novice should be 20+");
                return errorArr;
            case 3:
                if (userRange < 49)
                    System.out.println("==> Range for legend should be 50+");
                return errorArr;
            default:
                System.out.println("You loose!!");
        }

        int[] rangeArr = {minRange, maxRange};
        return rangeArr;
    }
    static void printLevelDetails(int level){

    }

    static boolean checkUserGuess(int a, int b, int trials){
        int guess = getUserGuess();
        int ans = guessNumber(a, b);
        System.out.println("Answer: " + ans);
        boolean hasWon = false;
        int attempts = 0;
        while(guess != ans && trials > 0){
            attempts++;
            trials--;
            System.out.println("==> Wrong guess");
            System.out.println("Trials remaining: " + trials);
            System.out.println("----------------------");
            guess = getUserGuess();
            ans = guessNumber(a, b);
            if(guess > ans){
                System.out.println("==> Hint: too high");
            }else{
                System.out.println("==> Hint: to low");
            }
            //trials--;
        }
        if(trials == 0){
            System.out.println("You've squandered all your trials. Off you go!");
            System.out.println("Attempts: " + attempts);
            return  hasWon;
        }else if(ans == guess){
            System.out.println("Lucky bastard! You've this round with: " + trials + " to spare");
            System.out.println("Attempts: " + attempts);
            hasWon = true;
        }
        return hasWon;
    }
}
