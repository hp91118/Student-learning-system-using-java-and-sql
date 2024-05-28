

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.*;

public class C_Course implements ActionListener{

    static JFrame c = new JFrame("C Course");
    JLabel syllabus = new JLabel();
    JButton foc = new JButton("Fundamentals Of C Language");
    JButton cs = new JButton("Control Statements");
    JButton functions = new JButton("Functions");
    JButton array = new JButton("Array");
    JButton pointer = new JButton("Pointer");
    JButton structures = new JButton("Structures");

    public void cframe() {
        syllabus.setText("Resource Material");
        /*foc.setText("Fundamentals Of C Language");
        cs.setText("Control Statements");
        functions.setText("Functions");
        array.setText("Array");
        pointer.setText("Pointer");
        structures.setText("Structures");*/
        c.add(syllabus);
        c.add(foc);
        c.add(cs);
        c.add(functions);
        c.add(array);
        c.add(pointer);
        c.add(structures);
        syllabus.setBounds(600, 5, 1000, 100);
        foc.setBounds(450, 100, 500, 70);
        cs.setBounds(450, 200, 500, 70);
        functions.setBounds(450, 300, 500, 70);
        array.setBounds(450, 400, 500, 70);
        pointer.setBounds(450, 500, 500, 70);
        structures.setBounds(450, 600, 500, 70);

        syllabus.setFont(new Font("Times New Roman", Font.BOLD, 30));
        foc.setFont(new Font("Times New Roman",Font.BOLD,20));
        cs.setFont(new Font("Times New Roman",Font.BOLD,20));
        functions.setFont(new Font("Times New Roman",Font.BOLD,20));
        array.setFont(new Font("Times New Roman",Font.BOLD,20));
        pointer.setFont(new Font("Times New Roman",Font.BOLD,20));
        structures.setFont(new Font("Times New Roman",Font.BOLD,20));

        foc.addActionListener(this::actionPerformed);
        cs.addActionListener(this::actionPerformed);
        functions.addActionListener(this::actionPerformed);
        array.addActionListener(this::actionPerformed);
        pointer.addActionListener(this::actionPerformed);
        structures.addActionListener(this::actionPerformed);

        //c.getContentPane().setBackground(Color.PINK);

        c.setSize(1400,800);
        JLabel label1 = new JLabel(); //JLabel Creation
        label1.setIcon(new ImageIcon("C:/Users/Kulkarni/IdeaProjects/JavaProject3/src/demo11.png")); //Sets the image to be displayed as an icon
         Dimension size = label1.getPreferredSize(); //Gets the size of the image
        label1.setBounds(0, 0,1400, 800);
        c.add(label1);

        c.setLayout(null);
        c.setVisible(true);



    }

    public void actionPerformed(ActionEvent e1)
    {

        String button = e1.getActionCommand();
        if (button.equals("Fundamentals Of C Language")) {

            try {
                Runtime.getRuntime().exec("rundll32 url.dll, FileProtocolHandler " + "D:/D Drive/RIT/C/1. Chapter Notes -01.pdf");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
       else if (button.equals("Control Statements")) {

            try {
                Runtime.getRuntime().exec("rundll32 url.dll, FileProtocolHandler " + "D:/D Drive/RIT/C/Chapter Notes-02.pdf");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
       else if (button.equals("Functions")) {

            try {
                Runtime.getRuntime().exec("rundll32 url.dll, FileProtocolHandler " + "D:/D Drive/RIT/C/Chapter 3 Notes.pdf");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
       else if (button.equals("Array")) {

            try {
                Runtime.getRuntime().exec("rundll32 url.dll, FileProtocolHandler " + "D:/D Drive/RIT/C/Chapter Note 4.pdf");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
       else if (button.equals("Pointer")) {

            try {
                Runtime.getRuntime().exec("rundll32 url.dll, FileProtocolHandler " + "D:/D Drive/RIT/C/Chapter Notes-05.pdf");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if (button.equals("Structures")) {

            try {
                Runtime.getRuntime().exec("rundll32 url.dll, FileProtocolHandler " + "D:/D Drive/RIT/C/Chapter Notes -06.pdf");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        C_Course obj = new C_Course();
        obj.cframe();


    }






}

