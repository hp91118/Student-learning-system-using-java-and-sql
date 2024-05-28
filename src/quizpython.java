



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



public class quizpython extends JFrame implements ActionListener
{
    JLabel label;
    JRadioButton radioButtons[]=new JRadioButton[5];
    JButton btnNext,btnback,btnResult;
    ButtonGroup bg ;
    int count=0,current=0,x=1,y=1,now=0;
    int m[]=new int[10];

    quizpython(String s)
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
        label.setFont(new Font("Times New Roman",Font.BOLD,22));
       // radioButtons[0].setBounds(150,110,700,20);
        radioButtons [0].setBounds(150, 120, 450, 40);
        radioButtons [1].setBounds (150,180,450,40);
        radioButtons [2].setBounds (150,240, 450, 40);
        radioButtons [3].setBounds (150,300,450,40);
        btnNext.setBounds (500,380,100, 40);
        btnback.setBounds(350,380,100, 40);
        btnResult.setBounds (650,380, 100, 40);

       // JLabel label1 = new JLabel(); //JLabel Creation
       // label1.setIcon(new ImageIcon("C:/Users/Kulkarni/IdeaProjects/JavaProject3/src/demo11.png")); //Sets the image to be displayed as an icon
        // Dimension size = label.getPreferredSize(); //Gets the size of the image
       // label1.setBounds(0, 0,1400, 800);
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
            label.setText("Q1 :Who developed Python Programming Language?");
            radioButtons[0].setText("Guido van Rossum");
            radioButtons[1].setText("Wick van Rossum");
            radioButtons[2].setText("Rasmus Lerdorf");
            radioButtons[3].setText("Niene Stom");
        }

        if(current==1)
        {
            label.setText("Q2 :Which type of Programming does Python support? ");
            radioButtons[0].setText("object-oriented programming");
            radioButtons[1].setText("structured programming");
            radioButtons[2].setText("functional programming");
            radioButtons[3].setText("all of the mentioned");
        }

        if(current==2)
        {
            label.setText("Q3 :Which of the following is the correct extension of the Python file?");
            radioButtons[0].setText(".python");
            radioButtons[1].setText(".py");
            radioButtons[2].setText(".py");
            radioButtons[3].setText(" .p");
        }

        if(current==3)
        {
            label.setText("Q4 :Which keyword is used for function in Python language? ");
            radioButtons[0].setText("def");
            radioButtons[1].setText("Function");
            radioButtons[2].setText("Fun");
            radioButtons[3].setText("Define");
        }

        if(current==4)
        {
            label.setText("Q5 :Which of the following character is used to give single-line comments in Python?");
            radioButtons[0].setText("//");
            radioButtons[1].setText(" #");
            radioButtons[2].setText("!");
            radioButtons[3].setText("/*");
        }

        if(current==5)
        {
            label.setText("Q6 :Python supports the creation of anonymous functions at runtime, using a construct called ");
            radioButtons[0].setText("none of the mentioned");
            radioButtons[1].setText("anonymous");
            radioButtons[2].setText("lambda");
            radioButtons[3].setText("pi");
        }

        if(current==6)
        {
            label.setText("Q7 :What do we use to define a block of code in Python language?");
            radioButtons[0].setText("None of these");
            radioButtons[1].setText("Key");
            radioButtons[2].setText("backets");
            radioButtons[3].setText("Indentation");
        }

        if(current==7)
        {
            label.setText("Q8 Which of the following is a Python tuple? ");
            radioButtons[0].setText("(1, 2, 3)");
            radioButtons[1].setText("{}");
            radioButtons[2].setText("{1, 2, 3}");
            radioButtons[3].setText("[1, 2, 3]");
        }

        if(current==8)
        {
            label.setText("Q9 :Which of the following commands will create a list? ");
            radioButtons[0].setText("all of the mentioned");
            radioButtons[1].setText("list1 = []");
            radioButtons[2].setText("list1 = list([1, 2, 3])");
            radioButtons[3].setText("list1 = list()");
        }

        if(current==9)
        {
            label.setText("Q10 :Is Python code compiled or interpreted?");
            radioButtons[0].setText("Python code is neither compiled nor interpreted ");
            radioButtons[1].setText("Python code is only compiled ");
            radioButtons[2].setText("Python code is only interpreted ");
            radioButtons[3].setText("Python code is both compiled and interpreted");
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
        new quizpython("Python Quiz");

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