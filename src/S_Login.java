import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class S_Login implements ActionListener {
   JFrame f3;
   JLabel s1,user,pass;
   JTextField t1;
   JPasswordField t2;
   JButton log;

   public static int currentStudentID;
   String str1,str2;
   public void login1()
   {
       f3 = new JFrame("Student Login");
       f3.setSize(600,300);
       f3.setLayout(null);

      /* s1 = new JLabel("Student Login");
       s1.setFont(new Font("Times New Roman", Font.PLAIN, 42));
       s1.setBounds(362, 52, 380, 50);
       f3.add(s1);*/

       user = new JLabel("Username");
       user.setFont(new Font("Tahoma", Font.PLAIN, 20));
       user.setBounds(40, 20, 100, 30);
       f3.add(user);

       pass = new JLabel("Password");
       pass.setFont(new Font("Tahoma", Font.PLAIN, 20));
       pass.setBounds(40, 70, 100, 30);
       f3.add(pass);

       t1 = new JTextField();
       t1.setFont(new Font("Tahoma", Font.PLAIN, 30));
       t1.setBounds(150, 20, 150, 30);
       f3.add(t1);
       t1.addActionListener(this::actionPerformed);



       t2 = new JPasswordField();
       t2.setFont(new Font("Tahoma", Font.PLAIN, 30));
       t2.setBounds(150, 70, 150, 30);
       f3.add(t2);
       t2.addActionListener(this::actionPerformed);

       ImageIcon i1 = new ImageIcon("C:/Users/Kulkarni/IdeaProjects/JavaProject3/src/second.jpg");
       Image i2 = i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
       ImageIcon i3 =  new ImageIcon(i2);
       JLabel l3 = new JLabel(i3);
       l3.setBounds(350,20,150,150);
       f3.add(l3);

       log = new JButton("Login");
       log.setFont(new Font("Tahoma", Font.PLAIN, 22));
       log.setBounds(60, 140, 120, 30);
       f3.add(log);
       log.addActionListener(this::actionPerformed);

       f3.getContentPane().setBackground(Color.WHITE);

       f3.setVisible(true);
       f3.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
       f3.setLocation(420,365);

   }

    public static void main(String[] args) {
        S_Login d = new S_Login();
        d.login1();
    }



     public void actionPerformed(ActionEvent e) {
        String button = e.getActionCommand();
        if (button.equals("Login")) {
            str1 = t1.getText();
            str2 = t2.getText();
            dbcon();
            //Student s = new Student();

        }
    }

    public void dbcon()
    {
        //JFrame f1 = new JFrame();
        //JLabel l, l0;
        //JButton course,quiz,performance,assignment;

        System.out.println(str1);
        System.out.println(str2);
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Java?characterEncoding=latin1", "root", "shravani");
            PreparedStatement ps = con.prepareStatement("select * from Student where userName=? and password=?");
            ps.setString(1, str1);
            ps.setString(2, str2);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "login successful");
                currentStudentID = Integer.parseInt(rs.getString("stdID"));
                System.out.println(currentStudentID);
                f3.dispose();
                Student s = new Student();

          /*      f1.setVisible(true);
                f1.setSize(900, 600);
                f1.setLayout(null);
                l = new JLabel();
                l0 = new JLabel("you are succefully logged in..");
                l0.setForeground(Color.blue);
                l0.setFont(new Font("Serif", Font.BOLD, 30));
                l.setBounds(60, 50, 400, 30);
                l0.setBounds(60, 100, 400, 40);
                f1.add(l);
                f1.add(l0);
                l.setText("Welcome " + rs.getString(1));
                l.setForeground(Color.red);
                l.setFont(new Font("Serif", Font.BOLD, 30));

                course=new JButton("Course");
                quiz=new JButton("Quiz");
                performance=new JButton("Preformance");
                assignment=new JButton("Assignment");

                course.setBounds(100,200,200,60);
                quiz.setBounds(400,200,200,60);
                performance.setBounds(100,400,200,60);
                assignment.setBounds(400,400,200,60);

                f1.add(course);
                f1.add(quiz);
                f1.add(performance);
                f1.add(assignment);

                course.setFont(new Font("Serif", Font.BOLD, 20));
                quiz.setFont(new Font("Serif", Font.BOLD, 20));
                performance.setFont(new Font("Serif", Font.BOLD, 20));
                assignment.setFont(new Font("Serif", Font.BOLD, 20));

            }*/
            }
                else
            {
                JOptionPane.showMessageDialog(null,"Incorrect email-Id or password..Try Again with correct detail");
               // f3.dispose();
            }
        }
        catch (Exception ex)
        {
            System.out.println(ex);

        }

    }







}

