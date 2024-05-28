import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;


public class TeacherChangeEmail extends JFrame implements ActionListener{
    JLabel newEmaillbl;
    JTextField newEmail;
    JButton updateEmailbtn;
    public TeacherChangeEmail(){
        newEmaillbl = new JLabel("New Email");
        newEmaillbl.setFont(new Font("Tahoma", Font.PLAIN, 20));
        newEmaillbl.setBounds(10, 10, 150, 30);
        add(newEmaillbl);


        newEmail = new JTextField();
        newEmail.setFont(new Font("Tahoma", Font.PLAIN, 22));
        newEmail.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        newEmail.setBounds(150, 10, 150, 40);
        add(newEmail);
        newEmail.setColumns(20);

        updateEmailbtn = new JButton("Update");
        updateEmailbtn.setBounds(80, 90, 150, 30);
        updateEmailbtn.addActionListener((ActionListener) this);
        add(updateEmailbtn);

//            ChangePassFrame.setResizable(false);
        setLayout(null);
        setSize(320,220);
        setLocation(500,320);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == updateEmailbtn){
            String EmailID = newEmail.getText();
            try{
               // DBConnection c1 = new DBConnection();
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Java?characterEncoding=latin1", "root", "shravani");
                Statement sta = con.createStatement();
                String q = "update Teacher SET emaiId = '"+ EmailID +"'"
                        + "Where teacherID ='" + T_Login.currentTeacherID + "'";

                int x = sta.executeUpdate(q);
                if(x == 0){
                    JOptionPane.showMessageDialog(null, "Got some error");
                }else{
                    JOptionPane.showMessageDialog(null, "Your Email Updated Successfully");
                    setVisible(false);
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        new TeacherChangeEmail();
    }
}

