/**
    In this program, I created a class for instantiating an object called Activity, wherein it contains 
    a name and a calorie amount. Similar to Food, we can get its corresponding fields and 
    update the calorie amount of an Activity. 

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

public class Activity {
    private String activityName;
    private double activityCalories;

    public Activity (String n, double c){
        this.activityName = n;
        this.activityCalories = c;
    }

    public String getActivityName(){
        return this.activityName;
    }

    public double getActivityCalories(){
        return this.activityCalories;
    }

    public void updateCalories(double c){
        this.activityCalories = c;
    }
}
