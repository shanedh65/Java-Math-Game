//Program developed by Shane De-Hayr
//Must install java version 11.
//imports
import java.util.Scanner;
import java.util.Random;

//Todo:  Save function so the player can see how many games they have played and how many questions they have answered.
//Todo:  Have a timer so the player needs to answer the question within a time limit


public class MathQuiz {
    private static int isRunning;
    private static int score;
    private static String userName;

    public static void main(String [] args){
        System.out.println("Hello Welcome to Math Quiz... Please enter your name: ");
        Scanner in = new Scanner(System.in);
        userName = in.nextLine();
        mainMenu(userName);
    }

    public static void mainMenu(String userName){
        int userInput, maxVal, questAsked, diffLevel;
        while (isRunning == 0) {
            //Display the main menu
            System.out.println("Welcome " + userName + " to Math Game");
            System.out.println("1. Add");
            System.out.println("2. Minus");
            System.out.println("3. Multiply");
            System.out.println("4. Divide");
            System.out.println("5. Add and Minus");
            System.out.println("6. Multiply and Divide");
            System.out.println("7. Add, Minus, Multiply, Divide");
            System.out.println("8. Exit");
            System.out.println("Please select difficulty level: ");
            Scanner in = new Scanner(System.in);
            //Test for valid input. If no number then display the menu again.
            if (!in.hasNextInt()) {
                System.out.println("Please enter only a valid number between 1 and 8.");
                System.out.println("Enter a number higher then 8 will exit the application.");
                String badInfo = in.nextLine();
                mainMenu(userName);
            }
            userInput = in.nextInt();

            if (userInput == 1) {
                questAsked = getQuestNum();
                maxVal = getHighNum(); //include numbers upto
                diffLevel = 1;  //add
                score = questGenerator(userName, maxVal, questAsked, diffLevel);
            } else if (userInput == 2) {
                questAsked = getQuestNum();
                maxVal = getHighNum();
                diffLevel = 2; //minus
                score = questGenerator(userName, maxVal, questAsked, diffLevel);
            } else if (userInput == 3) {
                questAsked = getQuestNum();
                maxVal = getHighNum(); //include numbers upto
                diffLevel = 3; //multiply questions
                score = questGenerator(userName, maxVal, questAsked, diffLevel);
            } else if (userInput == 4) {
                questAsked = getQuestNum();
                maxVal = getHighNum(); //include numbers upto
                diffLevel = 4; //divide questions
                score = questGenerator(userName, maxVal, questAsked, diffLevel);
            } else if (userInput == 5) {
                questAsked = getQuestNum();
                maxVal = getHighNum(); //include numbers upto
                diffLevel = 5;  //Add and minus questions
                score = questGenerator(userName, maxVal, questAsked, diffLevel);
            } else if (userInput == 6) {
                questAsked = getQuestNum();
                maxVal = getHighNum(); //include numbers upto
                diffLevel = 6; // multiply and divide questions
                score = questGenerator(userName, maxVal, questAsked, diffLevel);
            } else if (userInput == 7) {
                questAsked = getQuestNum();
                maxVal = getHighNum(); //include numbers upto
                diffLevel = 7;   // add, minus, multiply and divide questions
                score = questGenerator(userName, maxVal, questAsked, diffLevel);
            } else {
                //Exit application
                exitApp(userName);
            }
        }
    }

    public static int getQuestNum() {
        Scanner in = new Scanner(System.in);
        System.out.println("How many questions do you want to answer: ");
        //Test for valid input. If none, return to main menu.
        if (!in.hasNextInt()) {
            System.out.println("Please enter a valid number.");
            mainMenu(userName);
        }
        int userInput = in.nextInt();
        return userInput;
    }

    public static int getHighNum(){
        Scanner in = new Scanner(System.in);
        System.out.println("Please enter how high numbers you want to use for your questions: ");
        //Test for valid input. If none, return to main menu.
        if (!in.hasNextInt()) {
            System.out.println("Please enter a valid number.");
            mainMenu(userName);
        }
        int userInput;
        userInput = in.nextInt();
        return userInput;
    }

    public static int questGenerator(String userName, int maxVal, int questAsked, int diffLevel){
        int num1, num2, num3, question, ans, score, corrAns;
        question = 1;
        ans = 0;
        score = 0;
        System.out.println("You need to answer: " + questAsked + " questions.");
        while (question<questAsked + 1) {
            Random randomnum = new Random();
            num1 = randomnum.nextInt(maxVal);
            num2 = randomnum.nextInt(maxVal);

            if(diffLevel == 1){
                ans = ansPlus(num1, num2);
            }
            else if(diffLevel == 2){
                if (num1<num2){
                    //Switch numbers to avoid a negative
                    ans = ansMinus(num2, num1);
                } else {
                    ans = ansMinus(num1, num2);
                }
            }
            else if(diffLevel == 3){
                ans = ansMultiply(num1, num2);
            }
            else if(diffLevel == 4){
                if (num1<num2){
                    //Switch numbers to avoid a negative
                    ans = ansDivide(num2, num1);
                } else {
                    ans = ansDivide(num1, num2);
                }
            }
            else if(diffLevel == 5){ //add and minus
                num3 = randomnum.nextInt(10);
                if(num3 <5){
                    ans = ansPlus(num1, num2);
                }
                else if(num3<10){
                    if (num1<num2){
                        //Switch numbers to avoid a negative
                        ans = ansMinus(num2, num1);
                    } else {
                        ans = ansMinus(num1, num2);
                    }
                }
            }
            else if(diffLevel == 6){ //add and minus
                num3 = randomnum.nextInt(10);
                if(num3 <5){
                    ans = ansMultiply(num1, num2);
                }
                else if(num3<10){
                    if (num1<num2){
                        //Switch numbers to avoid a negative
                        ans = ansDivide(num2, num1);
                    } else {
                        ans = ansDivide(num1, num2);
                    }
                }
            }
            else if(diffLevel == 7){ //add, minus, mutliply and divide
                num3 = randomnum.nextInt(20);
                if(num3 <5){
                    ans = ansPlus(num1, num2);
                }
                else if(num3<10){
                    if (num1<num2){
                        //Switch numbers to avoid a negative
                        ans = ansMinus(num2, num1);
                    } else {
                        ans = ansMinus(num1, num2);
                    }
                }
                else if(num3<15){
                    ans = ansMultiply(num1, num2);
                }
                else if(num3<20) {
                    if (num1 < num2) {
                        //Switch numbers to avoid a negative
                        ans = ansDivide(num2, num1);
                    } else {
                        ans = ansDivide(num1, num2);
                    }
                }
            }

            corrAns = askAnswer(num1, num2, ans);
            if (corrAns == 0) {
                question = question + 1; //increase questions asked by 1
                System.out.println("You have failed that question. The correct answer is " + ans + ". Your score is " + score + ".");
            }
            if (corrAns == 1) {
                score = score + 1;  //increse score by 1
                question = question + 1; //increse questions asked by 1
                System.out.println("You answered that question correctly, your current score is " + score);
            }
        }
        if (score == questAsked){
            System.out.println(userName + ", you did an excellent job, answering " + score + " out of " + questAsked);
            return score;
        }
        return score;
    }

    public static int ansPlus(int num1, int num2){
        int ans;
        System.out.println("Question is " + num1 + " + " + num2 + " = ");
        ans = num1 + num2;
        return ans;
    }

    public static int ansMinus(int num1, int num2){
        int ans;
        System.out.println("Question is " + num1 + " - " + num2 + " = ");
        ans = num1 - num2;
        return ans;
    }
    public static int ansMultiply(int num1, int num2){
        int ans;
        System.out.println("Question is " + num1 + " * " + num2 + " = ");
        ans = num1 * num2;
        return ans;
    }

    public static int ansDivide(int num1, int num2){
        int ans;
        System.out.println("Question is " + num1 + " / " + num2 + " = ");
        ans = num1 / num2;
        return ans;
    }

    public static int askAnswer(int num1, int num2, int ans){
        //Todo: Should answer each qestion including -, * and /
        //Todo: check if the input is a number, if not, return a incorrect answer.
        Scanner in = new Scanner(System.in);
        if (!in.hasNextInt()) {
            System.out.println("You have entered invalid input. To avoid this enter only numbers.");
            String userInput;
            userInput = in.nextLine(); //read and discard data in the scanner input
            return 0; //return a incorrect answer
        }
        int userInput;
        userInput = in.nextInt();

        if(userInput == ans){
            return 1; //Correct answer
        }
        else{
            return 0; //Incorrect answer
        }
    }

    public static void exitApp(String userName) {
        //exit the app
        isRunning = 10;
        System.out.println("Thank you for playing, " + userName + ". Exiting the application, have a nice day.");
    }
}
