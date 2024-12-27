/**
    In this program, I created a class for instantiating an object called Food, wherein it contains 
    a name and a calorie amount. Using its methods, we can get its corresponding fields and 
    update the calorie amount of a Food.
    
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

public class Food {
    private String foodName;
    private double foodCalories;

    public Food (String f, double c){
        this.foodName = f;
        this.foodCalories = c;
    }

    public String getFoodName(){
        return this.foodName;
    }

    public double getFoodCalories(){
        return this.foodCalories;
    }

    public void updateCalories(double c){
        this.foodCalories = c;
    }
}
