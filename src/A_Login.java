import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class A_Login implements ActionListener {
    JFrame aregi;
    JLabel s1, user, pass;
    JTextField t1;
    JPasswordField t2;
    JButton log;

    String str1, str2;

    public static int currentAdminID;

    public void login3() {
        aregi = new JFrame("Admin Login");
        aregi.setSize(600, 300);
        aregi.setLayout(null);

       /* s1 = new JLabel("Admin Login");
        s1.setFont(new Font("Times New Roman", Font.PLAIN, 42));
        s1.setBounds(362, 52, 380, 50);
        aregi.add(s1);*/

        user = new JLabel("Username");
        user.setFont(new Font("Tahoma", Font.PLAIN, 20));
        user.setBounds(40, 20, 100, 30);
        aregi.add(user);

        pass = new JLabel("Password");
        pass.setFont(new Font("Tahoma", Font.PLAIN, 20));
        pass.setBounds(40, 70, 100, 30);
        aregi.add(pass);

        t1 = new JTextField();
        t1.setFont(new Font("Tahoma", Font.PLAIN, 30));
        t1.setBounds(150, 20, 150, 30);
        aregi.add(t1);
        t1.addActionListener(this::actionPerformed);


        t2 = new JPasswordField();
        t2.setFont(new Font("Tahoma", Font.PLAIN, 30));
        t2.setBounds(150, 70, 150, 30);
        aregi.add(t2);
        t2.addActionListener(this::actionPerformed);

        ImageIcon i1 = new ImageIcon("C:/Users/Kulkarni/IdeaProjects/JavaProject3/src/second.jpg");
        Image i2 = i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i3 =  new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(350,20,150,150);
        aregi.add(l3);


        log = new JButton("Login");
        log.setFont(new Font("Tahoma", Font.PLAIN, 22));
        log.setBounds(60, 140, 120, 30);
      //  log.setBackground(Color.BLACK);
      //  log.setForeground(Color.WHITE);
        aregi.add(log);

       aregi.getContentPane().setBackground(Color.WHITE);
        log.addActionListener(this::actionPerformed);

        aregi.setVisible(true);
        aregi.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        aregi.setLocation(420,365);

    }

    public static void main(String[] args) {
        A_Login d = new A_Login();
        d.login3();
    }


    public void actionPerformed(ActionEvent e) {
        String button = e.getActionCommand();
        if (button.equals("Login")) {
            str1 = t1.getText();
            str2 = t2.getText();
            dbcon1();
           // Admin a = new Admin();
        }
    }

    public void dbcon1() {

        System.out.println(str1);
        System.out.println(str2);
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Java?characterEncoding=latin1", "root", "shravani");
            PreparedStatement ps = con.prepareStatement("select * from Admin where userName=? and password=?");
            ps.setString(1, str1);
            ps.setString(2, str2);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                JOptionPane.showMessageDialog(null,"login successfull");
                currentAdminID = Integer.parseInt(rs.getString("adminID"));
                System.out.println(currentAdminID);
                Admin a = new Admin();
                aregi.dispose();

            } else {
                JOptionPane.showMessageDialog(null, "Incorrect email-Id or password..Try Again with correct detail");
            }
        } catch (Exception ex) {
            System.out.println(ex);

        }

    }
}



