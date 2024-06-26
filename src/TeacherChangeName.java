import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;



public class TeacherChangeName extends JFrame implements ActionListener{
    JLabel newFNamelbl;
    JLabel newLNamelbl;
    JTextField newFName;
    JTextField newLName;
    JButton updateNameButton;
    public TeacherChangeName(){
        newFNamelbl = new JLabel("First Name");
        newFNamelbl.setFont(new Font("Tahoma", Font.PLAIN, 20));
        newFNamelbl.setBounds(10, 10, 150, 30);
        add(newFNamelbl);


        newFName = new JTextField();
        newFName.setFont(new Font("Tahoma", Font.PLAIN, 22));
        newFName.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        newFName.setBounds(150, 10, 150, 40);
        add(newFName);
        newFName.setColumns(20);

        newLNamelbl = new JLabel("Last Name");
        newLNamelbl.setFont(new Font("Tahoma", Font.PLAIN, 20));
        newLNamelbl.setBounds(10, 80, 150, 30);
        add(newLNamelbl);


        newLName = new JTextField();
        newLName.setFont(new Font("Tahoma", Font.PLAIN, 22));
        newLName.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        newLName.setBounds(150, 80, 150, 40);
        add(newLName);
        newLName.setColumns(20);

        updateNameButton = new JButton("Update");
        updateNameButton.setBounds(80, 140, 150, 30);
        updateNameButton.addActionListener((ActionListener) this);
        add(updateNameButton);

//            ChangePassFrame.setResizable(false);
        setLayout(null);
        setSize(320,220);
        setLocation(500,320);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == updateNameButton){
            String FirstName = newFName.getText();
            String LastName = newLName.getText();
            try{
                //DBConnection c1 = new DBConnection();
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://Localhost:3306/Java?characterEncoding=latin1","root","shravani");
                Statement sta = con.createStatement();
                String q = "update Teacher SET firstName = '"+ FirstName +"', lastName = '"+ LastName +"'"
                        + "Where teacherID ='" + T_Login.currentTeacherID + "'";

                int x = sta.executeUpdate(q);
                if(x == 0){
                    JOptionPane.showMessageDialog(null, "Got some error");
                }else{
                    JOptionPane.showMessageDialog(null, "Your Name Updated Successfully");
                    setVisible(false);
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        new TeacherChangeName();
    }
}
