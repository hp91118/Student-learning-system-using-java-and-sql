import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;

public class C_Assignment
{
    JFrame j;
    JLabel label4 = new JLabel();
    JFrame j2=new JFrame("Display");
    ArrayList<String> arr=new ArrayList<String>();

    public void framec() {

        JFrame j = new JFrame("Add assignment");
        j.setSize(1400, 800);

        //labels

        JLabel label1=new JLabel("ASSIGNMENT");
        label1.setBounds(900,70,400,100);
        label1.setFont(new Font(Font.DIALOG,  Font.BOLD, 40));
        j.add(label1);

        JLabel label2 = new JLabel("Question no:");
        label2.setBounds(840, 180, 150, 100);
        label2.setFont(new Font(Font.SERIF,Font.BOLD,25));
        j.add(label2);

        JLabel label3 = new JLabel("Question:");
        label3.setBounds(840, 280, 150, 100);
        label3.setFont(new Font(Font.SERIF,Font.BOLD,25));
        j.add(label3);

        // textfields

        JTextField text = new JTextField();
        text.setBounds(1050, 210, 150, 50);
        text.setFont(new Font(Font.DIALOG,Font.BOLD,25));
        j.add(text);

        JTextField text1 = new JTextField();
        text1.setBounds(1050, 310, 150, 50);
        text1.setFont(new Font(Font.DIALOG,Font.BOLD,25));
        j.add(text1);

        JButton button = new JButton("Add question");
        button.setBounds(790, 430, 190, 50);
        j.add(button);

        JButton button1 = new JButton("Display questions");
        button1.setBounds(930, 550, 190, 50);
        j.add(button1);

        JButton btndelete=new JButton("Delete the question");
        btndelete.setBounds(1080,430,190,50);
        j.add(btndelete);

        //for j2 frame  text area code
        JTextArea c1=new JTextArea();
        c1.setBounds(470,110,450,450);
        Font font = new Font("Serif", Font.BOLD, 20);
        c1.setFont(font);

        //back button for frame2

        JButton btnback=new JButton("Back");
        btnback.setFont(new Font(Font.SERIF,Font.BOLD,20));
        btnback.setBounds(480, 590, 150, 50);

        //JLabel label4 = new JLabel(); //JLabel Creation
       // label4.setIcon(new ImageIcon("C:/Users/Kulkarni/IdeaProjects/JavaProject3/src/demo11.png")); //Sets the image to be displayed as an icon
        // Dimension size = label.getPreferredSize(); //Gets the size of the image
        //label4.setBounds(0, 0,1400, 800);
       // j.add(label4);
        JLabel labelpic = new JLabel();
        labelpic.setIcon(new ImageIcon("C:/Users/Kulkarni/IdeaProjects/JavaProject3/src/My project.png"));
        labelpic.setBounds(0,0,700,800);
        j.add(labelpic);

        ImageIcon icon = new ImageIcon("C:/Users/Kulkarni/IdeaProjects/JavaProject3/src/demo11.png");
        j.add(new JLabel(icon));
        j.pack();

        j.setLayout(null);
        j.setVisible(true);

        //actionlistner for add question button

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                int sr_no= Integer.parseInt(text.getText());
                String que = text1.getText();

                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/Java?characterEncoding=latin1", "root", "shravani");

                    String query = "INSERT INTO assignmentc values('" + sr_no + "','" + que + "')";

                    Statement stmt = con.createStatement();
                    int x = stmt.executeUpdate(query);
                    if (x == 0) {
                        JOptionPane.showMessageDialog(button, "This is alredy exist");
                    } else {
                        JOptionPane.showMessageDialog(button,
                                " sucessfully Added quetion");
                    }

                    con.close();
                } catch (Exception exception) {
                    exception.printStackTrace();
                }

            }
        });

        //actionlistner for delete question button

        btndelete.addActionListener(new ActionListener() {
            @Override

            public void actionPerformed(ActionEvent e) {
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    int n=Integer.parseInt(text.getText());
                    Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/Java?characterEncoding=latin1", "root", "shravani");

                    String query = "delete from assignmentc where sr_no=?";
                    PreparedStatement ptmt=con.prepareStatement(query);
                    ptmt.setInt(1,n);
                    ptmt.executeUpdate();
                    JOptionPane.showMessageDialog(null,"question deleted succesfully");
                    text.setText(" ");
                    con.close();
                } catch (Exception exception) {
                    exception.printStackTrace();
                }

            }
        });

        //actionlistner for display question button

        button1.addActionListener(new ActionListener() {
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

                 //JLabel Creation
                // Dimension size = label.getPreferredSize(); //Gets the size of the image
                label4.setIcon(new ImageIcon("C:/Users/Kulkarni/IdeaProjects/JavaProject3/src/demo11.png")); //Sets the image to be displayed as an icon
                label4.setBounds(0, 0,1400, 800);


                j2.add(label4);
                j2.setLayout(null);
                j2.setVisible(true);

                try
                {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Java?characterEncoding=latin1", "root", "shravani");
                    Statement stmt= con.createStatement();
                    ResultSet rs=stmt.executeQuery("select * from assignmentc");
                    c1.setText(null);
                    while(rs.next())
                    {
                        c1.append(rs.getString(1)+":"+rs.getString(2)+"\n");

                    }
                   /* for(int i=0;i<arr.size();i++)
                    {
                        c1.append(arr.get(i)+"\n");
                    }*/

                    //c1.clear();

                    c1.setEditable(false);
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
                j.add(label4);
                j.setVisible(true);
            }

        });

    }



    //private void actionPerformed(ActionEvent actionEvent) {
    //}

    public static void main(String[] args)
    {
        C_Assignment a=new C_Assignment();
        a.framec();

    }

}
