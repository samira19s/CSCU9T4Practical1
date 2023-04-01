// GUI and main program for the Training Record
package com.stir.cscu9t4practical1;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.lang.Number;

public class TrainingRecordGUI extends JFrame implements ActionListener {

    private JTextField name = new JTextField(30);
    private JTextField day = new JTextField(2);
    private JTextField month = new JTextField(2);
    private JTextField year = new JTextField(4);
    private JTextField hours = new JTextField(2);
    private JTextField mins = new JTextField(2);
    private JTextField secs = new JTextField(2);
    private JTextField dist = new JTextField(4);
    private JTextField where = new JTextField(10);
    private JTextField terrain = new JTextField(10);
    private JTextField tempo = new JTextField(10);
    private JTextField repetitions = new JTextField(10);
    private JTextField recovery = new JTextField(10);
    private JLabel labn = new JLabel(" Name:");
    private JLabel labd = new JLabel(" Day:");
    private JLabel labm = new JLabel(" Month:");
    private JLabel laby = new JLabel(" Year:");
    private JLabel labh = new JLabel(" Hours:");
    private JLabel labmm = new JLabel(" Mins:");
    private JLabel labs = new JLabel(" Secs:");
    private JLabel labdist = new JLabel(" Distance (km):");
    private JLabel labwr = new JLabel(" Where:");
    private JLabel labtr = new JLabel(" Terrain:");
    private JLabel labto = new JLabel(" Tempo:");
    private JLabel labrp = new JLabel(" Repetitions:");
    private JLabel labrv = new JLabel(" Recovery:");
    String[] type = {"Swim", "Sprint", "Cycle"};
    private JComboBox <String> exercise = new JComboBox(type);
    private JButton addR = new JButton("Add");
    private JButton lookUpByDate = new JButton("Look Up");
    private JButton findAllByDate =  new JButton("FindAllByDate");// it appears to be related to finding entries by a specific date
    private JButton remove = new JButton("Remove");//it appears to be related to removing something from the program
    private JButton sport = new JButton("Sport");
    private TrainingRecord myAthletes = new TrainingRecord();

    private JTextArea outputArea = new JTextArea(5, 50);

    public static void main(String[] args) {
        TrainingRecordGUI applic = new TrainingRecordGUI();
    } // main

    // set up the GUI
    public TrainingRecordGUI() {
        super("Training Record");
        setLayout(new FlowLayout());
        add(labn);
        add(name);
        name.setEditable(true);
        add(labd);
        add(day);
        day.setEditable(true);
        add(labm);
        add(month);
        month.setEditable(true);
        add(laby);
        add(year);
        year.setEditable(true);
        add(labh);
        add(hours);
        hours.setEditable(true);
        add(labmm);
        add(mins);
        mins.setEditable(true);
        add(labs);
        add(secs);
        secs.setEditable(true);
        add(labdist);
        add(dist);
        dist.setEditable(true);
        add(labwr);
        add(where);
        where.setEditable(true);
        add(labtr);
        add(terrain);
        terrain.setEditable(true);
        add(labto);
        add(tempo);
        tempo.setEditable(true);
        add(labrp);
        add(repetitions);
        repetitions.setEditable(true);
        add(labrv);
        add(recovery);
        recovery.setEditable(true);
        add(addR);
        addR.addActionListener(this);
        add(exercise);
        exercise.addActionListener(this);
        add(lookUpByDate);
        lookUpByDate.addActionListener(this);
        add(findAllByDate);
        findAllByDate.addActionListener(this);
        add(remove);
        remove.addActionListener(this);
        add(outputArea);
        outputArea.setEditable(false);
        setSize(720, 200);
        setVisible(true);
        blankDisplay();

        // To save typing in new entries while testing, uncomment
        // the following lines (or add your own test cases)

    } // constructor

    // listen for and respond to GUI events
    public void actionPerformed(ActionEvent event) {
        String message = "";
        if (event.getSource() == addR) {
            message = addEntry("generic");
        }
        if (event.getSource() == lookUpByDate) {
            message = lookupEntry();
        }
        if (event.getSource() == findAllByDate) {
            message = findAllByDate();//stores the result in a variable called "message"
        }

        if (event.getSource() == remove) {
            remove();// remove the result
        }
        outputArea.setText(message);
        blankDisplay();
    } // actionPerformed

    public String addEntry(String what) {
        String message = "Record added\n";
        System.out.println("Adding "+what+" entry to the records");

        String n = name.getText();
        int m = Integer.parseInt(month.getText());
        int d = Integer.parseInt(day.getText());
        int y = Integer.parseInt(year.getText());
        float km = java.lang.Float.parseFloat(dist.getText());
        int h = Integer.parseInt(hours.getText());
        int mm = Integer.parseInt(mins.getText());
        int s = Integer.parseInt(secs.getText());
        String wre = where.getText();
        String trn = terrain.getText();
        String too = tempo.getText();
        int rps = Integer.parseInt(repetitions.getText());
        int rvy = Integer.parseInt(recovery.getText());

        String event = exercise.getSelectedItem().toString();
        if (event.equals("Sprint")) {//object is created with the given parameters
            Entry e= new SprintEntry(n, d, m, y, h, mm, s,km , rps, rvy);
            myAthletes.addEntry(e);//object is then added to a list
            return "Sprint Entry added";
        }
        if (event.equals("Swim")) {////object is created with the given parameters
            Entry e = new SwimEntry(n, d, m, y, h, mm, s, km, wre);
            myAthletes.addEntry(e);//object is then added to a list
            return "Swim Entry added";
        }
        if(event.equals("Cycle"))////object is created with the given parameters
        {
            Entry e= new CycleEntry(n, d, m, y, h, mm, s, km, trn, too);
            myAthletes.addEntry(e);// object is then added to a list
            return "Cycle Entry added";
        }
        else
        {
            return "Select the sport";
        }

    }



    public String lookupEntry() {
        int m = Integer.parseInt(month.getText());
        int d = Integer.parseInt(day.getText());
        int y = Integer.parseInt(year.getText());
        outputArea.setText("looking up record ...");
        String message = myAthletes.lookupEntry(d, m, y);
        return message;
    }

    public String findAllByDate() {
        int m = Integer.parseInt(month.getText());
        int d = Integer.parseInt(day.getText());
        int y = Integer.parseInt(year.getText());
        outputArea.setText("looking up record ...");
        String message = myAthletes.lookupEntries(d, m, y);
        return message;
        //String message = "Not implemented yet";
        //return message;
    }

    public void remove() {// removing
        String n = name.getText();
        int m = Integer.parseInt(month.getText());
        int d = Integer.parseInt(day.getText());
        int y = Integer.parseInt(year.getText());
        outputArea.setText("Deleting record ...");// deleting the record
        myAthletes.removeEntry(n, d, m, y);// object is remove from the list

    }

    public void blankDisplay() {
        name.setText("");
        day.setText("");
        month.setText("");
        year.setText("");
        hours.setText("");
        mins.setText("");
        secs.setText("");
        dist.setText("");

    }// blankDisplay
    // Fills the input fields on the display for testing purposes only
    public void fillDisplay(Entry ent) {
        name.setText(ent.getName());
        day.setText(String.valueOf(ent.getDay()));
        month.setText(String.valueOf(ent.getMonth()));
        year.setText(String.valueOf(ent.getYear()));
        hours.setText(String.valueOf(ent.getHour()));
        mins.setText(String.valueOf(ent.getMin()));
        secs.setText(String.valueOf(ent.getSec()));
        dist.setText(String.valueOf(ent.getDistance()));
    }

} // TrainingRecordGUI