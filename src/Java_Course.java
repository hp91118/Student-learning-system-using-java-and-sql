

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.*;

public class Java_Course implements ActionListener{

    static JFrame J1 = new JFrame("Java Course");
    JLabel syllabus = new JLabel();
    JButton oop = new JButton("Introduction and Object Oriented Programming in Java");
    JButton collection= new JButton("Collection and String API");
    JButton exception1 = new JButton("Exception Handling and Packages");
    JButton file = new JButton("Multithreading and File I/O");
    JButton gui = new JButton("GUI Programming and Event Handling");
    JButton db = new JButton("Database Connectivity");

    public void jframe() {
        syllabus.setText("Resource Material");
        /*oop.setText("Fundamentals Of C Language");
        collection.setText("Control Statements");
        exception1s.setText("exception1s");
        file.setText("file");
        gui.setText("gui");
        db.setText("db");*/
        J1.add(syllabus);
        J1.add(oop);
        J1.add(collection);
        J1.add(exception1);
        J1.add(file);
        J1.add(gui);
        J1.add(db);
        syllabus.setBounds(600, 5, 1000, 100);
        oop.setBounds(450, 100, 500, 70);
        collection.setBounds(450, 200, 500, 70);
        exception1.setBounds(450, 300, 500, 70);
        file.setBounds(450, 400, 500, 70);
        gui.setBounds(450, 500, 500, 70);
        db.setBounds(450, 600, 500, 70);

        syllabus.setFont(new Font("Times New Roman", Font.BOLD, 30));
        oop.setFont(new Font("Times New Roman",Font.BOLD,20));
        collection.setFont(new Font("Times New Roman",Font.BOLD,20));
        exception1.setFont(new Font("Times New Roman",Font.BOLD,20));
        file.setFont(new Font("Times New Roman",Font.BOLD,20));
        gui.setFont(new Font("Times New Roman",Font.BOLD,20));
        db.setFont(new Font("Times New Roman",Font.BOLD,20));


        oop.addActionListener(this::actionPerformed);
        collection.addActionListener(this::actionPerformed);
        exception1.addActionListener(this::actionPerformed);
        file.addActionListener(this::actionPerformed);
        gui.addActionListener(this::actionPerformed);
        db.addActionListener(this::actionPerformed);

      //  J1.getContentPane().setBackground(Color.PINK);


        J1.setSize(1400,800);
        JLabel label1 = new JLabel(); //JLabel Creation
        label1.setIcon(new ImageIcon("C:/Users/Kulkarni/IdeaProjects/JavaProject3/src/demo11.png")); //Sets the image to be displayed as an icon
        Dimension size = label1.getPreferredSize(); //Gets the size of the image
        label1.setBounds(0, 0,1400, 800);
        J1.add(label1);
        J1.setLayout(null);
        J1.setVisible(true);



    }

    public void actionPerformed(ActionEvent e1)
    {

        String button = e1.getActionCommand();
        if (button.equals("Introduction and Object Oriented Programming in Java")) {

            try {
                Runtime.getRuntime().exec("rundll32 url.dll, FileProtocolHandler " + "D:/D Drive/RIT/JAVA/OOP in Java.pdf");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if (button.equals("Collection and String API")) {

            try {
                Runtime.getRuntime().exec("rundll32 url.dll, FileProtocolHandler " + "D:/D Drive/RIT/JAVA/Collection, Collection Framework.pdf");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if (button.equals("Exception Handling and Packages")) {

            try {
                Runtime.getRuntime().exec("rundll32 url.dll, FileProtocolHandler " + "D:/D Drive/RIT/JAVA/Exception Handling.pdf");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if (button.equals("Multithreading and File I/O")) {

            try {
                Runtime.getRuntime().exec("rundll32 url.dll, FileProtocolHandler " + "D:/D Drive/RIT/JAVA/Lecture on MultiThreading.pdf");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if (button.equals("GUI Programming and Event Handling")) {

            try {
                Runtime.getRuntime().exec("rundll32 url.dll, FileProtocolHandler " + "D:/D Drive/RIT/JAVA/1 Applet.pdf");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if (button.equals("Database Connectivity")) {

            try {
                Runtime.getRuntime().exec("rundll32 url.dll, FileProtocolHandler " + "D:/D Drive/RIT/JAVA/Database Connectivity.pdf");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Java_Course obj = new Java_Course();
        obj.jframe();


    }






}


