import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class T_Login implements ActionListener {
    JFrame f4;
    JLabel s1, user, pass;
    JTextField t1;
    JPasswordField t2;
    JButton log;

    String str1, str2;

    public static int currentTeacherID;

    public void login2() {
        f4 = new JFrame("Teacher Login");
        f4.setSize(600,300);
        f4.setLayout(null);

      /*  s1 = new JLabel("Teacher Login");
        s1.setFont(new Font("Times New Roman", Font.PLAIN, 42));
        s1.setBounds(362, 52, 380, 50);
        f4.add(s1);*/

        user = new JLabel("Username");
        user.setFont(new Font("Tahoma", Font.PLAIN, 20));
        user.setBounds(40, 20, 100, 30);
        f4.add(user);

        pass = new JLabel("Password");
        pass.setFont(new Font("Tahoma", Font.PLAIN, 20));
        pass.setBounds(40, 70, 100, 30);
        f4.add(pass);

        t1 = new JTextField();
        t1.setFont(new Font("Tahoma", Font.PLAIN, 30));
        t1.setBounds(150, 20, 150, 30);
        f4.add(t1);
        t1.addActionListener(this::actionPerformed);


        t2 = new JPasswordField();
        t2.setFont(new Font("Tahoma", Font.PLAIN, 30));
        t2.setBounds(150, 70, 150, 30);
        f4.add(t2);
        t2.addActionListener(this::actionPerformed);

        ImageIcon i1 = new ImageIcon("C:/Users/Kulkarni/IdeaProjects/JavaProject3/src/second.jpg");
        Image i2 = i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i3 =  new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(350,20,150,150);
        f4.add(l3);

        log = new JButton("Login");
        log.setFont(new Font("Tahoma", Font.PLAIN, 22));
        log.setBounds(60, 140, 120, 30);
        f4.add(log);
        log.addActionListener(this::actionPerformed);

        f4.getContentPane().setBackground(Color.WHITE);

        f4.setVisible(true);
        f4.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        f4.setLocation(420,365);

    }

    public static void main(String[] args) {
        T_Login d1 = new T_Login();
        d1.login2();
    }


    public void actionPerformed(ActionEvent e) {
        String button = e.getActionCommand();
        if (button.equals("Login")) {
            str1 = t1.getText();
            str2 = t2.getText();
            dbcon1();
          //  Teacher t = new Teacher();
        }
    }

    public void dbcon1() {

        System.out.println(str1);
        System.out.println(str2);
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Java?characterEncoding=latin1", "root", "shravani");
            PreparedStatement ps = con.prepareStatement("select * from Teacher where userName=? and password=?");
            ps.setString(1, str1);
            ps.setString(2, str2);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                JOptionPane.showMessageDialog(null,"login successfull");
                currentTeacherID = Integer.parseInt(rs.getString("teacherID"));
                System.out.println(currentTeacherID);
                f4.dispose();
                Teacher t = new Teacher();

            } else {
                JOptionPane.showMessageDialog(null, "Incorrect email-Id or password..Try Again with correct detail");
            }
        } catch (Exception ex) {
            System.out.println(ex);

        }

    }
}


