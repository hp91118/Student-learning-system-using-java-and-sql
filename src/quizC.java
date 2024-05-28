



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



public class quizC extends JFrame implements ActionListener
{
    JLabel label;
    JRadioButton radioButtons[]=new JRadioButton[5];
    JButton btnNext,btnback,btnResult;
    ButtonGroup bg ;
    int count=0,current=0,x=1,y=1,now=0;
    int m[]=new int[10];

    quizC(String s)
    {
        super(s);

        label=new JLabel();
        add(label);


       // setLocation(250, 100);
       // ImageIcon icon=new ImageIcon("C:/Users/kamble/Desktop/SE/demo11.png");
       // JLabel l =new JLabel();
        //add(l);

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
      //  radioButtons[0].setBounds(150,120,450,40);
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

       // JLabel label1 = new JLabel(); //JLabel Creation
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
            label.setText("Q1 :Who is the father of C language? ");
            radioButtons[0].setText("Dennis Ritchie ");
            radioButtons[1].setText("James Gosling ");
            radioButtons[2].setText("Steve Jobs ");
            radioButtons[3].setText("Rasmus Lerdorf");
        }

        if(current==1)
        {
            label.setText("Q2 :C language is used in the development of? ");
            radioButtons[0].setText("Databases ");
            radioButtons[1].setText("Graphic applications ");
            radioButtons[2].setText("Word Processors");
            radioButtons[3].setText("All of the above ");
        }

        if(current==2)
        {
            label.setText("Q3 :Which of the following symbol is used to denote a pre-processor statement?  ");
            radioButtons[0].setText("=");
            radioButtons[1].setText("#");
            radioButtons[2].setText("!");
            radioButtons[3].setText("not know");
        }

        if(current==3)
        {
            label.setText("Q4 :  Character constants should be enclosed between");
            radioButtons[0].setText("Single quotes");
            radioButtons[1].setText("double quotes");
            radioButtons[2].setText("both a and b");
            radioButtons[3].setText(" none of the above");
        }

        if(current==4)
        {
            label.setText("Q5 :Header files in C contain ");
            radioButtons[0].setText("Compiler commands  ");
            radioButtons[1].setText("Library functions");
            radioButtons[2].setText("Header information of C programs ");
            radioButtons[3].setText("Operators for files ");
        }

        if(current==5)
        {
            label.setText("Q6 : C programs are converted into machine language with the help of");
            radioButtons[0].setText("An Editor");
            radioButtons[1].setText("An operating system ");
            radioButtons[2].setText("A compiler ");
            radioButtons[3].setText("None of these ");
        }

        if(current==6)
        {
            label.setText("Q7 :Which is the only function all C programs must contain? ");
            radioButtons[0].setText("start( )");
            radioButtons[1].setText("printf ( )");
            radioButtons[2].setText("system( )");
            radioButtons[3].setText(" main( )");
        }

        if(current==7)
        {
            label.setText("Q8 : What is the size of an int data type?");
            radioButtons[0].setText("Depends on the system/compiler ");
            radioButtons[1].setText("4 Bytes");
            radioButtons[2].setText("8 Bytes");
            radioButtons[3].setText("Cannot be determined");
        }

        if(current==8)
        {
            label.setText("Q9 :The compiler in C ignores all text till the end of line using ");
            radioButtons[0].setText("// ");
            radioButtons[1].setText("/");
            radioButtons[2].setText("*/");
            radioButtons[3].setText("none of above");
        }

        if(current==9)
        {
            label.setText("Q10 :Which operator has the highest priority ");
            radioButtons[0].setText("[]");
            radioButtons[1].setText("*");
            radioButtons[2].setText("/");
            radioButtons[3].setText("() ");
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
        new quizC("C Quiz");

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
