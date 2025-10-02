package com.example;
import java.util.Scanner;
import java.text.DecimalFormat; // to round the decimals. Source: ChatGPT
import java.util.ArrayList; // to store menu items. Source: https://www.w3schools.com/java/java_arraylist.asp

public class TipCalculator {
    //WRITE YOUR PROGRAM IN calculateTip
    public static String calculateTip(int people, int percent, double cost) { //You must use these  variable in your calculations
        //DO NOT DELETE ANY OF THE CODE BELOW      

        // calculations
        double tipAmount = cost * percent / 100.0;
        double totalWithTip = cost + tipAmount;
        
        double perPersonBeforeTip = cost / people;
        double perPersonTip = tipAmount / people;
        double perPersonTotal = totalWithTip / people;

        // round to 2 decimals using DecimalFormat Source: 
        DecimalFormat df = new DecimalFormat("0.00");
        
        String result = "-------------------------------\n" +
                       "Total bill before tip: $" + df.format(cost) + "\n" +
                       "Total percentage: " + percent + "%\n" +
                       "Total tip: $" + df.format(tipAmount) + "\n" +
                       "Total Bill with tip: $" + df.format(totalWithTip) + "\n" +
                       "Per person cost before tip: $" + df.format(perPersonBeforeTip) + "\n" +
                       "Tip per person: $" + df.format(perPersonTip) + "\n" +
                       "Total cost per person: $" + df.format(perPersonTotal) + "\n" +
                       "-------------------------------\n";

        return result;
    }

    public static String extraCredit(int people, int percent, double cost) {
        //String result = "Extra credit not implemented";
        //boolean condition = true;
        Scanner scan = new Scanner(System.in);
        ArrayList<String> items = new ArrayList<>();

        // ask for items
        while (true) {
            System.out.println("Enter an item name or type '-1' to finish:");
            String item = scan.nextLine();
            
            if (item.equals("-1")) {
                break; // exit loop
            } else {
                items.add(item);
            }
        }

        // first, get bill calculations
        String result = calculateTip(people, percent, cost);

        // then add items list
        result += "Items ordered:\n";
        for (String item : items) {
            result += item + "\n";
        }

        return result;
    
        //  COPY AND PASTE YOUR PROGRAM FROM calculateTip() HERE 
        
        // the while loop condition is checked,
        // and if TRUE, runs the code inside.
        // when the code inside is done running, the condition is rechecked,
        // and the loop repeats as long as the condition remains TRUE.
        // when the condition becomes FALSE, it stops

    }
    
    
     //TEST YOUR PROGRAM IN main
     public static void main(String[] args) {
        //try different values for people, percent, and cost to test your program before running test cases
        Scanner scan = new Scanner(System.in);

        //int people=10; 
        //int percent=8;
        //double cost=10.5;              
        System.out.println("How many people are there?");
        int people = scan.nextInt();
        System.out.println("What % tip will you give?");
        int percent = scan.nextInt();
        System.out.println("What is the total cost of your order?");
        double cost = scan.nextDouble();

        System.out.println(calculateTip(people,percent,cost));
        System.out.println(extraCredit(people, percent, cost));
        scan.close();

    }
}        