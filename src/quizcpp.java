



import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;



public class quizcpp extends JFrame implements ActionListener
{
    JLabel label;
    JRadioButton radioButtons[]=new JRadioButton[5];
    JButton btnNext,btnback,btnResult;
    ButtonGroup bg ;
    int count=0,current=0,x=1,y=1,now=0;
    int m[]=new int[10];

    quizcpp(String s)
    {
        super(s);
        label=new JLabel();
        add(label);
        bg=new ButtonGroup();

        for (int i=0; i<5; i++)
        {
            radioButtons[i] = new JRadioButton();
            radioButtons[i].setFont(new Font("Times New Roman",Font.BOLD,18));
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
        label.setFont(new Font("Times New Roman",Font.BOLD,23));
       // radioButtons[0].setBounds(430,110,800,20);
        radioButtons [0].setBounds(150, 120, 450, 40);
        radioButtons [1].setBounds (150,180,450,40);
        radioButtons [2].setBounds (150,240, 450, 40);
        radioButtons [3].setBounds (150,300,450,40);
        btnNext.setBounds (500,380,100, 40);
        btnback.setBounds(350,380,100, 40);
        btnResult.setBounds (650,380, 100, 40);

        JLabel label1 = new JLabel();
        label1.setIcon(new ImageIcon("C:/Users/Kulkarni/IdeaProjects/JavaProject3/src/test7.png"));

        label1.setBounds(1000,20,400,400);
        add(label1);

        ImageIcon icon = new ImageIcon("C:/Users/Kulkarni/IdeaProjects/JavaProject3/src/demo11.png");
        add(new JLabel(icon));
        pack();


        //JLabel label1 = new JLabel(); //JLabel Creation
        //label1.setIcon(new ImageIcon("C:/Users/Kulkarni/IdeaProjects/JavaProject3/src/demo11.png")); //Sets the image to be displayed as an icon
        // Dimension size = label.getPreferredSize(); //Gets the size of the image
        //label1.setBounds(0, 0,1400, 800);
        //add(label1);



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
            label.setText("Q1 : Who invented C++?");
            radioButtons[0].setText(" Bjarne Stroustrup ");
            radioButtons[1].setText("Dennis Ritchie");
            radioButtons[2].setText("Ken Thompson");
            radioButtons[3].setText("Brian Kernighan ");
        }

        if(current==1)
        {
            label.setText("Q2 : What is C++?");
            radioButtons[0].setText("C++ is an object oriented programming language ");
            radioButtons[1].setText("C++ is a procedural programming language ");
            radioButtons[2].setText("C++ is a functional programming language ");
            radioButtons[3].setText("C++ supports both procedural and object oriented programming language ");
        }

        if(current==2)
        {
            label.setText("Q3 :Which of the following is used for comments in C++? ");
            radioButtons[0].setText(" /* comment */ ");
            radioButtons[1].setText("both // comment or /* comment */ ");
            radioButtons[2].setText("// comment ");
            radioButtons[3].setText("// comment */ ");
        }

        if(current==3)
        {
            label.setText("Q4 :Which of the following is a correct identifier in C++? ");
            radioButtons[0].setText("VAR_1234 ");
            radioButtons[1].setText(" $var_name ");
            radioButtons[2].setText("7VARNAME ");
            radioButtons[3].setText("7var_name ");
        }

        if(current==4)
        {
            label.setText("Q5 :Which of the following is not a type of Constructor in C++? ");
            radioButtons[0].setText("Default constructor");
            radioButtons[1].setText("Friend constructor");
            radioButtons[2].setText("Parameterized constructor");
            radioButtons[3].setText("none of the above ");
        }

        if(current==5)
        {
            label.setText("Q6 :Which of the following is the correct syntax to print the message in C++ language? ");
            radioButtons[0].setText("Out <<\"Hello world!; ");
            radioButtons[1].setText("Cout << Hello world! ; ");
            radioButtons[2].setText("cout <<\"Hello world!\"; ");
            radioButtons[3].setText("None of the above ");
        }

        if(current==6)
        {
            label.setText("Q7 :Which of the following is the address operator? ");
            radioButtons[0].setText("@ ");
            radioButtons[1].setText("# ");
            radioButtons[2].setText("%");
            radioButtons[3].setText("& ");
        }

        if(current==7)
        {
            label.setText("Q8 :What does polymorphism stand for? ");
            radioButtons[0].setText("a class that has many forms");
            radioButtons[1].setText("a class that has two forms ");
            radioButtons[2].setText("a class that has only a single form");
            radioButtons[3].setText(" a class that has four forms");
        }

        if(current==8)
        {
            label.setText("Q9 :Inheritance models which type of relationship? ");
            radioButtons[0].setText("Is-A relationship");
            radioButtons[1].setText("Belongs-to relationship ");
            radioButtons[2].setText("Has-A relationship ");
            radioButtons[3].setText("Part-Of relationship ");
        }

        if(current==9)
        {
            label.setText("Q10 :Which function executes faster but requires more memory space? ");
            radioButtons[0].setText("Regular function ");
            radioButtons[1].setText(" Void function");
            radioButtons[2].setText("Normal function ");
            radioButtons[3].setText("Inline function ");
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
        new quizcpp("CPP Quiz");

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
            //System.exit(0);
        }
    }



}

