package com.example;
import java.util.Scanner;
import java.text.DecimalFormat; // to round the decimals. i learned about DecimalFormat from Google, and asking ChatGPT
import java.util.ArrayList; // to store menu items. I learned about ArrayList from here: https://www.w3schools.com/java/java_arraylist.asp

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

        // round to 2 decimals using DecimalFormat 
        DecimalFormat df = new DecimalFormat("0.00"); //Source: https://jenkov.com/tutorials/java-internationalization/decimalformat.html talks about how to use DecimalFormat in more depth.
        // the format() function comes with the class DecimalFormat.
        // the "0.00" means to always show 2 decimal places.
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
        Scanner scan = new Scanner(System.in);
        ArrayList<String> items = new ArrayList<>(); // I learned how to use ArrayLists from https://codehs.com/tutorial/evelyn/arraylists-in-java and https://www.w3schools.com/java/java_arraylist.asp

        // ask for items
        while (true) {
            System.out.println("Enter an item name or type '-1' to finish:");
            String item = scan.nextLine();
            
            if (item.equals("-1")) { // I used https://www.w3schools.com/java/ref_string_equals.asp to help me figure out the method ".equals()"
                break; // exit loop
            } else {
                items.add(item);
            }
        }

        // first, get bill calculations
        String result = calculateTip(people, percent, cost);

        // then add items list
        result += "Items ordered:\n";
        for (String item : items) { //this is basically a for loop, I got help on doing this from https://www.w3schools.com/java/java_ref_string.asp
            result += item + "\n";
        }

        return result;

    }
     //TEST YOUR PROGRAM IN main
     public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
             
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