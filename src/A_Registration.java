import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


public class A_Registration{
    JFrame f;
    JLabel ar,fn,ln,email,user,pass,mob;
    JTextField t1,t2,t3,t4,t5,t6;
    JButton regi;




    public void Register4() {
        f = new JFrame("Admin Registration");
        f.setSize(1600, 800);

        f.setLayout(null);

        ar = new JLabel("Admin Registration");
        ar.setFont(new Font("Times New Roman", Font.PLAIN, 42));
        ar.setBounds(362, 52, 350, 50);
        f.add(ar);

        fn = new JLabel("First Name");
        fn.setFont(new Font("Tahoma", Font.PLAIN, 20));
        fn.setBounds(58, 152, 99, 43);
        f.add(fn);

        ln = new JLabel("Last Name");
        ln.setFont(new Font("Tahoma", Font.PLAIN, 20));
        ln.setBounds(58, 243, 110, 29);
        f.add(ln);

        email = new JLabel("Email Address");
        email.setFont(new Font("Tahoma", Font.PLAIN, 20));
        email.setBounds(58, 324, 135, 36);
        f.add(email);

        user = new JLabel("Username");
        user.setFont(new Font("Tahoma", Font.PLAIN, 20));
        user.setBounds(542, 159, 99, 29);
        f.add(user);

        pass = new JLabel("Password");
        pass.setFont(new Font("Tahoma", Font.PLAIN, 20));
        pass.setBounds(542, 245, 99, 24);
        f.add(pass);

        mob = new JLabel("Mobile Number");
        mob.setFont(new Font("Tahoma", Font.PLAIN, 20));
        mob.setBounds(542, 329, 139, 26);
        f.add(mob);

        t1 = new JTextField();
        t1.setFont(new Font("Tahoma", Font.PLAIN, 32));
        t1.setBounds(214, 151, 228, 50);
        f.add(t1);
        // t1.addActionListener(this::actionPerformed);

        t2 = new JTextField();
        t2.setFont(new Font("Tahoma", Font.PLAIN, 32));
        t2.setBounds(214, 235, 228, 50);
        f.add(t2);
        //t2.addActionListener(this::actionPerformed);

        t3 = new JTextField();
        t3.setFont(new Font("Tahoma", Font.PLAIN, 32));
        t3.setBounds(214, 320, 228, 50);
        f.add(t3);
        //t3.addActionListener(this::actionPerformed);

        t4 = new JTextField();
        t4.setFont(new Font("Tahoma", Font.PLAIN, 32));
        t4.setBounds(707, 151, 228, 50);
        f.add(t4);
        //t4.addActionListener(this::actionPerformed);

        t5 = new JPasswordField();
        t5.setFont(new Font("Tahoma", Font.PLAIN, 32));
        t5.setBounds(707, 235, 228, 50);
        f.add(t5);
        //t5.addActionListener(this::actionPerformed);

        t6 = new JTextField();
        t6.setFont(new Font("Tahoma", Font.PLAIN, 32));
        t6.setBounds(707, 320, 228, 50);
        f.add(t6);
        //t6.addActionListener(this::actionPerformed);

        regi = new JButton("Register");
        regi.setFont(new Font("Tahoma", Font.PLAIN, 22));
        regi.setBounds(399, 447, 259, 74);
        f.add(regi);


        JLabel label1 = new JLabel(); //JLabel Creation
        label1.setIcon(new ImageIcon("C:/Users/Kulkarni/IdeaProjects/JavaProject3/src/demo11.png")); //Sets the image to be displayed as an icon
        Dimension size = label1.getPreferredSize(); //Gets the size of the image
        label1.setBounds(0, 0,1400, 800);
        f.add(label1);

        f.setVisible(true);
        regi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String firstName = t1.getText();
                String lastName = t2.getText();
                String emailId = t3.getText();
                String userName = t4.getText();
                String mobileNumber = t6.getText();
                int len = mobileNumber.length();
                String password = t5.getText();

                String msg = "" + firstName;
                msg += " \n";
                if (len != 10) {
                    JOptionPane.showMessageDialog(t6, "Enter a valid mobile number");
                }

                else{
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Java?characterEncoding=latin1", "root", "shravani");

                    String query = "INSERT INTO Admin(firstName,lastName,userName,password,emailId,mobileNumber) values('" + firstName + "','" + lastName + "','" + userName + "','" +
                            password + "','" + emailId + "','" + mobileNumber + "')";

                    Statement sta = connection.createStatement();
                    int x = sta.executeUpdate(query);
                    if (x == 0) {
                        JOptionPane.showMessageDialog(regi, "This is alredy exist");
                    } else {
                        JOptionPane.showMessageDialog(regi,
                                "Welcome, " + msg + "Your account is sucessfully created");
                        A_Login a = new A_Login();
                        a.login3();

                    }
                    connection.close();
                } catch (Exception exception) {
                    exception.printStackTrace();
                }}
            }
        });

    }


    public static void main(String[]args){

        A_Registration a1 = new A_Registration();
        a1.Register4();

    }
}

