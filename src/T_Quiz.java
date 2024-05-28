import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;



public class T_Quiz extends JFrame implements ActionListener{
    JLabel title, subjectCbLbl,quizNameLbl, courseDescriptionLbl, courseContentLbl;
    JComboBox subjectsCb;
    JTextArea courseDescription, courseContent;
    JButton addBtn;
    JPanel middlePanel;
    JTextField quizName;
    String SubjectsData[];
    JScrollPane scroll, scroll2;
    public T_Quiz(){
        super("Add Quiz");
        setLayout(new BorderLayout());

        title = new JLabel("Add Quiz", JLabel.CENTER);
        title.setFont(title.getFont().deriveFont (22.0f));
        title.setBackground(Color.LIGHT_GRAY);
        title.setForeground(Color.BLACK);
        title.setOpaque(true);
        add(title, BorderLayout.NORTH);

        middlePanel = new JPanel();
        middlePanel.setLayout(null);
        add(middlePanel, BorderLayout.CENTER);

        subjectCbLbl = new JLabel("Select Subject");
        subjectCbLbl.setFont(new Font(Font.SERIF,Font.BOLD, 16));
        subjectCbLbl.setBounds(80, 30, 120, 28);
        subjectCbLbl.setHorizontalAlignment(JLabel.LEFT);
        middlePanel.add(subjectCbLbl);

        this.getSubjects();
        subjectsCb = new JComboBox(SubjectsData);
        subjectsCb.setSelectedIndex(-1);
        subjectsCb.setBounds(200, 30, 140, 28);
        subjectsCb.addActionListener(this);
        middlePanel.add(subjectsCb);


        quizNameLbl = new JLabel("Quiz Name");
        quizNameLbl.setFont(new Font(Font.SERIF,Font.BOLD, 16));
        quizNameLbl.setBounds(80, 75, 140, 28);
        quizNameLbl.setHorizontalAlignment(JLabel.LEFT);
        middlePanel.add(quizNameLbl);

        quizName = new JTextField();
        quizName.setFont(new Font(Font.SERIF,Font.BOLD, 16));
        quizName.setBounds(200, 75, 120, 28);
        quizName.setHorizontalAlignment(JLabel.CENTER);
        middlePanel.add(quizName);




        addBtn = new JButton("Add");
        addBtn.setFont(new Font(Font.SERIF,Font.BOLD, 15));
        addBtn.setHorizontalAlignment(JButton.CENTER);
        addBtn.addActionListener(this);
        add(addBtn, BorderLayout.SOUTH);


        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setSize(720,570);
        setLocation(375,145);
        setVisible(true);
    }
    private void getSubjects(){
        try{
            //DBConnection c1 = new DBConnection();
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Java?characterEncoding=latin1", "root", "shravani");
            Statement sta = connection.createStatement();

            String q = "select * from Subjects";

            ResultSet rs = sta.executeQuery(q);
            int rowCount = 0;
            while(rs.next())
                rowCount++;
            SubjectsData = new String[rowCount];
            rs.beforeFirst();
            int i=0;
            while(rs.next()){
                SubjectsData[i] = rs.getString("Name");
                i++;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == addBtn){
            String subjectStr = subjectsCb.getSelectedItem().toString();
            String quizNameStr = quizName.getText();

            try{
                // DBConnection c1 = new DBConnection();
                Class.forName("com.mysql.jdbc.Driver");
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Java?characterEncoding=latin1", "root", "shravani");
                Statement sta = connection.createStatement();

                String q1  = "Select Subject_ID From Subjects  Where Name = '"+ subjectStr +"'";
                ResultSet rs = sta.executeQuery(q1);
                int subject_ID;
                rs.next();
                subject_ID = rs.getInt("Subject_ID");

                String q = "INSERT INTO Quiz (Name, teacherID, Subject_ID) "
                        + "Values ('" + quizNameStr +"',  '" + T_Login.currentTeacherID +"', '" + subject_ID + "')";

                int x = sta.executeUpdate(q);
                if(x == 0){
                    JOptionPane.showMessageDialog(null, "Some Error Occured");
                }else{
                    JOptionPane.showMessageDialog(null, "Quiz Added!");
                    dispose();
                }
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "This Quiz is Already being Offered By other Teacher!");
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        new T_Quiz();
    }

}

