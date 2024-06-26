import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.sql.*;
import java.awt.event.*;


public class TeacherAccountDetails extends JFrame implements ActionListener{
    JPanel contentPane;
    JTextField firstname, lastname, email, username, passwordField;
    JButton OkButton;
    public TeacherAccountDetails(){
        super("Teacher Details");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(1014,550);
        setLocation(230,110);

        setResizable(false);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblTeacherDetails = new JLabel("Teacher Details");
        lblTeacherDetails.setFont(new Font("Times New Roman", Font.PLAIN, 42));
        lblTeacherDetails.setBounds(362, 52, 325, 50);
        contentPane.add(lblTeacherDetails);

        JLabel lblName = new JLabel("First name");
        lblName.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblName.setBounds(58, 152, 99, 43);
        contentPane.add(lblName);

        JLabel lblNewLabel = new JLabel("Last name");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel.setBounds(58, 243, 110, 29);
        contentPane.add(lblNewLabel);

        JLabel lblEmailAddress = new JLabel("Email\r\n address");
        lblEmailAddress.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblEmailAddress.setBounds(58, 324, 124, 36);
        contentPane.add(lblEmailAddress);

        String firstName = null,lastName = null,
                emailId = null, userName = null,
                password = null;
        try{
            //DBConnection c1 = new DBConnection();
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://Localhost:3306/Java?characterEncoding=latin1","root","shravani");
            Statement sta = con.createStatement();
            String q = "select * from Teacher where teacherID = '"+ T_Login.currentTeacherID +"'";

            ResultSet rs = sta.executeQuery(q);
            if(rs.next()){
                firstName = rs.getString("firstName");
                lastName = rs.getString("lastName");
                emailId = rs.getString("emaiId");
                userName = rs.getString("userName");
                password = rs.getString("password");
               // userGender = rs.getString("Gender");
            }else{
                JOptionPane.showMessageDialog(null, "Not Found");
            }
        }catch(Exception e){
            e.printStackTrace();
        }


        firstname = new JTextField();
        firstname.setFont(new Font("Tahoma", Font.PLAIN, 32));
        firstname.setBounds(214, 151, 228, 50);
        firstname.setText(firstName);
        firstname.setEditable(false);
        contentPane.add(firstname);

        lastname = new JTextField();
        lastname.setFont(new Font("Tahoma", Font.PLAIN, 32));
        lastname.setBounds(214, 235, 228, 50);
        lastname.setText(lastName);
        lastname.setEditable(false);
        contentPane.add(lastname);

        email = new JTextField();

        email.setFont(new Font("Tahoma", Font.PLAIN, 32));
        email.setBounds(214, 320, 320, 50);
        email.setEditable(false);
        email.setText(emailId);
        contentPane.add(email);

        username = new JTextField();
        username.setFont(new Font("Tahoma", Font.PLAIN, 32));
        username.setBounds(707, 151, 228, 50);
        username.setEditable(false);
        username.setText(userName);
        contentPane.add(username);

        JLabel lblUsername = new JLabel("Username");
        lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblUsername.setBounds(542, 159, 99, 29);
        contentPane.add(lblUsername);

        JLabel lblPassword = new JLabel("Password");
        lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblPassword.setBounds(542, 245, 99, 24);
        contentPane.add(lblPassword);

        passwordField = new JTextField();
        passwordField.setFont(new Font("Tahoma", Font.PLAIN, 32));
        passwordField.setBounds(707, 235, 228, 50);
        passwordField.setEditable(false);
        passwordField.setText(password);
        contentPane.add(passwordField);

       /* JLabel lblGender = new JLabel("Gender");
        lblGender.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblGender.setBounds(542, 321, 99, 24);
        contentPane.add(lblGender);

        gender = new JTextField();
        gender.setFont(new Font("Tahoma", Font.PLAIN, 32));
        gender.setBounds(707, 311, 228, 50);
        gender.setEditable(false);
        gender.setText(userGender);
        contentPane.add(gender);*/

        OkButton = new JButton("Ok");
        OkButton.setBounds(410, 440, 228, 60);
        OkButton.addActionListener((ActionListener) this);
        contentPane.add(OkButton);

        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == OkButton){
            dispose();
        }
    }

    public static void main(String[] args) {
        new TeacherAccountDetails();
    }
}
