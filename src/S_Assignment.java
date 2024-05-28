import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;

public class S_Assignment
{
    JFrame j;
    JFrame j2=new JFrame("Display");
    ArrayList<String> arr=new ArrayList<String>();

    public void frame4() {

        JFrame j = new JFrame("Student Assignment");
        j.setSize(400,300);
        j.setLocation(550,365);



        JButton C = new JButton("C Assignment");
        C.setBounds(115,15,150,40);
        j.add(C);

        JButton Cpp = new JButton("Cpp Assignment");
        Cpp.setBounds(115,75,150,40);
        j.add(Cpp);

        JButton Python = new JButton("Python Assignment");
        Python.setBounds(115,135,150,40);
        j.add(Python);

        JButton java=new JButton("Java Assignment");
        java.setBounds(115,195,150,40);
        j.add(java);







        //for j2 frame  text area code
        JTextArea c1=new JTextArea();
        c1.setBounds(470,90,400,400);
        Font font = new Font("Serif", Font.BOLD, 20);
        c1.setFont(font);

        //back button for frame2

        JButton btnback=new JButton("Back");
        btnback.setFont(new Font(Font.SERIF,Font.BOLD,20));
        btnback.setBounds(480, 530, 150, 50);

        j2.add(btnback);
        j2.add(c1);

       // j2.setLayout(null);
        //j2.setVisible(true);

        j.setLayout(null);
        j.setVisible(true);


       java.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                j.dispose();
                j2.setSize(1400,800);

                //label n frame 2
                JLabel labelque=new JLabel("Assignment questions:");
                labelque.setBounds(550,20,350,50);
                labelque.setFont(new Font(Font.DIALOG,Font.BOLD,25));
                j2.add(labelque);

                //back button for frame2

                j2.add(btnback);
                j2.add(c1);




                j2.setLayout(null);
                j2.setVisible(true);

                try
                {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Java?characterEncoding=latin1", "root", "shravani");
                    Statement stmt= con.createStatement();
                    ResultSet rs=stmt.executeQuery("select *from assignment");
                    c1.setText(null);
                    while(rs.next())
                    {
                        c1.append(rs.getString(1)+":"+rs.getString(2)+"\n");
                    }
                   /* for(int i=0;i<arr.size();i++)
                    {
                        c1.append(arr.get(i)+"\n");
                    }*/
                    stmt.close();
                    con.close();
                }
                catch (Exception e1)
                {
                    System.out.println(e1);
                }
            }
        });


        C.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                j.dispose();
                j2.setSize(1400,800);

                //label n frame 2
                JLabel labelque=new JLabel("Assignment questions:");
                labelque.setBounds(550,20,350,50);
                labelque.setFont(new Font(Font.DIALOG,Font.BOLD,25));
                j2.add(labelque);

                //back button for frame2

                j2.add(btnback);
                j2.add(c1);
                j2.setLayout(null);
                j2.setVisible(true);

                try
                {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Java?characterEncoding=latin1", "root", "shravani");
                    Statement stmt= con.createStatement();
                    ResultSet rs=stmt.executeQuery("select *from assignmentc");
                    c1.setText(null);
                    while(rs.next())
                    {
                        c1.append(rs.getString(1)+":"+rs.getString(2)+"\n");
                    }
                    /*for(int i=0;i<arr.size();i++)
                    {
                        c1.append(arr.get(i)+"\n");
                    }*/
                    stmt.close();
                    con.close();
                }
                catch (Exception e1)
                {
                    System.out.println(e1);
                }
            }
        });

        Cpp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                j.dispose();
                j2.setSize(1400,800);

                //label n frame 2
                JLabel labelque=new JLabel("Assignment questions:");
                labelque.setBounds(550,20,350,50);
                labelque.setFont(new Font(Font.DIALOG,Font.BOLD,25));
                j2.add(labelque);

                //back button for frame2

                j2.add(btnback);
                j2.add(c1);
                j2.setLayout(null);
                j2.setVisible(true);

                try
                {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Java?characterEncoding=latin1", "root", "shravani");
                    Statement stmt= con.createStatement();
                    ResultSet rs=stmt.executeQuery("select *from assignmentcpp");
                    c1.setText(null);
                    while(rs.next())
                    {
                        c1.append(rs.getString(1)+":"+rs.getString(2)+"\n");
                    }
                    /*for(int i=0;i<arr.size();i++)
                    {
                        c1.append(arr.get(i)+"\n");
                    }*/
                    stmt.close();
                    con.close();
                }
                catch (Exception e1)
                {
                    System.out.println(e1);
                }
            }
        });


        Python.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                j.dispose();
                j2.setSize(1400,800);

                //label n frame 2
                JLabel labelque=new JLabel("Assignment questions:");
                labelque.setBounds(550,20,350,50);
                labelque.setFont(new Font(Font.DIALOG,Font.BOLD,25));
                j2.add(labelque);

                //back button for frame2

                j2.add(btnback);
                j2.add(c1);
                j2.setLayout(null);
                j2.setVisible(true);

                try
                {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Java?characterEncoding=latin1", "root", "shravani");
                    Statement stmt= con.createStatement();
                    ResultSet rs=stmt.executeQuery("select *from assignmentpython");
                    c1.setText(null);
                    while(rs.next())
                    {
                        c1.append(rs.getString(1)+":"+rs.getString(2)+"\n");
                    }
                    /*for(int i=0;i<arr.size();i++)
                    {
                        c1.append(arr.get(i)+"\n");
                    }*/
                    stmt.close();
                    con.close();
                }
                catch (Exception e1)
                {
                    System.out.println(e1);
                }
            }
        });

        //actionlistner for back button

        btnback.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                j2.dispose();
                j.setVisible(true);
            }

        });

    }




    public static void main(String[] args)
    {
        S_Assignment a=new S_Assignment();
        a.frame4();

    }

}