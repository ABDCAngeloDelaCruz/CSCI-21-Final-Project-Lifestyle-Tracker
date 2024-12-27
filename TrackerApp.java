/**
    This program creates an instance of the TrackerGUI in the main method to run it.    

    @author Angelo B. Dela Cruz (222086)
    @version December 5, 2022
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

public class TrackerApp {
    public static void main(String[] args){
        TrackerGUI LifestyleTrackerGUI = new TrackerGUI(1280, 720);
        LifestyleTrackerGUI.setUpGUI(); 
        LifestyleTrackerGUI.setUpButtonListeners();
    }
}
