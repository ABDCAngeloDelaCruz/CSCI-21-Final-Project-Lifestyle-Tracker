/**
    In this program, I instantiated the LifestyleTracker object and ran everything in the main method via the console. 
    As long as it hasn't reported anything yet, it will keep on accepting commands from the console. 
    It will print the corresponding statements depending on your chosen command.

    @author Angelo B. Dela Cruz (222086)
    @version December 1, 2022
**/
/*
    I have not discussed the Java language code in my program 
    with anyone other than my instructor or the teaching assistants 
    assigned to this course.

    I have not used Java language code obtained from another student, 
    or any other unauthorized source, either modified or unmodified.

    If any Java language code or documentation used in my program 
    was obtained from another source, such as a textbook or website, 
    that has been clearly noted with a proper citation in the comments 
    of my program.
*/

import java.util.Scanner;

public class TrackerConsole {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        LifestyleTracker tracker = new LifestyleTracker();

        System.out.printf("Welcome to %s's Lifestyle Tracker!\n", args[0]);
        String command = in.next();
        String item;
        double value;

        /*
            The equalsIgnoreCase method compares two strings and ignores and case differences. 
            I'm commenting this as I don't think it was in the modules (but it was in the Java video playlist).
            Retrieved from https://docs.oracle.com/javase/7/docs/api/java/lang/String.html
        */

        while(!command.equalsIgnoreCase("Report")){
            item = in.next();
            value = in.nextDouble();

            if(command.equalsIgnoreCase("Food")){
                System.out.print(tracker.addFood(item, value));
            }
            else if (command.equalsIgnoreCase("Activity")){
                System.out.print(tracker.addActivity(item, value));
            }
            else if (command.equalsIgnoreCase("Eat")){
                System.out.print(tracker.eat(item, value));
            }
            else if (command.equalsIgnoreCase("Perform")){
                System.out.print(tracker.perform(item, value));
            }

            command = in.next();
        }

        System.out.println(tracker.report());
    }
}
