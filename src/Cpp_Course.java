

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.*;

public class Cpp_Course implements ActionListener{

    static JFrame C1 = new JFrame("Java Course");
    JLabel syllabus = new JLabel();
    JButton oopc = new JButton("Introduction and Object Oriented Programming");
    JButton dp= new JButton("Dynamic Allocation and Pointers");
    JButton foo = new JButton("Functions and Operator Overloading");
    JButton inheri = new JButton("Inheritance and Virtual Functions");
    JButton feh = new JButton("File and Exception Handling");
    JButton tc = new JButton("Templates and Collections");

    public void cpframe() {
        syllabus.setText("Resource Material");
        /*oopc.setText("Fundamentals Of C Language");
        dp.setText("Control Statements");
        foos.setText("foos");
        inheri.setText("inheri");
        feh.setText("feh");
        tc.setText("tc");*/
        C1.add(syllabus);
        C1.add(oopc);
        C1.add(dp);
        C1.add(foo);
        C1.add(inheri);
        C1.add(feh);
        C1.add(tc);
        syllabus.setBounds(600, 5, 1000, 100);
        oopc.setBounds(450, 100, 500, 70);
        dp.setBounds(450, 200, 500, 70);
        foo.setBounds(450, 300, 500, 70);
        inheri.setBounds(450, 400, 500, 70);
        feh.setBounds(450, 500, 500, 70);
        tc.setBounds(450, 600, 500, 70);

        syllabus.setFont(new Font("Times New Roman", Font.BOLD, 30));
        oopc.setFont(new Font("Times New Roman",Font.BOLD,20));
        dp.setFont(new Font("Times New Roman",Font.BOLD,20));
        foo.setFont(new Font("Times New Roman",Font.BOLD,20));
        inheri.setFont(new Font("Times New Roman",Font.BOLD,20));
        feh.setFont(new Font("Times New Roman",Font.BOLD,20));
        tc.setFont(new Font("Times New Roman",Font.BOLD,20));

        oopc.addActionListener(this::actionPerformed);
        dp.addActionListener(this::actionPerformed);
        foo.addActionListener(this::actionPerformed);
        inheri.addActionListener(this::actionPerformed);
        feh.addActionListener(this::actionPerformed);
        tc.addActionListener(this::actionPerformed);


      //  C1.getContentPane().setBackground(Color.PINK);

        C1.setSize(1400,800);
        JLabel label1 = new JLabel(); //JLabel Creation
        label1.setIcon(new ImageIcon("C:/Users/Kulkarni/IdeaProjects/JavaProject3/src/demo11.png")); //Sets the image to be displayed as an icon
        Dimension size = label1.getPreferredSize(); //Gets the size of the image
        label1.setBounds(0, 0,1400, 800);
        C1.add(label1);
        C1.setLayout(null);
        C1.setVisible(true);



    }

    public void actionPerformed(ActionEvent e1)
    {

        String button = e1.getActionCommand();
        if (button.equals("Introduction and Object Oriented Programming")) {

            try {
                Runtime.getRuntime().exec("rundll32 url.dll, FileProtocolHandler " + "D:/D Drive/RIT/Cpp/Introduction to CPP and OOP.pdf");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if (button.equals("Dynamic Allocation and Pointers")) {

            try {
                Runtime.getRuntime().exec("rundll32 url.dll, FileProtocolHandler " + "D:/D Drive/RIT/Cpp/Pointer.pdf");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if (button.equals("Functions and Operator Overloading")) {

            try {
                Runtime.getRuntime().exec("rundll32 url.dll, FileProtocolHandler " + "D:/D Drive/RIT/Cpp/Function and operator overloading .pdf");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if (button.equals("Inheritance and Virtual Functions")) {

            try {
                Runtime.getRuntime().exec("rundll32 url.dll, FileProtocolHandler " + "D:/D Drive/RIT/Cpp/Virtual base class and Function.pdf");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if (button.equals("File and Exception Handling")) {

            try {
                Runtime.getRuntime().exec("rundll32 url.dll, FileProtocolHandler " + "D:/D Drive/RIT/Cpp/Files Handling_merged.pdf");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if (button.equals("Templates and Collections")) {

            try {
                Runtime.getRuntime().exec("rundll32 url.dll, FileProtocolHandler " + "D:/D Drive/RIT/Cpp/STL.pdf");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Cpp_Course obj = new Cpp_Course();
        obj.cpframe();


    }






}



