package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // START FASE 1

            // Variable's declaration FASE 1

        int FiveEur = 5;
        int TenEur = 10;
        int TwentyEur = 20;
        int FivetyEur = 50;
        int HundredEur = 100;
        int TwoHunEur = 200;
        int FiveHunEur = 500;

        int TotalPriceMenu = 0;

        String[] Menu = new String[5];
        Integer[] Prices = new Integer[5];

        // END FASE 1

        // START FASE 2 AND 3

        // Variable's declaration FASE 2 AND 3

        System.out.println();
        System.out.println("Welcome to JavaEat Restaurant!");
        System.out.println("Before to start, we made the menu.");

        Scanner CreateMenuQuestion = new Scanner(System.in);
        Scanner CreatePriceQuestion = new Scanner(System.in);
        Scanner MenuQuestion = new Scanner(System.in);

        int MaxCounter = 0;
        int count = 0;

        String UserContinue;
        String UserResponse;

        ArrayList Order = new ArrayList<String>();
        List WrongOrder = new ArrayList<String>();

            // Menu Questions - START and adding answers to Strings[];

        label:
        while (MaxCounter < 5) {
            for (int e = 0; e < Menu.length; e++) {
                if (MaxCounter == 0) {
                    System.out.println("Put into the first plate and her price(after the enter): ");
                    Menu[e] = CreateMenuQuestion.nextLine();
                    Prices[e] = Integer.parseInt(CreatePriceQuestion.nextLine());
                    MaxCounter++;
                } else if (MaxCounter >= 1 && MaxCounter < 4) {
                    System.out.println("Put the next one and her price(after the enter): ");
                    Menu[e] = CreateMenuQuestion.nextLine();
                    Prices[e] = Integer.parseInt(CreatePriceQuestion.nextLine());
                    MaxCounter++;
                } else {
                    System.out.println("Put the last one and her price(after del enter): ");
                    Menu[e] = CreateMenuQuestion.nextLine();
                    Prices[e] = Integer.parseInt(CreatePriceQuestion.nextLine());
                    break label;
                }
            }
        }
            // Menu Questions - END

            // Show Array[] Menu via console

        System.out.println();
        System.out.println("Here we have the menu with the prices respectively ");
        System.out.println();;

        for(int e = 0; e < Menu.length; e++){
            for(int i = 0; i < Prices.length; i++){
                if(e == i){
                    System.out.println( Menu[e] + "........." + Prices[e] + "€, ");
                }
            }
        }

            // Round of Orders - START
                //The first question, determines your intention, if you want eat or heat a seat.
                // In while, determines the questions of Yes/No, and what do you want more eat.
                // Finally sums all prices accord with your order/selection in a external scope variable.

        System.out.println("What do you want for starter to eat?");
        UserResponse = MenuQuestion.nextLine();

        if (UserResponse.equals("")) {
            System.out.println("So what are you going in for ?! ?! GTFO!!!");
            return;
        } else {
            Order.add(UserResponse);
            count++;
        }

        label:
        while (true){
            System.out.println("Do you want to ask for something more? (answer yes or no)");
            UserContinue = MenuQuestion.nextLine();
            if(UserContinue.matches(".*\\d.*")){
                System.out.println("You have to say yes or no!");
                continue;
            }
            switch (UserContinue) {
                case "Yes": case "YES": case "yes": case "yEs": case "yeS": case "yES": case "YEs": case "YeS":
                    if(count >= 1 && count < 4){
                        System.out.println("What do you want more for eat?");
                        UserResponse = MenuQuestion.nextLine();
                        Order.add(UserResponse);
                        count++;
                        continue;
                    } else if (count == 4){
                        System.out.println("For last one?");
                        UserResponse = MenuQuestion.nextLine();
                        Order.add(UserResponse);
                        break label;
                    } else {
                        System.out.println("Error Switch IF/ELSE IF/ELSE");
                        break label;
                    }
                case "No": case "no": case "nO": case "NO":
                    break label;
                case "":
                    System.out.println("You have to say yes or no!");
                    break;
                default:
                    System.out.println("Error read input in loop While, breaking loop...");
                    break label;
            }
        }
        if (Order.equals("")) {
            System.out.println("There is nothing written in the order!");
        } else {
            System.out.println("Very well, let's see...");
            System.out.print("You have ordered: ");
            for(Object c : Order){
                System.out.print(c + ", ");
            }
            for(int i = 0; i < Menu.length; i++){
                for(Object o : Order){
                    if(Menu[i].equals(o)){
                        TotalPriceMenu += Prices[i];
                    } else {
                        WrongOrder.add(o);
                    }
                }
            }
            // Round of Orders - END

            // Showing Total and Alternatives - START
            System.out.println(" and the final price of all is: " + TotalPriceMenu + "€");
            System.out.println();
            System.out.println("The wrong orders are this: " + WrongOrder);
            System.out.println();
            if(TotalPriceMenu < 10) {
                System.out.println("It will be better to pay with: " + FiveEur + "€");
            } else if(TotalPriceMenu >= 10 && TotalPriceMenu <= 40){
                System.out.println("It will be better to pay with: " + FiveEur + ", " + TenEur  + ", "+  "and/o " + TwentyEur + "€");
            } else if(TotalPriceMenu >= 50 && TotalPriceMenu <= 100) {
                System.out.println("It will be better to pay with: " + TwentyEur + ", " + FivetyEur  + ", "+  "and/o " + HundredEur + "€");
            } else {
                System.out.println("It will be better to pay with: " + FivetyEur + ", "+ HundredEur + ", " + TwoHunEur  + ", "+  "and/o " + FiveHunEur + "€");
            }
        }
            //Round of Orders - END

        // END FASE 2 AND 3
    }
}
