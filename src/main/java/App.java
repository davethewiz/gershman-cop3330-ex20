/*
 *  UCF COP3330 Fall 2021 Assignment 1 Solution
 *  Copyright 2021 Dave Gershman
 */

public class App
{
    public static double GetTaxRate(String state, String county) {
        double taxRate = 0;

        if (state.equals("wisconsin")) {
            taxRate = 0.05;

            if (county.equals("eau clair"))
                taxRate += 0.005;

            if (county.equals("dunn"))
                taxRate += 0.004;
        }

        if (state.equals("illinois"))
            taxRate = 0.08;

        return taxRate;
    }

    public static void main( String[] args )
    {
        double orderAmount = Input.GetDouble("What is the order amount? ");
        String state = Input.GetString("What state do you live in? ").toLowerCase();
        String county = Input.GetString("What county do you live in? ").toLowerCase();

        double total = orderAmount;

        String output = "";

        double taxRate = GetTaxRate(state, county);

        if (taxRate > 0) {
            double tax = orderAmount * taxRate;
            tax = Math.round(tax * 100) / 100d;
            output += String.format("The tax is $%.2f.\n", tax);

            total += tax;
        }

        total = Math.round(total * 100) / 100d;
        output += String.format("The total is $%.2f.", total);

        System.out.print(output);
    }
}