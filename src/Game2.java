//Guessing game v1.0.1 fixed previous version's, v1.0.0 bugs removed beta features as well.
//Add user controlled range in future updates, as well as update views
import java.util.Random;
import java.util.Scanner;

public class Game2 {
    //a guessing game with three levels
    //show game details ==> initGame()
    //prompt user to enter a game level of their choice ==> getUserLevel()
    //check if the level is valid ==> validGameLevel()
    //display game level rules and details ==> initLevel()
    //prompt the user to guess a number ==> getUserGuess()
    //guess the correct number using Random class ==> getCorrectGuess()
    //check if the guessed number matches the correct answer
    //keep track and update the values of trials and attempts
    //return results upon winning or depletion of trials for the game level
    public static void main(String[] args) {
        //initialize the game
        initGame();

        int level = getUserLevel();

        if(validGameLevel(level)) {
            System.out.println("You entered a valid game level " + level);
            initLevel(level);
            int maxTrialsAllowed = numberOfTrials(level);
            System.out.println("level: "+ level + ", trials: " + maxTrialsAllowed);
            boolean hasWon = checkUserGuess(maxTrialsAllowed, level);

        }else{
            System.out.println("Invalid game level " + level);
        }
    }

    static void initGame(){
        System.out.println("----------------A guessing game!-----------------");
        System.out.println("================Choose a level====================");
        System.out.println("=> 1. Easy: 5 attempts allowed and minimum range of 10 numbers");
        System.out.println("=> 2. Novice: 3 attempts allowed and minimum range of 30 numbers");
        System.out.println("=> 3. Legend: 1 attempts allowed and minimum range of 50 numbers");
        System.out.println("--------------------------------------------------------------------");
    }

    //get the user level
    static int getUserLevel(){
        Scanner level = new Scanner(System.in);
        System.out.print("Choose a valid level from above: ");
        return level.nextInt();
    }

    //check if the user has given a valid game level
    static boolean validGameLevel(int level){
        //validate that level values lie between 1 and 3
        return level >= 0 && level <= 3;
    }

    static void initLevel(int level){
        int numberOfTrials = 0, minRange = 0;
        if(level == 1){
            numberOfTrials = 5;
            minRange = 10;
        }else if(level == 2){
            numberOfTrials = 3;
            minRange = 20;
        }else {
            numberOfTrials = 1;
            minRange = 50;
        }
        switch (level){
            case 1:
                System.out.println("==> You've selected the easiest level!");
                System.out.println("[-] Number of trials: " + numberOfTrials);
                System.out.println("[-] Minimum range allowed: " + minRange);
                break;
            case 2:
                System.out.println("==> You've selected a mediocre level!");
                System.out.println("[-] Number of trials: " + numberOfTrials);
                System.out.println("[-] Minimum range allowed: " + minRange);
                break;
            case 3:
                System.out.println("==> You're to overconfident noob!");
                System.out.println("[-] Number of trials: " + numberOfTrials);
                System.out.println("[-] Minimum range allowed: " + minRange);
                break;
            default:
                System.out.println("You ain't supposed to be here");
        }
    }

    //get the correct answer randomly
    static  int getCorrectGuess(int level){
        int upperBound = 0;
        Random random = new Random();
        int algorithmGuessedNumber = 0;

        switch (level){
            case 1:
                upperBound = 10;
                algorithmGuessedNumber = random.nextInt(upperBound);
                break;
            case 2:
                upperBound = 20;
                algorithmGuessedNumber =  random.nextInt(upperBound);
                break;
            case 3:
                upperBound = 50;
                algorithmGuessedNumber = random.nextInt(upperBound);
                break;
            default:
                upperBound = -1;
                algorithmGuessedNumber = -1;

        }
        System.out.println("To be removed " + algorithmGuessedNumber);
        return  algorithmGuessedNumber;
    }

    //get user guess
    static int getUserGuess(){
        Scanner user = new Scanner(System.in);
        System.out.print("Enter your guess in the specified range: ");
        return user.nextInt();
    }

    //initialize number of attempts
    static int numberOfTrials(int level){
        int numberOfTrials = 0;
        /*int numberOfAttempts = 0;*/

        switch (level){
            case 1:
                numberOfTrials = 5;
                break;
            case 2:
                numberOfTrials = 3;
                break;
            case 3:
                numberOfTrials = 1;
                break;
            default:
                numberOfTrials = -1;
        }
        return numberOfTrials;
    }

    //validate the user guess
    static boolean checkUserGuess(int maxTrials, int level){
        boolean hasWon = false;
        int attempts = 1;
        int correctGuess = getCorrectGuess(level);


        while(maxTrials != attempts){
            //do something over here
            int userGuess = getUserGuess();

            if(correctGuess == userGuess){
                hasWon = true;
                break;
            }else {
                if(userGuess > correctGuess){
                    System.out.println("Not quite, try a lower guess");
                }else {
                    System.out.println("Not quite, try a higher guess");
                }
                attempts++;
                System.out.println("trials: " + maxTrials);
                System.out.println("attempt: " + attempts);

            }
        }
        if(!hasWon)
            System.out.println("Sorry you are out of attempts, consider trying an easier level");

        if (hasWon) {
            System.out.println("Congratulations! You won after " + attempts + " attempts");
        }

        return hasWon;
    }



}

