import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;



public class AddCourse extends JFrame implements ActionListener{
    JLabel title, subjectCbLbl,courseNameLbl, courseDescriptionLbl, courseContentLbl;
    JComboBox subjectsCb;
    JTextArea courseDescription, courseContent;
    JButton addBtn;
    JPanel middlePanel;
    JTextField courseName;
    String SubjectsData[];
    JScrollPane scroll, scroll2;
    public AddCourse(){
        super("Add Course");
        setLayout(new BorderLayout());

        title = new JLabel("Add Course", JLabel.CENTER);
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


        courseNameLbl = new JLabel("Course Name");
        courseNameLbl.setFont(new Font(Font.SERIF,Font.BOLD, 16));
        courseNameLbl.setBounds(80, 75, 140, 28);
        courseNameLbl.setHorizontalAlignment(JLabel.LEFT);
        middlePanel.add(courseNameLbl);

        courseName = new JTextField();
        courseName.setFont(new Font(Font.SERIF,Font.BOLD, 16));
        courseName.setBounds(200, 75, 120, 28);
        courseName.setHorizontalAlignment(JLabel.CENTER);
        middlePanel.add(courseName);


        courseDescriptionLbl = new JLabel("Course Description");
        courseDescriptionLbl.setFont(new Font(Font.SERIF,Font.BOLD, 16));
        courseDescriptionLbl.setBounds(80, 125, 140, 28);
        courseDescriptionLbl.setHorizontalAlignment(JLabel.LEFT);
        middlePanel.add(courseDescriptionLbl);

        courseDescription = new JTextArea();
        courseDescription.setLineWrap(true);
        courseDescription.setWrapStyleWord(true);
        scroll = new JScrollPane(courseDescription);
        scroll.setBounds(150, 155, 460, 100);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS );
        courseDescription.setEditable(true);
        middlePanel.add(scroll);


        courseContentLbl = new JLabel("Course Content");
        courseContentLbl.setFont(new Font(Font.SERIF,Font.BOLD, 16));
        courseContentLbl.setBounds(80, 260, 140, 28);
        courseContentLbl.setHorizontalAlignment(JLabel.LEFT);
        middlePanel.add(courseContentLbl);

        courseContent = new JTextArea();
        courseContent.setLineWrap(true);
        courseContent.setWrapStyleWord(true);
        scroll2 = new JScrollPane(courseContent);
        scroll2.setBounds(10, 290, 685, 150);
        scroll2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS );
        courseContent.setEditable(true);
        middlePanel.add(scroll2);


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
            String courseNameStr = courseName.getText();
            String courseDescriptionStr = courseDescription.getText();
            String courseContentStr = courseContent.getText();
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

                String q = "INSERT INTO Courses (Name, Description, Content, teacherID, Subject_ID) "
                        + "Values ('" + courseNameStr +"', '" + courseDescriptionStr +"', '" + courseContentStr +"', '"
                        + T_Login.currentTeacherID +"', '" + subject_ID + "')";

                int x = sta.executeUpdate(q);
                if(x == 0){
                    JOptionPane.showMessageDialog(null, "Some Error Occured");
                }else{
                    JOptionPane.showMessageDialog(null, "Course Added!");
                    dispose();
                }
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "This Course is Already being Offered By other Teacher!");
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        new AddCourse();
    }

}
