import java.util.Scanner;
import java.util.Random;
import java.text.DecimalFormat;

public class MiniApps
{
    public static void main(String[] args)
    {
        java.util.Scanner input=new java.util.Scanner(System.in);
        Scanner scanner = new Scanner(System.in);
        boolean mainLoop = true;

        while (mainLoop){
            System.out.println(" ");
            System.out.println("----------------------");
            System.out.println("P4CS Mini Applications");
            System.out.println("----------------------");
            System.out.println("Please select an option:");
            System.out.println("1) Keep Counting Game");
            System.out.println("2) Square Root Calculator");
            System.out.println("3) Check-Digit Generator");
            System.out.println("4) Check-Digit Checker");
            System.out.println("9) Quit");
            System.out.println(" ");
            System.out.println("Please enter option:");

            int MainMenu=input.nextInt();//user input

            switch (MainMenu) {

//first-game---------------------------------------------------------------------------------------------------------------
                case 1 -> {
                    System.out.println(" ");
                    System.out.println("-------------");
                    System.out.println("Keep Counting");
                    System.out.println("-------------");
                    System.out.println("You will be presented with 10 addition questions.");
                    System.out.println("After the first question, the left-hand operand ");
                    System.out.println("is the result of the previous addition. ");
                    System.out.println("Press enter to start...");
                    scanner.nextLine();// press enter will start the game


                    long startTime = System.nanoTime();//this will start the timer for the game
                    Random rand = new Random();

                    int randomOne = rand.nextInt((10 - 1) + 1) + 1;//first random number
                    int randomTwo = rand.nextInt((10 - 1) + 1) + 1;//second random number
                    int AddSub = rand.nextInt((2 - 1) + 1) + 1;// random for symbol
                    int answer, UserAnswer, NextNumber, i;// defining variables

                    //this will pick if the first question is a subtraction or plus
                    if (AddSub == 1){
                        answer = randomOne + randomTwo;
                        System.out.println("Question 1: " + randomOne + " + " + randomTwo + " =");
                    }
                    else{
                        answer = randomOne - randomTwo;
                        System.out.println("Question 1: " + randomOne + " - " + randomTwo + " =");
                    }
                    UserAnswer = input.nextInt();//user input
                    NextNumber = UserAnswer;

                    //if the user enters the wrong answer the coe will end
                    if (UserAnswer != answer) {
                        System.out.println("Wrong! Correct answer:" + answer);
                        break;
                    }

                    //this will run through all 10 of the questions
                    for (i = 2; i < 11; i++) {
                        int randomTwoLoop = rand.nextInt((10 - 1) + 1) + 1;//second random number
                        int AddSubLoop = rand.nextInt((2 - 1) + 1) + 1;// random for symbol

                        if (AddSubLoop == 1) {
                            answer = NextNumber + randomTwoLoop;
                            System.out.println("Question " + i + ": " + NextNumber + " + " + randomTwoLoop + " =");
                        } else {
                            answer = NextNumber - randomTwoLoop;
                            System.out.println("Question " + i + ": " + NextNumber + " - " + randomTwoLoop + " =");
                        }

                        UserAnswer = input.nextInt();//user input
                        NextNumber = UserAnswer;

                        if (UserAnswer != answer) {
                            i = 15;
                            System.out.println("Wrong! Correct answer:" + answer);
                        }
                    }

                    //if all the question have been answered then this will pop up
                    if (i == 11) {
                        long endTime = System.nanoTime();
                        long duration = (endTime - startTime);
                        double elapsedTimeInSecond = (double) duration / 1000000000;
                        DecimalFormat formatter = new DecimalFormat("#");
                        System.out.println("congratulations! Answered all question right in: " + formatter.format(elapsedTimeInSecond) + " seconds");
                    }
                }
//second-game--------------------------------------------------------------------------------------------------------------
                case 2 -> {
                    System.out.println(" ");
                    System.out.println("----------------------");
                    System.out.println("Square Root Calculator");
                    System.out.println("----------------------");
                    System.out.println("Please enter a positive number: ");
                    int PosNum = input.nextInt();//user input

                    //check to see if it is a positive number
                    while (PosNum < 0) {
                        System.out.println("invalid Number!");
                        System.out.println("Select a positive number:");
                        PosNum = input.nextInt();//user input
                    }

                    double UBond, LBond, avgComp;//defined variables

                    //this calculates the square root by getting the upper and lower bounds
                    UBond = Math.pow(PosNum, 0.5) + ((Math.pow(PosNum, 0.5)) % 1) / 2;
                    LBond = Math.pow(PosNum, 0.5) - ((Math.pow(PosNum, 0.5)) % 1) / 2;
                    avgComp = (UBond + LBond) / 2;

                    //decimal places picker
                    System.out.println("How many decimal places do you want the ");
                    System.out.println("solution calculated to: ");
                    int DecPla = input.nextInt();//user input

                    //see if its a valid input
                    while (DecPla <= 0 || DecPla >= 8) {
                        System.out.println("invalid decimal places!");
                        System.out.println("Select from 1-7:");
                        DecPla = input.nextInt();
                    }
                    DecimalFormat formatter = null;
                    //will switch to how many decimal places the user wants
                    switch (DecPla) {
                        case 1 -> formatter = new DecimalFormat("#.#");
                        case 2 -> formatter = new DecimalFormat("#.##");
                        case 3 -> formatter = new DecimalFormat("#.###");
                        case 4 -> formatter = new DecimalFormat("#.####");
                        case 5 -> formatter = new DecimalFormat("#.#####");
                        case 6 -> formatter = new DecimalFormat("#.######");
                        case 7 -> formatter = new DecimalFormat("#.#######");
                    }
                    System.out.println("The square root of " + PosNum + " to " + DecPla + " decimal places is\n"+formatter.format(avgComp));
                }
//third-game----------------------------------------------------------------------------------------------------------------
                case 3 -> {
                    int FiveNum, ONum=0, Num1=0, Num2=0, Num3=0, Num4=0, Num5=0, Num_check, Num_checkR, Num_checkRN, Num_checkF;
                    boolean gameteLoop = false;

                    System.out.println(" ");
                    System.out.println("----------------------");
                    System.out.println("Check-Digit Calculator");
                    System.out.println("----------------------");
                    System.out.println("This calculator will take a 5-digit number");
                    System.out.println("and generate a trailing 6th check digit");
                    System.out.println("Please enter 5-digit number to generate final");
                    System.out.println("code:");

                    //this loop if the user inputs invalid
                    while (!gameteLoop){
                        FiveNum = input.nextInt();//user input
                        ONum = FiveNum;
                        Num5 = FiveNum % 10; FiveNum = FiveNum / 10;
                        Num4 = FiveNum % 10; FiveNum = FiveNum / 10;
                        Num3 = FiveNum % 10; FiveNum = FiveNum / 10;
                        Num2 = FiveNum % 10; FiveNum = FiveNum / 10;
                        Num1 = FiveNum % 10;
                        if (ONum <= 9999 || ONum >= 99999 || Num2 == 0 || Num3 == 0 || Num4 == 0 || Num5 == 0){
                            System.out.println(" ");
                            System.out.println("invalid number!");
                            System.out.println("enter 5-digit number & range of 1-9:");
                        }else{
                            gameteLoop = true;
                        }
                    }

                    //calculate to get the 6th number
                    Num_check = (7 * (Num1 + Num3 + Num5)) + (3 * (Num2 + Num4));
                    Num_checkR = Num_check / 10;
                    Num_checkRN = Num_checkR % 10;
                    if (Num_checkRN == 0) {
                        Num_checkF = 0;
                    } else {
                        Num_checkF = 10 - Num_checkRN;
                    }
                    System.out.println("The 6-digit final number is: " + ONum + Num_checkF);//outputs number
                }
//fourth-game--------------------------------------------------------------------------------------------------------------
                case 4 -> {
                    // all Variables used in game four
                    int NumChe, FNum1, FNum2, FNum3, FNum4, FNum5, FNum6, FNum_check, FNum_checkR, FNum_checkRN, FNum_checkF;
                    //start of game
                    System.out.println(" ");
                    System.out.println("-------------------");
                    System.out.println("Check-Digit Checker");
                    System.out.println("-------------------");
                    System.out.println("Please enter 6-digit number to check:");
                    NumChe = input.nextInt();//user input
                    // cuts down the number and gets the end value
                    FNum6 = NumChe % 10; NumChe = NumChe / 10;
                    FNum5 = NumChe % 10; NumChe = NumChe / 10;
                    FNum4 = NumChe % 10; NumChe = NumChe / 10;
                    FNum3 = NumChe % 10; NumChe = NumChe / 10;
                    FNum2 = NumChe % 10; NumChe = NumChe / 10;
                    FNum1 = NumChe % 10;

                    //calculate to get the 6th number
                    FNum_check = (7 * (FNum1 + FNum3 + FNum5)) + (3 * (FNum2 + FNum4));
                    FNum_checkR = FNum_check / 10;
                    FNum_checkRN = FNum_checkR % 10;
                    if (FNum_checkRN == 0) {
                        FNum_checkF = 0;
                    } else {
                        FNum_checkF = 10 - FNum_checkRN;
                    }
                    //see if the calculated 6th number is the same as the user input
                    if (FNum_checkF == FNum6) {
                        System.out.println("The number is valid!");
                    } else {
                        System.out.println("The number is invalid!");
                    }
                }
 /*
 Game 4 test table - Testing my code and seeing if I get the outcome I want
 ____________________________________________________________________
|     inputs     |     expected outputs     |     actual outputs     |
|----------------|--------------------------|------------------------|
|    435234      | The number is invalid!   | The number is invalid! |
|    234351      | The number is valid!     | The number is valid!   | - checked with game three
|    345321      | The number is valid!     | The number is invalid! | - maths error
|    123452      | The number is valid!     | The number is valid!   | - checked with game three
|      21        | The number is invalid!   | The number is invalid! | - int too short
\____________________________________________________________________/

 */
//exit-game----------------------------------------------------------------------------------------------------------------
                case 9 -> {
                    System.out.println("-------------------------");
                    System.out.println("---EXITING APPLICATION---");
                    System.out.println("-------------------------");
                    //ends the loop
                    mainLoop = false;
                }
                // if user inputs an invalid number
                default -> System.out.println("Invalid input! Select another input");
            }
        }
    }
}