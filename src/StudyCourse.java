import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;



public class StudyCourse extends JFrame implements ActionListener{
    JLabel title, subjectCbLbl, courseCbLbl, courseContentLbl;
    JTextArea courseContent;
    JComboBox coursesCb;
    JPanel middlePanel;
    JScrollPane scroll;
    public StudyCourse(){
        super("Study Course");
        setLayout(new BorderLayout());

        title = new JLabel("Study Course", JLabel.CENTER);
        title.setFont(title.getFont().deriveFont (22.0f));
        title.setBackground(Color.LIGHT_GRAY);
        title.setForeground(Color.BLACK);
        title.setOpaque(true);
        add(title, BorderLayout.NORTH);

        middlePanel = new JPanel();
        middlePanel.setLayout(null);
        add(middlePanel, BorderLayout.CENTER);


        courseCbLbl = new JLabel("Select Course");
        courseCbLbl.setFont(new Font(Font.SERIF,Font.BOLD, 16));
        courseCbLbl.setBounds(80, 80, 120, 28);
        courseCbLbl.setHorizontalAlignment(JLabel.LEFT);
        middlePanel.add(courseCbLbl);


        coursesCb = new JComboBox(this.getCourses());
        coursesCb.setSelectedIndex(-1);
        coursesCb.setBounds(200, 80, 140, 28);
        coursesCb.addActionListener(this);
        middlePanel.add(coursesCb);


        courseContentLbl = new JLabel("Course Content");
        courseContentLbl.setFont(new Font(Font.SERIF,Font.BOLD, 16));
        courseContentLbl.setBounds(80, 160, 120, 28);
        courseContentLbl.setHorizontalAlignment(JLabel.LEFT);
        middlePanel.add(courseContentLbl);

        courseContent = new JTextArea();
        courseContent.setLineWrap(true);
        courseContent.setWrapStyleWord(true);
        scroll = new JScrollPane(courseContent);
        scroll.setBounds(10, 190, 570, 180);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS );
        courseContent.setEditable(false);
        middlePanel.add(scroll);



        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setSize(600,450);
        setLocation(420,260);
        setVisible(true);
    }
    private String[] getCourses(){
        String[] coursesData = null;
        try{
           // DBConnection c1 = new DBConnection();
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Java?characterEncoding=latin1", "root", "shravani");
            Statement sta = connection.createStatement();

            String q = "Select C.Name From Courses As C"
                    + " Inner Join Enrollments As E ON E.course_ID = C.course_ID"
                    + " Where E.stdID = '"+ S_Login.currentStudentID+"'";

            ResultSet rs = sta.executeQuery(q);
            int rowCount = 0;
            while(rs.next())
                rowCount++;
            coursesData = new String[rowCount];
            rs.beforeFirst();
            int i=0;
            while(rs.next()){
                coursesData[i] = rs.getString("Name");
                i++;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return coursesData;
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == coursesCb){
            Object selected = coursesCb.getSelectedItem();
            String courseName = selected.toString();
            try{
                //DBConnection c1 = new DBConnection();
                Class.forName("com.mysql.jdbc.Driver");
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Java?characterEncoding=latin1", "root", "shravani");
                Statement sta = connection.createStatement();

                String q1  = "Select Content From Courses Where Name = '"+ courseName +"'";
                ResultSet rs = sta.executeQuery(q1);
                rs.next();
                String course_Content;
                course_Content = rs.getString("Content");
                courseContent.setText(course_Content);

            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        new StudyCourse();
    }

}
