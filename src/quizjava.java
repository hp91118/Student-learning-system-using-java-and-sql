



import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;



public class quizjava extends JFrame implements ActionListener
{
    JLabel label;
    JRadioButton radioButtons[]=new JRadioButton[5];
    JButton btnNext,btnback,btnResult;
    ButtonGroup bg ;
    int count=0,current=0,x=1,y=1,now=0;
    int m[]=new int[10];

    quizjava(String s)
    {
        super(s);
        label=new JLabel();
        add(label);
        bg=new ButtonGroup();

        for (int i=0; i<5; i++)
        {
            radioButtons[i] = new JRadioButton();
            radioButtons[i].setFont(new Font("Times New Roman",Font.BOLD,20));
            add(radioButtons[i]);
            bg.add(radioButtons[i]);
        }
        btnNext = new JButton("Next");
        btnback=new JButton("Back");
        btnResult = new JButton("Result");

        btnResult.setVisible(false);
        btnResult.addActionListener(this::actionPerformed);
        btnNext.addActionListener(this::actionPerformed);
        btnback.addActionListener(this::actionPerformed);
        add(btnNext);
        add(btnback);
        add(btnResult);
        setData();
        label.setBounds(100,60,1000,40);
        label.setFont(new Font("Times New Roman",Font.BOLD,25));
       // radioButtons[0].setBounds(430,110,450,20);
        radioButtons [0].setBounds(150, 120, 450, 40);
        radioButtons [1].setBounds (150,180,450,40);
        radioButtons [2].setBounds (150,240, 450, 40);
        radioButtons [3].setBounds (150,300,450,40);
        btnNext.setBounds (500,380,100, 40);
        btnback.setBounds(350,380,100, 40);
        btnResult.setBounds (650,380, 100, 40);

        //JLabel label1 = new JLabel(); //JLabel Creation
        //label1.setIcon(new ImageIcon("C:/Users/Kulkarni/IdeaProjects/JavaProject3/src/demo11.png")); //Sets the image to be displayed as an icon
        // Dimension size = label.getPreferredSize(); //Gets the size of the image
        //label1.setBounds(0, 0,1400, 800);
        //add(label1);

        JLabel label1 = new JLabel();
        label1.setIcon(new ImageIcon("C:/Users/Kulkarni/IdeaProjects/JavaProject3/src/test7.png"));

        label1.setBounds(1000,20,400,400);
        add(label1);

        ImageIcon icon = new ImageIcon("C:/Users/Kulkarni/IdeaProjects/JavaProject3/src/demo11.png");
        add(new JLabel(icon));
        pack();



        //setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        setLayout (null);
        //setLocation(250, 100);
        setVisible(true);
        setSize(1400, 800);


    }


    void setData()
    {
        radioButtons[4].setSelected(true);
        if(current==0)
        {
            label.setText("Q1 : which is official language for android development");
            radioButtons[0].setText("java");
            radioButtons[1].setText("kotlin");
            radioButtons[2].setText("c++");
            radioButtons[3].setText("javascript");
        }

        if(current==1)
        {
            label.setText("Q2 : How do you create a variable with the numeric value 5");
            radioButtons[0].setText("not know");
            radioButtons[1].setText("x=5;");
            radioButtons[2].setText("x=5;");
            radioButtons[3].setText("int x = 5;");
        }

        if(current==2)
        {
            label.setText("Q3 :Which operator can be used to compare two values?");
            radioButtons[0].setText("=");
            radioButtons[1].setText("==");
            radioButtons[2].setText("!=");
            radioButtons[3].setText("not know");
        }

        if(current==3)
        {
            label.setText("Q4 :Which data type is used to create a variable that should store text? ");
            radioButtons[0].setText("String");
            radioButtons[1].setText("mystring");
            radioButtons[2].setText("text");
            radioButtons[3].setText("string");
        }

        if(current==4)
        {
            label.setText("Q5 :Which method can be used to find the length of a string? ");
            radioButtons[0].setText("setsize()");
            radioButtons[1].setText("length()");
            radioButtons[2].setText("getlenght");
            radioButtons[3].setText("len");
        }

        if(current==5)
        {
            label.setText("Q6 :Which method can be used to return a string in upper case letters? ");
            radioButtons[0].setText("uppercase");
            radioButtons[1].setText("tuc");
            radioButtons[2].setText("toUpperCase()");
            radioButtons[3].setText("touppercase");
        }

        if(current==6)
        {
            label.setText("Q7 : what are the features of java?");
            radioButtons[0].setText("secure");
            radioButtons[1].setText("platform independent");
            radioButtons[2].setText("oop");
            radioButtons[3].setText("all of the above");
        }

        if(current==7)
        {
            label.setText("Q8 : when the object created with new keyword?");
            radioButtons[0].setText("At run time");
            radioButtons[1].setText("At compile time");
            radioButtons[2].setText("Depends on the code");
            radioButtons[3].setText("None");
        }

        if(current==8)
        {
            label.setText("Q9 :In which of the following is toString() method defined? ");
            radioButtons[0].setText("java.lang.Object");
            radioButtons[1].setText("java.lang.String");
            radioButtons[2].setText("java.lang.util");
            radioButtons[3].setText("None");
        }

        if(current==9)
        {
            label.setText("Q10 :what is the extension of java code files?");
            radioButtons[0].setText(".js");
            radioButtons[1].setText(".txt");
            radioButtons[2].setText(".class");
            radioButtons[3].setText(".java");
        }

        label.setBounds(100,60,1000,40);
        for(int i=0,j=0;i<=180;i+=60,j++)
        {
            radioButtons[j].setBounds(150,120+i,450,40);
        }

    }

    boolean checkAns()
    {
        if(current==0)
        {
            return(radioButtons[0].isSelected());
        }

        if(current==1)
        {
            return(radioButtons[3].isSelected());
        }

        if(current==2)
        {
            return(radioButtons[1].isSelected());
        }

        if(current==3)
        {
            return(radioButtons[0].isSelected());
        }

        if(current==4)
        {
            return(radioButtons[1].isSelected());
        }

        if(current==5)
        {
            return(radioButtons[2].isSelected());
        }

        if(current==6)
        {
            return(radioButtons[3].isSelected());
        }

        if(current==7)
        {
            return(radioButtons[0].isSelected());
        }

        if(current==8)
        {
            return(radioButtons[0].isSelected());
        }

        if(current==9)
        {
            return(radioButtons[3].isSelected());
        }

        return false;
    }
    public static void main(String[] args)
    {
        new quizjava("Java Quiz");

    }

    public void actionPerformed(ActionEvent e)
    {
        //throw new UnsupportedOperationException("not sured yet");

        if(e.getSource()==btnNext)
        {
            if(checkAns())
                count=count+1;
            current++;
            setData();
            if(current==9)
            {
                btnNext.setEnabled(false);
                btnResult.setVisible(true);
                btnResult.setText("Result");
            }
        }

        if(e.getSource()==btnback)
        {
            if(checkAns())
                count=count+1;
            current--;

            setData();
            if(current==9)
            {
                btnNext.setEnabled(true);
                btnResult.setVisible(true);
                btnResult.setText("Result");
            }

        }
        if(e.getActionCommand().equals("Result"))
        {
            if(checkAns())
                count=count+1;
            current++;
            JOptionPane.showMessageDialog(this,"correct answers are "+count);
            int marks=count;
            // System.out.println("marks are"+count);

            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/Java?characterEncoding=latin1", "root", "shravani");

                String query = "INSERT INTO quiz values('" + marks + "')";

                /*Statement stmt = con.createStatement();
                int x = stmt.executeUpdate(query);
                if (x == 0) {
                    JOptionPane.showMessageDialog(btnResult, "This is alredy exist");
                } else {
                    JOptionPane.showMessageDialog(btnResult, " sucessfully Added marks");
                }*/

                con.close();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
           // System.exit(0);
        }
    }



}
