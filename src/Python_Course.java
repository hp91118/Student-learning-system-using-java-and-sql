

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.*;

public class Python_Course implements ActionListener{

    static JFrame P1 = new JFrame("Python Course");
    JLabel syllabus = new JLabel();
    JButton pf = new JButton("Introduction to Python Fundamentals");
    JButton ds= new JButton("List,tuples,Sets,Dictionaries");
    JButton pcs = new JButton("Python Conditional Statements");
    JButton pco = new JButton("Python Classes and Object");
    JButton fh = new JButton("Python file handling and modules");
    JButton pm = new JButton("Python matplotlib");

    public void pframe() {
        syllabus.setText("Resource Material");
        /*pf.setText("Fundamentals Of C Language");
        ds.setText("Control Statements");
        pcss.setText("pcss");
        fpco.setText("fpco");
        fh.setText("fh");
        pm.setText("pm");*/
        P1.add(syllabus);
        P1.add(pf);
        P1.add(ds);
        P1.add(pcs);
        P1.add(pco);
        P1.add(fh);
        P1.add(pm);
        syllabus.setBounds(600, 5, 1000, 100);
        pf.setBounds(450, 100, 500, 70);
        ds.setBounds(450, 200, 500, 70);
        pcs.setBounds(450, 300, 500, 70);
        pco.setBounds(450, 400, 500, 70);
        fh.setBounds(450, 500, 500, 70);
        pm.setBounds(450, 600, 500, 70);

        syllabus.setFont(new Font("Times New Roman", Font.BOLD, 30));
        pf.setFont(new Font("Times New Roman",Font.BOLD,20));
        ds.setFont(new Font("Times New Roman",Font.BOLD,20));
        pcs.setFont(new Font("Times New Roman",Font.BOLD,20));
        pco.setFont(new Font("Times New Roman",Font.BOLD,20));
        fh.setFont(new Font("Times New Roman",Font.BOLD,20));
        pm.setFont(new Font("Times New Roman",Font.BOLD,20));

        pf.addActionListener(this::actionPerformed);
        ds.addActionListener(this::actionPerformed);
        pcs.addActionListener(this::actionPerformed);
        pco.addActionListener(this::actionPerformed);
        fh.addActionListener(this::actionPerformed);
        pm.addActionListener(this::actionPerformed);


        //P1.getContentPane().setBackground(Color.PINK);


        P1.setSize(1400,800);
        JLabel label1 = new JLabel(); //JLabel Creation
        label1.setIcon(new ImageIcon("C:/Users/Kulkarni/IdeaProjects/JavaProject3/src/demo11.png")); //Sets the image to be displayed as an icon
        Dimension size = label1.getPreferredSize(); //Gets the size of the image
        label1.setBounds(0, 0,1400, 800);
        P1.add(label1);
        P1.setLayout(null);
        P1.setVisible(true);



    }

    public void actionPerformed(ActionEvent e1)
    {

        String button = e1.getActionCommand();
        if (button.equals("Introduction to Python Fundamentals")) {

            try {
                Runtime.getRuntime().exec("rundll32 url.dll, FileProtocolHandler " + "D:/D Drive/RIT/Python/Introduction to Python.pdf");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if (button.equals("List,tuples,Sets,Dictionaries")) {

            try {
                Runtime.getRuntime().exec("rundll32 url.dll, FileProtocolHandler " + "D:/D Drive/RIT/Python/set tuple dictionary list in python.pdf");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if (button.equals("Python Conditional Statements")) {

            try {
                Runtime.getRuntime().exec("rundll32 url.dll, FileProtocolHandler " + "D:/D Drive/RIT/Python/Python Conditional Statements.pdf");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if (button.equals("Python Classes and Object")) {

            try {
                Runtime.getRuntime().exec("rundll32 url.dll, FileProtocolHandler " + "D:/D Drive/RIT/Python/object_oriented_python_tutorial.pdf");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if (button.equals("Python file handling and modules")) {

            try {
                Runtime.getRuntime().exec("rundll32 url.dll, FileProtocolHandler " + "D:/D Drive/RIT/Python/File Handling in Python.pdf");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if (button.equals("Python matplotlib")) {

            try {
                Runtime.getRuntime().exec("rundll32 url.dll, FileProtocolHandler " + "D:/D Drive/RIT/Python/matplotlib_tutorial.pdf");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Python_Course obj = new Python_Course();
        obj.pframe();


    }






}



