import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;



public class AdminDeleteAccount{
    int input;
    public AdminDeleteAccount(){
        input = JOptionPane.showConfirmDialog(null, "Do you want to proceed?", "Select an Option...",
                JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);

        if(input == 0){
            try{
               // DBConnection c1 = new DBConnection();
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Java?characterEncoding=latin1", "root", "shravani");
                Statement sta = con.createStatement();
                String q = "Delete From Admin Where Adminid ='" + A_Login.currentAdminID + "'";

                int x = sta.executeUpdate(q);
                if(x == 0){
                    JOptionPane.showMessageDialog(null, "Got some error");
                }else{
                    JOptionPane.showMessageDialog(null, "Account Deleted Successfully");

                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }

    }
    public static void main(String[] args) {
        new AdminDeleteAccount();
    }
}

