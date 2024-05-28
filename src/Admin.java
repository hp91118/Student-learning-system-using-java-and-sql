import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;



public class Admin extends JFrame implements ActionListener,WindowStateListener{
    JPanel sidePanel, rightPanel, buttonsPanel;
    JButton manageAccount, viewProfileBtn, logoutBtn;
    JLabel label, backgroundPic;
    JButton b1,b2, b3, b4, b5, b6, b7, b8, b9;
    JLabel lblUsername;

    public Admin(){
        super("Admin Module");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(1280,720);
        setLocation(35,30);
        setLayout(new BorderLayout());

        ImageIcon icon = new ImageIcon("C:/Users/Kulkarni/IdeaProjects/JavaProject3/src/systemIcon.png");
        setIconImage(icon.getImage());

        sidePanel = new JPanel();
        sidePanel.setLayout(null);
        sidePanel.setBackground(new Color(64, 64, 64));
        Dimension sidePanelSize = new Dimension(180, 720);
        sidePanel.setPreferredSize(sidePanelSize);
        add(sidePanel, BorderLayout.WEST);



        String firstName = null,lastName = null;

        try{

            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Java?characterEncoding=latin1", "root", "shravani");
            PreparedStatement ps = con.prepareStatement("select * from Admin where adminID = '"+ A_Login.currentAdminID +"'");
            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                firstName = rs.getString("firstName");
                lastName = rs.getString("lastName");

            }else{
                JOptionPane.showMessageDialog(null, "Not Found");
            }
            ps.close();
        }catch(Exception e){
            e.printStackTrace();
        }



        lblUsername = new JLabel();
        lblUsername.setFont(new Font(Font.SERIF,Font.BOLD, 20));
        lblUsername.setForeground(new Color(45,255,3));
        lblUsername.setBounds(20, 98, 150, 40);
        lblUsername.setHorizontalAlignment((int) CENTER_ALIGNMENT);
        lblUsername.setText(firstName + " " + lastName);
        sidePanel.add(lblUsername);



        logoutBtn = new JButton("Logout");
        logoutBtn.setFont(new Font(Font.SERIF,Font.BOLD, 13));
        logoutBtn.setBackground(Color.BLACK);
        logoutBtn.setForeground(Color.WHITE);
        logoutBtn.setBounds(30, 600, 120, 28);
        logoutBtn.setHorizontalAlignment((int) CENTER_ALIGNMENT);
        logoutBtn.addActionListener((ActionListener) this);
        sidePanel.add(logoutBtn);

        //rightPanel Code
        rightPanel = new JPanel(new BorderLayout());
        add(rightPanel, BorderLayout.CENTER);


        JLabel mainTitle = new JLabel("Admin Module");
        mainTitle.setHorizontalAlignment(JLabel.CENTER);
        mainTitle.setFont(new Font(Font.SERIF,Font.BOLD, 50));
        mainTitle.setBackground(Color.BLACK);
        mainTitle.setForeground(Color.WHITE);
        mainTitle.setOpaque(true);
        rightPanel.add(mainTitle, BorderLayout.NORTH);

        buttonsPanel = new JPanel();
        buttonsPanel.setLayout(null);
        rightPanel.add(buttonsPanel, BorderLayout.CENTER);

        JLabel buttonSectionTitle = new JLabel("My Account");
        buttonSectionTitle.setFont(new Font(Font.SERIF,Font.BOLD, 25));
        buttonSectionTitle.setForeground(Color.BLACK);
        buttonSectionTitle.setHorizontalAlignment(JLabel.LEFT);
        buttonSectionTitle.setBounds(6,6,150,50);
        buttonsPanel.add(buttonSectionTitle);

        // 64 is the size of Button Icon https://icons8.com/

        b1 = new JButton("Manage Account");
        b1.setIcon(new ImageIcon("C:/Users/Kulkarni/IdeaProjects/JavaProject3/src/ManageAccount.png"));
        b1.setBounds(250,60,130,90);
        b1.setHorizontalTextPosition(JButton.CENTER);
        b1.setVerticalTextPosition(JButton.BOTTOM);
        b1.addActionListener((ActionListener) this);
        buttonsPanel.add(b1);

        b2 = new JButton("Delete Account");
        b2.setIcon(new ImageIcon("C:/Users/Kulkarni/IdeaProjects/JavaProject3/src/DeleteAccount.png"));
        b2.setBounds(410,60,130,90);
        b2.setHorizontalTextPosition(JButton.CENTER);
        b2.setVerticalTextPosition(JButton.BOTTOM);
        b2.addActionListener((ActionListener) this);
        buttonsPanel.add(b2);

        // gap to 160 Horizontally
        b3 = new JButton("View Account");
        b3.setIcon(new ImageIcon("C:/Users/Kulkarni/IdeaProjects/JavaProject3/src/viewAccount.png"));
        b3.setBounds(570,60,130,90);
        b3.setHorizontalTextPosition(JButton.CENTER);
        b3.setVerticalTextPosition(JButton.BOTTOM);
        b3.addActionListener((ActionListener) this);
        buttonsPanel.add(b3);


        // second Row of Buttons
        JLabel buttonSectionTitle2 = new JLabel("Admin Operations");
        buttonSectionTitle2.setFont(new Font(Font.SERIF,Font.BOLD, 25));
        buttonSectionTitle2.setForeground(Color.BLACK);
        buttonSectionTitle2.setHorizontalAlignment(JLabel.LEFT);
        buttonSectionTitle2.setBounds(6,150,210,50);
        buttonsPanel.add(buttonSectionTitle2);

        // 64 is the size of Button Icon https://icons8.com/

        b4 = new JButton("Add Subject");
        b4.setIcon(new ImageIcon("C:/Users/Kulkarni/IdeaProjects/JavaProject3/src/addSubject.png"));
        b4.setBounds(250,210,130,90);
        b4.setHorizontalTextPosition(JButton.CENTER);
        b4.setVerticalTextPosition(JButton.BOTTOM);
        b4.addActionListener((ActionListener) this);
        buttonsPanel.add(b4);

        b5 = new JButton("Delete Subject");
        b5.setIcon(new ImageIcon("C:/Users/Kulkarni/IdeaProjects/JavaProject3/src/deleteSubject.png"));
        b5.setBounds(410,210,130,90);
        b5.setHorizontalTextPosition(JButton.CENTER);
        b5.setVerticalTextPosition(JButton.BOTTOM);
        b5.addActionListener((ActionListener) this);
        buttonsPanel.add(b5);

        // gap to 160 Horizontally
        b6 = new JButton("View Students");
        b6.setIcon(new ImageIcon("C:/Users/Kulkarni/IdeaProjects/JavaProject3/src/viewStudents.png"));
        b6.setBounds(570,210,130,90);
        b6.setHorizontalTextPosition(JButton.CENTER);
        b6.setVerticalTextPosition(JButton.BOTTOM);
        b6.addActionListener((ActionListener) this);
        buttonsPanel.add(b6);

        b7 = new JButton("View Teachers");
        b7.setIcon(new ImageIcon("C:/Users/Kulkarni/IdeaProjects/JavaProject3/src/viewTeachers.png"));;
        b7.setBounds(250,320,130,90);
        b7.setHorizontalTextPosition(JButton.CENTER);
        b7.setVerticalTextPosition(JButton.BOTTOM);
        b7.addActionListener((ActionListener) this);
        buttonsPanel.add(b7);

        b8 = new JButton("View Courses");
        b8.setIcon(new ImageIcon("C:/Users/Kulkarni/IdeaProjects/JavaProject3/src/myCourses.png"));
        b8.setBounds(410,320,130,90);
        b8.setHorizontalTextPosition(JButton.CENTER);
        b8.setVerticalTextPosition(JButton.BOTTOM);
        b8.addActionListener((ActionListener) this);
        buttonsPanel.add(b8);


        b9 = new JButton("Add New Admin");
        b9.setIcon(new ImageIcon("C:/Users/Kulkarni/IdeaProjects/JavaProject3/src/addNewAdmin.png"));

        b9.setBounds(570,320,130,90);
        b9.setHorizontalTextPosition(JButton.CENTER);
        b9.setVerticalTextPosition(JButton.BOTTOM);
        b9.addActionListener((ActionListener) this);
        buttonsPanel.add(b9);

        setResizable(true);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == b1){
           new AdminManageAccount();
        }
        else if(ae.getSource() == b2){
            AdminDeleteAccount delete = new AdminDeleteAccount();
            if(delete.input == 0){
                dispose();
                new Main2();
            }
        }
        else if(ae.getSource() == b4){
            new AddSubject();
        }
        else if(ae.getSource() == b5){
            new DeleteSubject();
        }
        else if(ae.getSource() == b3){
            new AdminAccountDetails();
        }

        else if(ae.getSource() == logoutBtn){
            JOptionPane.showMessageDialog(null, "Logging Out...");
            new Main2();
            dispose();
        }
        else if(ae.getSource() == b6){
            new ViewStudents();
        }
        else if(ae.getSource() == b7){
            new ViewTeachers();
        }
        else if(ae.getSource() == b8){
            new ViewCourses();
        }
        else if(ae.getSource() == b9){

            A_Registration ar = new A_Registration();
            ar.Register4();
        }

    }
    @Override
    public void windowStateChanged(WindowEvent e) {
        // normal state
        if ((e.getNewState() & Frame.MAXIMIZED_BOTH) == Frame.NORMAL){
            logoutBtn.setLocation(30, 600);
        }
        // maximized
        else if ((e.getNewState() & Frame.MAXIMIZED_BOTH) == Frame.MAXIMIZED_BOTH){
            logoutBtn.setLocation(30, this.getHeight() - 120);
        }
    }
}

