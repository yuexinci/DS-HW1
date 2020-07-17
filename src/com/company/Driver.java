package com.company;

import java.util.Scanner;
import java.util.Random;


public class Driver {

    public static void main(String[] args) {

        Driver me = new Driver();
        me.numGenerator();
    }

    private void numGenerator() {
        Scanner kbd = new Scanner(System.in);
        Random r = new Random();
        boolean done = false;
        int count = 0;

        //generate and set random number
        int random = r.nextInt(1000) + 1;

        System.out.println("I am thinking of an integer between 1 and 1000...");

        while (!done) {
            System.out.println("Please guess an integer between 1 and 1000");
            int guess;

            //get input and check formatting
            try {
                guess = kbd.nextInt();
            }
            //bad formatting
            catch (java.util.InputMismatchException e) { //bad formatting
                System.out.println("Invalid input");
                kbd.nextLine(); //"flush" buffer for next loop iteration
                continue;
            }
            if (guess > 1000 || guess < 1) { //out of range
                System.out.println("Invalid input");
                kbd.nextLine();
                continue;
            }
            done = comparison(guess, random, done);
            count++;
        }
        System.out.println("You took " + count + " tries to guess the right number. Thank you for playing!");
    }

    //method to compare user guess to the random number generated
    private boolean comparison(int guess, int random, boolean done) {
        if (guess == random) { //good guess
            System.out.println("Correct!");
            done = true;
        }
        if (guess < random) {
            System.out.println("Incorrect, too low!");
        }
        if (guess > random) {
            System.out.println("Incorrect, too high!");
        }
        return done;
    }
}
