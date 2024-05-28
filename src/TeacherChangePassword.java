import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;

public class TeacherChangePassword extends JFrame implements ActionListener{
    JLabel newPasswordlbl;
    JPasswordField newPassword;
    JButton updatePassbtn;
    public TeacherChangePassword(){
        newPasswordlbl = new JLabel("New Password");
        newPasswordlbl.setFont(new Font("Tahoma", Font.PLAIN, 20));
        newPasswordlbl.setBounds(10, 10, 150, 30);
        add(newPasswordlbl);


        newPassword = new JPasswordField();
        newPassword.setFont(new Font("Tahoma", Font.PLAIN, 22));
        newPassword.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        newPassword.setBounds(150, 10, 150, 40);
        add(newPassword);
        newPassword.setColumns(20);

        updatePassbtn = new JButton("Update");
        updatePassbtn.setBounds(80, 90, 150, 30);
        updatePassbtn.addActionListener((ActionListener) this);
        add(updatePassbtn);

//            ChangePassFrame.setResizable(false);
        setLayout(null);
        setSize(320,220);
        setLocation(500,320);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == updatePassbtn){
            String password = String.valueOf(newPassword.getPassword());
            try{
                //DBConnection c1 = new DBConnection();
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Java?characterEncoding=latin1", "root", "shravani");
                Statement sta = con.createStatement();

                String q = "update Teacher SET password = '"+ password +"'"
                        + "Where teacherID ='" + T_Login.currentTeacherID + "'";

                int x = sta.executeUpdate(q);
                if(x == 0){
                    JOptionPane.showMessageDialog(null, "Got some error");
                }else{
                    JOptionPane.showMessageDialog(null, "Your Password Updated Successfully");
                    setVisible(false);
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        new TeacherChangePassword();
    }
}
