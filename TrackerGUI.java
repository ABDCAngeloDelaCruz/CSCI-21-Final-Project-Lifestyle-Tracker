/**
    In this program, I created a GUI class for the Tracker. I used Frames, Panels, Buttons, Labels,
    Text Fields, Text Areas, and ScrollPanes for the GUI. I also added EventListeners for the buttons
    which will be pressed in the GUI that will eventually print out the your tracker's details. 
    Another instantiation of the LifestyleTracker was made here as well to facilitate everything.
    As you can see, this is the only add-on I did.

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

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TrackerGUI {
    private JFrame trackerFrame;
    private int width;
    private int height;

    private JPanel FoodPanel;
    private JPanel ActivityPanel;
    private JPanel ConsolePanel;
    private JPanel ReportPanel;

    private JButton addFood;
    private JButton addActivity;
    private JButton eatFood;
    private JButton performActivity;
    private JButton reportLifestyleTracker;

    private JLabel FoodNameLabel1;
    private JLabel CalorieLabel1;
    private JLabel ActivityLabel1;
    private JLabel CalorieLabel2;
    private JLabel ActionLabel;

    private JTextField FoodField1;
    private JTextField CalorieField1;
    private JTextField ActivityField1;
    private JTextField CalorieField2;

    private JTextArea UpdateText;
    private JTextArea ReportText;

    /*
        The JScrollPane is used to be able to scroll through a GUI component. I used this as 
        screen real estate was a problem for my laptop and I'm not sure if my experience would 
        convert well with the checker's machine.
        Retrieved from https://docs.oracle.com/javase/tutorial/uiswing/components/scrollpane.html
    */
    private JScrollPane scrollPane1;
    private JScrollPane scrollPane2;

    LifestyleTracker tracker;
    private String outputString;
    
    public TrackerGUI(int w, int h){
        trackerFrame = new JFrame();
        width = w;
        height = h;

        FoodPanel = new JPanel();
        ActivityPanel = new JPanel();
        ConsolePanel = new JPanel();
        ReportPanel = new JPanel();

        addFood = new JButton("Add Food");
        addActivity = new JButton("Add Activity");
        eatFood = new JButton("Eat Food");
        performActivity = new JButton("Perform Activity");
        reportLifestyleTracker = new JButton("Show Lifestyle Report");

        FoodNameLabel1 = new JLabel("Food");
        CalorieLabel1 = new JLabel("Calorie(s) / Servings Eaten");
        ActivityLabel1 = new JLabel("Activity");
        CalorieLabel2 = new JLabel("Calorie(s) / Hours Performed");
        ActionLabel = new JLabel("Lifestyle Choices Taken");

        FoodField1 = new JTextField(32);
        CalorieField1 = new JTextField(32);
        ActivityField1 = new JTextField(32);
        CalorieField2 = new JTextField(32);

        UpdateText = new JTextArea(9, 64);
        ReportText = new JTextArea(9,64);

        scrollPane1 = new JScrollPane(UpdateText);
        scrollPane2 = new JScrollPane(ReportText);

        tracker = new LifestyleTracker();
        outputString = "";
    }

    public void setUpGUI(){
        trackerFrame.setSize(width, height);
        // JFrames are BorderLayouts by default which didn't look as good so I used a GridLayout.
        trackerFrame.setLayout(new GridLayout(6, 1, 0, 6));
        trackerFrame.setTitle("Lifestyle Tracker");
        trackerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        /*  
            setLocationRelativeTo(null) centers the JFrame when opened.
            Retrieved from https://docs.oracle.com/javase/7/docs/api/javax/swing/JFrame.html
        */
        trackerFrame.setLocationRelativeTo(null);
        
        /*  
            setBackground (which wasn't discussed in class) is used to set a GUI element's bg color.
            Retrieved from https://docs.oracle.com/javase/7/docs/api/javax/swing/JFrame.html
        */
        FoodPanel.setBackground(Color.lightGray);
        FoodPanel.add(FoodNameLabel1);
        FoodPanel.add(FoodField1);
        FoodPanel.add(CalorieLabel1);
        FoodPanel.add(CalorieField1);
        FoodPanel.add(addFood);
        FoodPanel.add(eatFood);

        ActivityPanel.setBackground(Color.lightGray);
        ActivityPanel.add(ActivityLabel1);
        ActivityPanel.add(ActivityField1);
        ActivityPanel.add(CalorieLabel2);
        ActivityPanel.add(CalorieField2);
        ActivityPanel.add(addActivity);
        ActivityPanel.add(performActivity);

        ConsolePanel.add(ActionLabel);
        ConsolePanel.setBackground(Color.lightGray);

        ReportText.setEditable(false);

        /*
            These are methods for the JScrollPane and they set whether or not there should be a
            vertical or horizontal scroll bar.
        */

        scrollPane1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane1.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane2.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        
        ReportPanel.setBackground(Color.cyan);
        ReportPanel.add(reportLifestyleTracker);

        trackerFrame.add(FoodPanel);
        trackerFrame.add(ActivityPanel);
        trackerFrame.add(ConsolePanel);
        trackerFrame.add(scrollPane1);
        trackerFrame.add(ReportPanel);
        trackerFrame.add(scrollPane2);
        trackerFrame.setVisible(true);
    }

    public void setUpButtonListeners(){
        ActionListener buttonListener = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                Object obj = ae.getSource();
                if (obj==addFood){
                    String foodName = FoodField1.getText();
                    double foodCalories = Double.parseDouble(CalorieField1.getText());
                    outputString += tracker.addFood(foodName, foodCalories);
                    UpdateText.setText(outputString);
                }
                else if(obj==eatFood){
                    String foodName = FoodField1.getText();
                    double servings = Double.parseDouble(CalorieField1.getText());
                    outputString += tracker.eat(foodName, servings);
                    UpdateText.setText(outputString);
                }
                else if (obj==addActivity){
                    String activityName = ActivityField1.getText();
                    double activityCalories = Double.parseDouble(CalorieField2.getText());
                    outputString += tracker.addActivity(activityName, activityCalories);
                    UpdateText.setText(outputString);
                }
                else if(obj==performActivity){
                    String activityName = ActivityField1.getText();
                    double hours = Double.parseDouble(CalorieField2.getText());
                    outputString += tracker.perform(activityName, hours);
                    UpdateText.setText(outputString);
                }
                else if(obj==reportLifestyleTracker){
                    ReportText.setText(tracker.report());
                }
            }
        };

        addFood.addActionListener(buttonListener);
        eatFood.addActionListener(buttonListener);
        addActivity.addActionListener(buttonListener);
        performActivity.addActionListener(buttonListener);
        reportLifestyleTracker.addActionListener(buttonListener);
    }
}
