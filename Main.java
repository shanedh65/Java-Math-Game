package com.shanes_company;
import java.util.Scanner;

import jdk.nashorn.api.tree.WhileLoopTree;


public class Main {
    private static int userInput;
    private static int attempts;

    public static void main(String[] args) {
       mMenu();
    }

    public static void mMenu(){

	// Display the main menu
        int score;
        int attempts;

        System.out.println("Difficulty Menu");
        System.out.println("1. Begineer Level");
        System.out.println("2, Medium Level");
        System.out.println("3. Advanced Level");
        System.out.println("4. Extreme Level");
        System.out.println("5. Exit");
        
        System.out.println("Please enter difficulty level: ");

        //Get the user input and set the difficulty options applicable to the difficulty level chosen.
        Scanner in = new Scanner(System.in);
        userInput = in.nextInt();

        if(userInput == 1) {
            //Beginner level, numbers between 1 and 100, 10 questions to the asked, can have 4 attempts to answer, add and substact
            //askQuestion(lowNum, highNum, questAsked, attempt,  add, subs, multi, divis);
            askQuestion(1, 100, 10, 4, 1, 1, 0, 0);
        }
        else if(userInput == 2) {
            //Medium level, numbers between 1 and 1000, 25 questions to the asked, can have 2 attempts to answer, add and substrate
            //askQuestion(lowNum, highNum, questAsked, attempt, add, subs, multi, divis);
            askQuestion(1, 1000, 25, 3, 1, 1, 0, 0);
        }

        else if(userInput == 3) {
            //Advanced level, numbers between 1 and 100000, 30 questions to the asked, can have 2 attempts to answer, add,substact, multiply and division
            //askQuestion(lowNum, highNum, questAsked, attempt, add, subs, multi, divis);
            askQuestion(1, 100000, 30, 2, 1, 1, 1, 1);
        }
        else if(userInput == 4) {
            //Exteme level, numbers between 1 and 1000000, 50 questions to the asked, can have 2 attempts to answer, add and substact
            //askQuestion(lowNum, highNum, questAsked, attempt, add, subs, multi, divis);
            askQuestion(1, 1000000, 50, 2, 1, 1, 1, 1);
        }
        
        else if (userInput == 5){
            // exit the application
            exitApp();
        }
        else
        {
            System.out.println("Error: invalid selection.");
            mMenu();
        }
    }

    public static void askQuestion(int lowNum, int highNum, int questAsked, int attempt, int add, int subs, int multi, int divis){
        //Todo:  have a randon number generated between lowNum and highNum. Radon add, subs, multi and divivde according to the difficulty level.

        int score = 0;
        attempts = 1;
        System.out.println("Question: " + attempt);

        while(attempts <= attempt){
            System.out.println("Question " + attempts);
            attempts = attempts+1;
        }
        mMenu();
    }

    public static int exitApp(){
        //exit the application.
        //Todo, warn the player the app is existing and to force to select yes or no.
        System.out.println("Exiting application, please wait...");
        return 1;
    }
}
