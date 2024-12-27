/**
    In this program, I created a class for instantiating an object called LifestyleTracker, wherein it contains 
    an array list of foods and activities and their corresponding calorie amount, number of servings or hours done. 
    Using its methods, we can get add new Food or Activities to the tracker, or we can update their calorie amount too.
    We can also eat Food or perform an Activity. It gives a report of the activities you did and the food you ate for a certain day.
    This tracker will calculate our net calorie intake for the day and will estimate your weight 
    gain or loss in the future, all others remaining constant. As you can see, I did not do any add-ons for this.

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

import java.util.*;

public class LifestyleTracker {
    private ArrayList<Food> FoodList;
    private ArrayList<Activity> ActivityList;
    private ArrayList<String> FoodEaten;
    private ArrayList<Double> FoodServings;
    private ArrayList<Double> FoodCalories;
    private ArrayList<String> ActivityPerformed;
    private ArrayList<Double> ActivityHours;
    private ArrayList<Double> ActivityCalories;
    private double caloriesConsumed;
    private double caloriesBurned;
    
    public LifestyleTracker(){
        FoodList = new ArrayList<Food>();
        ActivityList = new ArrayList<Activity>();
        FoodEaten = new ArrayList<String>();
        FoodServings = new ArrayList<Double>();
        FoodCalories = new ArrayList<Double>();
        ActivityPerformed = new ArrayList<String>();
        ActivityHours = new ArrayList<Double>();
        ActivityCalories = new ArrayList<Double>();
        caloriesConsumed = 0;
        caloriesBurned = 0;
    }

    /*
        Similar to printf, the format method returns a formatted string in accordance with its chosen
        format and arguments. I'm commenting this as I don't think it was discussed in class.
        Retrieved from https://docs.oracle.com/javase/8/docs/api/java/util/Formatter.html
    */
    /*
        The equalsIgnoreCase method compares two strings and ignores and case differences. 
        I'm commenting this as I don't think it was in the modules (but it was in the Java video playlist).
        Retrieved from https://docs.oracle.com/javase/7/docs/api/java/lang/String.html
    */

    public String addFood(String n, double c){
        for (int foodCounter = 0; foodCounter<FoodList.size(); foodCounter++){
            if (FoodList.get(foodCounter).getFoodName().equalsIgnoreCase(n)){
                FoodList.get(foodCounter).updateCalories(c);

                return String.format("Updated Food %s with %.2f kcal\n", n, c);
            }
        }

        FoodList.add(new Food(n, c));
        return String.format("Added Food %s with %.2f kcal\n", n, c);
    }

    public String addActivity(String n, double c){
        for (int activityCounter = 0; activityCounter<ActivityList.size(); activityCounter++){
            if (ActivityList.get(activityCounter).getActivityName().equalsIgnoreCase(n)){
                ActivityList.get(activityCounter).updateCalories(c);

                return String.format("Updated Activity %s with %.2f kcal\n", n, c);
            }
        }

        ActivityList.add(new Activity(n, c));
        return String.format("Added Activity %s with %.2f kcal\n", n, c);
    }

    public String eat(String foodName, double servings){
        if (servings<0){
            return "Number of servings cannot be negative.\n";
        }
        
        for (int foodCounter = 0; foodCounter<FoodList.size(); foodCounter++){
            if (FoodList.get(foodCounter).getFoodName().equalsIgnoreCase(foodName)){
                FoodEaten.add(foodName);
                FoodServings.add(servings);
                double subTotalCal = servings*FoodList.get(foodCounter).getFoodCalories();
                FoodCalories.add(subTotalCal);
                caloriesConsumed += subTotalCal;

                return String.format("Ate %.2f serving(s) of %s, %.2f kcal\n", servings, foodName, subTotalCal);
            }
        }

        return "The specified food does not exist.\n";
    }

    public String perform(String actName, double hours){
        if (hours<0){
            return "Number of hours cannot be negative\n";
        }
        
        for (int activityCounter = 0; activityCounter<ActivityList.size(); activityCounter++){
            if (ActivityList.get(activityCounter).getActivityName().equalsIgnoreCase(actName)){
                ActivityPerformed.add(actName);
                ActivityHours.add(hours);
                double subTotalCal = hours*ActivityList.get(activityCounter).getActivityCalories();
                ActivityCalories.add(subTotalCal);
                caloriesBurned += subTotalCal;

                return String.format("Performed %.2f hour(s) of %s, %.2f kcal\n", hours, actName, subTotalCal);
            }
        }

        return "The specified activity does not exist.\n";
    }

    public String report(){
        String reportString = "";
        double netCalories = caloriesConsumed - caloriesBurned;
        reportString += "----------------\nLIFESTYLE REPORT\n----------------\n";
        reportString += "Food Consumed:\n";
        for (int i=0; i<FoodEaten.size(); i++){
            reportString += String.format("%.2f serving(s) of %s, %.2f kcal\n", FoodServings.get(i), FoodEaten.get(i), FoodCalories.get(i));
        }
        reportString += "----------------\n";
        reportString += String.format("Total Calories Consumed: %.2f kcal\n", caloriesConsumed);
        reportString += "----------------\n";
        reportString += "Activities Performed:\n";
        for (int i=0; i<ActivityPerformed.size(); i++){
            reportString += String.format("%.2f hour(s) of %s, %.2f kcal\n", ActivityHours.get(i), ActivityPerformed.get(i), ActivityCalories.get(i));
        }
        reportString += "----------------\n";
        reportString += String.format("Total Calories Burned: %.2f kcal\n", caloriesBurned);
        reportString += "----------------\n";
        reportString += String.format("Net Calories for the Day: %.2f kcal\n", netCalories);
        reportString += "If you keep up this lifestyle...\n";
        if (netCalories<0){
            reportString += String.format("In a week, you will lose %.2f kilograms.\n", 7*-netCalories*0.00012959782);
            reportString += String.format("In a month, you will lose %.2f kilograms.\n", 30*-netCalories*0.00012959782);
            reportString += String.format("In 3 months, you will lose %.2f kilograms.\n", 90*-netCalories*0.00012959782);
            reportString += String.format("In 6 months, you will lose %.2f kilograms.\n", 180*-netCalories*0.00012959782);
        }
        else if (netCalories==0){
            reportString += "Your weight will stay the same.\n";
        }
        else{
            reportString += String.format("In a week, you will gain %.2f kilograms.\n", 7*netCalories*0.00012959782);
            reportString += String.format("In a month, you will gain %.2f kilograms.\n", 30*netCalories*0.00012959782);
            reportString += String.format("In 3 months, you will gain %.2f kilograms.\n", 90*netCalories*0.00012959782);
            reportString += String.format("In 6 months, you will gain %.2f kilograms.\n", 180*netCalories*0.00012959782);
        }
        reportString += "----------------";

        return reportString;
    }
}
